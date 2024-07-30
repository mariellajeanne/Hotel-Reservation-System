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

        // TODO make a hashmap of rooms : reservation
        // TODO room based on index
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
        public double getNightRate(int date)
        {
            return this.rates[date - 1];
        }

        /**
         * Returns the total number of reservations.
         * 
         * @return {int}
         */
        public int getNumOfReservations()
        {
            int n = 0;

            for (Room r : rooms)
            {
                n += r.getReservations().size();
            }

            return n;
        }

        /**
         * Returns the reservation codes of all rooms.
         * 
         * @return {String[]}
         */
        public String[] getReservationCodes()
        {
            ArrayList<String> resCodesList = new ArrayList<>();
            int count = 0;

            for (Room r : rooms)
            {
                ArrayList<String> roomResCodes =
                new ArrayList<>(Arrays.asList(r.getReservationCodes()));

                resCodesList.addAll(roomResCodes);
                count += r.getReservations().size();
            }

            String[] resCodesArray = new String[count];
            resCodesList.toArray(resCodesArray);

            return resCodesArray;
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
         * Returns an array of the room numbers.
         * 
         * @return {String[]}
         */
        public String[] getRoomNumbers()
        {
            String[] numbers = new String[rooms.size()];

            for (int i = 0; i < numbers.length; i++)
                numbers[i] = String.valueOf(i + 1);

            return numbers;
        }

        /**
         * Returns the total number of rooms without reservations.
         * 
         * @return {int}
         */
        public int getNumOfAvailRooms()
        {
            int i = 0;

            for (Room r : rooms)
            {
                if (r.getReservations().isEmpty())
                    i++;
            }

            return i;
        }

        /**
         * Returns the number of rooms of a certain type without reservations.
         * 
         * @param   type    {String}    The room type.
         * @return          {int}
         */
        public int getNumOfAvailRooms(String type)
        {
            int i = 0;

            for (Room r : rooms)
            {
                if (r.getType().equals(type) &&
                    r.getReservations().isEmpty())
                    i++;
            }

            return i;
        }

        /**
         * Returns the number of available rooms given the date.
         * 
         * @param   date    {int}       The date.
         * @param   isAvail {boolean}   Determines if the availability is to be determined.
         * @return          {int}
         */
        public int getNumOfAvailRooms(int date, boolean isAvail)
        {
            int n; // The date count.
            
            // Assigns the initial night count.
            if (isAvail)    n = rooms.size();
            else            n = 0;

            // Loops through each room.
            for (Room r : rooms)
            {
                // Loops through each reservation.
                for (int i = 0; i < r.getReservations().size(); i++)
                {
                    // Checks if the reservation has the chosen date.
                    if (r.getReservations().get(i).hasNight(date))
                    {
                        if (isAvail)    n--;
                        else            n++;
                    }
                        
                }
            }
            return n;
        }

        /**
         * Returns the total number of rooms booked.
         * 
         * @return {int}
         */
        public int getNumOfBookedRooms()
        {
            return rooms.size() - getNumOfAvailRooms();
        }

        /**
         * Returns the hotel's total estimated earnings.
         * 
         * @return {double}
         */
        public double getTotalEarnings()
        {
            double sum = 0;

            for (Room r : rooms)
            {
                for (int i = 0; i < r.getReservations().size(); i++)
                    sum += r.getReservations().get(i).getTotalPrice();
            }

            return sum;
        }

        /**
         * Returns the first room with a reservation.
         * 
         * @return {Room}
         */
        public Room getFirstReservedRoom()
        {
            for (Room r : rooms)
            {
                if (!r.getReservations().isEmpty())
                    return r;
            }
            return null;
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

            for (int i = 0; i < rooms.size(); i++)
            {
                rooms.get(i).setNightlyPrice(basePrice);
            }
        }

        /**
         * Sets the rate of a particular date.
         * 
         * @param date {int} The date.
         * @param rate {double} The rate.
         */
        public void setNightRate(int date, double rate)
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
        public void addRoom(Room r)
        {
            this.rooms.add(r);
        }
}
