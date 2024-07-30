/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a panel for the title heading.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The sub page panel class.
 */
public class JTitlePanel extends JPanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private final JLabel lblTitle; // The title heading.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs a title panel.
         *
         * @param text {String} The text.
         */
        public JTitlePanel(String text)
        {
            // Configures the title label.
            this.lblTitle = new JLabel(text, SwingConstants.CENTER); 
            this.lblTitle.setFont(new Font("Arial", Font.BOLD, (int) (100 * Scale.MIN)));
            this.lblTitle.setForeground(Color.decode("#86d0f3"));

            // Configures the panel.
            setBackground(Color.decode("#26282e"));
            setLayout(new BorderLayout());
            add(lblTitle, BorderLayout.CENTER);
            setBounds(0, (int) (100 * Scale.Y), (int) (1920 * Scale.X), getPreferredSize().height);
        }
}
