/**   
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Manages pages.
 */

package managers;

import java.awt.Color;
import javax.swing.*;
import view.utils.JPagePanel;

/**  
 * The page manager class.
 */
public class PageManager
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */
    
    private static PageManager pageManager;     // The single instance of the page manager.
    private JFrame frmMain = new JFrame();      // The main frame.
    private JPagePanel pnlMain = new JPagePanel();  // The main panel.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the page manager.
     */
    public PageManager()
    {        
        pnlMain.setBackground(Color.BLACK);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frmMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmMain.add(pnlMain);
        frmMain.setVisible(true);

        // To remove:
        // panel.remove(panel)
        // panel.revalidate();
    }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

    /**
     * Returns the single instance of the page manager.
     */
    public static PageManager getInstance()
    {
        if (pageManager != null)
            pageManager = new PageManager();
        return PageManager.pageManager;
    }

    /**
     * 
     */



    
}
