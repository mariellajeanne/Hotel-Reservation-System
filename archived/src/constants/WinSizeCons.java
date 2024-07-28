/**   
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Sets the size of the main panel based on the screen size.
 */

package constants;

import java.awt.Toolkit;

/**
 * The window size constant class.
 */
public class WinSizeCons
{
    /* -------------------------------------------------------------------------- */
    /*                                  CONSTANTS                                 */
    /* -------------------------------------------------------------------------- */

    public static final int SW = getScreenWidth();  // Screen width.
    public static final int SH = getScreenHeight(); // Screen height.
    public static final int SM = getScreenMin();    // Screen minimum.

    public static final int W = getWindowWidth();   // Window width.
    public static final int H = getWindowHeight();  // Window height.

    /* -------------------------------------------------------------------------- */
    /*                                   METHODS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the width of the screen.
     * 
     * @return {int}
     */
    private static int getScreenWidth()
    {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    /**
     * Returns the height of the screen.
     * 
     * @return {int}
     */
    private static int getScreenHeight()
    {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    /**
     * Returns the lesser value between the screen width and height.
     * 
     * @return {int}
     */
    private static int getScreenMin()
    {
        return Math.min(SW, SH);
    }

    /**
     * Returns the width of the main panel size.
     * 
     * @return {int}
     */
    private static int getWindowWidth()
    {
        if (SM == SW)
            return SW;
        else
            return (int) (SH / 9.0 * 16.0);
    }

    /**
     * Returns the height of the main panel size.
     * 
     * @return {int}
     */
    private static int getWindowHeight()
    {
        if (SM == SH)
            return SH;
        else
            return (int) (SW / 16.0 * 9.0);
    }

}
