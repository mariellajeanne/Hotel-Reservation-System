/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a small button.
 */

package view.util;
 
import java.awt.*;
import javax.swing.*;

/**
 * The small button class.
 */
public class JSmallButton extends JButton
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the small button.
         * 
         * @param text      {String}    The button's text.
         * @param sizeMode  {int}       The button's size mode.
         */
        public JSmallButton(String text, int sizeMode)
        {
            // Sets the size of the small button.
            if (sizeMode == 0)
                setSize(89, 30);
            else if (sizeMode == 1)
                setSize(120, 30);
            
            // Configures the button.
            setText(text);
            setFont(new Font("Arial", Font.BOLD, 25));
            setBackground(Color.WHITE);
            setForeground(Color.decode("#26282e"));
            setHorizontalAlignment(SwingConstants.CENTER);
            setLayout(null);
        }
}
