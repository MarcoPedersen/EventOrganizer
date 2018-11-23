import java.util.Scanner;
public class ArrangementHandler {

    public static void main(String[] args) {

        Database.connectToDatabase();
        Scanner login = new Scanner(System.in);

        System.out.println("Brugernavn: ");
        String u = login.nextLine();
        System.out.println("Kodeord: ");
        String p = login.nextLine();

        Database.userLogin(u, p);
    }

    public static String getUrl() {
        String url;
        return url = "jdbc:mysql://212.237.138.123:3306/thomas?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    }
}
