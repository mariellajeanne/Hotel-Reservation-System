/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Controls reservation booking.
 */

package controller.page;

import controller.error.BookReservationER;
import java.awt.event.*;
import model.Database;
import model.Hotel;
import model.Reservation;
import model.Room;
import view.frame.MainFrameUI;
import view.page.BookReservationUI;

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

            handleBack();
            handleBookReservation();
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
         * Handles going back.
         */
        private void handleBack()
        {
            brUI.setActionListener("btnBack", (ActionEvent e) ->
            {
                brUI.resetValues();
                mfUI.openPage("BOOK_RESERVATION", "HOTEL_HUB");
            });
        }

        /**
         * Handles reservation booking.
         */
        private void handleBookReservation()
        {
            brUI.setActionListener("btnBook", (ActionEvent e) ->
            {
                if (!db.getHotels().isEmpty())
                {
                    /* Setup */
                
                        // Gets the inputted details.
                        String guest = brUI.getValue("txtGuest");
                        Hotel hotel = db.getHotel(brUI.getValue("cmbHotels"));
                        String type = brUI.getValue("cmbRoomTypes");
                        int checkIn = Integer.parseInt(brUI.getValue("cmbCheckIn"));
                        int checkOut = Integer.parseInt(brUI.getValue("cmbCheckOut"));
                        String code = brUI.getValue("txtCode");
                        
                        // Gets the error message.
                        String errorMessage =
                                brER.checkBookReservation(guest, hotel, type, checkIn, checkOut, code);

                    /* Update */
                
                        // Displays the error message if details are invalid.
                        if (!errorMessage.equals(""))
                            brUI.setFeedbackMessage(errorMessage, true);
                        
                        else
                        {
                            // Books a reservation if details are valid.
                            bookReservation(guest, hotel, type, checkIn, checkOut, code);
                            
                            // Updates the UI accordingly.
                            brUI.resetValues();
                            mfUI.openPage("BOOK_RESERVATION", "HOTEL_HUB");
                        }
                }
            });
        }

    /* -------------------------------------------------------------------------- */
    /*                                  SERVICES                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Books a reservation.
         * 
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
                    for (int i = checkIn; i < checkOut; i++)
                    {
                        if (room.getReservedDates().contains((Integer) i))
                            isAvailable = false;
                    }

                    // Reserves the first found available room.
                    if (isAvailable)
                    {
                        Reservation res = new Reservation(guest, checkIn, checkOut, room);
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
         * @param res   {Reservation} The reservation.
         * @param code  {String}      The discount code.
         */
        private void setUpPrice(Hotel h, Reservation res, String code)
        {
            double totalPrice = 0; // The reservation's total price.

            // Sets the nightly prices based on the night rates.
            for (int i = res.getCheckIn(); i < res.getCheckOut(); i++)
            {
                double roomPrice = res.getRoom().getNightlyPrice();
                double nightlyPrice = roomPrice * h.getNightRate(i);

                res.setNightlyPrice(i, nightlyPrice);
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
                    if (res.getCheckOut() - res.getCheckIn() >= 5)
                    {
                        double firstDayPrice = res.getNightlyPrice(res.getCheckIn());
                
                        totalPrice -= firstDayPrice;
                        res.setNightlyPrice(res.getCheckIn(), 0);
                    }
                }
                // Gives a 7% discount if the reservation has date 15 or 30.
                case "PAYDAY" ->
                {
                    if (res.hasNight(15) || res.hasNight(30))
                        totalPrice *= 0.7;
                }
            }

            res.setTotalPrice(totalPrice);
        }    
}
