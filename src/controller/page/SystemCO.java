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

        private static BookReservationCO brCO;  // The book reservation controller.
        private static CreateHotelCO chCO;      // The create hotel controller.
        private static HotelHubCO hhCO;         // The hotel hub controller.
        private static ManageHotelCO mhCO;      // The manage hotel controller.
        private static ViewHotelCO vhCO;        // The view hotel controller.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the system controller.
         */
        private SystemCO()
        {
            brCO = BookReservationCO.getInstance();
            chCO = CreateHotelCO.getInstance();
            hhCO = HotelHubCO.getInstance();
            mhCO = ManageHotelCO.getInstance();
            vhCO = ViewHotelCO.getInstance();
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
