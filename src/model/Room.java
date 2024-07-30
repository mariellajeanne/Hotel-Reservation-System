/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models a room.
 */

package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The room model class.
*/
public class Room
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */
    
        private int num;                                    // The room's number.
        private final String type;                          // The room type.
        private double nightlyPrice;                        // The room's nightly price.
        private final ArrayList<Reservation> reservations;  // The room's reservations.
        private final ArrayList<Integer> reservedDates;     // The room's reserved dates.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs a room given its number and nightly price.
         * 
         * @param num          {int} The room number.
         * @param type         {String} The room type.
         * @param basePrice    {double} The hotel's room base price.
         */
        public Room(int num, String type, double basePrice)
        {
            this.num = num;
            this.type = type;
            this.reservations = new ArrayList<>();
            this.reservedDates = new ArrayList<>();
            
            setNightlyPrice(basePrice);
        }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the room types.
         * 
         * @return {String[]}
         */
        public static String[] getRoomTypes()
        {
            String[] roomTypes = {"Standard", "Deluxe", "Executive"};
            return roomTypes;
        }

        /**
         * Returns the room number.
         * 
         * @return {int}
         */
        public int getNum()
        {
            return this.num;
        }

        /**
         * Returns the room type.
         * 
         * @return {String}
         */
        public String getType()
        {
            return this.type;
        }

        /**
         * Returns the room's nightly price.
         * 
         * @return {double}
         */
        public double getNightlyPrice()
        {
            return this.nightlyPrice;
        }

        /**
         * Returns the room's reservations.
         * 
         * @return {ArrayList<Reservation>}
         */
        public ArrayList<Reservation> getReservations()
        {
            return this.reservations;
        }

        /**
         * Returns a reservation given the check-in date.
         * 
         * @param checkIn {int} The check-in date.
         * @return Reservation
         */
        public Reservation getReservation(int checkIn)
        {
            for (Reservation r : this.reservations)
            {
                if (r.getCheckIn() == checkIn)
                    return r;
            }
            return null;
        }

        /**
         * Returns the room's reserved dates.
         * 
         * @return {ArrayList<Integer>}
         */
        public ArrayList<Integer> getReservedDates()
        {
            return this.reservedDates;
        }

        /**
         * Returns the codes of the room's reservations.
         * 
         * @return {String[]}
         */
        public String[] getReservationCodes()
        {
            ArrayList<String> resCodesList = new ArrayList<>();

            for (Reservation res : reservations)
                resCodesList.add(res.getCode());

            String[] resCodesArray = new String[resCodesList.size()];
            resCodesList.toArray(resCodesArray);

            return resCodesArray;
        }

        /**
         * Returns the nights when the room is not reserved.
         * 
         * @return {String[]}
         */
        public String[] getAvailableNights()
        {
            // Gets all the reservation nights.
            ArrayList<String> availNightsList =
            new ArrayList<>(Arrays.asList(Reservation.getReservationDates(true)));

            // Loops through each reservation.
            for (Reservation r : reservations)
            {
                // Removes all the reserved nights.
                for (int i = r.getCheckIn(); i < r.getCheckOut(); i++)
                    availNightsList.remove(String.valueOf(i));
            }

            // Stores the available nights list in an array.
            String[] availNightsArray = new String[availNightsList.size()];
            availNightsList.toArray(availNightsArray);

            return availNightsArray;
        }

    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Sets the room number.
         * 
         * @param num {int} The room number.
         */
        public void setNum(int num)
        {
            this.num = num;
        }

        /**
         * Sets the room's nightly price given the base price and its type.
         * 
         * @param basePrice {double} The base price.
         */
        public final void setNightlyPrice(double basePrice)
        {
            this.nightlyPrice = switch(type)
            {
                case "Deluxe"       -> basePrice * 1.20;
                case "Executive"    -> basePrice * 1.35;
                default             -> basePrice;
            };
        }

        /**
         * Sets the room's reserved dates.
         * 
         * @param checkIn  {int} The check-in date.
         * @param checkOut {int} The check-out date.
         */
        public void setReservedDates(int checkIn, int checkOut)
        {
            for (int i = checkIn; i < checkOut; i++)
            {
                this.reservedDates.add(i);
            }
        }
    
    /* -------------------------------------------------------------------------- */
    /*                                   ADDERS                                   */
    /* -------------------------------------------------------------------------- */

        /**
         * Adds a reservation.
         * 
         * @param r {Reservation} The reservation.
         */
        public void addReservation(Reservation r)
        {
            this.reservations.add(r);
        }
}
