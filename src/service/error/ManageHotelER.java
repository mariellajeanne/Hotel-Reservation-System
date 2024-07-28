/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles errors in hotel management.
 */

package service.error;

import model.*;

/**
 * The manage hotel error handler class.
 */
public class ManageHotelER
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static ManageHotelER mhER; // The single instance of the class.
        private static InputER iER;        // The input error handler.
        private static Database db;        // The database.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the manage hotel error handler.
         */
        private ManageHotelER()
        {
            iER = InputER.getInstance();
            db = Database.getInstance();
        }

        /**
         * Returns the instance of the manage hotel error handler.
         * 
         * @return {ManageHotelER}
         */
        public static ManageHotelER getInstance()
        {
            if (mhER == null)
                mhER = new ManageHotelER();
            return mhER;
        }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Checks all possible errors for changing the hotel name.
         * 
         * @param   name    {String}    The hotel name.
         * @return          {String}
         */
        public String checkChangeName(String name)
        {
            if (!iER.checkStringChars(name, false))
                return "No spaces must be at the first and last character.";
            else if (!iER.checkStringLength(name))
                return "Hotel name must have 1-20 characters.";
            else if (!iER.checkNameAvailability(name))
                return "Hotel name already exists.";
            return "";
        }

        /**
         * Checks all possible errors for changing the base price.
         * 
         * @param   hotel   {Hotel}     The hotel.
         * @param   price   {String}    The base price.
         * @return          {String}
         */
        public String checkChangePrice(Hotel h, String price)
        {
            if (!checkHotelReservations(h))
                return "Base price cannot change; hotel has reservations.";
            if (!iER.checkDoubleChars(price))
                return "Base price must be a decimal.";
            else if (!iER.checkPriceValue(price))
                return "Base price must be at least 100.0.";
            return "";
        }

        /**
         * Checks all possible errors for changing the date rate.
         * 
         * @param   rate    {String}    The date rate.
         * @return          {String}
         */
        public String checkChangeRate(String rate)
        {
            if (!iER.checkDoubleChars(rate))
                return "Date rate must be a decimal.";
            else if (!checkRateValue(rate))
                return "Date rate must be 0.50 to 1.50";
            return "";
        }

        /**
         * Checks if a hotel has no reservations.
         * 
         * @param h {Hotel} The hotel.
         * @return  {boolean}
         */
        private boolean checkHotelReservations(Hotel h)
        {
            for (Room r : h.getRooms())
            {
                if (!r.getReservations().isEmpty())
                    return false;
            }
            return true;
        }

        /**
         * Checks the validity of the inputted date rate.
         * 
         * @return  rate    {String}    The date rate.
         * @return          {boolean}
         */
        private boolean checkRateValue(String rate)
        {
            double val = Double.parseDouble(rate);

            return val >= 0.50 && val <= 1.50;
        }
}
