/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The view hotel page.
 */

package view.page;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Database;
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

        /* Component hashmap */
        
            private HashMap<String, JComponent> componentHashMap;

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
            private JCommonLabel lblReserveDeluxe;
            private JCommonLabel lblCheckInAndOut;
            private JCommonLabel lblReservationPrice;
            private JCommonLabel lblReservationPricePerNight;

            private JCommonComboBox<String> cmbHotels;
            private JCommonComboBox<Integer> cmbAvailDates;
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
            addCompsToHashMap();
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
            componentHashMap  = new HashMap<>();
            pnlTitle = new JTitlePanel("View Hotel");
            btnBack = new JBackButton();
            
            lblHotel = new JCommonLabel("HOTEL:", 1,true);
            lblNumRooms = new JCommonLabel("Number of rooms:", 0,false);
            lblEstEarnings = new JCommonLabel("Estimated earnings:", 0,false);
            lblRoomAvailability = new JCommonLabel("Room availability of date:", 1,false);
            lblAvailRoomCnt = new JCommonLabel("Number of rooms available:", 0,false);
            lblRoomTypeCnt = new JCommonLabel("Number of rooms booked:", 0,false);
            lblRoom = new JCommonLabel("ROOM:", 1,true);
            lblRoomType = new JCommonLabel("Type:", 0,false);
            lblPricePerNight = new JCommonLabel("Price per night:", 0,false);
            lblAvailNights = new JCommonLabel("Available nights:", 0,false);
            lblReservation = new JCommonLabel("RESERVATION:", 1,true);
            lblGuestName = new JCommonLabel("Guest:", 0,false);
            lblReserveDeluxe = new JCommonLabel("Room:", 0,false);
            lblCheckInAndOut = new JCommonLabel("Check-in and check-out:", 0,false);
            lblReservationPrice = new JCommonLabel("Price (w/discount if any):", 0,false);
            lblReservationPricePerNight = new JCommonLabel("Price per night:", 0,false);
            
            cmbHotels = new JCommonComboBox<>();
            cmbAvailDates = new JCommonComboBox<>(db.getReservationDates(true));
            cmbRooms = new JCommonComboBox<>();
            cmbReservations = new JCommonComboBox<>();
            cmbAvailNights = new JCommonComboBox<>();
            
            pnlScrollTable = new JPanel(new GridLayout(1,1));
            scrScroll = new JScrollPane();
            String[] datePrices = {"Date","Price"}; // TODO
            tblPricePerNight = new JTable(new DefaultTableModel(datePrices, 31));
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
            lblReserveDeluxe.setBounds(1010,371, lblReserveDeluxe.getPreferredSize().width,43);
            lblCheckInAndOut.setBounds(1010,435, lblCheckInAndOut.getPreferredSize().width,43);
            lblReservationPrice.setBounds(1010,494, lblReservationPrice.getPreferredSize().width,43);
            lblReservationPricePerNight.setBounds(1010,556,lblReservationPricePerNight.getPreferredSize().width,43);

            cmbHotels.setBounds(372,249,396,29);
            cmbAvailDates.setBounds(711,440,63,29);
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
            add(lblReserveDeluxe);
            add(lblCheckInAndOut);
            add(lblReservationPrice);
            add(lblReservationPricePerNight);
            
            add(cmbHotels);
            add(cmbAvailDates);
            add(cmbRooms);
            add(cmbAvailNights);
            add(cmbReservations);
            
            add(pnlScrollTable);
        }

        /**
         * Adds components to the component hashmap.
         */
        @Override
        protected void addCompsToHashMap()
        {
            componentHashMap.put("btnBack", btnBack);

            componentHashMap.put("cmbHotels", cmbHotels);
            componentHashMap.put("cmbAvailDates", cmbAvailDates);
            componentHashMap.put("cmbRooms", cmbRooms);
            componentHashMap.put("cmbAvailNights", cmbAvailNights);
            componentHashMap.put("cmbReservations", cmbReservations);

            componentHashMap.put("pnlScrollTable", pnlScrollTable);
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
         * Returns the component hashmap.
         *
         * @return {HashMap<String, JComponent>}
         */
        public HashMap<String, JComponent> getComp()
        {
            return componentHashMap;
        }

    /* -------------------------------------------------------------------------- */
    /*                                MANIPULATORS                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns a component given the component ID.
         *
         * @param componentID   {String}    The component ID.
         * @return              {JComponent}
         */
        public JComponent getComp(String componentID)
        {
            return componentHashMap.get(componentID);
        }
}