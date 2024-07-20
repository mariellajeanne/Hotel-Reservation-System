/**
 *
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * JFeedbackDialog is a custom dialog class for displaying feedback messages.
 */

import java.awt.*;
import javax.swing.*;

/**
 * JFeedbackDialog class that extends JDialog
 */
public class JFeedbackDialog extends JDialog {

    private JLabel lblFeedback;
    private JButton btnOK;
    private JPanel pnlDesign;

    /**
     * Constructs a JFeedbackDialog with the specified parent frame.
     *
     * @param frame the parent frame of the dialog
     */
    public JFeedbackDialog(JFrame frame) {
        // Set the title of the dialog
        this.setTitle("Feedback");

        // Set the background color of the dialog
        this.setBackground(Color.YELLOW);

        // Initialize components
        this.lblFeedback = new JLabel();
        this.btnOK = new JButton("OK");
        this.pnlDesign = new JPanel();

        // Set layout for the panel and add the OK button
        this.pnlDesign.setLayout(new FlowLayout());
        this.pnlDesign.add(btnOK);

        // Set layout for the dialog
        this.setLayout(new BorderLayout());

        // Center the text in the feedback label
        this.lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);

        // Add components to the dialog
        this.add(lblFeedback, BorderLayout.NORTH);
        this.add(pnlDesign, BorderLayout.CENTER);

        // Pack the dialog to fit the components
        this.pack();

        // Center the dialog relative to the parent frame
        this.setLocationRelativeTo(frame);

        // Make the dialog visible
        this.setVisible(true);
    }

    /**
     * Sets the feedback text in the dialog.
     *
     * @param feedbackText the feedback text to be displayed
     */
    public void setLblFeedback(String feedbackText) {
        this.lblFeedback.setText("Feedback: " + feedbackText);
        this.pack();
    }
}