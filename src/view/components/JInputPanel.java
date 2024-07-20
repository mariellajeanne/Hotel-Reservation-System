/**
 *
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * JInputPanel is a custom JPanel that includes a label, a text field, an optional error message, and an optional description.
 */

import javax.swing.*;
import java.awt.*;

/**
 * The JInputPanel class
 */
public class JInputPanel extends JPanel {

    private JLabel lblLabel;
    private JTextField txtTextField;
    private JLabel lblErrorMessage;
    private JLabel lblDescription;

    //CONSTRUCTOR

    /**
     * Constructs a new JInputPanel with a specified label text and default text for the text field.
     *
     * @param labelText The text to display on the label.
     * @param defaultText The default text to display in the text field.
     */
    public JInputPanel(String labelText, String defaultText) {
        this.setBackground(Color.YELLOW);

        // Initializes the text for label and text field
        this.lblLabel = new JLabel(labelText);
        this.txtTextField = new JTextField(defaultText);
        this.lblErrorMessage = new JLabel();
        this.lblDescription = new JLabel();

        // Colors the error message in red
        this.lblErrorMessage.setForeground(Color.RED);

        // Adds the label, text field, description, and error message to the panel
        this.add(lblLabel);
        this.add(txtTextField);
        this.add(lblDescription);
        this.add(lblErrorMessage);

        // Hides the error message and description initially
        this.lblLabel.setVisible(true);
        this.lblErrorMessage.setVisible(false);
        this.lblDescription.setVisible(false);

        // Sets the size of the panel
        this.setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height,
                this.getPreferredSize().width, this.getPreferredSize().height);
    }

    //SETTERS

    /**
     * Sets the error message and its visibility based on the error condition.
     *
     * @param errorMessage The error message to display.
     * @param errorCondition If true, displays the error message; otherwise, hides it.
     */
    public void setError(String errorMessage, boolean errorCondition) {
        if (errorCondition) {
            this.lblErrorMessage.setText(errorMessage);
            this.lblErrorMessage.setVisible(true);
        } else {
            this.lblErrorMessage.setVisible(false);
        }
        this.setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height,
                this.getPreferredSize().width, this.getPreferredSize().height);
    }

    /**
     * Sets the description message and makes it visible.
     *
     * @param descriptionMessage The description message to display.
     */
    public void setInpDescription(String descriptionMessage) {
        this.lblDescription.setText(descriptionMessage);
        this.lblDescription.setVisible(true);
        this.setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height,
                this.getPreferredSize().width, this.getPreferredSize().height);
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