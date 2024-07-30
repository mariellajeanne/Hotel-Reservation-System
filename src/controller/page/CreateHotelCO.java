/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls hotel creation.
 */

package controller.page;

import controller.error.CreateHotelER;
import java.awt.event.*;
import model.Database;
import model.Hotel;
import view.frame.MainFrameUI;
import view.page.CreateHotelUI;

/**
 * The create hotel controller.
*/
public class CreateHotelCO
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static CreateHotelCO chCO; // The single instance of the class.
        private static CreateHotelUI chUI; // The create hotel UI.
        private static CreateHotelER chER; // The create hotel error handler.
        private static MainFrameUI mfUI;   // The main frame UI.
        private static Database db;        // The database.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the create hotel controller.
         */
        private CreateHotelCO()
        {
            chUI = CreateHotelUI.getInstance();
            chER = CreateHotelER.getInstance();
            mfUI = MainFrameUI.getInstance();
            db = Database.getInstance();

            handleBack();
            handleCreateHotel();
        }

        /**
         * Returns the instance of the create hotel controller.
         * 
         * @return {CreateHotelCO}
         */
        public static CreateHotelCO getInstance()
        {
            if (chCO == null)
                chCO = new CreateHotelCO();
            return chCO;
        }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT LISTENERS                              */
    /* -------------------------------------------------------------------------- */

        /**
         * Handles going back.
         */
        private void handleBack()
        {
            chUI.setActionListener("btnBack", (ActionEvent e) ->
            {
                mfUI.openPage("HOTEL_HUB");
            });
        }

        /**
         * Handles hotel creation.
         */
        public final void handleCreateHotel()
        {
            chUI.setActionListener("btnCreate", (ActionEvent e) ->
            {
                /* Setup */

                    // Gets the hotel details.
                    String name = chUI.getValue("txtName");
                    String standard = chUI.getValue("txtStandard");
                    String deluxe = chUI.getValue("txtDeluxe");
                    String executive = chUI.getValue("txtExecutive");
                    String price = chUI.getValue("txtPrice");

                    // Gets the error message.
                    String errorMessage = chER.checkCreateHotel(name,
                        standard, deluxe, executive, price);

                /* Update */

                    // Displays the error message if there was an error.
                    if (!errorMessage.equals(""))
                        chUI.setErrorMessage(errorMessage);

                    else
                    {
                        // Creates the hotel if there was no error.
                        Hotel h = new Hotel(name,
                        Double.parseDouble(price),
                        Integer.parseInt(standard),
                        Integer.parseInt(deluxe),
                        Integer.parseInt(executive));
                        db.addHotel(h);

                        // Updates the UI accordingly.
                        mfUI.openPage("HOTEL_HUB");
                }
            });
        }
}