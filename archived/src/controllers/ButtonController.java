/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles button hovering and pressing.
 */
package controllers;

import constants.ColorCons;
import javax.swing.*;

/**
 * The button controller class.
 */
public class ButtonController
{
    /* -------------------------------------------------------------------------- */
    /*                                 ATTRIBUTES                                 */
    /* -------------------------------------------------------------------------- */

    private JButton b;    // The button to be handled.
    private ColorCons color; // The current color of the button.

    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

    /**
     * Constructs the button controller class.
     */
    public ButtonController(JButton b, ColorCons color)
    {
        this.b = b;
        this.color = color;

        addEventListeners();
    }

    /* -------------------------------------------------------------------------- */
    /*                               EVENT HANDLERS                               */
    /* -------------------------------------------------------------------------- */

    /**
     * Adds event listeners to the button.
     */
    private void addEventListeners()
    {
        // this.b.addMouseListener(this);
        // this.b.addMouseMotionListener(this);
    }

    // /**
    //  * Changes the button's color when pressed.
    //  * 
    //  * @param e {MouseEvent} The mouse event.
    //  */
    // @Override
    // public void mousePressed(MouseEvent e)
    // {
        
    // }

    // /**
    //  * Changes the button's color when released.
    //  * 
    //  * @param e {MouseEvent} The mouse event.
    //  */
    // @Override
    // public void mouseReleased(MouseEvent e)
    // {

    // }

    // /**
    //  * Changes the cursor when the button has been hovered on.
    //  * 
    //  * @param e {MouseEvent} The mouse event.
    //  */
    // @Override
    // public void mouseEntered(MouseEvent e)
    // {

    // }

    // /**
    //  * Changes the cursor when the button has been exited.
    //  * 
    //  * @param e {MouseEvent} The mouse event.
    //  */
    // @Override
    // public void mouseExited(MouseEvent e)
    // {

    // }

    // /**
    //  * Unused event handler required by MouseMotionListener.
    //  * 
    //  * @param e {MouseEvent} The mouse event.
    //  */
    // @Override
    // public void mouseClicked(MouseEvent e)
    // {

    // }

    // /**
    //  * Unused event handler required by MouseMotionListener.
    //  * 
    //  * @param e {MouseEvent} The mouse event.
    //  */
    // @Override
    // public void mouseDragged(MouseEvent e)
    // {

    // }

    // /**
    //  * Unused event handler required by MouseMotionListener.
    //  * 
    //  * @param e {MouseEvent} The mouse event.
    //  */
    // @Override
    // public void mouseMoved(MouseEvent e)
    // {

    // }
}
