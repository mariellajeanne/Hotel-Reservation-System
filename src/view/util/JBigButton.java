/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a big button.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The big button class.
 */
public class JBigButton extends JButton
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the big button given the width and height.
         * 
         * @param text  {String}    The text.
         * @param x     {int}       The x position.
         * @param y     {int}       The y position.
         */
        public JBigButton(String text, int x, int y)
        {
            setText(text);
            setFont(new Font("Arial", Font.BOLD, (int) (40 * Scale.MIN)));
            setSize((int) (350 * Scale.X), (int) (55 * Scale.Y));
            setBackground(Color.WHITE);
            setForeground(Color.decode("#26282e"));   
            setHorizontalAlignment(SwingConstants.CENTER);
            setLayout(null);
            setLocation((int) (x * Scale.X), (int) (y * Scale.Y));
        }

        /**
         * Constructs the big button given the width and height.
         * 
         * @param text  {String}    The text.
         * @param x     {int}       The x position.
         * @param y     {int}       The y position.
         * @param w     {int}       The width.
         * @param h     {int}       The height.
         */
        public JBigButton(String text, int x, int y, int w, int h)
        {
            setText(text);
            setFont(new Font("Arial", Font.BOLD, (int) (40 * Scale.MIN)));
            setSize(350, 55);
            setBackground(Color.WHITE);
            setForeground(Color.decode("#26282e"));   
            setHorizontalAlignment(SwingConstants.CENTER);
            setLayout(null);
            setBounds((int) (x * Scale.X), (int) (y * Scale.Y),
                    (int) (w * Scale.X), (int) (h * Scale.Y));
        }
}
