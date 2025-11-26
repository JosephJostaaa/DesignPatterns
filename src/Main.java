import Adpater.EmployeeAdapter;
import Adpater.Target;
import Factory.DataAnalyticsEngine;
import Factory.DatabaseFactory;
import Factory.DatabaseType;
import Observer.ConcreteObserver;
import Observer.Subject;

public class Main{

    public static void main(String[] args) {
        try {
            dbEngines();
            Thread.sleep(2000);
            System.out.println();

            employeesAdapterDemo();
            Thread.sleep(2000);
            System.out.println();

            observingThings();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // No need to replace this code after applying the factory pattern properly
    static void dbEngines() {
        DataAnalyticsEngine sqlEngine =
                new DataAnalyticsEngine(DatabaseFactory.createDatabase(DatabaseType.SQL_SERVER));
        sqlEngine.processData("Query to process data for SQL Server");

        DataAnalyticsEngine oracleEngine =
                new DataAnalyticsEngine(DatabaseFactory.createDatabase(DatabaseType.ORACLE));
        oracleEngine.processData("Query to process data for Oracle");
    }

    // No need to replace this code, just implement the Adapter classes
    static void employeesAdapterDemo() {
        String[][] employeesArray = {
                {"101", "John", "SE", "10000"},
                {"102", "Smith", "SE", "20000"},
                {"103", "Dev", "SSE", "30000"},
                {"104", "Pam", "SE", "40000"},
                {"105", "Sara", "SSE", "50000"}
        };

        System.out.println("HR system passes employee string array to Adapter\n");

        Target target = new EmployeeAdapter();
        target.processCompanySalary(employeesArray);
    }

    // No need to replace this code, just implement the Observer classes
    static void observingThings() {
        Subject RedMI = new Subject("Red MI Mobile", 10000, "Out Of Stock");

        ConcreteObserver user1 = new ConcreteObserver("Anurag");
        user1.addSubscriber(RedMI);

        ConcreteObserver user2 = new ConcreteObserver("Pranaya");
        user2.addSubscriber(RedMI);

        ConcreteObserver user3 = new ConcreteObserver("Priyanka");
        user3.addSubscriber(RedMI);

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        System.out.println("Red MI Mobile current state : " + RedMI.getAvailability());
        System.out.println();

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        user3.removeSubscriber(RedMI);

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        RedMI.setAvailability("Available");
    }
}
