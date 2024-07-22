/**   
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Manages pages.
 */

package managers;

import javax.swing.*;
import states.enums.PageEnum;

/**  
 * The page manager class.
 */
public class PageManager
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */
    
    private static PageManager pageManager;  // The single instance of the page manager.
    private PageEnum pageState;             // The page state.
    private JFrame frame = new JFrame();     // The main frame.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the page manager.
     */
    private PageManager()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
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
