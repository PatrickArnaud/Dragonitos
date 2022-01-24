/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragons;

import javax.swing.JFrame;

/**
 *
 * @author Patrick
 */
public class addDragonInterface {

    public addDragonInterface() {
        super();
        build();//On initialise notre fenêtre
    }

    void build() {
        JFrame addDrag = new JFrame();
        addDrag.setTitle("Ma première fenêtre"); //On donne un titre à l'application
        addDrag.setSize(320, 240); //On donne une taille à notre fenêtre
        addDrag.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        addDrag.setResizable(false); //On interdit la redimensionnement de la fenêtre
        addDrag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        addDrag.setVisible(true);
    }

}
