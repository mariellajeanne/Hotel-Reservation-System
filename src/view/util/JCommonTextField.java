/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a textfield with preset settings.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The common textfield class.
 */
public class JCommonTextField extends JTextField
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs an empty common textfield.
         */
        public JCommonTextField()
        {
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#26282e"));
        }

        /**
         * Constructs a common textfield given the text.
         *
         * @param text {String} The text.
         */
        public JCommonTextField(String text)
        {
            setText(text);
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#26282e"));
        }
}
