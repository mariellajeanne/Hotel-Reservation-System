/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls reservation booking.
 */

package controller.page;

import javax.swing.*;
import model.Database;
import model.Hotel;
import model.Reservation;
import model.Room;
import service.error.BookReservationER;
import view.frame.MainFrameUI;
import view.page.BookReservationUI;
import java.awt.*;

/**
 * The book reservation controller.
 */
public class BookReservationCO
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

        private static BookReservationCO brCO; // The single instance of the class.
        private static BookReservationER brER; // The book reservation error handler.
        private static BookReservationUI brUI; // The book reservation UI.
        private static MainFrameUI mfUI;       // The main frame UI.
        private static Database db;            // The database.

    /* -------------------------------------------------------------------------- */
    /*                                INSTANTIATION                               */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the book reservation controller.
         */
        private BookReservationCO()
        {
            brER = BookReservationER.getInstance();
            brUI = BookReservationUI.getInstance();
            mfUI = MainFrameUI.getInstance();
            db = Database.getInstance();

            handleBookBtn();
        }

        /**
         * Returns the instance of the book reservation controller.
         * 
         * @return {BookReservationCO}
         */
        public static BookReservationCO getInstance()
        {
            if (brCO == null)
                brCO = new BookReservationCO();
            return brCO;
        }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT LISTENERS                              */
    /* -------------------------------------------------------------------------- */

        /**
         * Handles reservation booking.
         */
        private void handleBookBtn()
        {
            brUI.getComp("btnBook").addActionListener(e -> 
            {
                /* Setup */

                    // Gets the inputted details.
                    String guest = (String) (JTextField)brUI.getComp("txtGuest").getText();
                    Hotel hotel = db.getHotel((String) cmbHotel.getSelectedItem());
                    String type = (String) cmbRoomType.getSelectedItem();
                    int checkIn = (int) cmbCheckIn.getSelectedItem();
                    int checkOut = (int) cmbCheckOut.getSelectedItem();
                    String code = (String) txtCode.getText();

                    // Gets the error message.
                    String errorMessage =
                        brER.checkBookReservation(guest, hotel, type, checkIn, checkOut, code);

                /* Update */

                    // Displays the error message if details are invalid.
                    if (!errorMessage.equals(""))
                        brUI.setErrorMessage(errorMessage);

                    else
                    {
                        // Books a reservation if details are valid.
                        bookReservation(guest, hotel, type, checkIn, checkOut, code);
                        
                        // Updates the UI accordingly.
                        mfUI.openPage("HOTEL_HUB");
                    }
            });
        }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */

        // TODO Change location of services?

        /**
         * Books a reservation.
         * @param guest     {String}    The guest.
         * @param h         {Hotel}     The hotel.
         * @param type      {String}    The room type.
         * @param checkIn   {int}       The check-in date.
         * @param checkOut  {int}       The check-out date.
         * @param code      {String}    The discount code.
         */
        private void bookReservation(String guest, Hotel h, String type,
            int checkIn, int checkOut, String code)
        {
            boolean isAvailable = true;
            
            // Checks each room of the hotel.
            for (Room room : h.getRooms())
            {   
                // Finds a room with the given room type.
                if (room.getType().equals(type))
                {   
                    // Checks if the reservation dates are available.
                    for (int j = checkIn; j < checkOut; j++)
                    {
                        if (room.getReservedDates().contains(j))
                            isAvailable = false;
                    }

                    // Reserves the first found available room.
                    if (isAvailable)
                    {
                        Reservation res = new Reservation(guest, checkIn, checkOut, room, code);
                        setUpPrice(h, res, code);
                        room.addReservation(res);
                        
                        return;
                    }
                }
            }
        }

        /**
         * Sets up the nightly and total price of a reservation given its code.
         * 
         * @param h     {Hotel}       The hotel.
         * @param r     {Reservation} The reservation.
         * @param code  {String}      The discount code.
         */
        private void setUpPrice(Hotel h, Reservation r, String code)
        {
            double totalPrice = 0; // The reservation's total price.

            // Sets the nightly prices based on the night rates.
            for (int i = r.getCheckIn(); i < r.getCheckOut(); i++)
            {
                double roomPrice = r.getRoom().getNightlyPrice();
                double nightlyPrice = roomPrice * h.getNightRate(i);

                r.setNightlyPrice(i, nightlyPrice);
                totalPrice += nightlyPrice;
            }

            // Sets the nightly prices based on the discount code.
            switch (code)
            {
                // Gives a 10% discount.
                case "I_WORK_HERE" ->
                {
                    totalPrice *= 0.9;
                }
                // Makes the first day free if the reservation has 5 days or more.
                case "STAY4_GET1" ->
                {
                    if (r.getCheckOut() - r.getCheckIn() >= 5)
                    {
                        double firstDayPrice = r.getNightlyPrice(r.getCheckIn());
                
                        totalPrice -= firstDayPrice;
                        r.setNightlyPrice(r.getCheckIn(), 0);
                    }
                }
                // Gives a 7% discount if the reservation has date 15 or 30.
                case "PAYDAY" ->
                {
                    if (r.hasNight(15) || r.hasNight(30))
                        totalPrice *= 0.7;
                }
            }

            r.setTotalPrice(totalPrice);
        }    
}
