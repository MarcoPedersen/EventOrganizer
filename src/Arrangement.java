import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void makeArrangement(String arrangementDuration, String name, String type, String description, String additionalInfo, String attendeeNames) throws SQLException {

        String sql = "INSERT INTO `arrangement`(`id`, `arrangementDuration`, `name`, `type`,`description`,`additionalInfo`,`attendeeNames`) VALUES (null , \"" + arrangementDuration + "\", \"" + name + "\", \"" + type + "\", \"" + description + "\" , \"" + additionalInfo + "\" , \"" + Secretary.getAttendeeNames() + "\")";

            st = Database.getConnect().createStatement();
            st.execute(sql);
            System.out.println("Du har nu tilføjet et arrangement.");
            st.close();


    }

}
