/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls hotel management.
 */

package controller.page;

import java.util.ArrayList;
import javax.swing.*;
import model.*;
import service.error.ManageHotelER;
import view.frame.MainFrameUI;
import view.page.ManageHotelUI;

/**
 * The manage hotel controller.
*/
public class ManageHotelCO
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static ManageHotelCO mhCO; // The single instance of the class.
        private static ManageHotelER mhER; // The manage hotel error handler.
        private static ManageHotelUI mhUI; // The manage hotel UI.
        private static MainFrameUI mfUI;   // The main frame UI.
        private static Database db;        // The database.


    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the manage hotel controller.
         */
        private ManageHotelCO()
        {
            mhER = ManageHotelER.getInstance();
            mhUI = ManageHotelUI.getInstance();
            mfUI = MainFrameUI.getInstance();
            db = Database.getInstance();

            if (!db.getHotels().isEmpty())
                db.setHotel(db.getHotel((String) cmbHotel.getSelectedItem()));

            handleDeleteHotel();
            handleChangeName();
            handleRoomCount();
            handleChangePrice();
            handleRemoveReservation();
            handleChangeRate();
        }

        /**
         * Returns the instance of the manage hotel controller.
         * 
         * @return {ManageHotelCO}
         */
        public static ManageHotelCO getInstance()
        {
            if (mhCO == null)
                mhCO = new ManageHotelCO();
            return mhCO;
        }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT LISTENERS                              */
    /* -------------------------------------------------------------------------- */

        /**
         * Handles hotel deletion.
         */
        private void handleDeleteHotel()
        {
            btnDeleteHotel.addActionListener(e ->
            {
                /* Setup */

                    // Gets the hotel.
                    String hotel = (String) cmbHotel.getSelectedItem();

                /* Update */

                    // Deletes the hotel.
                    db.removeHotel(hotel);

                    // Updates the UI accordingly.
                    if (db.getHotels().isEmpty())
                        mfUI.openPage("HOTEL_HUB");
                    else
                        mfUI.reopenPage();
            });
        }

        /**
         * Handles changing the hotel name.
         */
        private void handleChangeName()
        {   
            btnSaveName.addActionListener(e ->
            {
                /* Setup */

                    // Gets the new hotel name.
                    String newName = txtName.getText();

                    // Gets the hotel.
                    String oldName = (String) cmbHotel.getSelectedItem();
                    Hotel h = db.getHotel(oldName);

                    // Gets the error message.
                    String errorMessage = mhER.checkChangeName(newName);

                /* Update */
                
                    // Displays the error message if the input is invalid.
                    if (!errorMessage.equals(""))
                        lblErrorMessage.setText(errorMessage);
                    else
                    {
                        // Changes the hotel name if the input is valid.
                        h.setName(newName);

                        // Updates the UI accordingly.
                        mfUI.reopenPage();
                    }
            });
        }

        /**
         * Handles the addition and deletion of rooms.
         */
        private void handleRoomCount()
        {
            updateRoomCount(cmbStandard, btnAddStandard, "STANDARD", true);
            updateRoomCount(cmbStandard, btnDeleteStandard, "STANDARD", false);

            updateRoomCount(cmbDeluxe, btnAddDeluxe, "DELUXE", true);
            updateRoomCount(cmbDeluxe, btnDeleteDeluxe, "DELUXE", false);

            updateRoomCount(cmbExecutive, btnAddExecutive, "EXECUTIVE", true);
            updateRoomCount(cmbExecutive, btnDeleteExecutive, "EXECUTIVE", false);
        }

        /**
         * Handles the change of base price.
         */
        private void handleChangePrice()
        {
            btnSavePrice.addActionListener(e ->
            {
                /* Setup */

                    // Gets the hotel and base price.
                    Hotel h = db.getHotel((String) cmbHotel.getSelectedItem());
                    String price = txtPrice.getText();

                    // Gets the error message.
                    String errorMessage = mhER.checkChangePrice(h, price);

                /* Update */

                    // Displays the error message if there was an error.
                    if (!errorMessage.equals(""))
                        lblErrorMessage.setText(errorMessage);
                    
                    else
                    {
                        // Changes the base price if there was no error.
                        h.setBasePrice(Double.parseDouble(price));

                        // Updates the UI accordingly.
                        mfUI.reopenPage();
                    }
            });
        }

        /**
         * Handles the removal of a reservation.
         */
        private void handleRemoveReservation()
        {
            btnDeleteReservation.addActionListener(e ->
            {
                /* Setup */

                    // Gets the hotel.
                    Hotel h = db.getHotel((String) cmbHotel.getSelectedItem());

                    // Gets the reservation details.
                    String resCode = (String) cmbReservation.getSelectedItem();
                    String[] resDetails = resCode.split(": ");
                    String[] resRoom = resDetails[0].split(" ");
                    String[] resDates = resDetails[1].split("-");
                    int roomNum = Integer.parseInt(resRoom[1]);
                    int checkIn = Integer.parseInt(resDates[0]);

                    // Gets the room based on the room number.
                    Room room = h.getRooms().get(roomNum - 1);

                    // Gets the reservation based on the check-in date.
                    Reservation res = room.getReservation(checkIn);

                /* Update */

                    // Removes the reservation from the hotel.
                    room.getReservations().remove(res);

                    // Updates the UI accordingly.
                    mfUI.reopenPage();
            });
        }

        /**
         * Handles the change of a night rate.
         */
        private void handleChangeRate()
        {
            btnSaveRate.addActionListener(e ->
            {
                /* Setup */

                    // Gets the hotel.
                    Hotel h = db.getHotel((String) cmbHotel.getSelectedItem());

                    // Gets the night rate details.
                    int date = (int) cmbDate.getSelectedItem();
                    String rate = (String) txtRate.getText();

                    // Gets the error message.
                    String errorMessage = mhER.checkChangeRate(rate);

                /* Update */

                    // Displays the error message if there was an error.
                    if (!errorMessage.equals(""))
                        lblErrorMessage.setText(errorMessage);
                    
                    else
                    {
                        // Updates the night rate if there was no error.
                        h.setNightRate(date, Double.parseDouble(rate));

                        // Updates the UI accordingly.
                        mfUI.reopenPage();
                    }
            });
        }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Adds rooms to or removes rooms from a hotel.
         * 
         * @param cmbRoom   {JComboBox} The room combo box.
         * @param btnUpdate {JButton}   The add/delete button.
         * @param type      {String}    The room type.
         * @param isAdded   {boolean}   Determines if the number is to be added or deleted.
         */
        private void updateRoomCount(JComboBox<Integer> cmbRoom, JButton btnUpdate,
            String type, boolean isAdded)
        {
            cmbRoom.addActionListener(e ->
            {
                /* Setup */

                    // Gets the hotel.
                    Hotel h = db.getHotel((String) cmbHotel.getSelectedItem());

                    // Gets the number of rooms to be added/deleted.
                    String numUpdated = (String) cmbRoom.getSelectedItem();

                    // Gets the error message.
                    String errorMessage;
                    if (isAdded)
                        errorMessage = mhER.checkAddRooms(h, type);
                    else
                        errorMessage = mhER.checkDeleteRooms(h, type, numUpdated);

                /* Update */

                    // Displays the error message if there was an error.
                    if (!errorMessage.equals(""))
                        mhUI.setErrorMessage(errorMessage);

                    // Adds/deletes rooms if there was no error.
                    else
                    {
                        // Gets the current number of rooms in the hotel.
                        int numOfRooms = h.getRooms().size();

                        // Gets the rooms in the hotel.
                        ArrayList<Room> rooms = h.getRooms();

                        // Adds rooms.
                        if (isAdded)
                        {
                            for (int i = numOfRooms + 1; i <= numOfRooms +
                                Integer.parseInt(numUpdated); i++)
                                rooms.add(new Room(i, type, h.getBasePrice()));
                        }
                        else
                        {
                            // Removes rooms.
                            int numDeleted = 0;
                            for (int i = 0; i < numOfRooms && numDeleted <
                                Integer.parseInt(numUpdated); i++)
                            {
                                Room r = rooms.get(i);
                                
                                if (r.getType().equals(type) && r.getReservations().isEmpty())
                                {
                                    rooms.remove(r);
                                    numDeleted++;
                                }
                            }

                            // Updates room numbers.
                            for (int i = 0; i < rooms.size(); i++)
                                rooms.get(i).setNum(i + 1);

                            // Updates the UI accordingly.
                            mfUI.reopenPage();
                        }
                    }
            });
        }
}