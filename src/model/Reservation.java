/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models a reservation.
 */

package model;

/**
 * The reservation model class.
*/
public class Reservation
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private final String client;          // The client's name.
        private final int checkIn;            // The check-in date.
        private final int checkOut;           // The check-out date.
        private final Room room;              // The reserved room.
        private final double nightlyPrices[]; // The price per night.
        private double totalPrice;            // The total price.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs a reservation given the client's name, the check-in date,
         * the check-out date, the reserved room, and the discount code.
         * 
         * @param guest      {String}    The guest name.
         * @param checkIn    {int}       The check-in date.
         * @param checkOut   {int}       The check-out date.
         * @param room       {Room}      The reserved room.
         * @param code       {String}    The discount code.
         */
        public Reservation(String client, int checkIn, int checkOut,
                        Room room, String code)
        {
            this.client = client;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            this.room = room;
            this.nightlyPrices = new double[this.checkOut - this. checkIn];
        }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the client's name.
         * 
         * @return {String}
         */
        public String getClient()
        {
            return this.client;
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
         * @return {double}
         */
        public double getNightlyPrice(int night)
        {
            return this.nightlyPrices[checkIn - night];
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
            this.nightlyPrices[checkIn - night] = price;
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
    /*                                   OTHERS                                   */
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
