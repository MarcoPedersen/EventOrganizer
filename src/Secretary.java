import javax.net.ssl.SSLException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Scanner;

public class Secretary extends User{

    private static Arrangement a;
    private static int attendeeCount;
    private static String attendeeNames = "";

    public static String getAttendeeNames() {
        return attendeeNames;
    }

    public static void secretaryLogin() {
        System.out.println("1. Tilføj arrangement \t 2. Rediger arrangement \t 3. Slet arrangement");
        Scanner choice = new Scanner(System.in);
        int userChoice = choice.nextInt();
        switch (userChoice) {
            case 1:
                System.out.println("Udfyld felterne:");
                Scanner arrScanner = new Scanner(System.in);

                System.out.println("Navn på arrangement: ");
                name = arrScanner.nextLine();
                System.out.println("Arrangement type: ");
                type = arrScanner.nextLine();
                System.out.println("Varighed: ");
                aDuration = arrScanner.nextLine();
                System.out.println("Antal deltagere: ");
                attendeeCount = arrScanner.nextInt();
                System.out.print("");
                arrScanner.nextLine();
                System.out.println("Beskrivelse: ");
                description = arrScanner.nextLine();
                int tempCount = 0;
                while(attendeeCount > tempCount) {
                    System.out.println("Næste: ");
                    attendeeNames = attendeeNames + arrScanner.nextLine();
                    tempCount++;
                    if (tempCount != attendeeCount) {
                        attendeeNames = attendeeNames + ", ";
                    }
                }
                System.out.println("Anden info: ");
                additionalInfo = arrScanner.nextLine();

                try {
                    a.makeArrangement(aDuration, name, type, description, additionalInfo, attendeeNames);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                break;


            case 2:
                System.out.println("hehe");
                break;

            case 3:
                System.out.println("Indtast arrangement-ID for det ønskede arrangement: ");
                Scanner idScanner = new Scanner(System.in);
                Delete.deleteRow(idScanner.nextInt());
                break;

            default:
                System.out.println("prøv igen");
                break;
        }
    }
}
