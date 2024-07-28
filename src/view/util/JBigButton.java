/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a big button.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The big button class.
 */
public class JBigButton extends JButton
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the big button.
         * 
         * @param text {String} The text.
         */
        public JBigButton(String text)
        {
            setText(text);
            setFont(new Font("Arial", Font.BOLD, 40));
            setSize(350, 55);
            setBackground(Color.WHITE);
            setForeground(Color.decode("#26282e"));   
            setHorizontalAlignment(SwingConstants.CENTER);
            setLayout(null);
        }
}
