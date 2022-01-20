package veille;

import java.util.Scanner;

class Dragon {

    public Dragon(int id_dragon, String dragon, String sexe, int longueur, int nombre_ecailles, String crache_feu, String comportement_amoureux) {
        this.id_dragon = id_dragon;
        this.dragon = dragon;
        this.sexe = sexe;
        this.longueur = longueur;
        this.nombre_ecailles = nombre_ecailles;
        this.crache_feu = crache_feu;
        this.comportement_amoureux = comportement_amoureux;
    }

    @Override
    public String toString() {
        return "Dragon{" + "id_dragon=" + id_dragon + ", dragon=" + dragon + ", sexe=" + sexe + ", longueur=" + longueur + ", nombre_ecailles=" + nombre_ecailles + ", crache_feu=" + crache_feu + ", comportement_amoureux=" + comportement_amoureux + '}';
    }

    public Dragon() {
    }

    private int id_dragon;
    private String dragon;
    private String sexe;
    private int longueur;
    private int nombre_ecailles;
    private String crache_feu;
    private String comportement_amoureux;

    public int getId_dragon() {
        return id_dragon;
    }

    public void setId_dragon(int id_dragon) {
        this.id_dragon = id_dragon;
    }

    public String getDragon() {
        return dragon;
    }

    public void setDragon(String dragon) {
        this.dragon = dragon;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getNombre_ecailles() {
        return nombre_ecailles;
    }

    public void setNombre_ecailles(int nombre_ecailles) {
        this.nombre_ecailles = nombre_ecailles;
    }

    public String GetCrache_feu() {
        return crache_feu;
    }

    public void setCrache_feu(String crache_feu) {
        this.crache_feu = crache_feu;
    }

    public String getComportement_amoureux() {
        return comportement_amoureux;
    }

    public void setComportement_amoureux(String comportement_amoureux) {
        this.comportement_amoureux = comportement_amoureux;
    }

    public void CreateDragon() {
        System.out.println("Saisissez un nouveau Dragon");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom : ");
        this.setDragon(sc.nextLine());
        System.out.println("sexe : ");
        this.setSexe(sc.nextLine());
        System.out.println("longueur : ");
        this.setLongueur(sc.nextInt());
        System.out.println("nombre ecaille : ");
        this.setNombre_ecailles(sc.nextInt());
        sc.nextLine();
        System.out.println("crache feu t'il du feu ? : ");
        this.setCrache_feu(sc.nextLine());
        System.out.println("comportement amoureux : ");
        this.setComportement_amoureux(sc.nextLine());
        System.out.println(this.toString());       
    }

}