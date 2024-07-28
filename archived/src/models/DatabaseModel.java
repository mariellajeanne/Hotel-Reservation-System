/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Models the database.
 */

package models;

import java.util.ArrayList;

/*
 * The database model class.
 */
public class DatabaseModel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private static DatabaseModel db;        // The single instance of the class.
    
    private ArrayList<HotelModel> hotels;   // The hotels.
    private ArrayList<ClientModel> clients; // The clients.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the database.
     */
    public DatabaseModel()
    {

    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the single instance of the database.
     * 
     * @return {Database}
     */
    public static DatabaseModel getInstance()
    {
        if (db == null)
            db = new DatabaseModel();
        return db;
    }

    /**
     * Returns the hotels.
     * 
     * @return {ArrayList<HotelModel>}
     */
    public ArrayList<HotelModel> getHotels()
    {
        return this.hotels;
    }

    /**
     * Returns a hotel given its name.
     * 
     * @return {HotelModel}
     */
    public HotelModel getHotel(String name)
    {
        for (HotelModel h : hotels)
        {
            if (name.equals(h.getName()))
                return h;
        }
        return null;
    }
}