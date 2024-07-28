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
            setFont(new Font("Arial", Font.BOLD, 25));
            setBackground(Color.WHITE);
            setForeground(Color.decode("#26282e"));
            setBounds(70,70,150,40);
            setHorizontalAlignment(SwingConstants.CENTER);
            setLayout(null);
        }
}
