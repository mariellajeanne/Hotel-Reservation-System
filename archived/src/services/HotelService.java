/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Performs services for manipulating a hotel.
 */

package services;

public class HotelService
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private static HotelService hs; // The single instance of the class.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the hotel service.
     */
    private HotelService()
    {

    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the instance of the hotel service.
     */
    public static HotelService getInstance()
    {
        if (hs == null)
            hs = new HotelService();
        return hs;
    }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * 
     */

}
