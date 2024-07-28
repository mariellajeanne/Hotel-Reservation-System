/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The manage hotel page.
 */

package view.page;

import java.util.HashMap;
import javax.swing.*;
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

        /* Component hashmap */

            private HashMap<String, JComponent> componentHashMap;

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
            private JCommonTextField txtChangePrice;
            private JCommonTextField txtChangeRate;
            
            private JCommonComboBox<String> cmbHotelList;
            private JCommonComboBox<Integer> cmbStandardList; //TODO Change the <> type;
            private JCommonComboBox<Integer> cmbDeluxeList;
            private JCommonComboBox<Integer> cmbExecutiveList;
            private JCommonComboBox<String> cmbReservationList;
            private JCommonComboBox<String> cmbDateList;
            
            private JSmallButton btnDeleteHotel;
            private JSmallButton btnSaveName;
            private JSmallButton btnAddStandard;
            private JSmallButton btnDeleteStandard;
            private JSmallButton btnAddDeluxe;
            private JSmallButton btnDeleteDeluxe;
            private JSmallButton btnAddExecutive;
            private JSmallButton btnDeleteExecutive;
            private JSmallButton btnSavePrice;
            private JSmallButton btnDeleteReservation;
            private JSmallButton btnSaveRate;

            private JBigButton btnOK;
            
            private final String[] dates;

   /* -------------------------------------------------------------------------- */
   /*                                 CONSTRUCTOR                                */
   /* -------------------------------------------------------------------------- */

        /**
         * Constructs the manage hotel UI.
         */
        private ManageHotelUI()
        {
            /* Initialization */

                this.dates = new String[30];
                for (int i = 0; i < 30; i++)
                    this.dates[i] = String.valueOf(i + 1) + "-" + String.valueOf(i + 2);

                this.componentHashMap  = new HashMap<String, JComponent>();
                this.pnlTitle = new JTitlePanel("Manage Hotel");
                this.btnBack = new JBackButton();
                
                this.lblHotel = new JCommonLabel("HOTEL:",1,true);
                this.lblChangeName = new JCommonLabel("Change name:",0,false);
                this.lblActionStandard = new JCommonLabel("Add/delete standard rooms:",0,false);
                this.lblActionDeluxe = new JCommonLabel("Add/delete deluxe rooms:",0,false);
                this.lblActionExecutive = new JCommonLabel("Add/delete executive rooms:",0,false);
                this.lblChangePrice = new JCommonLabel("Change base price:",0,false);
                this.lblRemoveReservation = new JCommonLabel("Remove reservation:",0,false);
                this.lblChangeRate = new JCommonLabel("Change rate of night:",0,false);
                this.lblErrorMessage = new JErrorLabel();
                
                this.cmbHotelList = new JCommonComboBox<String>();
                this.txtChangeName = new JCommonTextField();
                this.cmbStandardList = new JCommonComboBox<Integer>();
                this.cmbDeluxeList = new JCommonComboBox<Integer>();
                this.cmbExecutiveList = new JCommonComboBox<Integer>();
                this.txtChangePrice = new JCommonTextField();
                this.cmbReservationList = new JCommonComboBox<String>();
                this.cmbDateList = new JCommonComboBox<String>(dates);
                this.txtChangeRate = new JCommonTextField();
                
                this.btnDeleteHotel = new JSmallButton("Delete", 1);
                this.btnSaveName = new JSmallButton("Save", 1);
                this.btnAddStandard = new JSmallButton("Add", 0);
                this.btnDeleteStandard = new JSmallButton("Delete", 1);
                this.btnAddDeluxe = new JSmallButton("Add", 0);
                this.btnDeleteDeluxe = new JSmallButton("Delete", 1);
                this.btnAddExecutive = new JSmallButton("Add", 0);
                this.btnDeleteExecutive = new JSmallButton("Delete", 1);
                this.btnSavePrice = new JSmallButton("Save", 1);
                this.btnDeleteReservation = new JSmallButton("Delete", 1);
                this.btnSaveRate = new JSmallButton("Save", 1);
                
                this.btnOK = new JBigButton("OK");

            /* Configuration and Addition to Panel and HashMap */
            
                add(pnlTitle);

                add(btnBack);
                componentHashMap.put("btnBack", btnBack);

                lblHotel.setBounds(470,299,lblHotel.getPreferredSize().width,31);
                add(lblHotel);

                lblChangeName.setBounds(470,389,lblChangeName.getPreferredSize().width,38);
                add(lblChangeName);

                lblActionStandard.setBounds(468,449,488,30);
                add(lblActionStandard);

                lblActionDeluxe.setBounds(468,508,452,31);
                add(lblActionDeluxe);

                lblActionExecutive.setBounds(468,568,503,31);
                add(lblActionExecutive);

                lblChangePrice.setBounds(468,628,343,39);
                add(lblChangePrice);

                lblRemoveReservation.setBounds(468,691,363,30);
                add(lblRemoveReservation);

                lblChangeRate.setBounds(468,751,458,38);
                add(lblChangeRate);

                //TODO Initialize the cmbHotelList;
                cmbHotelList.setBounds(673,300,341,30);
                add(cmbHotelList);
                componentHashMap.put("cmbHotelList", cmbHotelList);

                txtChangeName.setBounds(998,389,279,30);
                add(txtChangeName);
                componentHashMap.put("txtChangeName", txtChangeName);

                cmbStandardList.setBounds(998,449,89,30);
                add(cmbStandardList);
                componentHashMap.put("cmbStandardList", cmbStandardList);

                cmbDeluxeList.setBounds(998,508,89,30);
                add(cmbDeluxeList);
                componentHashMap.put("cmbDeluxeList", cmbDeluxeList);

                cmbExecutiveList.setBounds(998,568,89,30);
                add(cmbExecutiveList);
                componentHashMap.put("cmbExecutiveList", cmbExecutiveList);

                txtChangePrice.setBounds(998,628,180,30);
                add(txtChangePrice);
                componentHashMap.put("txtChangePrice", txtChangePrice);

                //TODO Initialize this
                cmbReservationList.setBounds(998,691,279,30);
                add(cmbReservationList);
                componentHashMap.put("cmbReservationList", cmbReservationList);

                cmbDateList.setBounds(998,751,89,30);
                add(cmbDateList);
                componentHashMap.put("cmbDateList", cmbDateList);

                txtChangeRate.setBounds(1190,751,89,30);
                add(txtChangeRate);
                componentHashMap.put("txtChangeRate", txtChangeRate);

                btnDeleteHotel.setLocation(1328,299);
                add(btnDeleteHotel);
                componentHashMap.put("btnDeleteHotel", btnDeleteHotel);

                btnSaveName.setLocation(1328,389);
                add(btnSaveName);
                componentHashMap.put("btnSaveName", btnSaveName);

                btnDeleteStandard.setLocation(1328,450);
                add(btnDeleteStandard);
                componentHashMap.put("btnDeleteStandard", btnDeleteStandard);

                btnDeleteDeluxe.setLocation(1328,509);
                add(btnDeleteDeluxe);
                componentHashMap.put("btnDeleteDeluxe", btnDeleteDeluxe);

                btnDeleteExecutive.setLocation(1328,569);
                add(btnDeleteExecutive);
                componentHashMap.put("btnDeleteExecutive", btnDeleteExecutive);

                btnSavePrice.setLocation(1328,628);
                add(btnSavePrice);
                componentHashMap.put("btnSavePrice", btnSavePrice);

                btnDeleteReservation.setLocation(1328,691);
                add(btnDeleteReservation);
                componentHashMap.put("btnDeleteReservation", btnDeleteReservation);

                btnSaveRate.setLocation(1328,749);
                add(btnSaveRate);
                componentHashMap.put("btnSaveRate", btnSaveRate);

                btnAddStandard.setLocation(1189,450);
                add(btnAddStandard);
                componentHashMap.put("btnAddStandard", btnAddStandard);

                btnAddDeluxe.setLocation(1189,509);
                add(btnAddDeluxe);
                componentHashMap.put("btnAddDeluxe", btnAddDeluxe);

                btnAddExecutive.setLocation(1189,569);
                add(btnAddExecutive);
                componentHashMap.put("btnAddExecutive", btnAddExecutive);

                btnOK.setBounds(785,925,330,55);
                add(btnOK);
                componentHashMap.put("btnOK", btnOK);

                lblErrorMessage.setBounds(468,830, lblErrorMessage.getPreferredSize().width,
                    lblErrorMessage.getPreferredSize().height);
                add(lblErrorMessage);
                lblErrorMessage.setVisible(false);
                componentHashMap.put("lblErrorMessage", lblErrorMessage);
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

        }

        /**
         * Configures components.
         */
        @Override
        protected void configureComps()
        {

        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addCompsToPanel()
        {

        }

        /**
         * Adds components to the component hashmap.
         */
        @Override
        protected void addCompsToHashMap()
        {

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
         * Updates the page's component values.
         */
        public void updateValues()
        {
            lblErrorMessage.setText("");
            this.repaint();
        }

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