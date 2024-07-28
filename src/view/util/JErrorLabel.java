/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a label for errors.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The error label class.
 */
public class JErrorLabel extends JLabel
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs an empty error label.
         */
        public JErrorLabel()
        {
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#ffa0a0"));
        }

        /**
         * Constructs an error label given the text.
         *
         * @param text {String} The text.
         */
        public JErrorLabel(String text)
        {
            setText(text);
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#ffa0a0"));
        }

        
}
