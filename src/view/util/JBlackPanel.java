/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Creates a black panel that serves as backgrounds.
 */

package view.util;

import java.awt.*;
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
         * Constructs the back button.
         */
        public JBlackPanel()
        {
            setBounds(0, 0, 1920, 1080);
            setBackground(Color.decode("#26282e"));
            setLayout(null);
            setVisible(true);
        }

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

        /**
         * Adds components to the component hashmap.
         */
        protected abstract void addCompsToHashMap();
}
