package dragons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Patrick
 *
 * all methode to interact with database
 */
public class DragonDB {

    //methode for show all the Dragons or return an arrayList of Dragons 
    static public List<Dragon> getAllDragons() {
        List<Dragon> dragons = new ArrayList<>();
        try {
            String query = "SELECT  id_dragon, dragon , sexe, longueur, nombre_ecailles, crache_feu,comportement_amoureux FROM dragons";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            ResultSet resultSet = declaration.executeQuery();
            while (resultSet.next()) {
                Dragon dragon = new Dragon();
                dragon.setId_dragon(resultSet.getInt(1));
                dragon.setDragon(resultSet.getString(2));
                dragon.setSexe(resultSet.getString(3));
                dragon.setLongueur(resultSet.getInt(4));
                dragon.setNombre_ecailles(resultSet.getInt(5));
                dragon.setCrache_feu(resultSet.getString(6));
                dragon.setComportement_amoureux(resultSet.getString(7));
                dragons.add(dragon);
                System.out.println(" dragons => " + dragon.getDragon());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return dragons;
        }
    }

    //methode for show a dragon in the database
    public static Dragon getDragon() {
        getAllDragons();
        Dragon dragon = new Dragon();
        System.out.println("Saisissez un dragon (nom).");
        String nom;
        Scanner sc = new Scanner(System.in);
        nom = sc.nextLine();
        try {
            String query = "SELECT  id_dragon, dragon , sexe, longueur, nombre_ecailles, crache_feu,comportement_amoureux FROM dragons WHERE dragon = ?";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setString(1, nom);
            ResultSet resultSet = declaration.executeQuery();
            while (resultSet.next()) {
                dragon.setId_dragon(resultSet.getInt(1));
                dragon.setDragon(resultSet.getString(2));
                dragon.setSexe(resultSet.getString(3));
                dragon.setLongueur(resultSet.getInt(4));
                dragon.setNombre_ecailles(resultSet.getInt(5));
                dragon.setCrache_feu(resultSet.getString(6));
                dragon.setComportement_amoureux(resultSet.getString(7));
            }
            System.out.println(" dragons => " + dragon);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dragon.toString();
            return dragon;
        }

    }

    //methode for add dragon in the database
    public static Dragon addDragon() {
        System.out.println("Saisissez un dragon ?? ajouter.");
        Dragon drag = new Dragon();
        drag.CreateDragon();
        try {
            String query = "INSERT INTO dragons (dragon , sexe, longueur, nombre_ecailles, crache_feu,comportement_amoureux) VALUES ( ? , ? , ? , ? , ? , ? )";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setString(1, drag.getDragon());
            declaration.setString(2, drag.getSexe());
            declaration.setInt(3, drag.getLongueur());
            declaration.setInt(4, drag.getNombre_ecailles());
            declaration.setString(5, drag.GetCrache_feu());
            declaration.setString(6, drag.getComportement_amoureux());
            int executeUpdate = declaration.executeUpdate();
            if (executeUpdate == 1) {
                System.out.println("insertion dragon effectu?? ! ");
            } else {
                System.out.println("insertion dragon non effectue");
            }
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'insertion dragon: " + e.getMessage()
            );
        }
        return drag;
    }

    //methode for delete any dragon in the database 
    public static boolean deleteDragonByName() {
        getAllDragons();
        System.out.println("Saisissez un dragon ?? supprimer (nom).");
        String nom;
        Scanner sc = new Scanner(System.in);
        nom = sc.nextLine();
        nom = User.upperCaseFirst(nom);
        boolean success = false;
        try {
            String query = "DELETE FROM dragons WHERE dragon = ?";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setString(1, nom);
            int executeUpdate = declaration.executeUpdate();
            success = (executeUpdate == 1);
        } catch (SQLException e) {
            System.err.println("Erreur suppression dragon : "
                    + e.getMessage());
        }
        return success;
    }

