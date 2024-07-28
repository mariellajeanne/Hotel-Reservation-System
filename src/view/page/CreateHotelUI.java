/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The create hotel page.
 */

package view.page;

import java.util.HashMap;
import javax.swing.*;
import view.util.*;

/**
 * The create hotel UI class.
*/
public final class CreateHotelUI extends JBlackPanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        /* Class instances */

            private static CreateHotelUI chUI;

        /* Component hashmap */
        
            private HashMap<String, JComponent> componentHashMap;

        /* Components */
        
            private JTitlePanel pnlTitle;
            private JBackButton btnBack;
            
            private JCommonLabel lblName;
            private JCommonLabel lblStandard;
            private JCommonLabel lblDeluxe;
            private JCommonLabel lblExecutive;
            private JCommonLabel lblPrice;
            private JErrorLabel lblErrorMessage;
            
            private JCommonTextField txtName;
            private JCommonTextField txtStandard;
            private JCommonTextField txtDeluxe;
            private JCommonTextField txtExecutive;
            private JCommonTextField txtPrice;
            
            private JBigButton btnCreate;

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the create hotel UI.
         */
        private CreateHotelUI()
        {
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
            pnlTitle = new JTitlePanel("Create Hotel");
            btnBack = new JBackButton();
            
            lblName = new JCommonLabel("Name:", 0,false);
            lblStandard = new JCommonLabel("Number of standard rooms:",
                0,false);
            lblDeluxe = new JCommonLabel("Number of deluxe rooms:",
                0,false);
            lblExecutive = new JCommonLabel("Number of executive rooms:",
                0,false);
            lblPrice = new JCommonLabel("Base nightly price:",
                0,false);
            lblErrorMessage = new JErrorLabel();
            
            txtName = new JCommonTextField();
            txtStandard = new JCommonTextField();
            txtDeluxe = new JCommonTextField();
            txtExecutive = new JCommonTextField();
            txtPrice = new JCommonTextField("1299.0");
            
            btnCreate = new JBigButton("Create");
        }

        /**
         * Configures components.
         */
        @Override
        protected void configureComps()
        {
            lblName.setBounds(670,300,lblName.getPreferredSize().width,30);
            lblStandard.setBounds(670,420,481,31);
            lblDeluxe.setBounds(670,480,443,31);
            lblExecutive.setBounds(670,540,494,31);
            lblPrice.setBounds(670,661,322,45);

            lblErrorMessage.setBounds(670,775, lblErrorMessage.getPreferredSize().width,
            lblErrorMessage.getPreferredSize().height);
            
            txtName.setBounds(869,300,380,30);
            txtStandard.setBounds(1184,421,65,30);
            txtDeluxe.setBounds(1184,481,65,30);
            txtExecutive.setBounds(1184,541,65,30);
            txtPrice.setBounds(1018,670,231,30);
            
            btnCreate.setBounds(785,925,330,55);
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addCompsToPanel()
        {
            add(pnlTitle);
            add(btnBack);

            add(lblName);
            add(lblStandard);
            add(lblDeluxe);
            add(lblExecutive);
            add(lblPrice);
            add(lblErrorMessage);

            add(txtName);
            add(txtStandard);
            add(txtDeluxe);
            add(txtExecutive);
            add(txtPrice);

            add(btnCreate);
        }

        /**
         * Adds components to the component hashmap.
         */
        @Override
        protected void addCompsToHashMap()
        {
            componentHashMap.put("btnBack", btnBack);

            componentHashMap.put("txtName", txtName);
            componentHashMap.put("txtStandard", txtStandard);
            componentHashMap.put("txtDeluxe", txtDeluxe);
            componentHashMap.put("txtExecutive", txtExecutive);
            componentHashMap.put("txtPrice", txtPrice);

            componentHashMap.put("lblErrorMessage", lblErrorMessage);

            componentHashMap.put("btnCreate", btnCreate);     
        }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the instance of the create hotel UI.
         * 
         * @return {CreateHotelUI}
         */
        public static CreateHotelUI getInstance()
        {
            if (chUI == null)
                chUI = new CreateHotelUI();
            return chUI;
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
    
    /* -------------------------------------------------------------------------- */
    /*                                MANIPULATORS                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Updates the page's component values.
         */
        public void updateValues()
        {
            lblErrorMessage.setText("");
            repaint();
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