/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Manages the pages.
 */

package view.frame;

import javax.swing.*;
import model.Database;
import model.Hotel;
import model.Room;
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

            currentPage = "";

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

        /**
         * Opens a page.
         * 
         * @param page {String} The page to open.
         */
        public final void openPage(String page)
        {
            if (!currentPage.equals(""))
                closePage();

            // Executes if the page had been changed.
            if (!page.equals(currentPage))
            {   
                // Sets the hotel to null if there exists no hotel.
                if (db.getHotels().isEmpty())
                    db.setHotel(null);
                
                else
                {
                    Hotel hotel = db.getHotels().get(0);
                    Room room = hotel.getRooms().get(0);
                    
                    // Sets the default chosen hotel to the first in the list.
                    db.setHotel(hotel);

                    // Sets the default chosen room to the hotel's first room.
                    db.setRoom(room);

                    // Sets the default chosen reservation to null if there exists no reservations.
                    if (hotel.getNumOfReservations() == 0)
                        db.setReservation(null);

                    // Sets the default chosen reservation to the hotel's first reservation otherwise.
                    else
                    {
                        boolean isFound = false;

                        // Loops through each room.
                        for (int i = 0; i < hotel.getRooms().size() && !isFound; i++)
                        {
                            Room r = hotel.getRooms().get(i);

                            // Sets the reservation if found.
                            if (!r.getReservations().isEmpty())
                            {
                                db.setReservation(r.getReservations().get(0));
                                isFound = true;
                            }
                        }
                    }
                }
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