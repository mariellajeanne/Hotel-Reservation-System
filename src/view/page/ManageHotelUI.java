/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The manage hotel page.
 */

package view.page;

import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import model.*;
import view.frame.MainFrameUI;
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
            private static MainFrameUI mfUI;
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
            private JErrorLabel lblErrorMessage;

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
   /*                                 CONSTRUCTOR                                */
   /* -------------------------------------------------------------------------- */

        /**
         * Constructs the manage hotel UI.
         */
        private ManageHotelUI()
        {
            db = Database.getInstance();
            mfUI = MainFrameUI.getInstance();
     
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
            pnlTitle = new JTitlePanel("Manage Hotel");
            btnBack = new JBackButton();
            
            lblHotel = new JCommonLabel("HOTEL:",1,true);
            lblChangeName = new JCommonLabel("Change name:",0,false);
            lblActionStandard = new JCommonLabel("Add/delete standard rooms:",0,false);
            lblActionDeluxe = new JCommonLabel("Add/delete deluxe rooms:",0,false);
            lblActionExecutive = new JCommonLabel("Add/delete executive rooms:",0,false);
            lblChangePrice = new JCommonLabel("Change base price:",0,false);
            lblRemoveReservation = new JCommonLabel("Remove reservation:",0,false);
            lblChangeRate = new JCommonLabel("Change rate of night:",0,false);
            lblErrorMessage = new JErrorLabel();

            txtChangeName = new JCommonTextField();
            txtStandardCnt = new JCommonTextField();
            txtDeluxeCnt = new JCommonTextField();
            txtExecutiveCnt = new JCommonTextField();
            txtChangePrice = new JCommonTextField();
            txtChangeRate = new JCommonTextField();
        
            cmbHotels = new JCommonComboBox<>(db.getHotelNames());
            cmbReservations = new JCommonComboBox<>(db.getHotel().getReservationCodes());
            cmbNights = new JCommonComboBox<>(Reservation.getReservationNights());
            
            btnSaveName = new JSmallButton("Save", 1);
            btnSavePrice = new JSmallButton("Save", 1);
            btnSaveRate = new JSmallButton("Save", 1);
            btnAddStandard = new JSmallButton("Add", 0);
            btnAddDeluxe = new JSmallButton("Add", 0);
            btnAddExecutive = new JSmallButton("Add", 0);
            btnDeleteHotel = new JSmallButton("Delete", 1);
            btnDeleteStandard = new JSmallButton("Delete", 1);
            btnDeleteDeluxe = new JSmallButton("Delete", 1);
            btnDeleteExecutive = new JSmallButton("Delete", 1);
            btnDeleteReservation = new JSmallButton("Delete", 1);
            
            btnOK = new JBigButton("OK");
        }

        /**
         * Configures components.
         */
        @Override
        protected void configureComps()
        {
            cmbHotels.setBounds(673,300,341,30);
            cmbNights.setBounds(998,751,89,30);
            cmbReservations.setBounds(998,691,279,30);
            
            lblHotel.setBounds(470,299,lblHotel.getPreferredSize().width,31);
            lblChangeName.setBounds(470,389,lblChangeName.getPreferredSize().width,38);
            lblActionStandard.setBounds(468,449,488,30);
            lblActionDeluxe.setBounds(468,508,452,31);
            lblActionExecutive.setBounds(468,568,503,31);
            lblChangePrice.setBounds(468,628,343,39);
            lblRemoveReservation.setBounds(468,691,363,30);
            lblChangeRate.setBounds(468,751,458,38);
            lblErrorMessage.setBounds(468,830, lblErrorMessage.getPreferredSize().width,
            lblErrorMessage.getPreferredSize().height);
            lblErrorMessage.setVisible(false);
            
            txtChangeName.setBounds(998,389,279,30);
            txtStandardCnt.setBounds(998,449,89,30);
            txtDeluxeCnt.setBounds(998,508,89,30);
            txtExecutiveCnt.setBounds(998,568,89,30);
            txtChangePrice.setBounds(998,628,180,30);
            txtChangeRate.setBounds(1190,751,89,30);
            
            btnSaveName.setLocation(1328,389);
            btnSavePrice.setLocation(1328,628);
            btnSaveRate.setLocation(1328,749);
            btnAddStandard.setLocation(1189,450);
            btnAddDeluxe.setLocation(1189,509);
            btnAddExecutive.setLocation(1189,569);
            btnDeleteHotel.setLocation(1328,299);
            btnDeleteStandard.setLocation(1328,450);
            btnDeleteDeluxe.setLocation(1328,509);
            btnDeleteExecutive.setLocation(1328,569);
            btnDeleteReservation.setLocation(1328,691);
            
            btnOK.setBounds(785,925,330,55);
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addCompsToPanel()
        {
            add(pnlTitle);
            add(btnBack);
            
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
            add(lblErrorMessage);
            
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
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

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

        /**
         * Returns the input of a component.
         *
         * @param componentID   {String}    The component ID.
         * @return              {JComponent}
         */
        @Override
        public String getValue(String componentID)
        {
            switch (componentID)
            {
                case "txtChangeName" -> {return txtChangeName.getText();}
                case "txtStandardCnt" -> {return txtStandardCnt.getText();}
                case "txtDeluxeCnt" -> {return txtDeluxeCnt.getText();}
                case "txtExecutiveCnt" -> {return txtExecutiveCnt.getText();}
                case "txtChangePrice" -> {return txtChangePrice.getText();}
                case "txtChangeRate" -> {return txtChangeRate.getText();}
                case "cmbHotels" -> {return (String) cmbHotels.getSelectedItem();}
                case "cmbReservations" -> {return (String) cmbReservations.getSelectedItem();}
                case "cmbNights" -> {return (String) cmbNights.getSelectedItem();}
            }
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
                case "btnSaveName" -> {btnSaveName.addActionListener(a);}
                case "btnSavePrice" -> {btnSavePrice.addActionListener(a);}
                case "btnSaveRate" -> {btnSaveRate.addActionListener(a);}
                case "btnAddStandard" -> {btnAddStandard.addActionListener(a);}
                case "btnAddDeluxe" -> {btnAddDeluxe.addActionListener(a);}
                case "btnAddExecutive" -> {btnAddExecutive.addActionListener(a);}
                case "btnDeleteHotel" -> {btnDeleteHotel.addActionListener(a);}
                case "btnDeleteStandard" -> {btnDeleteStandard.addActionListener(a);}
                case "btnDeleteDeluxe" -> {btnDeleteDeluxe.addActionListener(a);}
                case "btnDeleteExecutive" -> {btnDeleteExecutive.addActionListener(a);}
                case "btnDeleteReservation" -> {btnDeleteReservation.addActionListener(a);}
            }
        }

    /* -------------------------------------------------------------------------- */
    /*                                MANIPULATORS                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Updates the page's component values.
         */
        @Override
        public void updateValues()
        {
            mhUI = new ManageHotelUI();
        }

        /**
         * Sets the error message.
         * 
         * @param text {String} The error message.
         */
        public void setErrorMessage(String text)
        {
            lblErrorMessage.setText(text);
            repaint();
        }
}