package epam.bookticket.logic.dao.connectionPool;

import epam.bookticket.logic.dao.connectionPool.configuration.DBParameter;
import epam.bookticket.logic.dao.connectionPool.configuration.DBResourceManager;
import epam.bookticket.logic.dao.connectionPool.exception.ConnectionPoolException;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class ConnectionPool {

    private final static ConnectionPool connectionPool = new ConnectionPool();
    private BlockingQueue<Connection> connectionBlockingQueue;
    private BlockingQueue<Connection> givenAwayConnectionQueue;

    private String driver;
    private String url;
    private String userName;
    private String password;
    private int poolSize;

    public static ConnectionPool getConnectionPool()
    {
        return connectionPool;
    }

    private ConnectionPool()
    {
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
        this.driver = DBParameter.DB_DRIVER;
        this.url = DBParameter.DB_URL;
        this.userName = DBParameter.DB_USER_NAME;
        this.password = DBParameter.DB_PASSWORD;
        this.poolSize = DBParameter.DB_POOL_SIZE;
    }

    public synchronized void initPool() throws ConnectionPoolException
    {
        try {
            Class.forName(driver);
            givenAwayConnectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
            connectionBlockingQueue = new ArrayBlockingQueue<Connection>(poolSize);

            for(int i=0; i < poolSize; i++)
            {
                Connection connection = DriverManager.getConnection(url, userName, password);
                PooledConnection pooledConnection = new PooledConnection(connection);
                connectionBlockingQueue.add(pooledConnection);
            }
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Not found driver database",e);
        } catch (SQLException e) {
            throw new ConnectionPoolException("SQLException in ConnectionPoll",e);
        }
    }

    public  Connection takeConnection() throws ConnectionPoolException
    {

        if (connectionBlockingQueue == null && givenAwayConnectionQueue == null)
        {
            initPool();
        }
        return giveConnection();
    }

    private Connection giveConnection()throws ConnectionPoolException
    {
        Connection connection = null;
        try{
            connection = connectionBlockingQueue.take();
            givenAwayConnectionQueue.add(connection);
            System.out.println("Connection complite...");
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error connecting to the data source",e);
        }
        return connection;
    }
    public void dispose() throws ConnectionPoolException
    {
        clearConnectionQueue();
    }

    private void clearConnectionQueue() throws ConnectionPoolException
    {
        try{
            closeConnectionQueue(givenAwayConnectionQueue);
            closeConnectionQueue(connectionBlockingQueue);
        }catch (SQLException e) {
            throw new ConnectionPoolException("SQLException in ConnectionPoll with closing",e);
        }
    }

    public void closeConnection (Connection connection, Statement statement)
    {

            if(statement != null)
            {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
    }

    public void closeConnection (Connection connection, Statement statement, ResultSet resultSet)
    {

            if(resultSet!=null)
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }



            if(statement!=null)
            {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }



            if(connection!= null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

    }

    private void closeConnectionQueue(BlockingQueue<Connection> blockingQueue)throws SQLException
    {
        Connection connection;
        while ((connection = blockingQueue.poll()) != null)
        {
            if (!connection.getAutoCommit())
            {
                connection.commit();
            }
            ((PooledConnection)connection).reallyClose();
        }
    }


    private class PooledConnection implements Connection
    {
        private Connection connection;

        public PooledConnection (Connection c) throws SQLException
        {
            this.connection = c;
            this.connection.setAutoCommit(true);
        }

        public void reallyClose() throws SQLException {
            connection.close();
        }


        @Override
        public Statement createStatement() throws SQLException {
            return connection.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return connection.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return connection.prepareCall(sql);
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            return connection.nativeSQL(sql);
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            connection.setAutoCommit(autoCommit);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return connection.getAutoCommit();
        }

        @Override
        public void commit() throws SQLException {
            connection.commit();
        }

        @Override
        public void rollback() throws SQLException {
            connection.rollback();
        }

        @Override
        public void close() throws SQLException {
            if(connection.isClosed())
            {
                throw new SQLException("Attempting to close closed connection");
            }
            if(connection.isReadOnly())
            {
                connection.setReadOnly(false);
            }
            if(!givenAwayConnectionQueue.remove(this))
            {
                throw new SQLException("Error deleting connection from given away connections pool");
            }
            if(!connectionBlockingQueue.offer(this))
            {
                throw new SQLException("Error allocating connection in the pool.");
            }
        }

        @Override
        public boolean isClosed() throws SQLException {
            return connection.isClosed();
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return connection.getMetaData();
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
            connection.setReadOnly(readOnly);
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return connection.isReadOnly();
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
            connection.setCatalog(catalog);
        }

        @Override
        public String getCatalog() throws SQLException {
            return connection.getCatalog();
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
            connection.setTransactionIsolation(level);
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return connection.getTransactionIsolation();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return connection.getWarnings();
        }

        @Override
        public void clearWarnings() throws SQLException {
            connection.clearWarnings();
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.createStatement(resultSetType,resultSetConcurrency);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.prepareStatement(sql,resultSetType,resultSetConcurrency);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.prepareCall(sql,resultSetType,resultSetConcurrency);
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return connection.getTypeMap();
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            connection.setTypeMap(map);
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
            connection.setHoldability(holdability);
        }

        @Override
        public int getHoldability() throws SQLException {
            return connection.getHoldability();
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return connection.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return connection.setSavepoint(name);
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            connection.rollback(savepoint);
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            connection.releaseSavepoint(savepoint);
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.createStatement(resultSetType,resultSetConcurrency,resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareStatement(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareCall(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return connection.prepareStatement(sql,autoGeneratedKeys);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return connection.prepareStatement(sql,columnIndexes);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return connection.prepareStatement(sql,columnNames);
        }

        @Override
        public Clob createClob() throws SQLException {
            return connection.createClob();
        }

        @Override
        public Blob createBlob() throws SQLException {
            return connection.createBlob();
        }

        @Override
        public NClob createNClob() throws SQLException {
            return connection.createNClob();
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return connection.createSQLXML();
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return connection.isValid(timeout);
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            connection.setClientInfo(name,value);
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            connection.setClientInfo(properties);
        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return connection.getClientInfo(name);
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return connection.getClientInfo();
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return connection.createArrayOf(typeName,elements);
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return connection.createStruct(typeName,attributes);
        }

        @Override
        public void setSchema(String schema) throws SQLException {
            connection.setSchema(schema);
        }

        @Override
        public String getSchema() throws SQLException {
            return connection.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {
            connection.abort(executor);
        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            connection.setNetworkTimeout(executor,milliseconds);
        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return connection.getNetworkTimeout();
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return connection.unwrap(iface);
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return connection.isWrapperFor(iface);
        }
    }
}
