/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a combo box with preset settings.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The common combo box class.
 */
public class JCommonComboBox<E> extends JComboBox<E>
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the common combo box.
         * 
         * @param x {int} The x position.
         * @param y {int} The y position
         * @param w {int} The width.
         * @param h {int} The height.
         */
        public JCommonComboBox(int x, int y, int w, int h)
        {
            setBackground(Color.WHITE);
            setFont(new Font("Arial", Font.PLAIN, (int) (20 * Scale.MIN)));
            setForeground(Color.decode("#26282e"));
            setBounds(  (int) (x * Scale.X), (int) (y * Scale.Y),
                        (int) (w * Scale.X), (int) (h * Scale.Y));
        }

        /**
         * Constructs the common combo box given the items.
         * 
         * @param items {E[]} The items.
         * @param x     {int} The x position.
         * @param y     {int} The y position
         * @param w     {int} The width.
         * @param h     {int} The height.
         */
        public JCommonComboBox(E[] items, int x, int y, int w, int h)
        {
            super(items);
            setBackground(Color.WHITE);
            setFont(new Font("Arial", Font.PLAIN, (int) (20 * Scale.MIN)));
            setForeground(Color.decode("#26282e"));
            setBounds((int) (x * Scale.X), (int) (y * Scale.Y),
                    (int) (w * Scale.X), (int) (h * Scale.Y));
        }
}
