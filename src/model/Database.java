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

        private final ArrayList<Hotel> hotels;  // The hotels.
        private Hotel hotel;                    // The hotel currently being handled.
        private Room room;                      // The room currently being handled.
        private Reservation reservation;        // The reservation currently being handled.
        private int date;                       // The date currently being handled.

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
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the hotels.
         * 
         * @return {ArrayList<Hotel>} The hotel.
         */
        public ArrayList<Hotel> getHotels()
        {
            return this.hotels;
        }

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
         * Returns the hotel currently being handled.
         * 
         * @return  {Hotel}
         */
        public Hotel getHotel()
        {
            return this.hotel;
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
         * Returns the room currently being handled.
         * 
         * @return {Room}
         */
        public Room getRoom()
        {
            return this.room;
        }

        /**
         * Returns the reservation currently being handled.
         * 
         * @return {Reservation}
         */
        public Reservation getReservation()
        {
            return this.reservation;
        }

        /**
         * Returns the date currently being handled.
         * 
         * @param date {int} The date.
         */
        public int getDate()
        {
            return this.date;
        }
    
    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Sets the hotel to be currently handled.
         * 
         * @param h {Hotel} The hotel to be handled.
         */
        public void setHotel(Hotel h)
        {
            this.hotel = h;
        }

        /**
         * Sets the room to be currently handled.
         * 
         * @param r {Room} The room to be handled.
         */
        public void setRoom(Room r)
        {
            this.room = r;
        }

        /**
         * Sets the reservation to be currently handled.
         * 
         * @param r {Reservation} The reservation to be handled.
         */
        public void setReservation(Reservation r)
        {
            this.reservation = r;
        }

        /**
         * Sets the date to be currently handled.
         * 
         * @param d {int} The date.
         */
        public void setDate(int d)
        {
            this.date = d;
        }

    /* -------------------------------------------------------------------------- */
    /*                             ADDERS AND REMOVERS                            */
    /* -------------------------------------------------------------------------- */

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

            if (hotels.isEmpty())
                this.hotel = null;
        }

    /* -------------------------------------------------------------------------- */
    /*                                  UPDATERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Updates the default values of the database.
         */
        public void updateDefaultValues()
        {
            // Sets the hotel to null if there exists no hotel.
            if (db.getHotels().isEmpty())
                hotel = null;
        
            else
            {
                // Sets the default chosen hotel to the first in the list.
                hotel = hotels.getFirst();

                // Sets the default chosen room to the hotel's first room.
                room = (hotel.getRooms().getFirst());

                /*
                 * Sets the default chosen reservation to null
                 * if there exists no reservations.
                 */
                if (hotel.getNumOfReservations() == 0)
                    reservation = null;

                /*
                 * Sets the default chosen reservation to the hotel's
                 * first reservation otherwise.
                 */
                else
                {
                    boolean isFound = false;

                    // Loops through each room.
                    for (int i = 0; i < hotel.getRooms().size() && !isFound; i++)
                    {
                        Room r = hotel.getRooms().get(i);

                        // Sets the reservation if found.
                        if (!r.getReservations().isEmpty())
                        {
                            reservation = r.getReservations().getFirst();
                            isFound = true;
                        }
                    }
                }
            }
        }
}
