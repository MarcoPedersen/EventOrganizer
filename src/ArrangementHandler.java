import javax.xml.crypto.Data;

public class ArrangementHandler {

    public static Database database;

    public static void main(String[] args) {

        String connect = "INSERT INTO `arrangements`(`uid`, `name`, `type`, `info`, `yy1`, `MM1`, `dd1`, `hh1`, `mm_1`, `ss1`, `yy2`, `MM2`, `dd2`, `hh2`, `mm_2`, `ss2`) VALUES (1, 'ohyeah', '" + arrangement.type + "', '" + arrangement.info + "', 2000, 2, 28, 00, 00, 00, 2001, 2, 28, 00, 00, 00)";
        database.connectToDatabase(connect);

    }
}
