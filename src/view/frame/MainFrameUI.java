/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Manages the pages.
 */

package view.frame;

import javax.swing.*;
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

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            openPage("HOTEL_HUB");
            setExtendedState(JFrame.MAXIMIZED_BOTH);
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
         * @param page {String} The page to open.
         */
        public final void openPage(String page)
        {
            closePage();

            switch (page)
            {
                case "BOOK_RESERVATION" -> {add(brUI);}
                case "CREATE_HOTEL"     -> {add(chUI);}
                case "HOTEL_HUB"        -> {add(hhUI);}
                case "MANAGE_HOTEL"     -> {add(mhUI);}
                case "VIEW_HOTEL"       -> {add(vhUI);}
                default -> {}
            }

            currentPage = page;
        }

        /**
         * Closes a page.
         * 
         * @param page {String} The page to close.
         */
        public void closePage()
        {
            switch (currentPage)
            {
                case "BOOK_RESERVATION" -> {remove(brUI);}
                case "CREATE_HOTEL"     -> {remove(chUI);}
                case "HOTEL_HUB"        -> {remove(hhUI);}
                case "MANAGE_HOTEL"     -> {remove(mhUI);}
                case "VIEW_HOTEL"       -> {remove(vhUI);}
                default -> {}
            }
        }
}