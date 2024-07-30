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
        public void configureComps()
        {
            lblTitle.setFont(new Font("Arial", Font.BOLD, (int) (250 * Scale.MIN)));
            lblTitle.setForeground(Color.decode("#86d0f3"));
            lblTitle.setLocation((int) (382 * Scale.X),(int) (196 * Scale.Y));
            lblTitle.setSize((int) (lblTitle.getPreferredSize().width * 1.2), (int) (182 * Scale.Y));

            lblAuthor1.setSizePos(382, 440, 39);
            lblAuthor2.setSizePos(382, 494, 30);

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
    /*                             GETTERS AND SETTERS                            */
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
         * Sets the feedback message.
         * 
         * @param text      {String}    The feedback message.
         * @param isError   {boolean}   Determines if the feedback is an error warning.
         */
        @Override
        public void setFeedbackMessage(String text, boolean isError){}

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
         * Resets values of the error label and text fields.
         */
        @Override
        public void resetValues(){}
}