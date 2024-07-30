/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles errors in reservation booking.
 */

/**
 * Class associations:
 * 
 * Uses model.Hotel
 * Uses model.Room
 */

package controller.error;

import model.Hotel;
import model.Room;

/**
 * The book reservation error handler class.
 */
public class BookReservationER
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static BookReservationER brER; // The single instance of the class.
        private static CommonER cER;           // The common error handler.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the book reservation error handler.
         */
        private BookReservationER()
        {
            cER = CommonER.getInstance();
        }

        /**
         * Returns the instance of the book reservation error handler.
         * 
         * @return {BookReservationER}
         */
        public static BookReservationER getInstance()
        {
            if (brER == null)
                brER = new BookReservationER();
            return brER;
        }

    /* -------------------------------------------------------------------------- */
    /*                                MAIN CHECKERS                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Checks all possible errors for booking a reservation.
         * 
         * @param guest     {String}    The guest name.
         * @param h         {Hotel}     The hotel.
         * @param type      {String}    The room type.
         * @param checkIn   {int}       The check-in date.
         * @param checkOut  {int}       The check-out date.
         * @param code      {String}    The discount code.
         * @return          {String}
         */
        public String checkBookReservation(String guest, Hotel h, String type,
            int checkIn, int checkOut, String code)
        {
            if (guest.equals(""))
                return "Guest name must be entered.";
            if (!cER.checkStringChars(guest, true))
                return "Invalid guest name characters.";
            else if (!cER.checkStringLength(guest))
                return "Guest name must have 1-50 characters.";
            else if (!checkDates(checkIn, checkOut))
                return "Invalid reservation dates.";
            else if (!checkAvailability(h, type, checkIn, checkOut))
                return "No available room given the details.";
            else if (!checkCode(type))
                return "Invalid discount code.";
            return "";
        }

    /* -------------------------------------------------------------------------- */
    /*                               HELPER CHECKERS                              */
    /* -------------------------------------------------------------------------- */

        // TODO Deal with empty inputs

        /**
         * Checks if the check-in date check-out dates are valid.
         * 
         * @param checkIn   {int}   The check-in date.
         * @param checkOut  {int}   The check-out date.
         * @return          {boolean}
         */
        private boolean checkDates(int checkIn, int checkOut)
        {
            return checkIn < checkOut;
        }

        /**
         * Checks if a given room type is available given the reservation dates.
         * 
         * @param h         {Hotel}     The hotel.
         * @param type      {String}    The room type.
         * @param checkIn   {int}       The check-in date.
         * @param checkOut  {int}       The check-out date.
         * @return          {boolean}       
         */
        private boolean checkAvailability(Hotel h, String type, int checkIn, int checkOut)
        {
            for (Room r : h.getRooms())
            {
                if (r.getType().equals(type))
                {
                    for (int j = checkIn; j < checkOut; j++)
                    {
                        if (r.getReservedDates().contains(j))
                            return false;
                    }
                }
            }
            return true;
        }

        /**
         * Checks if the discount code exists.
         * 
         * @param code  {String}    The discount code.
         * @return      {boolean}
         */
        private boolean checkCode(String code)
        {
            return  code.equals("I_WORK_HERE") ||
                    code.equals("STAY4_GET1") ||
                    code.equals("PAYDAY") ||
                    code.equals("");
        }
}
