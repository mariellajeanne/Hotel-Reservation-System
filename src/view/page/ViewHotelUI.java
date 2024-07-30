/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The view hotel page.
 */

package view.page;

import java.awt.*;
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
            private JCommonComboBox<Integer> cmbDates;
            private JCommonComboBox<Integer> cmbRooms;
            private JCommonComboBox<String> cmbReservations;
            private JCommonComboBox<Integer> cmbAvailNights;

            private JPanel pnlScrollTable;
            private JScrollPane scrScroll;
            private JTable tblPricePerNight;
            private DefaultTableModel dtmTableModel;

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
            addCompsToPanel();
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
            pnlTitle = new JTitlePanel("View Hotel");
            btnBack = new JBackButton();
            
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

            dtmTableModel = new DefaultTableModel();
            tblPricePerNight = new JTable(dtmTableModel);
            
            scrScroll = new JScrollPane();
            scrScroll.setViewportView(tblPricePerNight);
            scrScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            pnlScrollTable = new JPanel(new GridLayout(1,1));
            pnlScrollTable.add(scrScroll);
            pnlScrollTable.setBounds(1010,618,536,290);
        }

        /**
         * Configures components.
         */
        @Override
        protected void configureComps()
        {
            lblHotel.setBounds(200,249,lblHotel.getPreferredSize().width,30);
            lblNumRooms.setBounds(250,308,lblNumRooms.getPreferredSize().width,39);
            lblEstEarnings.setBounds(250,371,lblEstEarnings.getPreferredSize().width,38);
            lblRoomAvailability.setBounds(250,432,441,43);
            lblAvailRoomCnt.setBounds(304,493,lblAvailRoomCnt.getPreferredSize().width,43);
            lblBookedRoomCnt.setBounds(304,556,lblBookedRoomCnt.getPreferredSize().width,43);
            lblRoom.setBounds(200,681,lblRoom.getPreferredSize().width,31);
            lblRoomType.setBounds(248,743,lblRoomType.getPreferredSize().width,43);
            lblPricePerNight.setBounds(248,806, lblPricePerNight.getPreferredSize().width,43);
            lblAvailNights.setBounds(248,868, lblAvailNights.getPreferredSize().width,43);
            lblReservation.setBounds(960,249,lblReservation.getPreferredSize().width,31);
            lblGuestName.setBounds(1010,308, lblGuestName.getPreferredSize().width,43);
            lblRoomDetails.setBounds(1010,371, lblRoomDetails.getPreferredSize().width,43);
            lblCheckInAndOut.setBounds(1010,435, lblCheckInAndOut.getPreferredSize().width,43);
            lblResPrice.setBounds(1010,494, lblResPrice.getPreferredSize().width,43);
            lblResPricePerNight.setBounds(1010,556,lblResPricePerNight.getPreferredSize().width,43);

            // Stores the hotel, room, and reservation being currently handled.
            Hotel h = db.getHotel();
            Room room = db.getRoom();
            Reservation res =  db.getReservation();

            // Executes the following if there exists hotels.
            if (!db.getHotels().isEmpty())
            {
                lblNumRooms.setText("Number of rooms: " + h.getRooms().size());
                lblEstEarnings.setText("Estimated earnings: " + h.getTotalEarnings());
                lblAvailRoomCnt.setText("Number of rooms available: " + h.getNumOfAvailRooms(db.getDate(), true));
                lblBookedRoomCnt.setText("Number of rooms booked: " + h.getNumOfAvailRooms(db.getDate(), false));
                lblRoomType.setText("Type: " + room.getType());
                lblPricePerNight.setText("Price per night: " + db.getRoom().getNightlyPrice());

                cmbHotels.setItems(db.getHotelNames());
                cmbDates.setItems(Reservation.getReservationDates(true));
                cmbRooms.setItems(db.getHotel().getRoomNumbers());
                cmbAvailNights.setItems(db.getRoom().getAvailableNights());
            }

            // Executes the following if there exists no hotels.
            else
            {
                lblNumRooms.setText("Number of rooms: N/A");
                lblEstEarnings.setText("Estimated earnings: N/A");
                lblAvailRoomCnt.setText("Number of rooms available: N/A");
                lblBookedRoomCnt.setText("Number of rooms booked: N/A");
                lblRoomType.setText("Type: ");
                lblPricePerNight.setText("Price per night: N/A");

                cmbHotels.removeAllItems();
                cmbDates.removeAllItems();
                cmbRooms.removeAllItems();
                cmbAvailNights.removeAllItems();
            }

            // Executes the following if the chosen hotel has a reservation.
            if (db.getReservation() != null)
            {
                lblGuestName.setText("Guest: " + res.getGuest());
                lblRoomDetails.setText("Room: Room " + res.getRoom().getNumber() + ", " + res.getRoom().getType());
                lblCheckInAndOut.setText("Check-in and check-out: " + res.getCheckInAndOut());
                lblResPrice.setText("Price (w/discount if any): " + res.getTotalPrice());
                lblResPricePerNight.setText("Price per night: " + res.getRoom().getNightlyPrice());
                cmbReservations.setItems(db.getRoom().getReservationCodes());

                dtmTableModel.setRowCount(0);

                // Adds rows to the price breakdown table.
                for (String s : res.getNightlyPrices())
                {
                    String[] row = new String[1];
                    row[0] = s;
                    dtmTableModel.addRow(row);
                }
            }

            // Executes the following if the chosen hotel has no reservations.
            else
            {
                lblGuestName.setText("Guest: N/A");
                lblRoomDetails.setText("Room: N/A");
                lblCheckInAndOut.setText("Check-in and check-out: N/A");
                lblResPrice.setText("Price (w/discount if any): N/A");
                lblResPricePerNight.setText("Price per night: N/A");
                cmbReservations.removeAllItems();
                dtmTableModel.setRowCount(0);
            }
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addCompsToPanel()
        {
            add(pnlTitle);
            add(btnBack);
            
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
            
            add(pnlScrollTable);
        }

    /* -------------------------------------------------------------------------- */
    /*                         GETTERS, SETTERS, UPDATERS                         */
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
         * Sets the error message.
         * 
         * @param text {String} The error message.
         */
        @Override
        public void setErrorMessage(String text){}

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
         * Updates the page's component values.
         */
        @Override
        public void updateValues()
        {
            configureComps();
            repaint();
        }
}