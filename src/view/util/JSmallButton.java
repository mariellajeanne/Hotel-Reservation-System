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
         * @param x         {int}       The x position.
         * @param y         {int}       The y position.
         */
        public JSmallButton(String text, int sizeMode, int x, int y)
        {
            // Sets the size of the small button.
            if (sizeMode == 0)
                setSize((int) (89 * Scale.X), (int) (30 * Scale.Y));
            else if (sizeMode == 1)
                setSize((int) (120 * Scale.X), (int) (30 * Scale.Y));
            
            // Configures the button.
            setText(text);
            setFont(new Font("Arial", Font.BOLD, (int) (20 * Scale.MIN)));
            setBackground(Color.WHITE);
            setForeground(Color.decode("#26282e"));
            setHorizontalAlignment(SwingConstants.CENTER);
            setLayout(null);
            setLocation((int) (x * Scale.X), (int) (y * Scale.Y));
        }
}
