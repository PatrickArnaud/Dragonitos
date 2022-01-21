package dragons;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Patrick
 *
 * all methods for User interactions
 *
 */
public class User {

    // methode for close the application
    public static boolean exit() {
        System.out.println("Que souhaitez vous faire ?");
        boolean choice = true;
        int value;
        System.out.println("1 - Continuer à naviguer sur la base de donnée ");
        System.out.println("2 - Quitter le programme");
        Scanner sc = new Scanner(System.in);
        value = sc.nextInt();
        switch (value) {
            case 1:
                choice = true;
                break;
            case 2:
                choice = false;
                break;
        }
        return choice;
    }

    //utilisation pattern
    public static void launcher() {
        System.out.println("que souhaitez vous faire ?");
        int value;
        Dialog.LauncherPattern();
        Scanner sc = new Scanner(System.in);
        value = sc.nextInt();
        switch (value) {
            case 1:
                DragonDB.getAllDragons();
                break;
            case 2:
                DragonDB.getDragon();
                break;
            case 3:
                DragonDB.deleteDragonByName();
                break;
            case 4:
                DragonDB.updateDragon();
                break;
            case 5:
                System.out.println("aurevoir");
                System.exit(0);
                break;
        }
    }

    // choosing target for modification of a dragon
    public static String userChoiceUpdate() {
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
        return choice;
    }

    // used to normalise any update on database for String 
    public static String upperCaseFirst(String val) {
        val = val.toLowerCase();
        char[] arr = val.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }

// check if int is well set
    public static int isANumber() {
        Scanner sc = new Scanner(System.in);
        boolean chiffre = false;
        String str;
        int numberTested = 0;
        do {
            str = sc.nextLine();
            try {
                numberTested = Integer.parseInt(str);
                chiffre = true; // si ton exécution arrive jusque là, ça signifie qu'il n'y a aucune exception lancée et que ta saisie est donc bien un chiffre
            } catch (NumberFormatException e) {
                System.out.println("Cette valeur n'est pas un chiffre");
            }
        } while (chiffre != true);
        return numberTested;
    }

    // cheching for sex value
    public static String maleOrFemale() {
        Scanner sc = new Scanner(System.in);
        String sex = null;
        boolean check = false;
        do {
            System.out.println("( male ou femelle )");
            try {
                sex = sc.nextLine();
                sex = sex.toLowerCase();
                if ("male".equals(sex) || "femelle".equals(sex)) {
                    check = true;
                } else {
                    System.out.println("merci de saisir le sexe( male ou femelle )");
                }
            } catch (NumberFormatException e) {
                System.out.println("Cette valeur n'est pas un sexe");
            }
        } while (check != true);
        return sex;
    }

    public static String spitFire() {
        Scanner sc = new Scanner(System.in);
        String fire = null;
        boolean check = false;
        do {
            System.out.println("( oui ou non )");
            try {
                fire = sc.nextLine();
                fire = fire.toLowerCase();
                if ("oui".equals(fire) || "non".equals(fire)) {
                    check = true;
                } else {
                    System.out.println("merci de s'il crache du feu( oui ou non )");
                }
            } catch (NumberFormatException e) {
                System.out.println("Cette valeur n'est pas oui ou non");
            }
        } while (check != true);
        return fire;
    }

}
