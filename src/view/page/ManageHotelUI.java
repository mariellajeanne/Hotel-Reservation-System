/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The manage hotel page.
 */

package view.page;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import model.*;
import view.util.*;

/**
 * The manage hotel UI class.
 */
public final class ManageHotelUI extends JBlackPanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        /* Class instances */

            private static ManageHotelUI mhUI;
            private static Database db;

        /* Components */
        
            private JTitlePanel pnlTitle;
            private JBackButton btnBack;
            
            private JCommonLabel lblHotel;
            private JCommonLabel lblChangeName;
            private JCommonLabel lblActionStandard;
            private JCommonLabel lblActionDeluxe;
            private JCommonLabel lblActionExecutive;
            private JCommonLabel lblChangePrice;
            private JCommonLabel lblRemoveReservation;
            private JCommonLabel lblChangeRate;
            private JFeedbackLabel lblFeedbackMessage;

            private JCommonTextField txtChangeName;
            private JCommonTextField txtStandardCnt;
            private JCommonTextField txtDeluxeCnt;
            private JCommonTextField txtExecutiveCnt;
            private JCommonTextField txtChangePrice;
            private JCommonTextField txtChangeRate;

            private JCommonComboBox<String> cmbHotels;
            private JCommonComboBox<String> cmbReservations;
            private JCommonComboBox<String> cmbNights;
            
            private JSmallButton btnSaveName;
            private JSmallButton btnSavePrice;
            private JSmallButton btnSaveRate;
            private JSmallButton btnAddStandard;
            private JSmallButton btnAddDeluxe;
            private JSmallButton btnAddExecutive;
            private JSmallButton btnDeleteHotel;
            private JSmallButton btnDeleteStandard;
            private JSmallButton btnDeleteDeluxe;
            private JSmallButton btnDeleteExecutive;
            private JSmallButton btnDeleteReservation;
    
            private JBigButton btnOK;

   /* -------------------------------------------------------------------------- */
   /*                                INSTANTIATION                               */
   /* -------------------------------------------------------------------------- */

        /**
         * Constructs the manage hotel UI.
         */
        private ManageHotelUI()
        {
            db = Database.getInstance();

            initializeComps();
            configureComps();
            addComps();
        }

        /**
         * Returns the single instance of the manage hotel UI.
         * 
         * @return {ManageHotelUI}
         */
        public static ManageHotelUI getInstance()
        {
            if (mhUI == null)
                mhUI = new ManageHotelUI();
            return mhUI;
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
            pnlTitle = new JTitlePanel("Manage Hotel");
            
            lblHotel = new JCommonLabel("HOTEL:",1,true);
            lblChangeName = new JCommonLabel("Change name:",0,false);
            lblActionStandard = new JCommonLabel("Add/delete standard rooms:",0,false);
            lblActionDeluxe = new JCommonLabel("Add/delete deluxe rooms:",0,false);
            lblActionExecutive = new JCommonLabel("Add/delete executive rooms:",0,false);
            lblChangePrice = new JCommonLabel("Change base price:",0,false);
            lblRemoveReservation = new JCommonLabel("Remove reservation:",0,false);
            lblChangeRate = new JCommonLabel("Change rate of night:",0,false);
            lblFeedbackMessage = new JFeedbackLabel();

            txtChangeName = new JCommonTextField(998,389,279,30);
            txtStandardCnt = new JCommonTextField(998,449,89,30);
            txtDeluxeCnt = new JCommonTextField(998,508,89,30);
            txtExecutiveCnt = new JCommonTextField(998,568,89,30);
            txtChangePrice = new JCommonTextField(998,628,180,30);
            txtChangeRate = new JCommonTextField(1190,751,89,30);
            
            cmbHotels = new JCommonComboBox<>(673,300,341,30);
            cmbNights = new JCommonComboBox<>(Reservation.getReservationDates(true),998,751,89,30);
            cmbReservations = new JCommonComboBox<>(998,691,279,30);
            
            btnSaveName = new JSmallButton("Save", 1,1328,389);
            btnSavePrice = new JSmallButton("Save", 1,1328,628);
            btnSaveRate = new JSmallButton("Save", 1,1328,749);
            btnAddStandard = new JSmallButton("Add", 0,1189,450);
            btnAddDeluxe = new JSmallButton("Add", 0,1189,509);
            btnAddExecutive = new JSmallButton("Add", 0,1189,569);
            btnDeleteHotel = new JSmallButton("Delete", 1,1328,299);
            btnDeleteStandard = new JSmallButton("Delete", 1,1328,450);
            btnDeleteDeluxe = new JSmallButton("Delete", 1,1328,509);
            btnDeleteExecutive = new JSmallButton("Delete", 1,1328,569);
            btnDeleteReservation = new JSmallButton("Delete", 1,1328,691);

            btnOK = new JBigButton("OK",785,925,330,55);
        }

        /**
         * Configures components.
         */
        @Override
        public void configureComps()
        {   
            // Executes if there exists hotels.
            if (!db.getHotels().isEmpty())
            {
                // Sets the hotel combo box's items.
                cmbHotels.setModel(new DefaultComboBoxModel<>(db.getHotelNames()));
                cmbHotels.setSelectedItem(db.getHotel().getName());
                
                // Sets the reservation combo box's items.
                if (db.getHotel().getNumOfReservations() != 0 && db.getReservation() != null)
                {
                    cmbReservations.setModel(new DefaultComboBoxModel<>
                        (db.getHotel().getReservationCodes()));
                    cmbReservations.setSelectedItem(db.getReservation().getCode());
                }
                    
                else
                    cmbReservations.removeAllItems();
            }

            // Makes the combo boxes empty if there exists no hotels.
            else
            {
                cmbHotels.removeAllItems();
                cmbReservations.removeAllItems();
            }

            // Enables the delete reservation button only if the hotel's reservations exist.
            if (!db.getHotels().isEmpty())
                btnDeleteReservation.setEnabled(db.getHotel().getNumOfReservations() != 0);
            else
                btnDeleteReservation.setEnabled(false);

            // Sets the label sizes according to text content.
            lblHotel.setSizePos(470,299,31);
            lblChangeName.setSizePos(470,389,38);
            lblActionStandard.setSizePos(468,449,30);
            lblActionDeluxe.setSizePos(468,508,31);
            lblActionExecutive.setSizePos(468,568,31);
            lblChangePrice.setSizePos(468,628,39);
            lblRemoveReservation.setSizePos(468,691,30);
            lblChangeRate.setSizePos(468,751,38);
            lblFeedbackMessage.setSizePos(468,830);
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addComps()
        {
            add(btnBack);
            add(pnlTitle);
            
            add(cmbHotels);
            add(cmbReservations);
            add(cmbNights);
            
            add(lblHotel);
            add(lblChangeName);
            add(lblActionStandard);
            add(lblActionDeluxe);
            add(lblActionExecutive);
            add(lblChangePrice);
            add(lblRemoveReservation);
            add(lblChangeRate);
            add(lblFeedbackMessage);
            
            add(txtChangeName);
            add(txtStandardCnt);
            add(txtDeluxeCnt);
            add(txtExecutiveCnt);
            add(txtChangePrice);
            add(txtChangeRate);
            
            add(btnDeleteHotel);
            add(btnSaveName);
            add(btnAddStandard);
            add(btnAddDeluxe);
            add(btnAddExecutive);
            add(btnDeleteStandard);
            add(btnDeleteDeluxe);
            add(btnDeleteExecutive);
            add(btnSavePrice);
            add(btnDeleteReservation);
            add(btnSaveRate);
            
            add(btnOK);
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
                case "txtChangeName"    -> txtChangeName.getText();
                case "txtStandardCnt"   -> txtStandardCnt.getText();
                case "txtDeluxeCnt"     -> txtDeluxeCnt.getText();
                case "txtExecutiveCnt"  -> txtExecutiveCnt.getText();
                case "txtChangePrice"   -> txtChangePrice.getText();
                case "txtChangeRate"    -> txtChangeRate.getText();
                case "cmbHotels"        -> (String) cmbHotels.getSelectedItem();
                case "cmbReservations"  -> (String) cmbReservations.getSelectedItem();
                case "cmbNights"        -> (String) cmbNights.getSelectedItem();
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
        public void setFeedbackMessage(String text, boolean isError)
        {   
            // Sets the text color to blue if not an error message.
            if (!isError)
                lblFeedbackMessage.setForeground(Color.decode("#86d0f3"));

            // Sets the text color to red otherwise.
            else
                lblFeedbackMessage.setForeground(Color.decode("#ffa0a0"));

            lblFeedbackMessage.setText(text);
            lblFeedbackMessage.setSizePos(468, 830);
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
                case "cmbHotels"            -> {cmbHotels.addActionListener(a);}
                case "btnSaveName"          -> {btnSaveName.addActionListener(a);}
                case "btnSavePrice"         -> {btnSavePrice.addActionListener(a);}
                case "btnSaveRate"          -> {btnSaveRate.addActionListener(a);}
                case "btnAddStandard"       -> {btnAddStandard.addActionListener(a);}
                case "btnAddDeluxe"         -> {btnAddDeluxe.addActionListener(a);}
                case "btnAddExecutive"      -> {btnAddExecutive.addActionListener(a);}
                case "btnDeleteHotel"       -> {btnDeleteHotel.addActionListener(a);}
                case "btnDeleteStandard"    -> {btnDeleteStandard.addActionListener(a);}
                case "btnDeleteDeluxe"      -> {btnDeleteDeluxe.addActionListener(a);}
                case "btnDeleteExecutive"   -> {btnDeleteExecutive.addActionListener(a);}
                case "btnDeleteReservation" -> {btnDeleteReservation.addActionListener(a);}
                case "btnBack"              -> {btnBack.addActionListener(a);}
                case "btnOK"                -> {btnOK.addActionListener(a);}
            }
        }

        /**
         * Resets values of the error label and text fields.
         */
        @Override
        public void resetValues()
        {
            lblFeedbackMessage.setText("");

            txtChangeName.setText("");
            txtStandardCnt.setText("");
            txtDeluxeCnt.setText("");
            txtExecutiveCnt.setText("");
            txtChangePrice.setText("");
            txtChangeRate.setText("");
        }
}