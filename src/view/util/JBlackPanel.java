/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a black panel that serves as backgrounds.
 */

package view.util;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The black panel class.
 */
public abstract class JBlackPanel extends JPanel
{
    /* -------------------------------------------------------------------------- */
    /*                                 CONSTRUCTOR                                */
    /* -------------------------------------------------------------------------- */

        /**
         * Constructs the black panel.
         */
        public JBlackPanel()
        {
            int width = (int) (1920 * Scale.X);
            int height = (int) (1080 * Scale.Y);

            setBounds(0, 0, width, height);
            setBackground(Color.decode("#26282e"));
            setLayout(null);
            setVisible(true);
        }

    /* -------------------------------------------------------------------------- */
    /*                                   GETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Returns the input of a component.
         *
         * @param componentID   {String}    The component ID.
         * @return              {JComponent}
         */
        public abstract String getValue(String componentID);

    /* -------------------------------------------------------------------------- */
    /*                           COMPONENT CONFIGURATION                          */
    /* -------------------------------------------------------------------------- */
    
        /**
         * Initializes components.
         */
        protected abstract void initializeComps();

        /**
         * Configures components.
         */
        protected abstract void configureComps();

        /**
         * Adds components to the panel.
         */
        protected abstract void addCompsToPanel();

    /* -------------------------------------------------------------------------- */
    /*                                   SETTERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Sets the error message.
         * 
         * @param text {String} The error message.
         */
        public abstract void setErrorMessage(String text);

        /**
         * Sets the action listener of a component.
         * 
         * @param componentID   {String}            The component ID.
         * @param a             {ActionListener}    The action listener.
         */
        public abstract void setActionListener(String componentID, ActionListener a);

    /* -------------------------------------------------------------------------- */
    /*                                  UPDATERS                                  */
    /* -------------------------------------------------------------------------- */

        /**
         * Resets values of text fields.
         */
        public abstract void resetValues();

        /**
         * Updates the page's component values.
         */
        public abstract void updateValues();
}
