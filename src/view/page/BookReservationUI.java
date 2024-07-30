/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The book reservation page.
 */

package view.page;

import java.awt.event.ActionListener;
import model.*;
import view.util.*;

/**
 * The book reservation UI class.
*/
public final class BookReservationUI extends JBlackPanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        /* Class instances */

            private static BookReservationUI brUI;
            private static Database db;

        /* Components */
        
            private JTitlePanel pnlTitle;
            private JBackButton btnBack;
            
            private JCommonLabel lblGuest;
            private JCommonLabel lblHotel;
            private JCommonLabel lblRoomType;
            private JCommonLabel lblCheckIn;
            private JCommonLabel lblCheckOut;
            private JCommonLabel lblDiscountCode;
            private JErrorLabel lblErrorMessage;
            
            private JCommonTextField txtGuest;
            private JCommonTextField txtCode;
            private JCommonComboBox<String> cmbHotels;
            private JCommonComboBox<String> cmbRoomTypes;
            private JCommonComboBox<Integer> cmbCheckIn;
            private JCommonComboBox<Integer> cmbCheckOut;
            
            private JBigButton btnBook;

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the book reservation UI.
         */
        private BookReservationUI()
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
            pnlTitle = new JTitlePanel("Book Reservation");
            btnBack = new JBackButton();
            
            lblGuest = new JCommonLabel("Guest:", 0, false);
            lblHotel = new JCommonLabel("Hotel:", 0, false);
            lblRoomType = new JCommonLabel("Room type:", 0, false);
            lblCheckIn = new JCommonLabel("Check-in date:", 0, false);
            lblCheckOut = new JCommonLabel("Check-out date:", 0, false);
            lblDiscountCode = new JCommonLabel("Discount code:", 0, false);
            lblErrorMessage = new JErrorLabel();
            
            txtGuest = new JCommonTextField();
            txtCode = new JCommonTextField();
            
            if (!db.getHotels().isEmpty())
                cmbHotels = new JCommonComboBox<>(db.getHotelNames());
            else
                cmbHotels = new JCommonComboBox<>();

            cmbRoomTypes = new JCommonComboBox<>(Room.getRoomTypes());
            cmbCheckIn = new JCommonComboBox<>(Reservation.getReservationDates(true));
            cmbCheckOut = new JCommonComboBox<>(Reservation.getReservationDates(false));

            btnBook = new JBigButton("Book");
        }

        /**
         * Configures components.
         */
        @Override
        protected void configureComps()
        {
            lblGuest.setBounds(670, 300, lblGuest.getPreferredSize().width,lblGuest.getPreferredSize().height);
            lblHotel.setBounds(670, 361, lblHotel.getPreferredSize().width,lblHotel.getPreferredSize().height);
            lblRoomType.setBounds(670,422,lblRoomType.getPreferredSize().width,lblRoomType.getPreferredSize().height);
            lblCheckIn.setBounds(670,482,254,31);
            lblCheckOut.setBounds(670,542,278,31);
            lblDiscountCode.setBounds(670,667,lblDiscountCode.getPreferredSize().width,lblDiscountCode.getPreferredSize().height);
            
            lblErrorMessage.setBounds(670,775, lblErrorMessage.getPreferredSize().width,
            lblErrorMessage.getPreferredSize().height);

            txtGuest.setBounds(870,300,381,30);
            txtCode.setBounds(962,667,289,30);
            
            cmbHotels.setBounds(870,361,380,30);
            cmbRoomTypes.setBounds(1031,422,220,30);
            cmbCheckIn.setBounds(1186,483,65,30);
            cmbCheckOut.setBounds(1186,543,65,30);
            
            btnBook.setBounds(785,925,330,55);
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addCompsToPanel()
        {
            add(pnlTitle);
            add(btnBack);
            
            add(lblGuest);
            add(lblHotel);
            add(lblRoomType);
            add(lblCheckIn);
            add(lblCheckOut);
            add(lblDiscountCode);
            add(lblErrorMessage);
            
            add(txtGuest);
            add(txtCode);
            
            add(cmbHotels);
            add(cmbRoomTypes);
            add(cmbCheckIn);
            add(cmbCheckOut);
            
            add(btnBook);
        }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the instance of the book reservation UI.
         * 
         * @return {BookReservationUI}
         */
        public static BookReservationUI getInstance()
        {
            if (brUI == null)
                brUI = new BookReservationUI();
            return brUI;
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
                case "txtGuest"     -> txtGuest.getText();
                case "cmbHotels"    -> (String) cmbHotels.getSelectedItem();
                case "cmbRoomTypes" -> (String) cmbRoomTypes.getSelectedItem();
                case "cmbCheckIn"   -> (String) cmbCheckIn.getSelectedItem();
                case "cmbCheckOut"  -> (String) cmbCheckOut.getSelectedItem();
                case "txtCode"      -> txtCode.getText();
                default -> "";
            };
        }

    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Sets the error message.
         * 
         * @param text {String} The error message.
         */
        public void setErrorMessage(String text)
        {
            lblErrorMessage.setText(text);
            revalidate();
            repaint();
        }

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
                case "btnBook"  -> {btnBook.addActionListener(a);}
                case "btnBack"  -> {btnBack.addActionListener(a);}
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
            brUI = new BookReservationUI();
        }
        
}