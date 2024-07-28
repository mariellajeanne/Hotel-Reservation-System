/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Performs services for manipulating rooms.
 */

package services;

import models.ReservationModel;
import models.RoomModel;

/**
 * The room service class.
 */
public class RoomService
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private static RoomService rs; // The single instance of the class.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the room service.
     */
    private RoomService()
    {

    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the instance of the room service.
     * 
     * @return {RoomService}
     */
    public static RoomService getInstance()
    {
        if (rs == null)
            rs = new RoomService();
        return rs;
    }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Adds a reservation to a room.
     * 
     * @param ro    {RoomModel}         The room.
     * @param res   {ReservationModel}  The reservation.
     */
    public void addReservation(RoomModel ro, ReservationModel res)
    {
        ro.getReservations().add(res);
    }

}
