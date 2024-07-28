/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models a room.
 */

package model;

import java.util.ArrayList;

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
         * Returns the room number.
         * 
         * @return {int}
         */
        public int getNumber()
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
                case "DELUXE"       -> basePrice * 1.20;
                case "EXECUTIVE"    -> basePrice * 1.35;
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
    /*                                   OTHERS                                   */
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
