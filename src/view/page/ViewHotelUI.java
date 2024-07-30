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
            private JCommonLabel lblRoomTypeCnt;
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

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
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

    /* -------------------------------------------------------------------------- */
    /*                           COMPONENT CONFIGURATION                          */
    /* -------------------------------------------------------------------------- */

        /**
         * Initializes components.
         */
        @Override
        protected void initializeComps()
        {
            Hotel h = db.getHotel();
            Room room = db.getRoom();
            Reservation res =  db.getReservation();
            
            pnlTitle = new JTitlePanel("View Hotel");
            btnBack = new JBackButton();
            
            lblHotel = new JCommonLabel("HOTEL:", 1,true);
            
            if (!db.getHotels().isEmpty())
            {
                lblNumRooms = new JCommonLabel("Number of rooms: " + h.getRooms().size(), 0,false);
                lblEstEarnings = new JCommonLabel("Estimated earnings: " + h.getTotalEarnings(), 0,false);
                lblRoomAvailability = new JCommonLabel("Room availability of date:", 1,false);
                lblAvailRoomCnt = new JCommonLabel("Number of rooms available: " + h.getNumOfAvailRooms(db.getDate(), true), 0,false);
                lblRoomTypeCnt = new JCommonLabel("Number of rooms booked: " + h.getNumOfAvailRooms(db.getDate(), false), 0,false);
                lblRoom = new JCommonLabel("ROOM:", 1,true);
                lblRoomType = new JCommonLabel("Type: " + room.getType(), 0, false);
                lblPricePerNight = new JCommonLabel("Price per night: " + db.getRoom().getNightlyPrice(), 0, false);

                cmbHotels = new JCommonComboBox<>(db.getHotelNames());
                cmbDates = new JCommonComboBox<>(Reservation.getReservationDates(true));
                cmbRooms = new JCommonComboBox<>(db.getHotel().getRoomNumbers());
                cmbAvailNights = new JCommonComboBox<>(db.getRoom().getAvailableNights());
            }
            else
            {
                lblNumRooms = new JCommonLabel("Number of rooms: ", 0,false);
                lblEstEarnings = new JCommonLabel("Estimated earnings: ", 0,false);
                lblRoomAvailability = new JCommonLabel("Room availability of date:", 1,false);
                lblAvailRoomCnt = new JCommonLabel("Number of rooms available: ", 0,false);
                lblRoomTypeCnt = new JCommonLabel("Number of rooms booked: ", 0,false);
                lblRoom = new JCommonLabel("ROOM:", 1,true);
                lblRoomType = new JCommonLabel("Type: ", 0,false);
                lblPricePerNight = new JCommonLabel("Price per night: ", 0, false);

                cmbHotels = new JCommonComboBox<>();
                cmbDates = new JCommonComboBox<>(Reservation.getReservationDates(true));
                cmbRooms = new JCommonComboBox<>();
                cmbAvailNights = new JCommonComboBox<>();
            }
            
            lblAvailNights = new JCommonLabel("Available nights:", 0, false);
            lblReservation = new JCommonLabel("RESERVATION:", 1, true);

            if (db.getReservation() != null)
            {
                lblGuestName = new JCommonLabel("Guest: " + res.getGuest(), 0,false);
                lblRoomDetails = new JCommonLabel("Room: Room " + res.getRoom().getNumber() + ", " + res.getRoom().getType(), 0,false);
                lblCheckInAndOut = new JCommonLabel("Check-in and check-out: " + res.getCheckInAndOut(), 0,false);
                lblResPrice = new JCommonLabel("Price (w/discount if any): " + res.getTotalPrice(), 0,false);
                lblResPricePerNight = new JCommonLabel("Price per night: " + res.getRoom().getNightlyPrice(), 0,false);
                cmbReservations = new JCommonComboBox<>(db.getRoom().getReservationCodes());

                pnlScrollTable = new JPanel(new GridLayout(1,1));
                scrScroll = new JScrollPane();
                tblPricePerNight = new JTable(new DefaultTableModel(res.getNightlyPrices(), res.getNightlyPrices().length));
            }
            else
            {
                lblGuestName = new JCommonLabel("Guest: N/A", 0,false);
                lblRoomDetails = new JCommonLabel("Room: N/A", 0,false);
                lblCheckInAndOut = new JCommonLabel("Check-in and check-out: N/A", 0,false);
                lblResPrice = new JCommonLabel("Price (w/discount if any): N/A", 0,false);
                lblResPricePerNight = new JCommonLabel("Price per night: N/A", 0,false);
                cmbReservations = new JCommonComboBox<>();

                pnlScrollTable = new JPanel(new GridLayout(1,1));
                scrScroll = new JScrollPane();
                tblPricePerNight = new JTable(new DefaultTableModel());
            }
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
            lblRoomTypeCnt.setBounds(304,556,lblRoomTypeCnt.getPreferredSize().width,43);
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

            cmbHotels.setBounds(372,249,396,29);
            cmbDates.setBounds(711,440,63,29);
            cmbRooms.setBounds(351,683,63,29);
            cmbAvailNights.setBounds(546,877,63,29);
            cmbReservations.setBounds(1273,251,272,29);

            scrScroll.setViewportView(tblPricePerNight);
            scrScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            pnlScrollTable.add(scrScroll);
            pnlScrollTable.setBounds(1010,618,536,290);
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
            add(lblRoomTypeCnt);
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
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

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

        /**
         * Returns the input of a component.
         *
         * @param componentID   {String}    The component ID.
         * @return              {JComponent}
         */
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

    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

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

    /* -------------------------------------------------------------------------- */
    /*                                  UPDATERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Updates the page's component values.
         */
        @Override
        public void updateValues()
        {
            vhUI = new ViewHotelUI();
        }
}