/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * The database.
 */

package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The database class.
 */
public class Database
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static Database db; // The single instance of the class.

        private final ArrayList<Hotel> hotels; // The hotels.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the database.
         */
        private Database()
        {
            hotels = new ArrayList<>();
        }

        /**
         * Returns the instance of the database.
         * 
         * @return {Database}
         */
        public static Database getInstance()
        {
            if (db == null)
                db = new Database();
            return db;
        }

    /* -------------------------------------------------------------------------- */
    /*                                  C.R.U.D.                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns an array of the hotel names.
         * 
         * @return {String[]}
         */
        public String[] getHotelNames()
        {
            String[] hotelNames = new String[hotels.size()];

            for (int i = 0; i < hotels.size(); i++)
                hotelNames[i] = hotels.get(i).getName();

            Arrays.sort(hotelNames);

            return hotelNames;
        }

        /**
         * Returns the hotel given the name.
         * 
         * @param name  {String}    The hotel name.
         * @return      {Hotel}
         */
        public Hotel getHotel(String name)
        {
            for (Hotel h : hotels)
            {
                if (h.getName().equals(name))
                    return h;
            }
            return null;
        }

        /**
         * Adds a hotel to the database.
         * 
         * @param h {Hotel} The hotel.
         */
        public void addHotel(Hotel h)
        {
            hotels.add(h);
        }

        /**
         * Removes a hotel from the database.
         * 
         * @param name      {Hotel}     The hotel name.
         */
        public void removeHotel(String name)
        {
            hotels.remove(getHotel(name));
        }

        /**
         * Returns the room types.
         * 
         * @return {String[]}
         */
        public String[] getRoomTypes()
        {
            String[] roomTypes = {"Standard", "Deluxe", "Executive"};
            return roomTypes;
        }

        /**
         * Returns the valid set of reservation dates.
         * 
         * @param isCheckIn {boolean} Determine if the dates to be returned
         *                            are the check-in dates.
         * @return          {Integer[]}
         */
        public Integer[] getReservationDates(boolean isCheckIn)
        {
            Integer[] reservationDates = new Integer[30];

            if (isCheckIn)
            {
                for (int i = 0; i < 30; i++)
                    reservationDates[i] = i + 1;
            }
            else
            {
                for (int i = 0; i < 30; i++)
                    reservationDates[i] = i + 2;
            }
            
            return reservationDates;
        }
}
