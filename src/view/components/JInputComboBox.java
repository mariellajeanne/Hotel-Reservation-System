/*
JInputComboBox✅
has a label + combo box✅
hungarian notation: inc
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JInputComboBox extends JPanel {

    //VARIABLES
    private JLabel incLabel;
    private JComboBox cbxComboBox;
    //CONSTRUCTOR

    public JInputComboBox(String labelText, ArrayList<String> comboList){
        this.setBackground(Color.YELLOW);

        this.incLabel = new JLabel(labelText);
        this.cbxComboBox = new JComboBox(comboList.toArray(new String[0]));

        this.incLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(incLabel);
        this.add(cbxComboBox);
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

