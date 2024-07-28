/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * The panel of each page.
 */

package view.utils;

import constants.ColorCons;
import constants.WinSizeCons;
import java.awt.*;
import javax.swing.*;

/**
 * The page panel class.
 */
public class JPagePanel extends JPanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the page panel.
     */
    public JPagePanel()
    {
        super();

        Dimension d = new Dimension(WinSizeCons.W, WinSizeCons.H);
        
        this.setPreferredSize(d);
        this.setBackground(ColorCons.BA);
        // this.setLayout(new BorderLayout());
    }
}
