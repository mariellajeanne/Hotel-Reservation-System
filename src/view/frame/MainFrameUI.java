/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Manages the pages.
 */

package view.frame;

import java.awt.Color;
import javax.swing.*;
import model.Database;
import view.page.*;

/**
 * The page manager class.
 */
public class MainFrameUI extends JFrame
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static MainFrameUI mfUI;        // The single instance of the class.

        private static BookReservationUI brUI;  // The book reservation UI.
        private static CreateHotelUI chUI;      // The create hotel UI.
        private static HotelHubUI hhUI;         // The hotel hub UI.
        private static ManageHotelUI mhUI;      // The manage hotel UI.
        private static ViewHotelUI vhUI;        // The view hotel UI.

        private static Database db;             // The database.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

    // TODO SET TEXT FIELDS TO EMPTY WHEN GOING BACK OR ACTION PERFORMED
        /**
         * Constructs the frame of the system.
         */
        private MainFrameUI()
        {
            db = Database.getInstance();

            brUI = BookReservationUI.getInstance();
            chUI = CreateHotelUI.getInstance();
            hhUI = HotelHubUI.getInstance();
            mhUI = ManageHotelUI.getInstance();
            vhUI = ViewHotelUI.getInstance();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setBackground(Color.decode("#26282e"));
            openPage("", "HOTEL_HUB");
            setVisible(true);
        }

        /**
         * Returns the instance of the page manager.
         * 
         * @return {PageManager}
         */
        public static MainFrameUI getInstance()
        {
            if (mfUI == null)
                mfUI = new MainFrameUI();
            return mfUI;
        }

    /* -------------------------------------------------------------------------- */
    /*                                MANIPULATORS                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Opens a page.
         * 
         * @param close {String}    The page to close.
         * @param open  {String}    The page to open.
         */
        public final void openPage(String close, String open)
        {
            closePage(close);

            // Updates the database's default values if the page changed.
            if (!close.equals(open))
                db.updateDefaultValues();

            // Opens each page.
            switch (open)
            {
                case "BOOK_RESERVATION" ->
                {
                    add(brUI);
                    brUI.updateValues();
                }
                case "CREATE_HOTEL" -> 
                {  
                    add(chUI);
                    chUI.updateValues();
                }
                case "HOTEL_HUB" ->
                {
                    add(hhUI);
                    hhUI.updateValues();
                }
                case "MANAGE_HOTEL" ->
                {
                    add(mhUI);
                    mhUI.updateValues();
                }
                case "VIEW_HOTEL" ->
                {
                    add(vhUI);
                    vhUI.updateValues();
                }
                default -> {}
            }
    
            revalidate();
            repaint();
        }

        /**
         * Closes a page.
         * 
         * @param page {String} The page to close.
         */
        private void closePage(String page)
        {
            switch (page)
            {
                case "BOOK_RESERVATION" -> {remove(brUI);}
                case "CREATE_HOTEL"     -> {remove(chUI);}
                case "HOTEL_HUB"        -> {remove(hhUI);}
                case "MANAGE_HOTEL"     -> {remove(mhUI);}
                case "VIEW_HOTEL"       -> {remove(vhUI);}
                default -> {}
            }

            revalidate();
            repaint();
        }
        
        /**
         * Re-opens the current page.
         * 
         * @param page {String} The page to be re-opened.
         */
        public void reopenPage(String page)
        {
            openPage(page, page);
        }
}