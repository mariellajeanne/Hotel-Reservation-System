/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models a reservation.
 */

package models;

/**
 * The reservation model class.
 */
public class ReservationModel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private final String client;          // The client's name.
    private final int checkIn;            // The check-in date.
    private final int checkOut;           // The check-out date.
    private final RoomModel room;         // The reserved room.
    private final double nightlyPrices[]; // The price per night.
    private double totalPrice;            // The total price.
    private String code;                  // The discount code.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs a reservation given the client's name, the check-in date,
     * the check-out date, the reserved room, and the discount code.
     * 
     * @param client    {String}    The client.
     * @param checkIn   {int}       The check-in date.
     * @param checkOut  {int}       The check-out date.
     * @param room      {RoomModel} The reserved room.
     * @param code      {String}    The discount code.
     */
    public ReservationModel(String client, int checkIn, int checkOut,
                            RoomModel room, String code)
    {
        this.client = client;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.nightlyPrices = new double[this.checkOut - this. checkIn];
        this.code = code;
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
     * @return {RoomModel}
     */
    public RoomModel getRoom()
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

    /**
     * Returns the discount code used.
     * 
     * @return {String}
     */
    public String getCode()
    {
        return this.code;
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

    // /**
    //  * Sets the nightly price.
    //  */
    // public void setNightlyPrice()
    // {
    //     Arrays.fill(this.nightlyPrice, this.room.getNightlyPrice());
    //     Arrays.stream(this.nightlyPrice).sum();

    //     switch (this.code)
    //     {
    //         case "I_WORK_HERE" -> this.totalPrice *= 0.90;

    //     }
    // }
}
