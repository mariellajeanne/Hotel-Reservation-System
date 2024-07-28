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
         * Constructs an empty common combo box.
         */
        public JCommonComboBox()
        {
            setBackground(Color.WHITE);
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#26282e"));
        }

        /**
         * Constructs a common combo box given the items.
         *
         * @param items {E[]} array of items.
         */
        public JCommonComboBox(E[] items) {
            super(items);
            setBackground(Color.WHITE);
            setFont(new Font("Arial", Font.PLAIN, 20));
            setForeground(Color.decode("#26282e"));
        }
}
