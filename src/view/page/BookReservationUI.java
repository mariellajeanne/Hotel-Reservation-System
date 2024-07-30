/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The book reservation page.
 */

package view.page;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
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
            private JFeedbackLabel lblFeedbackMessage;
            
            private JCommonTextField txtGuest;
            private JCommonTextField txtCode;
            private JCommonComboBox<String> cmbHotels;
            private JCommonComboBox<String> cmbRoomTypes;
            private JCommonComboBox<String> cmbCheckIn;
            private JCommonComboBox<String> cmbCheckOut;
            
            private JBigButton btnBook;

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
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
            pnlTitle = new JTitlePanel("Book Reservation");
            
            lblGuest = new JCommonLabel("Guest:", 0, false);
            lblHotel = new JCommonLabel("Hotel:", 0, false);
            lblRoomType = new JCommonLabel("Room type:", 0, false);
            lblCheckIn = new JCommonLabel("Check-in date:", 0, false);
            lblCheckOut = new JCommonLabel("Check-out date:", 0, false);
            lblDiscountCode = new JCommonLabel("Discount code:", 0, false);
            lblFeedbackMessage = new JFeedbackLabel();
            
            txtGuest = new JCommonTextField(870,300,381,30);
            txtCode = new JCommonTextField(962,667,289,30);

            cmbHotels = new JCommonComboBox<>(870,361,380,30);
            cmbRoomTypes = new JCommonComboBox<>(Room.getRoomTypes(), 1031,422,220,30);
            cmbCheckIn = new JCommonComboBox<>(Reservation.getReservationDates(true), 1186,483,65,30);
            cmbCheckOut = new JCommonComboBox<>(Reservation.getReservationDates(false), 1186,543,65,30);

            btnBook = new JBigButton("Book", 785,925,330,55);
        }

        /**
         * Configures components.
         */
        @Override
        public void configureComps()
        {
            if (!db.getHotels().isEmpty())
            {
                cmbHotels.setModel(new DefaultComboBoxModel<>(db.getHotelNames()));
                cmbHotels.setSelectedItem(db.getHotel().getName());
            }
                
            else
                cmbHotels.removeAllItems();

            lblGuest.setSizePos(670,300,30);
            lblHotel.setSizePos(670,361,30);
            lblRoomType.setSizePos(670,422,38);
            lblCheckIn.setSizePos(670,482,31);
            lblCheckOut.setSizePos(670,542,31);
            lblDiscountCode.setSizePos(670,667,30);
            lblFeedbackMessage.setSizePos(670,775);
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addCompsToPanel()
        {
            add(btnBack);
            add(pnlTitle);
            
            add(lblGuest);
            add(lblHotel);
            add(lblRoomType);
            add(lblCheckIn);
            add(lblCheckOut);
            add(lblDiscountCode);
            add(lblFeedbackMessage);
            
            add(txtGuest);
            add(txtCode);
            
            add(cmbHotels);
            add(cmbRoomTypes);
            add(cmbCheckIn);
            add(cmbCheckOut);
            
            add(btnBook);
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
                case "txtGuest"     -> txtGuest.getText();
                case "cmbHotels"    -> (String) cmbHotels.getSelectedItem();
                case "cmbRoomTypes" -> (String) cmbRoomTypes.getSelectedItem();
                case "cmbCheckIn"   -> (String) cmbCheckIn.getSelectedItem();
                case "cmbCheckOut"  -> (String) cmbCheckOut.getSelectedItem();
                case "txtCode"      -> txtCode.getText();
                default -> "";
            };
        }

        /**
         * Sets the feedback message.
         * 
         * @param text      {String}    The feedback message.
         * @param isError   {boolean}   Determines if the feedback is an error warning.
         */
        @Override
        public void setFeedbackMessage(String text, boolean isError)
        {
            lblFeedbackMessage.setText(text);
            lblFeedbackMessage.setSizePos(670, 775);
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

        /**
         * Resets values of the error label and text fields.
         */
        @Override
        public void resetValues()
        {
            lblFeedbackMessage.setText("");
            txtGuest.setText("");
            txtCode.setText("");
        }
}