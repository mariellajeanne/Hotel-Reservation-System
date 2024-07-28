/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * The client log-in page.
 */

package view.pages.client;

import constants.*;
import java.awt.*;
import javax.swing.*;
import view.utils.*;

/**
 * The client log-in class.
 */
public class UIClientLogIn extends JPagePanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private static UIClientLogIn cli; // The single instance of the class.

    // Title panel.
    private JTitlePanel tlpTitle;

    // Log-in panel.
    private JPanel pnlLogIn;

        // Labels.
        private JCustomLabel lblLogIn;
        private JCustomLabel lblErrorMessage;
        private JCustomLabel lblSignUp;
        private JCustomLabel lblAdminLogIn;

        // Buttons.
        private JCustomButton btnLogIn;

        // Text Fields.
        private JCustomTextField txtGuestName;
        private JCustomTextField txtPassword;
    

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the client log-in page.
     */
    private UIClientLogIn()
    {
        // Configuration of the title panel.
        tlpTitle = JTitlePanel.getInstance();

        // Configuration of the log-in panel.
        pnlLogIn = new JPanel();
        pnlLogIn.setPreferredSize(new Dimension((int) (WinSizeCons.W / 2), WinSizeCons.H));
        pnlLogIn.setLayout(new BoxLayout(pnlLogIn, BoxLayout.Y_AXIS));
        pnlLogIn.setBackground(ColorCons.BA);

            lblLogIn = new JCustomLabel("Log in",
                ColorCons.W, TxtSizeCons.L, 0, 0, SpaceSizeCons.M, 0);
            lblErrorMessage = new JCustomLabel("",
                ColorCons.R, TxtSizeCons.XS, 0, 0, SpaceSizeCons.S, 0);
            txtGuestName = new JCustomTextField("Guest Name",
                ColorCons.W, ColorCons.BA, 0.2813 * WinSizeCons.W,  0.0694 *
                WinSizeCons.H, TxtSizeCons.M, 0, 0, SpaceSizeCons.S, 0);
            txtPassword = new JCustomTextField("Password",
                ColorCons.W, ColorCons.BA, 0.2813 * WinSizeCons.W,  0.0694 *
                WinSizeCons.H, TxtSizeCons.M, 0, 0, SpaceSizeCons.S, 0);
            btnLogIn = new JCustomButton("Log in", ColorCons.W, ColorCons.BA,
                BtnSizeCons.M, TxtSizeCons.M, 0, 0, SpaceSizeCons.L, 0);
            lblSignUp = new JCustomLabel("No account? Sign up.",
                ColorCons.BU, TxtSizeCons.S, 0, 0, SpaceSizeCons.L * 2, 0);
            lblAdminLogIn = new JCustomLabel("Log in as administrator",
                ColorCons.BU, TxtSizeCons.S, 0, 0, 0, 0);

            pnlLogIn.add(lblLogIn);
            pnlLogIn.add(lblErrorMessage);
            pnlLogIn.add(txtGuestName);
            pnlLogIn.add(txtPassword);
            pnlLogIn.add(btnLogIn);
            pnlLogIn.add(lblSignUp);
            pnlLogIn.add(lblAdminLogIn);

        // Configuration of the main panel.
        this.setLayout(new BorderLayout());
        this.setBackground(ColorCons.BA);
        this.add(tlpTitle);
        // this.add(pnlLogIn);
    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the instance of the client log-in page.
     * 
     * @return {UIClientLogIn}
     */
    public static UIClientLogIn getInstance()
    {   
        if (cli == null)
            cli = new UIClientLogIn();
        return cli;
    }

    /* -------------------------------------------------------------------------- */
    /*                                    SETUP                                   */
    /* -------------------------------------------------------------------------- */

    // /**
    //  * Sets up the main panel.
    //  */
    // private void setUpMainPnl()
    // {
    //     this.add(tlpTitle);
    //     this.add(pnlLogIn);
    // }

    // /**
    //  * Sets up the log-in panel.
    //  */
    // private void setUpLogInPnl()
    // {
    //     pnlLogIn.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    //     pnlLogIn.add(lblLogIn);
    //     pnlLogIn.add(lblErrorMessage);
    //     pnlLogIn.add(txtGuestName);
    //     pnlLogIn.add(txtPassword);
    //     pnlLogIn.add(btnLogIn);
    //     pnlLogIn.add(lblSignUp);
    //     pnlLogIn.add(lblAdminLogIn);
    // }

    // /**
    //  * Sets up the log-in panel components.
    //  */
    // private void setUpLogInComps()
    // {
    //     lblLogIn = new JCustomLabel("Log in",
    //         ColorCons.W, TxtSizeCons.L, 0.5f, 0.0f, 0, 0, TxtSizeCons.M, 0);

    //     lblErrorMessage = new JCustomLabel("",
    //         ColorCons.R, TxtSizeCons.XS, 0.5f, 0.0f, 0, 0, TxtSizeCons.S, 0);
        
    //     txtGuestName = new JCustomTextField("Guest Name",
    //         ColorCons.W, ColorCons.BA, 0.2813 * WinSizeCons.W,  0.0694 *
    //         WinSizeCons.H, TxtSizeCons.M, 0.5f, 0.0f, 0, 0, TxtSizeCons.S, 0);

    //     txtPassword = new JCustomTextField("Password",
    //         ColorCons.W, ColorCons.BA, 0.2813 * WinSizeCons.W,  0.0694 *
    //         WinSizeCons.H, TxtSizeCons.M, 0.5f, 0.0f, 0, 0, TxtSizeCons.S, 0);

    //     btnLogIn = new JCustomButton("Log in", ColorCons.W, ColorCons.BA,
    //         BtnSizeCons.M, TxtSizeCons.M, 0.5f, 0.0f, 0, 0, TxtSizeCons.L, 0);
        
    //     lblSignUp = new JCustomLabel("No account? Sign up.",
    //         ColorCons.BU, TxtSizeCons.S, 0.5f, 0.0f, 0, 0, TxtSizeCons.L * 2, 0);

    //     lblAdminLogIn = new JCustomLabel("Log in as administrator",
    //         ColorCons.BU, TxtSizeCons.S, 0.5f, 0.0f, 0, 0, 0, 0);
    // }
}
