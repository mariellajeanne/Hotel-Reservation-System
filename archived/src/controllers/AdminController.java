/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Receives input from the user and requests client services accordingly.
 */

package controllers;

/**
 * The admin controller class.
 */
public class AdminController
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private static AdminController ac; // The instance of the class.
    // private AdminService as;           // The admin service.
    // Get instance of ADMIN_LOG_IN
    // Get instance of ADMIN_HOTEL_LIST

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the admin controller.
     */
    private AdminController()
    {
        addEventListeners();
    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the instance of the admin controller.
     * 
     * @return {AdminController}
     */
    public static AdminController getInstance()
    {
        if (ac == null)
            ac = new AdminController();
        return ac;
    }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT HANDLERS                               */
    /* -------------------------------------------------------------------------- */

    /**
     * Adds event listeners to the admin UI components.
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
    // public void actionPerformed(ActionEvent e)
    // {
    //     // Object source = e.getSource();

    //     // if      (source == btnLogIn)    logIn();
    //     // else if (source == btnSignUp)   signUp();
    // }

    // /**
    //  * Checks if text has been inserted in the text fields.
    //  * 
    //  * @param e {DocumentEvent} The event.
    //  */
    // public void insertUpdate(DocumentEvent e)
    // {
    //     checkFields();
    // }

    // /**
    //  * Checks if text has been removed from the text fields.
    //  * 
    //  * @param e {DocumentEvent} The event.
    //  */
    // public void removeUpdate(DocumentEvent e)
    // {
    //     checkFields();
    // }

    // /**
    //  * Checks if text has been change in the text fields.
    //  * 
    //  * @param e {DocumentEvent} The event.
    //  */
    // public void changedUpdate(DocumentEvent e)
    // {
    //     checkFields();
    // }

    /**
     * Enables the log-in button to be pressed
     * if all fields have been filled out.
     */
    private void checkFields()
    {
        // Reference
            // Enable the button only if both text fields are non-empty
            // boolean allFilled = !textField1.getText().trim().isEmpty() && !textField2.getText().trim().isEmpty();
            // button.setEnabled(allFilled);
    }

    /**
     * Allows the admin to log in.
     */
    public void logIn()
    {
        // Request UIAdminLogIn to get password

        // Error checking
            // Request UIAdminLogIn to edit error message
        // Otherwise
            // Request CAdminService to update user state
            // Request UIAdminLogIn to close ADMIN_LOG_IN
    }

    /**
     * Allows the admin to log out.
     */
    public void logOut()
    {
        // Request UIClientSignUp to close
        // Request UIClientLogIn to open
    }

}
