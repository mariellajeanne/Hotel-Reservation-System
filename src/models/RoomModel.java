/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models a room object.
 */

package models;

import java.util.ArrayList;
import states.enums.RoomTypeEnum;

/**
 * The room model class.
 */
public class RoomModel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private final int num;                                  // The room's number.
    private final RoomTypeEnum type;                        // The room type.
    private double nightlyPrice;                            // The room's nightly price.
    private final ArrayList<ReservationModel> reservations; // The room's reservations.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs a room given its number and nightly price.
     * 
     * @param num          {int} The room number.
     * @param type         {String} The room type.
     * @param nightlyPrice {double} The nightly price.
     */
    public RoomModel(int num, RoomTypeEnum type, double nightlyPrice)
    {
        this.num = num;
        this.type = type;
        this.nightlyPrice = nightlyPrice;
        this.reservations = new ArrayList<>();
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
     * @return {RoomTypeEnum}
     */
    public RoomTypeEnum getType()
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
     * @return {ArrayList<ReservationModel>} The reservations.
     */
    public ArrayList<ReservationModel> getReservations()
    {
        return this.reservations;
    }

    /**
     * Returns the number of reservations.
     * 
     * @return {int}
     */
    public int getNumOfReservations()
    {
        return this.reservations.size();
    }

    /**
     * Returns a reservation given its index.
     * 
     * @param index {int} The index.
     */
    public ReservationModel getReservation(int index)
    {
        return this.reservations.get(index);
    }

    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Sets the room's nightly price given the base price and its type.
     * 
     * @param basePrice {double} The base price.
     */
    public void setNightlyPrice(double basePrice)
    {
        double rate = switch (this.type)
            {
                case RoomTypeEnum.STANDARD  -> 1;
                case RoomTypeEnum.DELUXE    -> 1.2;
                case RoomTypeEnum.EXECUTIVE -> 1.35;
            };

        this.nightlyPrice = basePrice * rate;
    }
    
}
