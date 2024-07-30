/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls hotel viewing.
 */

package controller.page;

import java.awt.event.*;
import model.Database;
import model.Hotel;
import model.Room;
import view.frame.MainFrameUI;
import view.page.ViewHotelUI;

/**
 * The view hotel controller.
 */
public class ViewHotelCO
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static ViewHotelCO vhCO; // The single instance of the class.
        private static ViewHotelUI vhUI; // The view hotel UI.
        private static MainFrameUI mfUI; // The main frame UI.
        private static Database db;      // The database.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the view hotel controller.
         */
        private ViewHotelCO()
        {
            vhUI = ViewHotelUI.getInstance();
            mfUI = MainFrameUI.getInstance();
            db = Database.getInstance();

            handleBack();
            handleSelectHotel();
            handleSelectDate();
            handleSelectRoom();
            handleSelectReservation();
        }

        /**
         * Returns the instance of the view hotel controller.
         * 
         * @return          {ViewHotelCO}
         */
        public static ViewHotelCO getInstance()
        {
            if (vhCO == null)
                vhCO = new ViewHotelCO();
            return vhCO;
        }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT LISTENERS                              */
    /* -------------------------------------------------------------------------- */

        /**
         * Handles going back.
         */
        private void handleBack()
        {
            vhUI.setActionListener("btnBack", (ActionEvent e) ->
            {
                mfUI.openPage("VIEW_HOTEL", "HOTEL_HUB");
            });
        }

        /**
         * Handles hotel selection.
         */
        private void handleSelectHotel()
        {
            vhUI.setActionListener("cmbHotels", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty())
                {
                    /* Setup */

                        // Gets the default chosen hotel and room.
                        Hotel hotel = db.getHotel(vhUI.getValue("cmbHotels"));
                        Room room = hotel.getRooms().getFirst();

                    /* Update */

                        // Sets the default chosen hotel, date, and room.
                        db.setHotel(hotel);
                        db.setDate(1);
                        db.setRoom(room);
                        
                        // Sets the default chosen reservation if the hotel has reservations.
                        if (hotel.getNumOfReservations() != 0)
                        {
                            db.setReservation(hotel.getFirstReservedRoom().
                                getReservations().getFirst());
                        }                        

                        // Updates the UI accordingly.
                        vhUI.configureComps();
                }
            });   
        }

        /**
         * Handles date selection.
         */
        private void handleSelectDate()
        {
            vhUI.setActionListener("cmbDates", (ActionEvent e) ->
            {
                /* Setup */

                    // Gets the chosen date.
                    int date = Integer.parseInt(vhUI.getValue("cmbDates"));

                /* Update */

                    // Sets the chosen date.
                    db.setDate(date);

                    // Updates the UI accordingly.
                    vhUI.configureComps();
            });   
        }

        /**
         * Handles room selection.
         */
        private void handleSelectRoom()
        {
            vhUI.setActionListener("cmbRooms", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty())
                {
                    /* Setup */

                        // Gets the chosen room.
                        int num = Integer.parseInt(vhUI.getValue("cmbRooms"));
                        Room room = db.getHotel().getRooms().get(num - 1);

                    /* Update */

                        // Sets the chosen room.
                        db.setRoom(room);

                        // Updates the UI accordingly.
                        vhUI.configureComps();
                }
            });   
        }

        /**
         * Handles reservation selection.
         */
        private void handleSelectReservation()
        {
            vhUI.setActionListener("cmbReservations", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty() && db.getHotel().getNumOfReservations() != 0)
                {
                    /* Setup */
                
                        // Gets the hotel.
                        Hotel h = db.getHotel(vhUI.getValue("cmbHotels"));

                        // Gets the reservation details.
                        String resCode = vhUI.getValue("cmbReservations");
                        String[] resDetails = resCode.split(": ");
                        String[] resRoom = resDetails[0].split(" ");
                        String[] resDates = resDetails[1].split("-");
                        int roomNum = Integer.parseInt(resRoom[1]);
                        int checkIn = Integer.parseInt(resDates[0]);

                        // Gets the room based on the room number.
                        Room room = h.getRooms().get(roomNum - 1);

                    /* Update */

                        // Sets the reservation based on the check-in date.
                        db.setReservation(room.getReservation(checkIn));

                        // Updates the UI accordingly.
                        vhUI.configureComps();
                }
            });   
        }
}