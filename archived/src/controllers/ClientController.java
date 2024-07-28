/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Receives input from the user and requests client services accordingly.
 */
package controllers;

/**
 * The client controller class.
 */
public class ClientController
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private static ClientController cc; // The single instance of the class.
    // Get instance of clientService
    // Get instance of CLIENT_LOG_IN
    // Get instance of CLIENT_SIGN_UP
    // Get instance of CLIENT_RESERVATION_LIST
    // Get instance of ADMIN_LOG_IN

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the client controller.
     */
    private ClientController()
    {
        addEventListeners();
    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the instance of the client controller.
     * 
     * @return {ClientController}
     */
    public static ClientController getInstance()
    {
        if (cc == null)
            cc = new ClientController();
        return cc;
    }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT HANDLERS                               */
    /* -------------------------------------------------------------------------- */

    /**
     * Adds the event listeners to the client UI components.
     */
    private void addEventListeners()
    {
        // Don't forget button controller
    }

    // /**
    //  * The event handler.
    //  * 
    //  * @param e {ActionEvent} The event.
    //  */
    // @Override
    // public void actionPerformed(ActionEvent e)
    // {
    //     // Object source = e.getSource();

    //     // if      (source == btnLogIn)    logIn();
    //     // else if (source == btnSignUp)   signUp();
    //     // For btnLogOut
    //     // For 
    // }

    // /**
    //  * Checks if text has been inserted in the text fields.
    //  * 
    //  * @param e {DocumentEvent} The event.
    //  */
    // @Override
    // public void insertUpdate(DocumentEvent e)
    // {
    //     checkFields();
    // }

    // /**
    //  * Checks if text has been removed from the text fields.
    //  * 
    //  * @param e {DocumentEvent} The event.
    //  */
    // @Override
    // public void removeUpdate(DocumentEvent e)
    // {
    //     checkFields();
    // }

    // /**
    //  * Checks if text has been change in the text fields.
    //  * 
    //  * @param e {DocumentEvent} The event.
    //  */
    // @Override
    // public void changedUpdate(DocumentEvent e)
    // {
    //     checkFields();
    // }

    /**
     * Enables the log-in or sign-up button to be pressed
     * if all fields have been filled out.
     */
    private void checkFields()
    {
        // Reference
            // Enable the button only if both text fields are non-empty
            // boolean allFilled = !textField1.getText().trim().isEmpty() && !textField2.getText().trim().isEmpty();
            // button.setEnabled(allFilled);
        
        // Checks text fields of CLIENT_LOG_IN
            // Change button enable status
        // Checks text fields of CLIENT_SIGN_UP
            // Change button enable status
    }

    /**
     * Allows the client to log in.
     */
    public void logIn()
    {
        // Request UIClientLogIn to get guest name
        // Request UIClientLogIn to get password

        // Error checking
            // Request UIClientLogIn to edit error message
        // Otherwise
            // Request ClientService to update client state
            // Request UIClientLogIn to close CLIENT_LOG_IN
            // Request UIClientLogIn to open CLIENT_RESERVATION_LIST
    }

    /**
     * Allows the client to sign up.
     */
    public void signUp()
    {
        // Request UIClientSignUp to get guest name
        // Request UIClientSignUp to get password
        // Request UIClientSignUp to get password confirmation

        // Error checking
            // Request UIClientSignUp to edit GUI based on error
        // Otherwise
            // Request ClientService to save guest name and password
            // Request ClientService to update client state
            // Request UIClientSignUp to close CLIENT_SIGN_UP
            // Request UIClientSignUp to open CLIENT_RESERVATION_LIST
    }

    /**
     * Opens the admin log-in page.
     */
    public void logInAdmin()
    {
        // Request UIClientLogIn to close
        // Request UIAdminlogIn to open
    }

    /**
     * Allows the client to go from sign up to log in.
     */
    public void goBack()
    {
        // Request UIClientSignUp to close
        // Request UIClientLogIn to open
    }

}
