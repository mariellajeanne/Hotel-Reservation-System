/**
 *
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * JInputComboBox is a custom panel that contains a label and a combo box.
 */


import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * JInputComboBox class that extends JPanel
 */
public class JInputComboBox extends JPanel {

    //VARIABLES
    private JLabel incLabel;
    private JComboBox cmbComboBox;
    //CONSTRUCTOR

    /**
     * Constructs a JInputComboBox with the specified label text and combo box items.
     *
     * @param labelText the text for the label
     * @param comboList the list of items for the combo box
     */
    public JInputComboBox(String labelText, ArrayList<String> comboList){
        this.setBackground(Color.YELLOW);

        this.incLabel = new JLabel(labelText);
        this.cmbComboBox = new JComboBox(comboList.toArray(new String[0]));

        this.incLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(incLabel);
        this.add(cmbComboBox);
        this.setLayout(new GridLayout(2,1));
        this.setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height, this.getPreferredSize().width, this.getPreferredSize().height);

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
