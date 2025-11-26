package Factory;

public class DatabaseFactory {
    public static Database createDatabase(DatabaseType type) {
        return switch (type) {
            case ORACLE -> new OracleDatabase();
            case SQL_SERVER -> new SqlServerDatabase();
        };
    }
}
