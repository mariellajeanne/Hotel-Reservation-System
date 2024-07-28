/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls hotel creation.
 */

package controller.page;

import javax.swing.*;
import model.Database;
import model.Hotel;
import service.error.CreateHotelER;
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
        private static Database db;        // The database.

        JTextField txtName;

        JComboBox<Integer> cmbStandard;
        JComboBox<Integer> cmbDeluxe;
        JComboBox<Integer> cmbExecutive;

        JTextField txtPrice;

        JTextField txtErrorMessage;

        JButton btnCreate;

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
            db = Database.getInstance();

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
         * Handles hotel creation.
         */
        public final void handleCreateHotel()
        {
            btnCreate.addActionListener(e ->
            {
                /* Setup */

                    // Gets the hotel details.
                    String name = txtName.getText();
                    String standard = (String) cmbStandard.getSelectedItem();
                    String deluxe = (String) cmbDeluxe.getSelectedItem();
                    String executive = (String) cmbExecutive.getSelectedItem();
                    String price = txtPrice.getText();

                    // Gets the error message.
                    String errorMessage = chER.checkCreateHotel(name,
                        standard, deluxe, executive, price);

                /* Update */

                    // Displays the error message if there was an error.
                    if (!errorMessage.equals(""))
                        chUI.setErrorMessage(errorMessage);

                    // Creates the hotel if there was no error.
                    else
                    {
                        Hotel h = new Hotel(name,
                        Double.parseDouble(price),
                        Integer.parseInt(standard),
                        Integer.parseInt(deluxe),
                        Integer.parseInt(executive));

                        db.addHotel(h);

                        // TODO Update UI
                }
            });
        }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */
}