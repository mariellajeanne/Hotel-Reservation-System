/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Creates a panel with the application title and authors.
 */

package view.utils;

import constants.ColorCons;
import constants.SpaceSizeCons;
import constants.TxtSizeCons;
import constants.WinSizeCons;
import java.awt.*;
import javax.swing.*;

/**
 * The title panel class.
 */
public class JTitlePanel extends JPanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private static JTitlePanel tlp; // The single instance of the class.

    private final Dimension fixedSize = new Dimension((int) (WinSizeCons.W / 2), WinSizeCons.H);

    // The Components.

    private JPanel pnlTitle;
    private JCustomLabel pnlTitle;
    private JCustomLabel lblAuthor1;
    private JCustomLabel lblAuthor2;

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the title panel.
     */
    private JTitlePanel()
    {
        super();

        // Grid bag constraints.
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        // Configuration of the title panel.
        pnlTitle = new JPanel();
        pnlTitle.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        pnlTitle.setBackground(ColorCons.BA);

            pnlTitle = new JCustomLabel("HotelHub",
                ColorCons.W, TxtSizeCons.XL, 0, 0, SpaceSizeCons.XL, 0);
            lblAuthor1 = new JCustomLabel("Stephen M. Borja",
                ColorCons.W, TxtSizeCons.M, 0, 0, SpaceSizeCons.S, 0);
            lblAuthor2 = new JCustomLabel("Mariella Jeanne A. Dellosa",
                ColorCons.W, TxtSizeCons.M, 0, 0, 0, 0);
            
            pnlTitle.add(pnlTitle);
            pnlTitle.add(lblAuthor1);
            pnlTitle.add(lblAuthor2);
        
        // Configuration of the main panel.
        this.setPreferredSize(fixedSize);
        this.setMinimumSize(fixedSize);
        this.setMaximumSize(fixedSize);
        this.setLayout(new FlowLayout());
        this.setBackground(ColorCons.BA);

        this.add(pnlTitle, gbc);
    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the instance of the title panel.
     * 
     * @return {JTitlePanel}
     */
    public static JTitlePanel getInstance()
    {
        if (tlp == null)
            tlp = new JTitlePanel();
        return tlp;
    }

    /* -------------------------------------------------------------------------- */
    /*                                   SET UP                                   */
    /* -------------------------------------------------------------------------- */

    // /**
    //  * Sets up the panel.
    //  */
    // private void setUpPnl()
    // {
    //     Dimension d = new Dimension((int) (WinSizeCons.W / 2), WinSizeCons.H);

    //     this.setPreferredSize(d);
    //     this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    // }

    // /**
    //  * Sets up the components.
    //  */
    // private void setUpComps()
    // {
    //     pnlTitle = new JCustomLabel("HotelHub",
    //         ColorCons.W, TxtSizeCons.XL, 0.5f, 0.0f, 0, 0, TxtSizeCons.XL, 0);
        
    //     lblAuthor1 = new JCustomLabel("Stephen M. Borja",
    //         ColorCons.W, TxtSizeCons.M, 0.5f, 0.0f, 0, 0, TxtSizeCons.S, 0);
        
    //     lblAuthor1 = new JCustomLabel("Mariella Jeanne A. Dellosa",
    //         ColorCons.W, TxtSizeCons.M, 0.5f, 0.0f, 0, 0, 0, 0);
    // }

    @Override
    public Dimension getPreferredSize() {
        return fixedSize;
    }

    @Override
    public Dimension getMinimumSize() {
        return fixedSize;
    }

    @Override
    public Dimension getMaximumSize() {
        return fixedSize;
    }
}