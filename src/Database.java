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

        public static void connectToDatabase() {

            try {
                st = getConnect().createStatement();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public static Connection getConnect() throws SQLException {
            String url = ArrangementHandler.getUrl();
            return connect = DriverManager.getConnection(url, "thomas", "123456");
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

                    if(role.equals("Secretary")) {
                        s.secretaryLogin();
                    } else {
                        f.facilitatorLogin();
                    }

                } else {
                    System.out.println("Forkert brugernavn eller kodeord.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Fejl med databasen.");
        }

    }
}
