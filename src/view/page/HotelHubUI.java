/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The main page.
 */

package view.page;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import view.util.*;

/**
 * The hotel hub UI class.
 */
public final class HotelHubUI extends JBlackPanel
{

    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        /* Class instances */

            private static HotelHubUI hhUI;

        /* Component hashmap */
        
            private HashMap<String, JComponent> componentHashMap;

        /* Components */

            private JLabel pnlTitle;

            private JCommonLabel lblAuthor1;
            private JCommonLabel lblAuthor2;
            
            private JBigButton btnCreateHotel;
            private JBigButton btnViewHotel;
            private JBigButton btnManageHotel;
            private JBigButton btnBook;

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the hotel hub UI.
         */
        private HotelHubUI()
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
            pnlTitle = new JLabel("Hotel Hub");
            
            lblAuthor1 = new JCommonLabel("Stephen M. Borja", 0, false);
            lblAuthor2 = new JCommonLabel("Mariella Jeanne A. Dellosa", 0, false);
            
            btnCreateHotel = new JBigButton("Create Hotel");
            btnViewHotel = new JBigButton("View Hotel");
            btnManageHotel = new JBigButton("Manage Hotel");
            btnBook = new JBigButton("Book");
        }

        /**
         * Configures components.
         */
        @Override
        protected void configureComps()
        {
            pnlTitle.setFont(new Font("Arial", Font.BOLD, 250));
            pnlTitle.setForeground(Color.decode("#86d0f3"));
            pnlTitle.setLocation(382,196);
            pnlTitle.setSize(pnlTitle.getPreferredSize().width, 182);

            lblAuthor1.setBounds(382, 440, 306, 39);
            lblAuthor2.setBounds(382, 494, 470, 30);

            btnCreateHotel.setLocation(785,590);
            btnViewHotel.setLocation(785, 670);
            btnManageHotel.setLocation(785, 750);
            btnBook.setLocation(785,830);
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addCompsToPanel()
        {
            add(pnlTitle);
            
            add(lblAuthor1);
            add(lblAuthor2);
            
            add(btnCreateHotel);
            add(btnViewHotel);
            add(btnManageHotel);
            add(btnBook);
        }

        /**
         * Adds components to the component hashmap.
         */
        @Override
        protected void addCompsToHashMap()
        {
            componentHashMap.put("btnCreateHotel", btnCreateHotel);
            componentHashMap.put("btnViewHotel", btnViewHotel);
            componentHashMap.put("btnManageHotel", btnManageHotel);
            componentHashMap.put("btnBook", btnBook);
        }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the instance of the hotel hub UI.
         * 
         * @return {HotelHubUI}
         */
        public static HotelHubUI getInstance()
        {
            if (hhUI == null)
                hhUI = new HotelHubUI();
            return hhUI;
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