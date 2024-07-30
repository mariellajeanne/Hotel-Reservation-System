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
         * Constructs the error label.
         */
        public JErrorLabel()
        {
            setText("");
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#ffa0a0"));
        }
}
