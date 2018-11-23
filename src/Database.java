import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {

    private static Connection connect;
    private static Statement st;
    private static ResultSet rs;
    private static Secretary s;
    private static Facilitator f;

    public static String getUrl() {
        String url;
        return url = "jdbc:mysql://212.237.138.123:3306/thomas?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    }

    public static void connectToDatabase() {

        try {
            st = getConnect().createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnect() throws SQLException {
        return connect = DriverManager.getConnection(getUrl(), "thomas", "123456");
    }

    public static void userLogin(String u, String p) {

        try {

            String query = "SELECT * FROM user WHERE username='"+ u + "' and password='"+ p +"'";
            rs = st.executeQuery(query);

            if (rs.next()) {

                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("fullname");
                String role = rs.getString("role");

                if (u.equals(username) && p.equals(password)) {
                    System.out.println("Du er nu logget ind");
                    System.out.println("Velkommen, " + name + ". Din rolle er: " + role);

                    switch (role) {
                        case "Secretary":
                            s.secretaryLogin();
                            break;
                        case "Facilitator":
                            f.facilitatorLogin();
                            break;
                        default:
                            System.out.println("fail");
                            break;
                    }
                } else if(!u.equals(username) || !p.equals(password)){
                    System.out.println("Forkert brugernavn eller kodeord.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Fejl med databasen.");
        }

    }
}
