/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles errors in hotel management.
 */

package controller.error;

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

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the manage hotel error handler.
         */
        private ManageHotelER()
        {
            iER = InputER.getInstance();
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
    /*                                MAIN CHECKERS                               */
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
         * Checks all possible errors for adding rooms.
         * 
         * @param h     {Hotel}     The hotel.
         * @param n     {String}    The number of rooms to be added.
         * @return      {String}
         */
        public String checkAddRooms(Hotel h, String n)
        {
            if (!iER.checkIntChars(n))
                return "Invalid number input.";
            else if (checkMaxMinRoomCnt(h, true))
                return "Maximum number of rooms reached.";
            else if (!checkAddedValue(h, n))
                return "Number range must be 1-" + (50 - h.getRooms().size());
            return "";
        }

        /**
         * Checks all possible errors for deleting rooms.
         * 
         * @param h     {Hotel}     The hotel.
         * @param type  {String}    The room type.
         * @param n     {String}    The number of rooms to be deleted.
         * @return      {String}
         */
        public String checkDeleteRooms(Hotel h, String type, String n)
        {
            if (!iER.checkIntChars(n))
                return "Invalid number input.";
            else if (checkMaxMinRoomCnt(h, false))
                return "Minimum number of rooms reached.";
            else if (!checkDeletedValue(h, type, n))
            {
                if (h.getRooms().size() == h.getNumOfAvailRooms(type))
                    return "Number range must be 1-" + ((h.getNumOfAvailRooms(type) - 1));
                else
                    return "Number range must be 1-" + (h.getNumOfAvailRooms(type));
            }
            return "";
        }

    /* -------------------------------------------------------------------------- */
    /*                               HELPER CHECKERS                              */
    /* -------------------------------------------------------------------------- */

        /**
         * Checks if the number of rooms to be added is valid.
         * 
         * @param h     {Hotel}     The hotel.
         * @param n     {String}    The number of rooms to be added.
         * @return      {boolean}
         */
        private boolean checkAddedValue(Hotel h, String n)
        {
            int cnt = Integer.parseInt(n);

            return cnt + h.getRooms().size() <= 50 &&
                   cnt >= 1;
        }

        /**
         * Checks if the number of rooms to be deleted is valid.
         * 
         * @param h     {Hotel}     The hotel.
         * @param type  {String}    The room type.
         * @param n     {String}    The number of rooms to be added.
         * @return      {boolean}
         */
        private boolean checkDeletedValue(Hotel h, String type, String n)
        {
            int deleteCnt = Integer.parseInt(n);
            int typeCnt =  h.getNumOfAvailRooms(type);

            if (h.getRooms().size() == typeCnt)
                return deleteCnt >= 1 && deleteCnt <= typeCnt - 1;
            else
                return deleteCnt >= 1 && deleteCnt <= typeCnt;
        }

        /**
         * Checks if the number of existing rooms reached maximum/minimum.
         * 
         * @param h     {Hotel}     The hotel.
         * @param isMax {boolean}   Determines if the max/min room count is to be found.
         * @return      {boolean}
         */
        private boolean checkMaxMinRoomCnt(Hotel h, boolean isMax)
        {
            if (isMax)
                return h.getRooms().size() == 50;
            else
                return h.getRooms().size() == 1;
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
         * Checks all possible errors for changing the night rate.
         * 
         * @param   rate    {String}    The night rate.
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
         * Checks the validity of the inputted night rate.
         * 
         * @param rate  {String}    The night rate.
         * @return      {boolean}
         */
        private boolean checkRateValue(String rate)
        {
            double val = Double.parseDouble(rate);

            return val >= 0.50 && val <= 1.50;
        }
}
