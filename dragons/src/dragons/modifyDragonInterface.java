/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragons;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Patrick
 * modification interface
 */
public class modifyDragonInterface extends UserInterface implements ActionListener {

    JFrame modifyDrag = new JFrame();
    JFrame modifyDragUpdate = new JFrame();

    private JLabel idLabel = new JLabel("Id du dragon à modifier");
    private JTextField idInput = new JTextField();
    private JButton validate = new JButton("Choose id");
    private JTextField name = new JTextField();
    private JTextField sex = new JTextField();
    private JTextField size = new JTextField();
    private JTextField scale = new JTextField();
    private JTextField fire = new JTextField();
    private JTextField love = new JTextField();
    private JButton validateChange = new JButton("confirmer modification");
    private JLabel nameLabel = new JLabel("Nom");
    private JLabel sexLabel = new JLabel("Sexe");
    private JLabel sizeLabel = new JLabel("Taille");
    private JLabel scaleLabel = new JLabel("Nombre d'écailles");
    private JLabel fireLabel = new JLabel("crache du feu ?");
    private JLabel loveLabel = new JLabel("comportement amoureux");
    private JLabel idLabelShow = new JLabel("comportement amoureux");
    private JLabel idLabelShowLabel = new JLabel("id");
    private JLabel input = new JLabel("votre saisie");

    public modifyDragonInterface() {
        super();
        build();
    }

    
    //choosing with id dragon to modify
    void build() {
        modifyDrag.add(idLabel);
        modifyDrag.add(idInput);
        modifyDrag.add(validate);
        modifyDrag.setTitle("Id du dragon à modifier");
        modifyDrag.setSize(500, 100);
        modifyDrag.setLocationRelativeTo(null);
        modifyDrag.setResizable(false);
        modifyDrag.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modifyDrag.setVisible(true);
        modifyDrag.setLayout(new GridLayout(1, 2));

        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dragchangeString = idInput.getText();
                int dragchangeInt = Integer.parseInt(dragchangeString);
                buildModify(dragchangeInt);
                System.out.println("work");
            }
        });

    }
// get  dragon information ans set textfield modification
    void buildModify(int id) {
        Dragon drag = new Dragon();
        drag = DragonDB.getDragonByIdInterface(id);
        modifyDragUpdate.setTitle("modifiez les champs puis validez");
        modifyDragUpdate.setSize(400, 800);
        modifyDragUpdate.setLocationRelativeTo(null);
        modifyDragUpdate.setResizable(false);
        modifyDragUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modifyDragUpdate.setVisible(true);
        modifyDragUpdate.setLayout(new GridLayout(8, 2));

        modifyDragUpdate.add(idLabelShowLabel);
        idLabelShow.setText(String.valueOf(drag.getId_dragon()));
        modifyDragUpdate.add(idLabelShow);

        modifyDragUpdate.add(nameLabel);
        name.setText(drag.getDragon());
        modifyDragUpdate.add(name);

        modifyDragUpdate.add(sexLabel);
        sex.setText(drag.getSexe());
        modifyDragUpdate.add(sex);

        modifyDragUpdate.add(sizeLabel);
        size.setText(String.valueOf(drag.getLongueur()));
        modifyDragUpdate.add(size);

        modifyDragUpdate.add(scaleLabel);
        scale.setText(String.valueOf(drag.getNombre_ecailles()));
        modifyDragUpdate.add(scale);

        modifyDragUpdate.add(fireLabel);
        fire.setText(drag.GetCrache_feu());
        modifyDragUpdate.add(fire);

        modifyDragUpdate.add(loveLabel);
        love.setText(drag.getComportement_amoureux());
        modifyDragUpdate.add(love);
        modifyDragUpdate.add(validateChange);

        // update on database
        validateChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameDB = name.getText();
                String sexDB = sex.getText();
                String fireDB = fire.getText();
                String loveDB = love.getText();
                String sizeString = size.getText();
                int sizeInt = Integer.parseInt(sizeString);
                String scaleString = scale.getText();
                int scaleInt = Integer.parseInt(scaleString);
                String idString = idLabelShow.getText();
                int idInt = Integer.parseInt(idString);
                DragonDB.updateDragonInterface(nameDB, sexDB, sizeInt, scaleInt, fireDB, loveDB, idInt);
                modifyDragUpdate.dispose();
                modifyDrag.dispose();
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
    }

}
