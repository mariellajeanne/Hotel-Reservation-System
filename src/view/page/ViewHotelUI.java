/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The view hotel page.
 */

package view.page;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import view.util.*;

/**
 * The view hotel UI class.
*/
public final class ViewHotelUI extends JBlackPanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        /* Class instances */

            private static ViewHotelUI vhUI;
            private static Database db;

        /* Components */

            private JTitlePanel pnlTitle;
            private JBackButton btnBack;

            private JCommonLabel lblHotel;
            private JCommonLabel lblNumRooms;
            private JCommonLabel lblEstEarnings;
            private JCommonLabel lblRoomAvailability;
            private JCommonLabel lblAvailRoomCnt;
            private JCommonLabel lblBookedRoomCnt;
            private JCommonLabel lblRoom;
            private JCommonLabel lblRoomType;
            private JCommonLabel lblPricePerNight;
            private JCommonLabel lblAvailNights;
            private JCommonLabel lblReservation;
            private JCommonLabel lblGuestName;
            private JCommonLabel lblRoomDetails;
            private JCommonLabel lblCheckInAndOut;
            private JCommonLabel lblResPrice;
            private JCommonLabel lblResPricePerNight;

            private JCommonComboBox<String> cmbHotels;
            private JCommonComboBox<String> cmbDates;
            private JCommonComboBox<String> cmbRooms;
            private JCommonComboBox<String> cmbReservations;
            private JCommonComboBox<String> cmbAvailNights;

            private DefaultTableModel dtmPricePerNight;
            // !private JPanel pnlPricePerNight;
            private JScrollPane scrPricePerNight;
            private JTable tblPricePerNight;

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the view hotel UI.
         */
        public ViewHotelUI()
        {
            db = Database.getInstance();

            initializeComps();
            configureComps();
            addComps();
        }

        /**
         * Returns the single instance of the view hotel UI.
         * 
         * @return {ViewHotelUI}
         */
        public static ViewHotelUI getInstance()
        {
            if (vhUI == null)
                vhUI = new ViewHotelUI();
            return vhUI;
        }

    /* -------------------------------------------------------------------------- */
    /*                           COMPONENT CONFIGURATION                          */
    /* -------------------------------------------------------------------------- */

        /**
         * Initializes components.
         */
        @Override
        protected void initializeComps()
        {
            btnBack = new JBackButton();
            pnlTitle = new JTitlePanel("View Hotel");
            
            lblHotel = new JCommonLabel("HOTEL:", 1,true);
            lblNumRooms = new JCommonLabel(0,false);
            lblEstEarnings = new JCommonLabel(0,false);
            lblRoomAvailability = new JCommonLabel("Room availability of date:", 1,false);
            lblAvailRoomCnt = new JCommonLabel(0,false);
            lblBookedRoomCnt = new JCommonLabel(0,false);
            lblRoom = new JCommonLabel("ROOM:", 1,true);
            lblRoomType = new JCommonLabel(0,false);
            lblPricePerNight = new JCommonLabel(0, false);
            lblAvailNights = new JCommonLabel("Available nights:", 0, false);
            lblReservation = new JCommonLabel("RESERVATION:", 1, true);
            lblGuestName = new JCommonLabel("Guest: N/A", 0,false);
            lblRoomDetails = new JCommonLabel("Room: N/A", 0,false);
            lblCheckInAndOut = new JCommonLabel(0,false);
            lblResPrice = new JCommonLabel(0,false);
            lblResPricePerNight = new JCommonLabel(0,false);

            cmbHotels = new JCommonComboBox<>(372,249,396,29);
            cmbDates = new JCommonComboBox<>(711,440,63,29);
            cmbRooms = new JCommonComboBox<>(351,683,63,29);
            cmbAvailNights = new JCommonComboBox<>(546,877,63,29);
            cmbReservations = new JCommonComboBox<>(1273,251,272,29);

            dtmPricePerNight = new DefaultTableModel(0, 1);
            tblPricePerNight = new JTable(dtmPricePerNight);
            scrPricePerNight = new JScrollPane(tblPricePerNight);
        }

        /**
         * Configures components.
         */
        @Override
        public void configureComps()
        {
            // Executes the following if there exists hotels.
            if (!db.getHotels().isEmpty())
            {
                // Stores the hotel, room, and reservation being currently handled.
                Hotel h = db.getHotel();
                Room room = db.getRoom();
                Reservation res =  db.getReservation();

                lblNumRooms.setText("Number of rooms: " + h.getRooms().size());
                lblEstEarnings.setText("Estimated earnings: " + String.format("%.2f", h.getTotalEarnings()));
                lblAvailRoomCnt.setText("Number of rooms available: " + h.getNumOfAvailRooms(db.getDate(), true));
                lblBookedRoomCnt.setText("Number of rooms booked: " + h.getNumOfAvailRooms(db.getDate(), false));
                lblRoomType.setText("Type: " + room.getType());
                lblPricePerNight.setText("Base price per night: " + String.format("%.2f", db.getRoom().getNightlyPrice()));

                cmbHotels.setModel(new DefaultComboBoxModel<>(db.getHotelNames()));
                cmbDates.setModel(new DefaultComboBoxModel<>(Reservation.getReservationDates(true)));
                cmbRooms.setModel(new DefaultComboBoxModel<>(h.getRoomNumbers()));
                cmbAvailNights.setModel(new DefaultComboBoxModel<>(room.getAvailableNights()));

                cmbHotels.setSelectedItem(h.getName());
                cmbDates.setSelectedItem(String.valueOf(db.getDate()));
                cmbRooms.setSelectedItem(String.valueOf(room.getNum()));

                // Executes the following if the chosen hotel has reservations.
                if (db.getHotel().getNumOfReservations() != 0 && db.getReservation() != null)
                {
                    cmbReservations.setModel(new DefaultComboBoxModel<>(room.getReservationCodes()));
                    cmbReservations.setSelectedItem(res.getCode());

                    lblGuestName.setText("Guest: " + res.getGuest());
                    lblRoomDetails.setText("Room: Room " + res.getRoom().getNum() + ", " + res.getRoom().getType());
                    lblCheckInAndOut.setText("Check-in and check-out: " + res.getCheckInAndOut());
                    lblResPrice.setText("Price (w/discount if any): " + String.format("%.2f", res.getTotalPrice()));
                    lblResPricePerNight.setText("Price per night: " + String.format("%.2f", res.getRoom().getNightlyPrice()));

                    dtmPricePerNight.setDataVector(res.getNightlyPrices(), null);
                }

                // Executes the following if the chosen hotel has no reservations.
                else
                {
                    cmbReservations.removeAllItems();

                    lblGuestName.setText("Guest: N/A");
                    lblRoomDetails.setText("Room: N/A");
                    lblCheckInAndOut.setText("Check-in and check-out: N/A");
                    lblResPrice.setText("Price (w/discount if any): N/A");
                    lblResPricePerNight.setText("Price per night: N/A");
                    
                    dtmPricePerNight.setRowCount(0);
                }
            }

            // Executes the following if there exists no hotels.
            else
            {
                cmbHotels.removeAllItems();
                cmbDates.removeAllItems();
                cmbRooms.removeAllItems();
                cmbAvailNights.removeAllItems();
                cmbReservations.removeAllItems();

                lblNumRooms.setText("Number of rooms: N/A");
                lblEstEarnings.setText("Estimated earnings: N/A");
                lblAvailRoomCnt.setText("Number of rooms available: N/A");
                lblBookedRoomCnt.setText("Number of rooms booked: N/A");
                lblRoomType.setText("Type: ");
                lblPricePerNight.setText("Price per night: N/A");
                
                lblGuestName.setText("Guest: N/A");
                lblRoomDetails.setText("Room: N/A");
                lblCheckInAndOut.setText("Check-in and check-out: N/A");
                lblResPrice.setText("Price (w/discount if any): N/A");
                lblResPricePerNight.setText("Price per night: N/A");
                
                dtmPricePerNight.setRowCount(0);
                tblPricePerNight.setModel(new DefaultTableModel());
            }

            // Sets the price per night table panels.
            scrPricePerNight.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrPricePerNight.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrPricePerNight.setBounds((int) (1010 * Scale.X), (int) (618 * Scale.Y),
                                    (int) (536 * Scale.X),(int) (290 * Scale.Y));

            // Sets the label sizes according to text content.
            lblHotel.setSizePos(200,249,30);
            lblNumRooms.setSizePos(250,308,39);
            lblEstEarnings.setSizePos(250,371,38);
            lblRoomAvailability.setSizePos(250,432,43);
            lblAvailRoomCnt.setSizePos(304,493,43);
            lblBookedRoomCnt.setSizePos(304,556,43);
            lblRoom.setSizePos(200,681,31);
            lblRoomType.setSizePos(248,743,43);
            lblPricePerNight.setSizePos(248,806,43);
            lblAvailNights.setSizePos(248,868,43);
            lblReservation.setSizePos(960,249,31);
            lblGuestName.setSizePos(1010,308,43);
            lblRoomDetails.setSizePos(1010,371,43);
            lblCheckInAndOut.setSizePos(1010,435,43);
            lblResPrice.setSizePos(1010,494,43);
            lblResPricePerNight.setSizePos(1010,556,43);
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addComps()
        {
            add(btnBack);
            add(pnlTitle);
            
            add(lblHotel);
            add(lblNumRooms);
            add(lblEstEarnings);
            add(lblRoomAvailability);
            add(lblAvailRoomCnt);
            add(lblBookedRoomCnt);
            add(lblRoom);
            add(lblRoomType);
            add(lblPricePerNight);
            add(lblAvailNights);
            add(lblReservation);
            add(lblGuestName);
            add(lblRoomDetails);
            add(lblCheckInAndOut);
            add(lblResPrice);
            add(lblResPricePerNight);
            
            add(cmbHotels);
            add(cmbDates);
            add(cmbRooms);
            add(cmbAvailNights);
            add(cmbReservations);

            add(scrPricePerNight);
        }

    /* -------------------------------------------------------------------------- */
    /*                             GETTERS AND SETTERS                            */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the input of a component.
         *
         * @param componentID   {String}    The component ID.
         * @return              {JComponent}
         */
        @Override
        public String getValue(String componentID)
        {
            return switch (componentID)
            {
                case "cmbHotels"        -> (String) cmbHotels.getSelectedItem();
                case "cmbDates"         -> (String) cmbDates.getSelectedItem();
                case "cmbRooms"         -> (String) cmbRooms.getSelectedItem();
                case "cmbReservations"  -> (String) cmbReservations.getSelectedItem();
                default                 -> "";
            };
        }

        /**
         * Sets the feedback message.
         * 
         * @param text      {String}    The feedback message.
         * @param isError   {boolean}   Determines if the feedback is an error warning.
         */
        @Override
        public void setFeedbackMessage(String text, boolean isError){}

        /**
         * Sets the action listener of a component.
         * 
         * @param componentID   {String}            The component ID.
         * @param a             {ActionListener}    The action listener.
         */
        @Override
        public void setActionListener(String componentID, ActionListener a)
        {
            switch (componentID)
            {
                case "cmbHotels"        -> {cmbHotels.addActionListener(a);}
                case "cmbDates"         -> {cmbDates.addActionListener(a);}
                case "cmbRooms"         -> {cmbRooms.addActionListener(a);}
                case "cmbReservations"  -> {cmbReservations.addActionListener(a);}
                case "btnBack"          -> {btnBack.addActionListener(a);}
            }
        }

        /**
         * Resets values of the error label and text fields.
         */
        @Override
        public void resetValues(){}

        /**
         * Updates displayed values.
         * 
         * @param componentID {String} The component ID.
         */
        public void setUpdatedValues(String componentID)
        {
            switch (componentID)
            {
                case "cmbDates" ->
                {
                    cmbDates.setSelectedItem(String.valueOf(db.getDate()));
                    lblAvailRoomCnt.setText("Number of rooms available: " + db.getHotel().getNumOfAvailRooms(db.getDate(), true));
                    lblBookedRoomCnt.setText("Number of rooms booked: " + db.getHotel().getNumOfAvailRooms(db.getDate(), false));
                }
                case "cmbRooms" ->
                {
                    cmbRooms.setSelectedItem(String.valueOf(db.getRoom().getNum()));
                    lblRoomType.setText("Type: " + db.getRoom().getType());
                    lblPricePerNight.setText("Base price per night: " + String.format("%.2f", db.getRoom().getNightlyPrice()));
                }
                case "cmbReservations" ->
                {
                    cmbReservations.setSelectedItem(db.getReservation().getCode());
                    lblGuestName.setText("Guest: " + db.getReservation().getGuest());
                    lblRoomDetails.setText("Room: Room " + db.getReservation().getRoom().getNum() + ", " + db.getReservation().getRoom().getType());
                    lblCheckInAndOut.setText("Check-in and check-out: " + db.getReservation().getCheckInAndOut());
                    lblResPrice.setText("Price (w/discount if any): " + String.format("%.2f", db.getReservation().getTotalPrice()));
                    lblResPricePerNight.setText("Price per night: " + String.format("%.2f", db.getReservation().getRoom().getNightlyPrice()));

                    // TODO Update table
                }
            }
        }
}