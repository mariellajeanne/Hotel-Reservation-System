/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls hotel viewing.
 */

package controller.page;

/**
 * The view hotel controller.
 */
public class ViewHotelCO
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static ViewHotelCO vhCO; // The single instance of the class.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the view hotel controller.
         */
        private ViewHotelCO()
        {

        }

        /**
         * Returns the instance of the view hotel controller.
         * 
         * @return {ViewHotelCO}
         */
        public static ViewHotelCO getInstance()
        {
            if (vhCO == null)
                vhCO = new ViewHotelCO();
            return vhCO;
        }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT LISTENERS                              */
    /* -------------------------------------------------------------------------- */

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */
}