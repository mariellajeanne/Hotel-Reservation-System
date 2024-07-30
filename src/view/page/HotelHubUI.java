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

            private JLabel lblTitle;

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
    /*                           COMPONENT CONFIGURATION                          */
    /* -------------------------------------------------------------------------- */

        /**
         * Initializes components.
         */
        @Override
        protected void initializeComps()
        {
            lblTitle = new JLabel("Hotel Hub");
            
            lblAuthor1 = new JCommonLabel("Stephen M. Borja", 0, false);
            lblAuthor2 = new JCommonLabel("Mariella Jeanne A. Dellosa", 0, false);
            
            btnCreateHotel = new JBigButton("Create Hotel",785,590);
            btnViewHotel = new JBigButton("View Hotel",785, 670);
            btnManageHotel = new JBigButton("Manage Hotel",785, 750);
            btnBook = new JBigButton("Book",785,830);
        }

        /**
         * Configures components.
         */
        @Override
        protected void configureComps()
        {
            lblTitle.setFont(new Font("Arial", Font.BOLD, 250));
            lblTitle.setForeground(Color.decode("#86d0f3"));
            lblTitle.setLocation(382,196);
            lblTitle.setSize(lblTitle.getPreferredSize().width, 182);

            lblAuthor1.setBounds(382, 440, 306, 39);
            lblAuthor2.setBounds(382, 494, 470, 30);

            btnViewHotel.setEnabled(!db.getHotels().isEmpty());
            btnManageHotel.setEnabled(!db.getHotels().isEmpty());
            btnBook.setEnabled(!db.getHotels().isEmpty());
        }

        /**
         * Adds components to the panel.
         */
        @Override
        protected void addCompsToPanel()
        {
            add(lblTitle);
            
            add(lblAuthor1);
            add(lblAuthor2);
            
            add(btnCreateHotel);
            add(btnViewHotel);
            add(btnManageHotel);
            add(btnBook);
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
        public String getValue(String componentID){return "";}

        /**
         * Sets the error message.
         * 
         * @param text {String} The error message.
         */
        @Override
        public void setErrorMessage(String text){}

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