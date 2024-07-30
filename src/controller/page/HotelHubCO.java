/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls the main menu.
 */

package controller.page;

import java.awt.event.ActionEvent;
import view.frame.MainFrameUI;
import view.page.HotelHubUI;

/**
 * The hotel hub controller.
*/
public class HotelHubCO
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static HotelHubCO hhCO;     // The single instance of the class.
        private static HotelHubUI hhUI;     // The hotel hub UI.
        private static MainFrameUI mfUI;    // The main frame UI.       

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the hotel hub controller.
         */
        private HotelHubCO()
        {
            hhUI = HotelHubUI.getInstance();
            mfUI = MainFrameUI.getInstance();

            handleCreateHotel();
            handleViewHotel();
            handleManageHotel();
            handleBookReservation();
        }

        /**
         * Returns the instance of the hotel hub controller.
         * 
         * @return {HotelHubCO}
         */
        public static HotelHubCO getInstance()
        {
            if (hhCO == null)
                hhCO = new HotelHubCO();
            return hhCO;
        }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT LISTENERS                              */
    /* -------------------------------------------------------------------------- */

        /**
         * Handles the opening of the create hotel page.
         */
        private void handleCreateHotel()
        {
            hhUI.setActionListener("btnCreateHotel", (ActionEvent e) ->
            {
                mfUI.openPage("CREATE_HOTEL");
                System.out.println("Button pressed!");
            });
        }

        /**
         * Handles the opening of the view hotel page.
         */
        private void handleViewHotel()
        {
            hhUI.setActionListener("btnViewHotel", (ActionEvent e) ->
            {
                mfUI.openPage("VIEW_HOTEL");
            });
        }

        /**
         * Handles the opening of the manage hotel page.
         */
        private void handleManageHotel()
        {
            hhUI.setActionListener("btnManageHotel", (ActionEvent e) ->
            {
                mfUI.openPage("MANAGE_HOTEL");
            });
        }

        /**
         * Handles the opening of the book reservation page.
         */
        private void handleBookReservation()
        {
            hhUI.setActionListener("btnBook", (ActionEvent e) ->
            {
                mfUI.openPage("BOOK_RESERVATION");
            });
        }
    }