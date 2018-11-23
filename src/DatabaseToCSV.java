import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseToCSV {
public static void writeFile(){
    String filename = "desktop:test.csv";
        try {
        FileWriter fw = new FileWriter(filename);
        Class.forName("com.mysql.jdbc-Driver").newInstance();
        Connection conn =

                DriverManager.getConnection("jdbc:mysql://212.237.138.123:3306/thomas?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "thomas", "123456");
        String query = "select * from testtable";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            fw.append(rs.getString(1));
            fw.append(',');
            fw.append(rs.getString(2));
            fw.append(',');
            fw.append(rs.getString(3));
            fw.append('\n');
        }
        fw.flush();
        fw.close();
        conn.close();
        System.out.println("CSV fil er blevet dannet lokalt på din desktop.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    }
