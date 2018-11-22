import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void connectToDatabase(String sql) {
        String url = "jdbc:mysql://212.237.138.123:3306/thomas?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

        try {
            Connection connect = DriverManager.getConnection(url, "thomas", "12345");
            Statement stmt = connect.createStatement();

            stmt.execute(sql);

            connect.close();
        } catch (SQLException e) {
            System.out.println("Forkert login!");
        }
    }
}

