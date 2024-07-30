/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Returns the width, height, and font size scales.
 */

package view.util;

import java.awt.Toolkit;

public class Scale
{
    /* -------------------------------------------------------------------------- */
    /*                                  CONSTANTS                                 */
    /* -------------------------------------------------------------------------- */

        // Screen width and height.
        public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
        public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

        // Ratio of the screen width and height to 1920 and 1080, respectively.
        public static final double X = getXScale();
        public static final double Y = getYScale();

        // Gets the smallest of the width and height ratios.
        public static final double MIN = Math.min(X, Y);

        // Ratio of the screen area to the 1920x1080 area.
        public static final double A = (X * Y) / 1.0;

    /* -------------------------------------------------------------------------- */
    /*                                   METHODS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the screen width to 1920px ratio.
         * 
         * @return {double}
         */
        private static double getXScale()
        {
            if (WIDTH < HEIGHT)
                return WIDTH / 1920.0;
            else
                return ((HEIGHT / 9.0) * 16.0) / 1920.0;
        }

        /**
         * Returns the screen height to 1080px ratio.
         * 
         * @return {double}
         */
        private static double getYScale()
        {
            if (HEIGHT < WIDTH)
                return HEIGHT / 1080.0;
            else
                return ((WIDTH / 16.0) * 9.0) / 1080.0;
        }

        
}
