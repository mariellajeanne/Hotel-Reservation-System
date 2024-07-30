/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a back button.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The back button class.
 */
public class JBackButton extends JButton
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the back button.
         */
        public JBackButton()
        {
            setText("Back");
            setFont(new Font("Arial", Font.BOLD, (int) (25 * Scale.MIN)));
            setBackground(Color.WHITE);
            setForeground(Color.decode("#26282e"));
            setBounds((int) (70 * Scale.X), (int) (70 * Scale.Y),
                    (int) (150 * Scale.X), (int) (40 * Scale.Y));
            setHorizontalAlignment(SwingConstants.CENTER);
            setLayout(null);
        }
}
