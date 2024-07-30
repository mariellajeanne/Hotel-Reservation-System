/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * The main page.
 */

package view.page;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Database;
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
            private static Database db;

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

            lblAuthor1.setBounds(382, 440, lblAuthor1.getPreferredSize().width, lblAuthor1.getPreferredSize().height);
            lblAuthor2.setBounds(382, 494, lblAuthor2.getPreferredSize().width, lblAuthor2.getPreferredSize().height);

            btnCreateHotel.setLocation(785,590);
            btnViewHotel.setLocation(785, 670);
            btnViewHotel.setEnabled(!db.getHotels().isEmpty());
            btnManageHotel.setLocation(785, 750);
            btnManageHotel.setEnabled(!db.getHotels().isEmpty());
            btnBook.setLocation(785,830);
            btnBook.setEnabled(!db.getHotels().isEmpty());
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
                case "btnCreateHotel"   -> {btnCreateHotel.addActionListener(a);}
                case "btnViewHotel"     -> {btnViewHotel.addActionListener(a);}
                case "btnManageHotel"   -> {btnManageHotel.addActionListener(a);}
                case "btnBook"          -> {btnBook.addActionListener(a);}
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
            hhUI = new HotelHubUI();
        }
}