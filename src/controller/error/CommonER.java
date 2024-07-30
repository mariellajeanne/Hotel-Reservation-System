/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles input errors.
 */

package controller.error;

import model.Database;

/**
 * The common error handler class.
 */
public class CommonER
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static CommonER cER; // The single instance of the class.
        private static Database db;  // The database.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the common error handler.
         */
        private CommonER()
        {
            db = Database.getInstance();
        }

        /**
         * Returns the instance of the common error handler.
         * 
         * @return {InputER}
         */
        public static CommonER getInstance()
        {
            if (cER == null)
                cER = new CommonER();
            return cER;
        }

    /* -------------------------------------------------------------------------- */
    /*                                  CHECKERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Checks the character validity of a string.
         * 
         * @param text      {String}    The input text.
         * @param isAlpha   {boolean}   Determines if the characters must be letters only.
         * @return          {boolean}
         */
        public boolean checkStringChars(String text, boolean isAlpha)
        {
            if (text.equals(""))
                return false;

            if (text.charAt(0) == ' ' ||
                text.charAt(text.length() - 1) == ' ')
                return false;

            if (isAlpha)
                return text.matches("^[a-zA-Z\\s]+$");

            return true;
        }

        /**
         * Checks the length of a string.
         * 
         * @param text  {String}    The input text.
         * @return      {boolean}
         */
        public boolean checkStringLength(String text)
        {
            if (text.equals(""))
                return false;
            return text.length() >= 1 && text.length() <= 50;
        }

        /**
         * Checks if the input can be converted into an integer.
         * 
         * @param text  {String}    The input text.
         * @return      {boolean}
         */
        public boolean checkIntChars(String text)
        {
            if (text.equals(""))
                return false;
            try
            {
                Integer.valueOf(text);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
            return true;
        }

        /**
         * Checks if the input can be converted into a double.
         * 
         * @param text  {String}    The input text.
         * @return      {boolean}
         */
        public boolean checkDoubleChars(String text)
        {
            if (text.equals(""))
                return false;
            try
            {
                Double.valueOf(text);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
            return true;
        }

        /**
         * Checks the availability of the hotel name.
         * 
         * @param name  {String}    The hotel name.
         * @return      {boolean}
         */
        public boolean checkNameAvailability(String name)
        {
            return db.getHotel(name) == null;
        }

        /**
         * Checks the validity of the inputted base price value.
         * 
         * @param   price   {String}    The base price.
         * @return          {boolean}
         */
        public boolean checkPriceValue(String price)
        {
            double val = Double.parseDouble(price);

            return val >= 100 && val <= Double.MAX_VALUE;
        }
}
