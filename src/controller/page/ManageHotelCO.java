/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls hotel management.
 */

package controller.page;

import controller.error.ManageHotelER;
import java.awt.event.*;
import java.util.ArrayList;
import model.*;
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

        private static ManageHotelCO mhCO;  // The single instance of the class.
        private static ManageHotelER mhER;  // The manage hotel error handler.
        private static ManageHotelUI mhUI;  // The manage hotel UI.
        private static MainFrameUI mfUI;    // The main frame UI.
        private static Database db;         // The database.

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

            handleBack();
            handleSelectHotel();
            handleDeleteHotel();
            handleChangeName();
            handleRoomCount();
            handleChangePrice();
            handleRemoveReservation();
            handleChangeRate();
        }

        /**
         * Returns the instance of the book reservation controller.
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
         * Handles going back.
         */
        private void handleBack()
        {
            mhUI.setActionListener("btnBack", (ActionEvent e) ->
            {
                mhUI.resetValues();
                mfUI.openPage("MANAGE_HOTEL", "HOTEL_HUB");
            });

            mhUI.setActionListener("btnOK", (ActionEvent e) ->
            {
                mhUI.resetValues();
                mfUI.openPage("MANAGE_HOTEL", "HOTEL_HUB");
            });
        }

        /**
         * Handles hotel selection.
         */
        private void handleSelectHotel()
        {
            mhUI.setActionListener("cmbHotels", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty())
                {
                    db.setHotel(db.getHotel(mhUI.getValue("cmbHotels")));
                    mhUI.setFeedbackMessage("", false);
                    mhUI.configureComps();
                }
            });
        }

        /**
         * Handles hotel deletion.
         */
        private void handleDeleteHotel()
        {
            mhUI.setActionListener("btnDeleteHotel", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty())
                {
                    /* Setup */

                        // Gets the hotel.
                        String hotel = mhUI.getValue("cmbHotels");

                    /* Update */

                        // Deletes the hotel.
                        db.removeHotel(hotel);

                        // Updates the UI accordingly.
                        mhUI.setFeedbackMessage("Removed " + hotel + ".", false);
                        if (db.getHotels().isEmpty())
                            mfUI.openPage("MANAGE_HOTEL", "HOTEL_HUB");
                        else
                            mhUI.configureComps();
                }
            });
        }

        /**
         * Handles changing the hotel name.
         */
        private void handleChangeName()
        { 
            mhUI.setActionListener("btnSaveName", (ActionEvent e) ->
            {
                if (db.getHotel() != null)
                {
                    /* Setup */

                        // Gets the new hotel name.
                        String newName = mhUI.getValue("txtChangeName");

                        // Gets the hotel.
                        String oldName = mhUI.getValue("cmbHotels");
                        Hotel h = db.getHotel(oldName);

                        // Gets the error message.
                        String errorMessage = mhER.checkChangeName(newName);

                    /* Update */
                    
                        // Displays the error message if the input is invalid.
                        if (!errorMessage.equals(""))
                            mhUI.setFeedbackMessage(errorMessage, true);
                        else
                        {
                            // Changes the hotel name if the input is valid.
                            h.setName(newName);

                            // Updates the UI accordingly.
                            mhUI.setFeedbackMessage("Changed the name from \"" + oldName + 
                                "\" to \"" + newName + "\".", false);
                            mhUI.configureComps();
                    }
                }
            });
        }

        /**
         * Handles the addition and deletion of rooms.
         */
        private void handleRoomCount()
        {
            /* Standard room addition and deletion */

                mhUI.setActionListener("btnAddStandard",
                updateRoomCount("Standard", true));
                mhUI.setActionListener("btnDeleteStandard",
                updateRoomCount("Standard", false));

            /* Deluxe room addition and deletion */

                mhUI.setActionListener("btnAddDeluxe",
                updateRoomCount("Deluxe", true));
                mhUI.setActionListener("btnDeleteDeluxe",
                updateRoomCount("Deluxe", false));

            /* Executive room addition and deletion */

                mhUI.setActionListener("btnAddExecutive",
                updateRoomCount("Executive", true));
                mhUI.setActionListener("btnDeleteExecutive",
                updateRoomCount("Executive", false));
        }

        /**
         * Handles the change of base price.
         */
        private void handleChangePrice()
        {
            mhUI.setActionListener("btnSavePrice", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty())
                {
                    /* Setup */

                        // Gets the hotel and base price.
                        Hotel h = db.getHotel(mhUI.getValue("cmbHotels"));
                        String price = mhUI.getValue("txtChangePrice");

                        // Gets the error message.
                        String errorMessage = mhER.checkChangePrice(h, price);

                    /* Update */

                        // Displays the error message if there was an error.
                        if (!errorMessage.equals(""))
                            mhUI.setFeedbackMessage(errorMessage, true);
                        
                        else
                        {
                            // Changes the base price if there was no error.
                            h.setBasePrice(Double.parseDouble(price));

                            // Updates the UI accordingly.
                            mhUI.setFeedbackMessage("Changed the base price.", false);
                            mhUI.configureComps();
                        }
                }
            });
        }

        /**
         * Handles the removal of a reservation.
         */
        private void handleRemoveReservation()
        {
            mhUI.setActionListener("btnDeleteReservation", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty())
                {
                    /* Setup */

                        // Gets the hotel.
                        Hotel h = db.getHotel(mhUI.getValue("cmbHotels"));

                        // Gets the reservation details.
                        String resCode = mhUI.getValue("cmbReservations");
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
                        mhUI.setFeedbackMessage("Removed " + resCode +
                            " reservation.", false);
                        mhUI.configureComps();
                }
            });
        }

        /**
         * Handles the change of a night's price rate.
         */
        private void handleChangeRate()
        {
            mhUI.setActionListener("txtChangeRate", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty())
                {
                    /* Setup */

                        // Gets the hotel.
                        Hotel h = db.getHotel(mhUI.getValue("cmbHotels"));

                        // Gets the night rate details.
                        int night = Integer.parseInt(mhUI.getValue("cmbNights"));
                        String rate = mhUI.getValue("txtChangeRate");

                        // Gets the error message.
                        String errorMessage = mhER.checkChangeRate(rate);

                    /* Update */

                        // Displays the error message if there was an error.
                        if (!errorMessage.equals(""))
                            mhUI.setFeedbackMessage(errorMessage, true);
                        
                        else
                        {
                            // Updates the night rate if there was no error.
                            h.setNightRate(night, Double.parseDouble(rate));

                            // Updates the UI accordingly.
                            mhUI.setFeedbackMessage("Changed the night rate.", false);
                            mhUI.configureComps();
                        }
                }
            });
        }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Adds rooms to or removes rooms from a hotel.
         * 
         * @param type      {String}    The room type.
         * @param isAdded   {boolean}   Determines if rooms are to be added or deleted.
         */
        private ActionListener updateRoomCount(String type, boolean isAdded)
        {
            return (ActionEvent e) ->
            {
                /* Setup */

                    // Gets the hotel.
                    Hotel h = db.getHotel();

                    // Gets the number of rooms to be added/deleted.
                    String numUpdated = switch (type)
                    {
                        case "Standard" -> mhUI.getValue("txtStandardCnt");
                        case "Deluxe" -> mhUI.getValue("txtDeluxeCnt");
                        case "Executive" -> mhUI.getValue("txtExecutiveCnt");
                        default -> "";
                    };

                    // Gets the error message.
                    String errorMessage;
                    if (isAdded)
                        errorMessage = mhER.checkAddRooms(h, numUpdated);
                    else
                        errorMessage = mhER.checkDeleteRooms(h, type, numUpdated);

                /* Update */

                    // Displays the error message if there was an error.
                    if (!errorMessage.equals(""))
                        mhUI.setFeedbackMessage(errorMessage, true);

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
                            // The number to be added.
                            int numAdded = Integer.parseInt(numUpdated);
                            // The start and end room numbers.
                            int start = numOfRooms + 1;
                            int end = numOfRooms + numAdded;

                            // Loops through the added room numbers.
                            for (int i = start; i <= end; i++)
                                rooms.add(new Room(i, type, h.getBasePrice()));

                            // Updates the UI accordingly.
                            mhUI.setFeedbackMessage("Added " + numAdded + " " + 
                                type.toLowerCase() + " rooms.", false);
                        }

                        // Removes rooms.
                        else
                        {
                            // Tracks the number of rooms deleted.
                            int numDeleted = 0;
                            
                            // Loops through all rooms. Stops when enough rooms were deleted.
                            for (int i = 0; i < numOfRooms && numDeleted <=
                                Integer.parseInt(numUpdated); i++)
                            {
                                Room r = rooms.get(i);
                                
                                // Gets the room type with no reservations.
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
                            mhUI.setFeedbackMessage("Removed " + numDeleted + " " + 
                                type.toLowerCase() + " rooms.", false);
                        }
                        mhUI.configureComps();
                    }
            };
        }
}