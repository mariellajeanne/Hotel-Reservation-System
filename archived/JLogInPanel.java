package view.utils;

/**
 *
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * JEditDialog is an abstract class that represents a login panel.
 */

import javax.swing.*;
import java.awt.*;

/**
 * JEditDialog an abstract class that extends JPanel
 */
public abstract class JLoginPanel extends JPanel{

    //VARIABLES
    private JPanel pnlLoginPanel;
    private TitlePanel titlePanel;
    protected JPanel pnlLoginDetails;
    protected JPanel pnlText;
    protected JPanel pnlClickables;

    /**
     * Constructor for JLoginPanel.
     * Initializes the login panel and title panel, sets layout and visibility.
     */
    protected JLoginPanel(){
        this.pnlLoginPanel = new JPanel(new GridLayout(3, 1));
        this.titlePanel = TitlePanel.getInstance();

        setLayout(new GridLayout(1,2));
        setBounds(0, 0, 1920, 1080);
        add(titlePanel.getPnlTitlePanel());
        setVisible(false);
    }

    /**
     * Sets the login details panel.
     * @param loginDetails the JPanel containing login details.
     */
    public void setPnlLoginDetails(JPanel loginDetails){
        if(pnlLoginDetails != null){
            pnlLoginPanel.remove(pnlLoginDetails);
        }
        this.pnlLoginDetails = loginDetails;
        pnlLoginPanel.add(pnlLoginDetails);
    }

    /**
     * Sets the text panel.
     * @param text the JPanel containing text.
     */
    public void setPnlText(JPanel text){
        if(pnlText != null){
            pnlLoginPanel.remove(pnlText);
        }
        this.pnlText = text;
        pnlLoginPanel.add(pnlText);
    }

    /**
     * Sets the clickables panel.
     * @param clickables the JPanel containing clickable components.
     */
    public void setPnlClickables(JPanel clickables){
        if(pnlClickables != null){
            pnlLoginPanel.remove(pnlClickables);
        }
        this.pnlClickables = clickables;
        pnlClickables.add(pnlClickables);
    }

    /**
     * Adds the login panel to the main panel.
     */
    public void addLoginPanel(){
        add(pnlLoginPanel);
    }

    /**
     * Sets the visibility of the panel.
     * @param visible the visibility state.
     */
    public void setVisiblity(boolean visible){
        setVisible(visible);
    }
}
