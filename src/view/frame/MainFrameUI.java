/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Manages the pages.
 */

package view.frame;

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

        private static String currentPage;      // The current page.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the frame of the system.
         */
        private MainFrameUI()
        {
            brUI = BookReservationUI.getInstance();
            chUI = CreateHotelUI.getInstance();
            hhUI = HotelHubUI.getInstance();
            mhUI = ManageHotelUI.getInstance();
            vhUI = ViewHotelUI.getInstance();
            db = Database.getInstance();

            currentPage = "HOTEL_HUB";

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            openPage("HOTEL_HUB");
            setVisible(true);

            // TODO SET SIZE
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

    // TODO USE CARD LAYOUT?

        /**
         * Opens a page.
         * 
         * @param page {String} The page to open.
         */
        public final void openPage(String page)
        {
            closePage();

            // Sets the default hotel, reservation, and room.
            if (!db.getHotels().isEmpty() && !page.equals(currentPage))
            {
                db.setHotel(db.getHotels().get(0));
                db.setRoom(db.getHotel().getRooms().get(0));
                db.setDate(1);

                if (!db.getRoom().getReservations().isEmpty())
                    db.setReservation(db.getRoom().getReservations().get(0));
            }

            // Opens each page.
            switch (page)
            {
                case "BOOK_RESERVATION" ->
                {
                    brUI.updateValues();
                    getContentPane().add(brUI);
                }
                case "CREATE_HOTEL" -> 
                {
                    chUI.updateValues();
                    getContentPane().add(chUI);
                }
                case "HOTEL_HUB" ->
                {
                    hhUI.updateValues();
                    getContentPane().add(hhUI);
                }
                case "MANAGE_HOTEL" ->
                {
                    mhUI.updateValues();
                    getContentPane().add(mhUI);
                }
                case "VIEW_HOTEL" ->
                {
                    vhUI.updateValues();
                    getContentPane().add(vhUI);
                }
                default -> {}
            }

            revalidate();
            repaint();
            currentPage = page;
        }

        /**
         * Closes a page.
         * 
         * @param page {String} The page to close.
         */
        private void closePage()
        {
            switch (currentPage)
            {
                case "BOOK_RESERVATION" -> {getContentPane().remove(brUI);}
                case "CREATE_HOTEL"     -> {getContentPane().remove(chUI);}
                case "HOTEL_HUB"        -> {getContentPane().remove(hhUI);}
                case "MANAGE_HOTEL"     -> {getContentPane().remove(mhUI);}
                case "VIEW_HOTEL"       -> {getContentPane().remove(vhUI);}
                default -> {}
            }
        }
        
        /**
         * Re-opens the current page.
         */
        public void reopenPage()
        {
            closePage();
            openPage(currentPage);
        }
}