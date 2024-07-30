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
        private static CommonER cER;       // The common error handler.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the create hotel error handler.
         */
        private CreateHotelER()
        {
            cER = CommonER.getInstance();
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
            if (name.equals("") || standard.equals("") ||
                deluxe.equals("") || executive.equals("") ||
                price.equals(""))
                return "All fields must be filled out.";
            if (!cER.checkStringChars(name, false))
                return "No spaces must be at the first and last character.";
            else if (!cER.checkStringLength(name))
                return "Hotel name must have 1-50 characters.";
            else if (!cER.checkNameAvailability(name))
                return "Hotel name already exists.";
            else if (!cER.checkIntChars(standard) || !cER.checkIntChars(deluxe) ||
                    !cER.checkIntChars(executive) || !cER.checkDoubleChars(price))
                return "Invalid number input.";
            if (!checkRoomCount(standard, deluxe, executive))
                return "Total room count must be 1-50.";
            if (!cER.checkPriceValue(price))
                return "Base price must be at least 100.0.";
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
            int standardCnt = Integer.parseInt(standard);
            int deluxeCnt = Integer.parseInt(deluxe);
            int executiveCnt = Integer.parseInt(executive);

            int sum = standardCnt + deluxeCnt + executiveCnt;

            return  sum >= 1 && sum <= 50 && standardCnt >= 0 &&
                    deluxeCnt >= 0 && executiveCnt >= 0;
        }
}
