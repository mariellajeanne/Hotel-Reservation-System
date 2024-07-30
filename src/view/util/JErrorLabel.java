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
         * 
         * @param text {String} The text.
         */
        public JErrorLabel(String text)
        {
            setText(text);
            setFont(new Font("Arial", Font.PLAIN, (int) (20 * Scale.MIN)));
            setForeground(Color.decode("#ffa0a0"));
        }

        /**
         * Sets the error label's size and position.
         * 
         * @param x {int} The x position.
         * @param y {int} The y position.
         */
        public void setSizePos(int x, int y)
        {
            setBounds((int) (x * Scale.X), (int) (y * Scale.Y),
                    (int) (getPreferredSize().width * 1.2), getPreferredSize().height);
        }

        // TODO LABEL UPDATES MUST HAVE LOCATION/SIZE UPDATES
}
