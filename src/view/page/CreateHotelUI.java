/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The create hotel page.
 */

package view.page;

import java.awt.event.ActionListener;
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
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the create hotel UI.
         */
        private CreateHotelUI()
        {
            initializeComps();
            configureComps();
            addCompsToPanel();
        }

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

    /* -------------------------------------------------------------------------- */
    /*                           COMPONENT CONFIGURATION                          */
    /* -------------------------------------------------------------------------- */

        /**
         * Initializes components.
         */
        @Override
        protected void initializeComps()
        {  
            pnlTitle = new JTitlePanel("Create Hotel");
            btnBack = new JBackButton();
            
            lblName = new JCommonLabel("Name:", 0,false);
            lblStandard = new JCommonLabel("Number of standard rooms:", 0,false);
            lblDeluxe = new JCommonLabel("Number of deluxe rooms:", 0,false);
            lblExecutive = new JCommonLabel("Number of executive rooms:", 0, false);
            lblPrice = new JCommonLabel("Base nightly price:", 0, false);
            lblErrorMessage = new JErrorLabel();
            
            txtName = new JCommonTextField(869,300,380,30);
            txtStandard = new JCommonTextField(1184,421,65,30);
            txtDeluxe = new JCommonTextField(1184,481,65,30);
            txtExecutive = new JCommonTextField(1184,541,65,30);
            txtPrice = new JCommonTextField("1299.0",1018,670,231,30);
            
            btnCreate = new JBigButton("Create", 785,925,330,55);
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
                case "txtName"      -> txtName.getText();
                case "txtStandard"  -> txtStandard.getText();
                case "txtDeluxe"    -> txtDeluxe.getText();
                case "txtExecutive" -> txtExecutive.getText();
                case "txtPrice"     -> txtPrice.getText();
                default             -> "";
            };
        }

        /**
         * Sets the error message.
         * 
         * @param text {String} The error message.
         */
        @Override
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
                case "btnCreate"    -> {btnCreate.addActionListener(a);}
                case "btnBack"      -> {btnBack.addActionListener(a);}
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