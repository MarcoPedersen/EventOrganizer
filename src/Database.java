import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    String sql = "INSERT INTO `arrangements`(`uid`, `name`, `type`, `info`, `yy1`, `MM1`, `dd1`, `hh1`, `mm_1`, `ss1`, `yy2`, `MM2`, `dd2`, `hh2`, `mm_2`, `ss2`) VALUES (1, 'ohyeah', '" + arrangement.type + "', '" + arrangement.info + "', 2000, 2, 28, 00, 00, 00, 2001, 2, 28, 00, 00, 00)";

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

