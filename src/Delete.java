import java.sql.*;

public class Delete {

    public static void deleteRow(int id)
    {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://212.237.138.123:3306/thomas?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "thomas", "123456");

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM arrangement WHERE id = " + id);
            stmt.executeUpdate();

        } catch(SQLException sqlex) {
            System.out.println(sqlex);
        }
    }

}
