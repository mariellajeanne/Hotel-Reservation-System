package view.utils;

/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * JItemPanel is a custom panel that contains labels for an item name and description,
 * a button to edit the item, and a delete dialog.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.*;

/**
 * JItemPanel class that extends JPanel
 */
public class JItemPanel extends JPanel {

    // VARIABLES
    private JLabel lblItemName;
    private JLabel lblDescription;
    private JButton btnEdit;
    private JDeleteDialog ddgDelete;

    /**
     * Constructs a JItemPanel with the specified parent frame.
     *
     * @param frame the parent frame of the dialog
     */
    public JItemPanel(JFrame frame) {
        // Set the background color of the panel
        this.setBackground(Color.YELLOW);

        // Initialize components
        this.lblItemName = new JLabel("Item");
        this.lblDescription = new JLabel("Description");
        this.btnEdit = new JButton("Edit");
        this.ddgDelete = new JDeleteDialog(frame);

        // Set layout for the panel and add components
        this.setLayout(new FlowLayout());
        this.add(lblItemName);
        this.add(lblDescription);
        this.add(btnEdit);
        this.add(ddgDelete);

        // Set the bounds for the panel
        this.setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height, this.getPreferredSize().width, this.getPreferredSize().height);

        // Make the panel visible
        this.setVisible(true);
    }

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