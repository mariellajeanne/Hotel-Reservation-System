/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a label for feedback.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The feedback label class.
 */
public class JFeedbackLabel extends JLabel
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the feedback label.
         * 
         * @param text {String} The text.
         */
        public JFeedbackLabel()
        {
            setFont(new Font("Arial", Font.PLAIN, (int) (30 * Scale.MIN)));
            setForeground(Color.decode("#ffa0a0"));
        }

        /**
         * Sets the feedback label's size and position.
         * 
         * @param x {int} The x position.
         * @param y {int} The y position.
         */
        public void setSizePos(int x, int y)
        {
            setBounds((int) (x * Scale.X), (int) (y * Scale.Y),
                    (int) (getPreferredSize().width * 1.2), getPreferredSize().height);
        }
}
