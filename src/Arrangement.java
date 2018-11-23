import javax.xml.crypto.Data;
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

    public static void makeArrangement(String arrangementDuration, String name, String type, String description, String additionalInfo) throws SQLException {

        String sql = "INSERT INTO `arrangement`(`id`, `arrangementDuration`, `name`, `type`,`description`,`additionalInfo`) VALUES (null , \"" + arrangementDuration + "\", \"" + name + "\", \"" + type + "\", \"" + description + "\" , \"" + additionalInfo + "\")";

        st = Database.getConnect().createStatement();
        st.execute(sql);
        st.close();

    }

}
