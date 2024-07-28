/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls the menu.
 */

package controller.page;

/**
 * The hotel hub controller.
*/
public class HotelHubCO
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static HotelHubCO hhCO; // The single instance of the class.
        

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the hotel hub controller.
         */
        private HotelHubCO()
        {

        }

        /**
         * Returns the instance of the hotel hub controller.
         * 
         * @return {HotelHubCO}
         */
        public static HotelHubCO getInstance()
        {
            if (hhCO == null)
                hhCO = new HotelHubCO();
            return hhCO;
        }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT LISTENERS                              */
    /* -------------------------------------------------------------------------- */

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */
}