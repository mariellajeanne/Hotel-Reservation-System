/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models a hotel object.
 */

package models;

import java.util.*;

/**
 * The hotel model class.
 */
public class HotelModel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private String name;                      // The hotel's name.
    private double basePrice;                 // The hotel's base price.
    private final double[] rates;             // The hotel's rates per date.
    private final ArrayList<RoomModel> rooms; // The hotel's rooms.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs a hotel given its name.
     * 
     * @param name {String} The hotel's name.
     */
    public HotelModel(String name)
    {
        this.name = name;
        this.rates = new double[30];
        this.rooms = new ArrayList<>();

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
     * Gets the price rate given a date.
     * 
     * @param date {int} The date.
     * @return     {double}
     */
    public double getDateRate(int date)
    {
        return this.rates[date - 1];
    }

    /**
     * Returns the number of rooms.
     * 
     * @return {int}
     */
    public int getNumOfRoms()
    {
        return this.rooms.size();
    }

    /**
     * Returns a room given its index.
     * 
     * @param index The index.
     */
    public RoomModel getRoom(int index)
    {
        return this.rooms.get(index);
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

        for (int i = 0; i < getNumOfRoms(); i++)
        {
            getRoom(i).setNightlyPrice(basePrice);
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
}
