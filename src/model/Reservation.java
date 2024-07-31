/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models a reservation.
 */

package model;

import java.text.DecimalFormat;

/**
 * The reservation model class.
*/
public class Reservation
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private final String guest;           // The guest's name.
        private final int checkIn;            // The check-in date.
        private final int checkOut;           // The check-out date.
        private final Room room;              // The reserved room.
        private final double nightlyPrices[]; // The price per night.
        private double totalPrice;            // The total price.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs a reservation given the guest's name, the check-in date,
         * the check-out date, the reserved room, and the discount code.
         * 
         * @param guest      {String}    The guest name.
         * @param checkIn    {int}       The check-in date.
         * @param checkOut   {int}       The check-out date.
         * @param room       {Room}      The reserved room.
         */
        public Reservation(String guest, int checkIn, int checkOut, Room room)
        {
            this.guest = guest;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            this.room = room;
            this.nightlyPrices = new double[this.checkOut - this. checkIn];

            this.room.setReservedDates(checkIn, checkOut);
        }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns a set of valid reservation dates.
         * 
         * @param isCheckIn {boolean} Determine if the dates to be returned
         *                            are the check-in dates.
         * @return          {String[]}
         */
        public static String[] getReservationDates(boolean isCheckIn)
        {
            String[] reservationDates = new String[30];

            if (isCheckIn)
            {
                for (int i = 0; i < 30; i++)
                    reservationDates[i] = String.valueOf(i + 1);
            }
            else
            {
                for (int i = 0; i < 30; i++)
                    reservationDates[i] = String.valueOf(i + 2);
            }
            
            return reservationDates;
        }

        /**
         * Returns an array of reservation nights.
         * 
         * @retun String[]
         */
        public static String[] getReservationNights()
        {
            String[] reservationNights = new String[30];

            for (int i = 0; i < 30; i++)
            {
                reservationNights[i] =
                    String.valueOf(i + 1) + "-" +
                    String.valueOf(i + 2);
            }

            return reservationNights;
        }

        /**
         * Returns the guest's name.
         * 
         * @return {String}
         */
        public String getGuest()
        {
            return this.guest;
        }
        
        /**
         * Returns the check-in date.
         * 
         * @return {int}
         */
        public int getCheckIn()
        {
            return this.checkIn;
        }

        /**
         * Returns the check-out date.
         * 
         * @return {int}
         */
        public int getCheckOut()
        {
            return this.checkOut;
        }

        /**
         * Returns a string of the check-in and check-out dates.
         * 
         * @return {String}
         */
        public String getCheckInAndOut()
        {
            return checkIn + "-" + checkOut;
        }

        /**
         * Returns the room.
         * 
         * @return {Room}
         */
        public Room getRoom()
        {
            return this.room;
        }

        /**
         * Returns the nightly price given the night.
         * 
         * @param night {int} The night.
         * @return      {double}
         */
        public double getNightlyPrice(int night)
        {
            return this.nightlyPrices[night - checkIn];
        }

        /**
         * Returns an array of the nightly price breakdown.
         * 
         * @return {String[][]}
         */
        public String[] getNightlyPrices()
        {
            String[] pricePerNight = new String[nightlyPrices.length];

            for (int i = checkIn; i < checkOut; i++)
            {
                pricePerNight[i - checkIn] = "Night " +
                    (i) + (i + 1) + ": " + new DecimalFormat("#.##").
                    format(getNightlyPrice(i));
            }
                
            return pricePerNight;
        }

        /**
         * Returns the total reservation price.
         * 
         * @return {double}
         */
        public double getTotalPrice()
        {
            return this.totalPrice;
        }

        /**
         * Gets the reservation code.
         * 
         * @return {String} The reservation code.
         */
        public String getCode()
        {
            return "Room " + room.getNum() + ": " +
                checkIn + "-" + checkOut;
        }

    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Sets the price of a night.
         * 
         * @param night {int} The night.
         * @param price {double} The price.
         */
        public void setNightlyPrice(int night, double price)
        {
            this.nightlyPrices[night - checkIn] = price;
        }

        /**
         * Sets the total price of the reservation.
         * 
         * @param totalPrice {double} The total price.
         */
        public void setTotalPrice(double totalPrice)
        {
            this.totalPrice = totalPrice;
        }

    /* -------------------------------------------------------------------------- */
    /*                                  BOOLEANS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Checks if a reservation has a particular night.
         * 
         * @param night {int} The night.
         * @return {boolean}
         */
        public boolean hasNight(int night)
        {
            return night >= this.checkIn && night < this.checkOut;
        }
}
