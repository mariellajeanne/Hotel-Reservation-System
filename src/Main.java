/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Contains the main function.
 */

import controller.page.SystemCO;
import view.frame.MainFrameUI;

/**
 * The main class.
 */
public class Main
{    
    /**
     * The main function.
     * 
     * @param args {String[]} The inputted arguments.
     */
    public static void main(String[] args) {
        
        MainFrameUI.getInstance();
        SystemCO.getInstance();
    }
}
