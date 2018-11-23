import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Arrangement {

    private int id;
    private int arrangementDuration;
    private String name;
    private String type;
    private String description;
    private String additionalInfo;
    private static Statement st;

    public Arrangement(int id, int arrangementDuration, String name, String type, String description, String additionalInfo) {
        this.id = id;
        this.arrangementDuration = arrangementDuration;
        this.name = name;
        this.type = type;
        this.description = description;
        this.additionalInfo = additionalInfo;
    }
    public int getId() {

        return id;
    }

    public int getArrangementDuration() {
        return arrangementDuration;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public static void makeArrangement(String arrangementDuration, String name, String type, String description, String additionalInfo) throws SQLException {

        String sql = "INSERT INTO `arrangement`(`id`, `arrangementDuration`, `name`, `type`,`description`,`additionalInfo` ) VALUES (\"" + null + "\", \"" + arrangementDuration + "\", \"" + name + "\", \"" + type + "\", \"" + description + "\" + \"" + additionalInfo + "\")";

        st = Database.getConnect().createStatement();
        st.execute(sql);
        st.close();

    }

    public class DbToCSV {
        String filename = "desktop:test.csv";
        try

        {
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

}
