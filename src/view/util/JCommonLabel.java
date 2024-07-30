/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a label with preset settings.
 */

package view.util;

import java.awt.*;
import javax.swing.*;

/**
 * The common label class.
 */
public class JCommonLabel extends JLabel
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the common label.
         *
         * @param colorMode {int}       The text color mode.
         * @param isBold    {boolean}   Determines if the text must be bold.
         */
        public JCommonLabel(int colorMode, boolean isBold)
        {
            setFontStyle(isBold);
            setColor(colorMode);
        }

        /**
         * Constructs the common label given the text.
         * 
         * @param text      {String}    The text.
         * @param colorMode {int}       The text color mode.
         * @param isBold    {boolean}   Determines if the text must be bold.
         * @param x         {int}       The x position.
         * @param y         {int}       The y position.
         * @param w         {int}       The width.
         * @param h         {int}       The height.
         */
        public JCommonLabel(String text, int colorMode, boolean isBold)
        {
            setText(text);
            setFontStyle(isBold);
            setColor(colorMode);
        }

    /* -------------------------------------------------------------------------- */
    /*                                CONFIGURATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Sets the common label's color.
         * 
         * @param colorMode {int} The color mode (0: white, 1: blue)
         */
        private void setColor(int colorMode)
        {
            if (colorMode == 0)
                setForeground(Color.WHITE);
            else
                setForeground(Color.decode("#86d0f3"));
        }

        /**
         * Sets the common label's font style.
         * 
         * @param isBold {boolean} Determines if the font must be bold.
         */
        private void setFontStyle(boolean isBold)
        {
            if (!isBold)
                setFont(new Font("Arial", Font.PLAIN, (int) (40 * Scale.MIN)));
            else
                setFont(new Font("Arial", Font.BOLD, (int) (40 * Scale.MIN)));
        }

        /**
         * Sets the common label's size and position.
         * 
         * @param x {int} The x position.
         * @param y {int} The y position.
         * @param h {int} The height.
         */
        public void setSizePos(int x, int y, int h)
        {
            setBounds((int) (x * Scale.X), (int) (y * Scale.Y),
                    (int) (getPreferredSize().width * 1.2), getPreferredSize().height);
        }
}
