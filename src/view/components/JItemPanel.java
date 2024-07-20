package view.components;

import java.awt.*;
import javax.swing.*;

public class JItemPanel extends JPanel{

    //VARIABLES
    private JLabel lblItemName;
    private JLabel lblDescription;
    private JButton btnEdit;
    private JDeleteDialog ddgDelete;

    //CONSTRUCTOR
    public JItemPanel(JFrame frame){

        this.setBackground(Color.YELLOW);

        this.lblItemName = new JLabel("Item");
        this.lblDescription = new JLabel("Description ");
        this.btnEdit = new JButton("Edit");
        this.ddgDelete = new JDeleteDialog(frame);

        this.setLayout(new FlowLayout());

        this.add(lblItemName);
        this.add(lblDescription);
        this.add(btnEdit);
        this.add(ddgDelete);

        this.setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height, this.getPreferredSize().width, this.getPreferredSize().height);

        this.setVisible(true);
    }

    //SETTERS

    /**
     * Sets the location of the panel on the screen.
     *
     * @param x The x-coordinate of the panel's new location.
     * @param y The y-coordinate of the panel's new location.
     */
    public void setPanelLocation(int x, int y) {
        this.setBounds(x, y, this.getPreferredSize().width, this.getPreferredSize().height);
    }

}
