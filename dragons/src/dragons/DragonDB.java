/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veille;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Patri
 */
public class DragonDB {

    //function for show all the Dragons or return an arrayList of Dragons 
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

    public static void addDragon() {
        System.out.println("Saisissez un dragon à ajouter.");
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
                System.out.println("insertion dragon effectué ! ");
            } else {
                System.out.println("insertion dragon non effectue");
            }
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'insertion dragon: " + e.getMessage()
            );
        }
    }

    public static boolean deleteDragonByName() {
        getAllDragons();
        System.out.println("Saisissez un dragon à supprimer (nom).");
        String nom;
        Scanner sc = new Scanner(System.in);
        nom = sc.nextLine();
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

    public static void updateDragon() {
        getAllDragons();
        System.out.println("Saisissez le nom du dragon à modifier.");
        String dragon;
        Scanner sc = new Scanner(System.in);
        dragon = sc.nextLine();
        try {
            System.out.println("quel element souhaitez vous modifier ?");
            String userChoice = userChoice();
            System.out.println("nouvelle valeur ?");
            String update;
            update = sc.nextLine();

            String query = " UPDATE dragons SET " + userChoice + "  = ?  WHERE dragons.dragon = ? ";
            Connection cnx = ConnectionDB.connect();
            PreparedStatement declaration = cnx.prepareStatement(query);
            declaration.setString(1, update);
            declaration.setString(2, dragon);
            System.out.println(declaration);
            int executeUpdate = declaration.executeUpdate();
            getAllDragons();
            if (executeUpdate == 1) {
                System.out.println("modification dragon effectué ! ");
            } else {
                System.out.println("modification dragon non effectue");
            }
        } catch (Exception e) {
            System.err.println(
                    "Erreur d'insertion modification dragon : " + e.getMessage()
            );
        }
    }

    public static String userChoice() {
        String choice = null;
        int value;
        System.out.println("nom dragon = 1, sexe =2 , longueur = 3, nombre_ecailles = 4, crache_feu = 5,comportement_amoureux= 6 ");
        Scanner sc = new Scanner(System.in);
        value = sc.nextInt();
        switch (value) {
            case 1:
                choice = "dragon";
                break;
            case 2:
                choice = "sexe";
                break;
            case 3:
                choice = "longueur";
                break;
            case 4:
                choice = "nombre_ecailles";
                break;
            case 5:
                choice = "crache_feu";
                break;
            case 6:
                choice = "comportement_amoureux";
                break;
        }
        System.out.println(choice);
        return choice;

    }

}
