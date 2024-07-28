/**   
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Size of a button.
 */

package constants;

import java.awt.Dimension;

/**
 * The button size constant class.
 */
public class BtnSizeCons
{
    /* -------------------------------------------------------------------------- */
    /*                                  CONSTANTS                                 */
    /* -------------------------------------------------------------------------- */

    public static final Dimension XS = getExtraSmallSize(); // Extra small.
    public static final Dimension S = getSmallSize();       // Small.
    public static final Dimension M = getMediumSize();      // Medium.
    public static final Dimension L = getLargeSize();       // Large.
    public static final Dimension XL = getExtraLargeSize(); // Extra large.

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the extra small button size.
     * 
     * @return {Dimension}
     */
    private static Dimension getExtraSmallSize()
    {
        int width = (int) (0.165 * WinSizeCons.W);
        int height = (int) (0.555 * WinSizeCons.H);

        return new Dimension(width, height);
    }

    /**
     * Returns the small button size.
     * 
     * @return {Dimension}
     */
    private static Dimension getSmallSize()
    {
        int width = (int) (0.0165 * WinSizeCons.W);
        int height = (int) (0.0555 * WinSizeCons.H);

        return new Dimension(width, height);
    }

    /**
     * Returns the medium button size.
     * 
     * @return {Dimension}
     */
    private static Dimension getMediumSize()
    {
        int width = (int) (0.0165 * WinSizeCons.W);
        int height = (int) (0.0555 * WinSizeCons.H);

        return new Dimension(width, height);
    }

    /**
     * Returns the large button size.
     * 
     * @return {Dimension}
     */
    private static Dimension getLargeSize()
    {
        int width = (int) (0.0165 * WinSizeCons.W);
        int height = (int) (0.0555 * WinSizeCons.H);

        return new Dimension(width, height);
    }

    /**
     * Returns the extra large button size.
     * 
     * @return {Dimension}
     */
    private static Dimension getExtraLargeSize()
    {
        int width = (int) (0.0165 * WinSizeCons.W);
        int height = (int) (0.0555 * WinSizeCons.H);

        return new Dimension(width, height);
    }
}
