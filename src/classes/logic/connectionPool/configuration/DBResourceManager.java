package classes.logic.connectionPool.configuration;

public class DBResourceManager {

    private final static DBResourceManager instance = new DBResourceManager();

    public static DBResourceManager getInstance()
    {
        return instance;
    }
}
