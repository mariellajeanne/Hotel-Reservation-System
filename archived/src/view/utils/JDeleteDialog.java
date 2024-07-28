/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Creates and manipulates a dialog box requesting the user to delete an object.
 */

/**
 * Class Associations
 * 
 * Inherits JPanel
 */

package view.utils;

import java.awt.*;
import javax.swing.*;

/**  
 * The delete dialog class.
 */
public class JDeleteDialog extends JDialog {

    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private JLabel lblQuestion;
    private JButton btnYes;
    private JButton btnNo;

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the delete dialog.
     */
    public JDeleteDialog(String question)
    {
        super();

        setUpQuestionLbl(question);

        
    }

    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Sets up the question label.
     * 
     * @param question {String} The question.
     */
    private void setUpQuestionLbl(String question)
    {
        this.lblQuestion.setText(question);
        this.lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        // this.lblQuestion.setFont(new Font("Serif", Font.BOLD, 14));
        // this.lblQuestion.setForeground(Color.BLUE);
    }

    private void setUpYesBtn()
    {
        this.btnYes.setText("Yes");
        this.btnYes.setFont(new Font("Serif", Font.BOLD, 14));
        // this.btnYes.setForeground(Color.WHITE);
        // this.btnYes.setBackground(Color.BLUE);
        // this.button.setEnabled(false);

    }


}