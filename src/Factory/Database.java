package Factory;

public interface Database {
    void connect();
    void executeQuery(String query);
}
