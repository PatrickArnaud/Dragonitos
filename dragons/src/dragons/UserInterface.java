/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragons;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Patri
 */
public class UserInterface {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Table des Dragons");

        String[] columnsNames = {"Id", "Nom", "Sexe", "Longueur", "Nombres écailles", "Crache feu", "Comportement amoureux"};
        Object[][] data;
        data = (Object[][]) Utils.convertArrayDragonsToTab();

        JTable table = new JTable(data, columnsNames);
        JButton delete = new JButton("Supprimer dragon");
        JButton add = new JButton("Ajouter dragon");
        JPanel buttonList = new JPanel();
        buttonList.add(delete);
        buttonList.add(add);

        table.setRowHeight(30);
        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JLabel labelHead = new JLabel("Liste des dragons");
        labelHead.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));

        frame.getContentPane().add(labelHead, BorderLayout.PAGE_START);
        //ajouter la table au frame
        frame.getContentPane().add(scroll, BorderLayout.CENTER);
        frame.getContentPane().add(buttonList, BorderLayout.PAGE_END);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

}
