package epam.bookticket.logic.dao.connectionPool.configuration;

public class DBParameter {

    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/booking_tickets";
    public static final String DB_USER_NAME = "root";
    public static final String DB_PASSWORD = "Root";
    public static final int DB_POOL_SIZE = 5;

    private DBParameter(){}
}
