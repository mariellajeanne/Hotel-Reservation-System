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
        private static Database db;        // The database.

        JComboBox<String> cmbHotel;
        JButton btnDeleteHotel;

        JTextField txtName;
        JButton btnSaveName;

        JComboBox<Integer> cmbStandard;
        JButton btnAddStandard;
        JButton btnDeleteStandard;

        JComboBox<Integer> cmbDeluxe;
        JButton btnAddDeluxe;
        JButton btnDeleteDeluxe;

        JComboBox<Integer> cmbExecutive;
        JButton btnAddExecutive;
        JButton btnDeleteExecutive;

        JTextField txtPrice;
        JButton btnSavePrice;

        JComboBox<String> cmbReservation;
        JButton btnDeleteReservation;

        JComboBox<Integer> cmbDate;
        JTextField txtRate;
        JButton btnSaveRate;

        JLabel lblErrorMessage;

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the manage hotel controller.
         */
        private ManageHotelCO()
        {
            mhER = ManageHotelER.getInstance();
            // TODO mhUI = ManageHotelUI.getInstance();
            db = Database.getInstance();

            handleDeleteHotel();
            handleChangeName();
            handlExecutiveCount();
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
                    // TODO redirect UI to main menu
                    db.removeHotel(hotel);
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
                    
                    // Changes the hotel name if the input is valid.
                    else
                    {
                        h.setName(newName);
                        // TODO update UI
                    }
            });
        }

        /**
         * Handles the addition and deletion of rooms.
         */
        private void handlExecutiveCount()
        {
            updatExecutiveCount(cmbStandard, btnAddStandard, "STANDARD", true);
            updatExecutiveCount(cmbStandard, btnDeleteStandard, "STANDARD", false);

            updatExecutiveCount(cmbDeluxe, btnAddDeluxe, "DELUXE", true);
            updatExecutiveCount(cmbDeluxe, btnDeleteDeluxe, "DELUXE", false);

            updatExecutiveCount(cmbExecutive, btnAddExecutive, "EXECUTIVE", true);
            updatExecutiveCount(cmbExecutive, btnDeleteExecutive, "EXECUTIVE", false);
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
                    
                    // Changes the base price if there was no error.
                    else
                    {
                        h.setBasePrice(Double.parseDouble(price));
                        // TODO Update UI
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
                    // TODO Update UI
            });
        }

        /**
         * Handles the change of a date rate.
         */
        private void handleChangeRate()
        {
            btnSaveRate.addActionListener(e ->
            {
                /* Setup */

                    // Gets the hotel.
                    Hotel h = db.getHotel((String) cmbHotel.getSelectedItem());

                    // Gets the date rate details.
                    int date = (int) cmbDate.getSelectedItem();
                    String rate = (String) txtRate.getText();

                    // Gets the error message.
                    String errorMessage = mhER.checkChangeRate(rate);

                /* Update */

                    // Displays the error message if there was an error.
                    if (!errorMessage.equals(""))
                        lblErrorMessage.setText(errorMessage);
                    
                    // Updates the date rate if there was no error.
                    else
                    {
                        h.setDateRate(date, Double.parseDouble(rate));
                        // TODO Update UI
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
        private void updatExecutiveCount(JComboBox<Integer> cmbRoom, JButton btnUpdate,
            String type, boolean isAdded)
        {
            cmbRoom.addActionListener(e ->
            {
                /* Setup */

                    // Gets the hotel.
                    Hotel h = db.getHotel((String) cmbHotel.getSelectedItem());

                    // Gets the number of rooms to be added/deleted.
                    int numAdded = (int) cmbRoom.getSelectedItem();

                /* Update */

                    // Gets the current number of rooms in the hotel.
                    int num = h.getRooms().size();

                    // Gets the rooms in the hotel.
                    ArrayList<Room> rooms = h.getRooms();

                    // Adds rooms.
                    if (isAdded)
                    {
                        for (int i = num + 1; i <= num + numAdded; i++)
                            rooms.add(new Room(i, type, h.getBasePrice()));
                    }
                    else
                    {
                        // Removes rooms.
                        for (Room r : rooms)
                        {
                            if (r.getType().equals(type) && r.getReservations().isEmpty())
                                rooms.remove(r);
                        }

                        // Updates room numbers.
                        for (int i = 0; i < rooms.size(); i++)
                            rooms.get(i).setNum(i + 1);

                        // TODO Update UI
                    }
            });
        }
}