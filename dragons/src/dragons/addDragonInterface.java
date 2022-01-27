package dragons;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Patrick
 */
public class addDragonInterface extends UserInterface implements ActionListener {

    JFrame addDrag = new JFrame();
    private JTextField name = new JTextField("Nom");
    private JTextField sex = new JTextField("Sexe");
    private JTextField size = new JTextField("Taille");
    private JTextField scale = new JTextField("Nombre d'écailles");
    private JTextField fire = new JTextField("crache du feu ?");
    private JTextField love = new JTextField("comportement amoureux");
    private JButton validate = new JButton("Ajouter");
    private JLabel label = new JLabel("votre saisie :");
    JPanel settings = new JPanel();

    public addDragonInterface() {
        super();
        build();

        validate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ajouter");
                String nameDB = name.getText();
                String sexDB = sex.getText();
                String sizeDB = size.getText();
                int sizeDBint = Integer.parseInt(sizeDB);
                String scaleDB = scale.getText();
                int scaleDBint = Integer.parseInt(scaleDB);
                String fireDB = fire.getText();
                String loveDB = love.getText();
                DragonDB.addDragonInterface(User.upperCaseFirst(nameDB), User.upperCaseFirst(sexDB), sizeDBint, scaleDBint, User.upperCaseFirst(fireDB), User.upperCaseFirst(loveDB));
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

    void build() {
        addDrag.setTitle("Ajouter dragon");
        addDrag.setSize(800, 200);
        addDrag.setLocationRelativeTo(null);
        addDrag.setResizable(false);
        addDrag.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addDrag.setVisible(true);
        addDrag.setLayout(new GridLayout(2, 4));

        addDrag.add(settings);

        addDrag.add(label);
        addDrag.add(name);
        addDrag.add(sex);
        addDrag.add(size);
        addDrag.add(scale);
        addDrag.add(fire);
        addDrag.add(love);
        addDrag.add(validate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
