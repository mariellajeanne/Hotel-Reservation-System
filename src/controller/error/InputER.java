/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles input errors.
 */

package service.error;

import model.Database;

/**
 * The input error handler class.
 */
public class InputER
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static InputER iER; // The single instance of the class.
        private static Database db; // The database.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the input error handler.
         */
        private InputER()
        {
            db = Database.getInstance();
        }

        /**
         * Returns the instance of the input error handler.
         * 
         * @return {InputER}
         */
        public static InputER getInstance()
        {
            if (iER == null)
                iER = new InputER();
            return iER;
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
            return text.length() >= 1 && text.length() <= 20;
        }

        /**
         * Checks if the input can be converted into an integer.
         * 
         * @param text  {String}    The input text.
         * @return      {boolean}
         */
        public boolean checkIntChars(String text)
        {
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
