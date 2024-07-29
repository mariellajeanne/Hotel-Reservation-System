/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles errors in hotel creation.
 */

package controller.error;

/**
 * The create hotel error handler class.
 */
public class CreateHotelER
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static CreateHotelER chER; // The single instance of the class.
        private static InputER iER;        // The input error handler.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the create hotel error handler.
         */
        private CreateHotelER()
        {
            iER = InputER.getInstance();
        }

        /**
         * Returns the instance of the create hotel error handler.
         * 
         * @return {CreateHotelER}
         */
        public static CreateHotelER getInstance()
        {
            if (chER == null)
                chER = new CreateHotelER();
            return chER;
        }

    /* -------------------------------------------------------------------------- */
    /*                                MAIN CHECKERS                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Checks all possible errors for creating a hotel.
         * 
         * @param name      {String}    The hotel name.
         * @param standard  {String}    The number of standard rooms.
         * @param deluxe    {String}    The number of deluxe rooms.
         * @param executive {String}    The number of executive rooms.
         * @param price     {String}    The base price.
         * @return          {String}
         */
        public String checkCreateHotel(String name, String standard,
            String deluxe, String executive, String price)
        {
            if (!iER.checkStringChars(name, false))
                return "No spaces must be at the first and last character.";
            else if (!iER.checkStringLength(name))
                return "Hotel name must have 1-20 characters.";
            else if (!iER.checkNameAvailability(name))
                return "Hotel name already exists.";
            else if (!iER.checkIntChars(standard) || !iER.checkIntChars(deluxe) ||
                    !iER.checkIntChars(executive) || !iER.checkDoubleChars(price))
                return "Invalid number input.";
            if (!checkRoomCount(standard, deluxe, executive))
                return "Total room count must be 1-50.";
            if (!iER.checkPriceValue(price))
                return "Base price must be at least 100.0";
            return "";
        }

    /* -------------------------------------------------------------------------- */
    /*                               HELPER CHECKERS                              */
    /* -------------------------------------------------------------------------- */

        /**
         * Checks the number of total rooms to be added.
         * 
         * @param standard  {String}    The number of standard rooms.
         * @param deluxe    {String}    The number of deluxe rooms.
         * @param executive {String}    The number of executive rooms.
         * @return          {double}
         */
        private boolean checkRoomCount(String standard, String deluxe, String executive)
        {
            int sum =   Integer.parseInt(standard) + Integer.parseInt(deluxe) +
                        Integer.parseInt(executive);

            return  sum <= 50 && sum >= 1;
        }
}
