/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Performs services for manipulating reservations.
 */

/**
 * !Relationships
 * 
 * Composes ReservationService
 * Uses ReservationModel
 * Uses RoomService
 */

package services;

import models.HotelModel;
import models.ReservationModel;
import models.RoomModel;

public class ReservationService
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private static ReservationService rs; // The single instance of the class.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the reservation service.
     */
    private ReservationService()
    {

    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the instance of the reservation service.
     * 
     * @return {Reservation Service}
     */
    public static ReservationService getInstance()
    {
        if (rs == null)
            rs = new ReservationService();
        return rs;
    }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Creates a reservation.
     * 
     * @param client    {String}    The client.
     * @param checkIn   {int}       The check-in date.
     * @param checkOut  {int}       The check-out date.
     * @param room      {RoomModel} The reserved room.
     * @param code      {String}    The discount code.
     * @return {ReservationModel}
     */
    public ReservationModel addReservation(String client, int checkIn, int checkOut,
           RoomModel room, String code)
    {
        ReservationModel r =
            new ReservationModel(client, checkIn, checkOut, room, code);
        
        RoomService.getInstance().addReservation(room, r);
        return r;
    }

    /**
     * Sets up the nightly and total price of a reservation given its code.
     * 
     * @param r {ReservationModel} The reservation.
     * @param h {HotelModel}       The hotel.
     */
    public void setUpPrice(ReservationModel r, HotelModel h)
    {
        double totalPrice = 0; // The reservation's total price.

        // Sets the nightly prices based on the date rates.
        for (int i = r.getCheckIn(); i < r.getCheckOut(); i++)
        {
            double roomPrice = r.getRoom().getNightlyPrice();
            double nightlyPrice = roomPrice * h.getDateRate(i);

            r.setNightlyPrice(i, nightlyPrice);
            totalPrice += nightlyPrice;
        }

        // Sets the nightly prices based on the discount code.
        switch (r.getCode())
        {
            // Gives a 10% discount.
            case "I_WORK_HERE" ->
            {
                totalPrice *= 0.9;
            }
            // Makes the first day free if the reservation has 5 days or more.
            case "STAY4_GET1" ->
            {
                if (r.getCheckOut() - r.getCheckIn() >= 5)
                {
                    double firstDayPrice = r.getNightlyPrice(r.getCheckIn());
            
                    totalPrice -= firstDayPrice;
                    r.setNightlyPrice(r.getCheckIn(), 0);
                }
            }
            // Gives a 7% discount if the reservation has date 15 or 30.
            case "PAYDAY" ->
            {
                if (hasNight(r, 15) || hasNight(r, 30))
                    totalPrice *= 0.7;
            }
        }

        r.setTotalPrice(totalPrice);
    }

    /**
     * Checks if a reservation has a particular night.
     * 
     * @param r {ReservationModel} The reservation.
     * @param night {int} The night.
     * @return {boolean}
     */
    public boolean hasNight(ReservationModel r, int night)
    {
        return night >= r.getCheckIn() && night < r.getCheckOut();
    }
}
