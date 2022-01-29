/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Patri
 */
public class UserInterface extends JFrame implements ActionListener {

    public static void main(String[] args) {

        UserInterface myDragon = new UserInterface();

    }
    final JFrame frame = new JFrame("Table des Dragons");
    private JButton delete = new JButton("Supprimer dragon");
    private JButton add = new JButton("Ajouter dragon");
    private JButton modify = new JButton("Modifier dragon");
    private JTextField deleteText = new JTextField("Entrez ici le nom du dragon à supprimer");
    public JTable table;
    JPanel buttonList = new JPanel();
    JLabel labelHead = new JLabel("Liste des dragons");

    public UserInterface() {

        String[] columnsNames = {"Id", "Nom", "Sexe", "Longueur", "Nombres écailles", "Crache feu", "Comportement amoureux"};
        Object[][] data;
        data = (Object[][]) Utils.convertArrayDragonsToTab();
        JTable table = new JTable(data, columnsNames);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DragonDB.deleteDragonByNameInterface(deleteText.getText());
                frame.remove(table);
                String[] columnsNames = {"Id", "Nom", "Sexe", "Longueur", "Nombres écailles", "Crache feu", "Comportement amoureux"};
                Object[][] data;
                data = (Object[][]) Utils.convertArrayDragonsToTab();
                JTable table = new JTable(data, columnsNames);
                table.setRowHeight(30);
                labelHead.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));
                frame.add(table);
                frame.validate();
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDragonInterface addDragon = new addDragonInterface();
                frame.setVisible(false);

            }
        });

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyDragonInterface modifyDragon = new modifyDragonInterface();
                frame.setVisible(false);
            }
        });
        frame.setResizable(false);

        buttonList.add(deleteText);
        deleteText.setSize(50, HEIGHT);
        buttonList.add(delete);
        buttonList.add(add);
        buttonList.add(modify);
        table.setRowHeight(30);
        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        labelHead.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));
        frame.getContentPane().add(labelHead, BorderLayout.PAGE_START);
        //ajouter la table au frame
        frame.getContentPane().add(scroll, BorderLayout.CENTER);
        frame.getContentPane().add(buttonList, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //   abstract method
    }

}
