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
         * Constructs the common textfield.
         * 
         * @param x {int} The x position.
         * @param y {int} The y position.
         * @param w {int} The width.
         * @param h {int} The height.
         */
        public JCommonTextField(int x, int y, int w, int h)
        {
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#26282e"));
            setBounds(x, y, w, h);
        }

        /**
         * Constructs the common textfield given the text.
         * 
         * @param text  {String} The text.
         * @param x     {int} The x position.
         * @param y     {int} The y position.
         * @param w     {int} The width.
         * @param h     {int} The height.
         */
        public JCommonTextField(String text, int x, int y, int w, int h)
        {
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#26282e"));
            setBounds(x, y, w, h);
        }
}
