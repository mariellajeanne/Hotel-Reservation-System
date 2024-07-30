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
                mfUI.openPage("HOTEL_HUB");
            });
        }

        /**
         * Handles hotel selection.
         */
        private void handleSelectHotel()
        {
            vhUI.setActionListener("cmbHotels", (ActionEvent e) ->
            {
                db.setHotel(db.getHotel(vhUI.getValue("cmbHotels")));
                db.setDate(1);
                db.setRoom(db.getHotel().getRooms().get(0));
                
                if (db.getHotel().getNumOfReservations() != 0)
                    db.setReservation(db.getRoom().getReservations().get(0));
                else
                    db.setReservation(null);

                mfUI.reopenPage();
            });   
        }

        /**
         * Handles date selection.
         */
        private void handleSelectDate()
        {
            vhUI.setActionListener("cmbDates", (ActionEvent e) ->
            {
                db.setDate(Integer.parseInt(vhUI.getValue("cmbDates")));
                mfUI.reopenPage();
            });   
        }

        /**
         * Handles room selection.
         */
        private void handleSelectRoom()
        {
            vhUI.setActionListener("cmbRooms", (ActionEvent e) ->
            {
                int num = Integer.parseInt(vhUI.getValue("cmbRooms"));
                db.setRoom(db.getHotel().getRooms().get(num - 1));
                mfUI.reopenPage();
            });   
        }

        /**
         * Handles reservation selection.
         */
        private void handleSelectReservation()
        {
            vhUI.setActionListener("cmbReservations", (ActionEvent e) ->
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
                    mfUI.reopenPage();
            });   
        }
}