    public static Dragon getDragonByIdInterface(int id) {
        Dragon dragon = new Dragon();

        try {
            String query = "SELECT id_dragon, dragon , sexe, longueur, nombre_ecailles, crache_feu,comportement_amoureux FROM dragons WHERE id_dragon = ?";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setInt(1, id);
            ResultSet resultSet = declaration.executeQuery();
            while (resultSet.next()) {
                dragon.setId_dragon(resultSet.getInt(1));
                dragon.setDragon(resultSet.getString(2));
                dragon.setSexe(resultSet.getString(3));
                dragon.setLongueur(resultSet.getInt(4));
                dragon.setNombre_ecailles(resultSet.getInt(5));
                dragon.setCrache_feu(resultSet.getString(6));
                dragon.setComportement_amoureux(resultSet.getString(7));
            }
            System.out.println(" dragons => " + dragon);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dragon.toString();
            return dragon;
        }
    }

    public static boolean deleteDragonByNameInterface(String dragon) {
        boolean success = false;
        try {
            String query = "DELETE FROM dragons WHERE dragon = ?";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setString(1, dragon);
            int executeUpdate = declaration.executeUpdate();
            success = (executeUpdate == 1);
        } catch (SQLException e) {
            System.err.println("Erreur suppression dragon : "
                    + e.getMessage());
        }
        System.out.println("cool");
        return success;
    }

    //methode for update any dragon in the database
    public static void updateDragon() {
        getAllDragons();
        System.out.println("Saisissez le nom du dragon ?? modifier.");
        String dragon;
        Scanner sc = new Scanner(System.in);
        dragon = sc.nextLine();
        try {
            System.out.println("quel element souhaitez vous modifier ?");
            String userChoice = User.userChoiceUpdate();
            System.out.println("nouvelle valeur ?");
            String update;
            update = sc.nextLine();
            String query = " UPDATE dragons SET " + userChoice + "  = ?  WHERE dragons.dragon = ? ";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setString(1, User.upperCaseFirst(update));
            declaration.setString(2, dragon);
            int executeUpdate = declaration.executeUpdate();
            getAllDragons();
            if (executeUpdate == 1) {
                System.out.println("modification dragon effectu?? ! ");
            } else {
                System.out.println("modification dragon non effectue");
            }
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'insertion modification dragon : " + e.getMessage()
            );
        }
    }

    public static void addDragonInterface(String name, String sex, int longueur, int scale, String fire, String love) {

        try {
            String query = "INSERT INTO dragons (dragon , sexe, longueur, nombre_ecailles, crache_feu,comportement_amoureux) VALUES ( ? , ? , ? , ? , ? , ? )";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setString(1, name);
            declaration.setString(2, sex);
            declaration.setInt(3, longueur);
            declaration.setInt(4, scale);
            declaration.setString(5, fire);
            declaration.setString(6, love);
            int executeUpdate = declaration.executeUpdate();
            if (executeUpdate == 1) {
                System.out.println("insertion dragon effectu?? ! ");
            } else {
                System.out.println("insertion dragon non effectue");
            }
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'insertion dragon: " + e.getMessage()
            );
        }
    }

    public static void updateDragonInterface(String name, String sex, int longueur, int scale, String fire, String love,int id) {

        try {
            String query = " UPDATE dragons SET dragon = ?, sexe = ?,longueur = ?, nombre_ecailles = ?, crache_feu = ? , comportement_amoureux = ? WHERE dragons.id_dragon = ?";            
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setString(1, name);
            declaration.setString(2, sex);
            declaration.setInt(3, longueur);
            declaration.setInt(4, scale);
            declaration.setString(5, fire);
            declaration.setString(6, love);
            declaration.setInt(7, id);
            int executeUpdate = declaration.executeUpdate();
            if (executeUpdate == 1) {
                System.out.println("modification dragon effectu?? ! ");
            } else {
                System.out.println("modification dragon non effectue");
            }
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'insertion dragon: " + e.getMessage()
            );
        }
    }
}
