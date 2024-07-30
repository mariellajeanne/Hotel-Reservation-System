/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles all controllers.
 */

package controller.page;

/**
 * The system controller class.
 */
public class SystemCO
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static SystemCO sCO;     // The single instance of the class.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the system controller.
         */
        private SystemCO()
        {
            BookReservationCO.getInstance();
            CreateHotelCO.getInstance();
            HotelHubCO.getInstance();
            ManageHotelCO.getInstance();
            ViewHotelCO.getInstance();
        }

        /**
         * Returns the instance of the system controller.
         */
        public static SystemCO getInstance()
        {
            if (sCO == null)
                sCO = new SystemCO();
            return sCO;
        }
}
