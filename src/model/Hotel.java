/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models a hotel.
 */

package model;

import java.util.ArrayList;
import java.util.Arrays;


public class Hotel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private String name;                      // The hotel's name.
        private double basePrice;                 // The hotel's base price.
        private final double[] rates;             // The hotel's rates per date.
        private final ArrayList<Room> rooms;      // The hotel's rooms.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs a hotel given its properties.
         * 
         * @param name      {String}    The hotel's name.
         * @param basePrice {double}    The hotel's base price.
         * @param standard  {int}       The number of standard rooms.
         * @param deluxe    {int}       The number of deluxe rooms.
         * @param executive {int}       The number of executive rooms.   
         */
        public Hotel(String name, double basePrice, int standard, int deluxe, int executive)
        {
            this.name = name;
            this.basePrice = basePrice;
            this.rates = new double[30];
            this.rooms = new ArrayList<>();

            for (int i = 1; i <= standard; i++)
                this.rooms.add(new Room(i, "STANDARD", basePrice));
            for (int i = standard + 1; i <= standard + deluxe; i++)
                this.rooms.add(new Room(i, "DELUXE", basePrice));
            for (int i = standard + deluxe + 1; i <= standard + deluxe + executive; i++)
                this.rooms.add(new Room(i, "EXECUTIVE", basePrice));

            Arrays.fill(rates, 1.0);
        }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the hotel name.
         * 
         * @return {String}
         */
        public String getName()
        {
            return this.name;
        }

        /**
         * Returns the hotel rooms' base price.
         * 
         * @return {double}
         */
        public double getBasePrice()
        {
            return this.basePrice;
        }

        /**
         * Returns the price rate given a date.
         * 
         * @param date {int} The date.
         * @return     {double}
         */
        public double getDateRate(int date)
        {
            return this.rates[date - 1];
        }

        /**
         * Returns the hotel's rooms.
         * 
         * @return {Room}
         */
        public ArrayList<Room> getRooms()
        {
            return this.rooms;
        }

        /**
         * Returns the number of rooms without reservations.
         * 
         * @param   type    {String}    The room type.
         * @return          {int}
         */
        public int getAvailablExecutives(String type)
        {
            int i = 0;

            for (Room r : this.rooms)
            {
                if (r.getType().equals(type) &&
                    r.getReservations().isEmpty())
                    i++;
            }

            return i;
        }


    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Sets the hotel name.
         * 
         * @param name {String} The hotel name.
         */
        public void setName(String name)
        {
            this.name = name;
        }

        /**
         * Sets the hotel rooms' base price.
         * 
         * @param basePrice {double} The base price.
         */
        public void setBasePrice(double basePrice)
        {
            this.basePrice = basePrice;

            for (int i = 0; i < this.rooms.size(); i++)
            {
                this.rooms.get(i).setNightlyPrice(basePrice);
            }
        }

        /**
         * Sets the rate of a particular date.
         * 
         * @param date {int} The date.
         * @param rate {double} The rate.
         */
        public void setDateRate(int date, double rate)
        {
            this.rates[date - 1] = rate;
        }

        /* -------------------------------------------------------------------------- */
        /*                                   OTHERS                                   */
        /* -------------------------------------------------------------------------- */

        /**
         * Adds a room to the hotel.
         * 
         * @param r {Room} The room.
         */
        public void adDeluxe(Room r)
        {
            this.rooms.add(r);
        }
}
