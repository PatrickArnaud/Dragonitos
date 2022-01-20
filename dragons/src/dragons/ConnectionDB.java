
package veille;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection connect() {
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.
                    getConnection("jdbc:mysql://localhost:3308/dragons3", "root", "");
            System.out.println("Connexion à la base de données dragons réussie !");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            System.out.println("connection échoué");
        }
        return conn;
    }
}
