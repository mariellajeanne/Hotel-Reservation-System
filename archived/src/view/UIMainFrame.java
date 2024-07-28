/**   
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Consists of the main frame.
 */

package view;


import constants.ColorCons;
import javax.swing.*;
import view.pages.client.UIClientLogIn;
 
 /**  
  * The main frame class.
  */
 public class UIMainFrame extends JFrame
 {
     /* -------------------------------------------------------------------------- */
     /*                                 ATTRIBUTES                                 */
     /* -------------------------------------------------------------------------- */
     
 
     /* -------------------------------------------------------------------------- */
     /*                                 CONSTRUCTOR                                */
     /* -------------------------------------------------------------------------- */
 
     /**
      * Constructs the main frame.
      */
     public UIMainFrame()
     {        
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
         this.setExtendedState(JFrame.MAXIMIZED_BOTH);
         this.setBackground(ColorCons.BA);
         this.add(UIClientLogIn.getInstance());
         this.setVisible(true);
 
         // To remove:
         // panel.remove(panel)
         // panel.revalidate();
     }
 }
 