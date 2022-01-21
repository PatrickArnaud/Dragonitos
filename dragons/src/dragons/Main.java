package dragons;

import java.sql.SQLException;

/**
 * @author Patrick main class for launch dragon acces database
 */
public class Main {
    
    public static void main(String[] args) throws SQLException {

//        do {
//            System.out.println("Bienvenue");
//            User.launcher();
//        } while (User.exit() == true);
        UserInterface.main(args);
    }
}
