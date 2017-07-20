package epam.bookticket.logic.dao.connectionPool.configuration;

public class DBResourceManager {

    private final static DBResourceManager instance = new DBResourceManager();

    public static DBResourceManager getInstance()
    {
        return instance;
    }
}
