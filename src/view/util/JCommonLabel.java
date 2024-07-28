/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a label with preset settings.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The common label class.
 */
public class JCommonLabel extends JLabel
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the small button.
         *
         * @param text      {String}    The text.
         * @param colorMode {int}       The text color mode.
         * @param isBold    {boolean}   Determines if the text must be bold.
         */
        public JCommonLabel(String text, int colorMode, boolean isBold)
        {
            setText(text);

            // Sets the font style to plain/bold.
            if (isBold == false)
                setFont(new Font("Arial", Font.PLAIN, 40));
            else
                setFont(new Font("Arial", Font.BOLD, 40));
            
            // Sets the color of the text to white/blue.
            if (colorMode == 0)
                setForeground(Color.WHITE);
            else
                setForeground(Color.decode("#86d0f3"));
        }
}
