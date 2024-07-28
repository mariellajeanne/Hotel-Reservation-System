/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Creates a custom label.
 */

package view.utils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The custom label class.
 */
public class JCustomLabel extends JLabel
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the custom label given its properties.
    * 
    * @param text     {String}    The label's text.
    * @param color    {Color}     The labels' color.
    * @param size     {int}       The label's size.
    * @param x        {int}       The label's x alignment.
    * @param y        {int}       The label's y alignment.
    * @param t        {int}       The top border.
    * @param l        {int}       The left border.
    * @param b        {int}       The bottom border.
    * @param r        {int}       The right border.
    */
    public JCustomLabel(String text, Color color, int size,
                        int t, int l, int b, int r)
    {
        super(text);

        this.setForeground(color);
        this.setFont(new Font("SansSerif", Font.PLAIN, size));
        // this.setAlignmentX(x);
        // this.setAlignmentY(y);
        this.setBorder(new EmptyBorder(t, l, b, r));
    }

}
 