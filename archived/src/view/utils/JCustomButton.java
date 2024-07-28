/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Creates a custom button.
 */

package view.utils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The custom button class.
 */
public class JCustomButton extends JButton
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the custom button given its properties.
     * 
     * @param text      {String}        The button's text.
     * @param colorBG   {Color}         The button's background color.
     * @param colorFG   {Color}         The button's text color.
     * @param btnSize   {Dimension}     The button's size.
     * @param txtSize   {int}           The button's text size.
     * @param x         {float}         The button's x alignment.
     * @param y         {float}         The button's y alignment.
     * @param t         {int}           The top border.
     * @param l         {int}           The left border.
     * @param b         {int}           The bottom border.
     * @param r         {int}           The right border.
     */
    public JCustomButton(String text, Color colorBG, Color colorFG, Dimension btnSize,
                         int txtSize, int t, int l, int b, int r)
    {
        super(text);

        this.setBackground(colorBG);
        this.setForeground(colorFG);
        this.setPreferredSize(btnSize);
        this.setFont(new Font("SansSerif", Font.PLAIN, txtSize));
        // this.setAlignmentX(x);
        // this.setAlignmentY(y);
        this.setBorder(new EmptyBorder(t, l, b, r));
    }
}
