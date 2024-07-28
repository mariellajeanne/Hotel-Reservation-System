/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Creates a custom text field.
 */

package view.utils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The custom text field class.
 */
public class JCustomTextField extends JTextField
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the custom text field given its properties.
     * 
     * @param text      {String}        The text field's default text.
     * @param colorBG   {Color}         The text fields's background color.
     * @param colorFG   {Color}         The text field's text color.
     * @param w         {double}        The text field's width.
     * @param h         {double}        The text field's height.
     * @param fntSize   {int}           The text field's text size.
     * @param x         {float}         The text field's x alignment.
     * @param y         {float}         The text field's y alignment.
     * @param t         {int}           The top border.
     * @param l         {int}           The left border.
     * @param b         {int}           The bottom border.
     * @param r         {int}           The right border.
     */
    public JCustomTextField(String text, Color colorBG, Color colorFG,
        double w, double h, int fntSize, int t, int l, int b, int r)
    {
        super(text);

        this.setBackground(colorBG);
        this.setForeground(colorFG);
        this.setPreferredSize(new Dimension((int) w, (int) h));
        this.setFont(new Font("SansSerif", Font.PLAIN, fntSize));
        // this.setAlignmentX(x);
        // this.setAlignmentY(y);
        this.setBorder(new EmptyBorder(t, l, b, r));
    }
}
 