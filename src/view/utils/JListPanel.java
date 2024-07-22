package view.utils;

/**
 *
 * @auther Stephen M. Borja
 * @auther Mariella Jeanne A. Dellosa
 *
 * JListPanel is an abstract class that represents a panel containing a list of items.
 * It includes a search panel, a scrollable list panel, and individual item panels.
 * The list panel is populated with multiple item panels upon initialization.
 *
 */

import javax.swing.*;
import java.awt.*;

/**
 * JListPanel is an abstract class that extends JPanel.
 */
public abstract class JListPanel extends JPanel {
    protected JPanel pnlSearchPanel;
    protected JScrollPane scrList;
    protected JPanel pnlList;
    protected JItemPanel itpItem;

    /**
     * Constructs a JListPanel with the specified parent frame.
     *
     * @param frame the parent JFrame to which this panel belongs
     */
    protected JListPanel(JFrame frame) {
        this.pnlSearchPanel = new JPanel();
        this.scrList = new JScrollPane();
        this.pnlList = new JPanel(new GridLayout(0, 1));
        this.itpItem = new JItemPanel(frame);

        setLayout(new GridLayout(1, 1));

        scrList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        pnlList.add(itpItem);

        for (int i = 0; i < 10; i++) {
            pnlList.add(new JItemPanel(frame));
        }

        scrList.setViewportView(pnlList);

        add(scrList);

        setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height, getPreferredSize().width, 100);
        setVisible(true);
    }

    /**
     * Gets the search panel.
     *
     * @return the search panel
     */
    public JPanel getPnlSearchPanel() {
        return pnlSearchPanel;
    }

    /**
     * Sets the search panel.
     *
     * @param pnlSearchPanel the search panel to set
     */
    public void setPnlSearchPanel(JPanel pnlSearchPanel) {
        this.pnlSearchPanel = pnlSearchPanel;
    }

    /**
     * Gets the scroll pane for the list.
     *
     * @return the scroll pane
     */
    public JScrollPane getScrList() {
        return scrList;
    }

    /**
     * Sets the scroll pane for the list.
     *
     * @param scrList the scroll pane to set
     */
    public void setScrList(JScrollPane scrList) {
        this.scrList = scrList;
    }

    /**
     * Gets the panel containing the list of items.
     *
     * @return the list panel
     */
    public JPanel getPnlList() {
        return pnlList;
    }

    /**
     * Sets the panel containing the list of items.
     *
     * @param pnlList the list panel to set
     */
    public void setPnlList(JPanel pnlList) {
        this.pnlList = pnlList;
    }

    /**
     * Gets the item panel.
     *
     * @return the item panel
     */
    public JItemPanel getItpItem() {
        return itpItem;
    }

    /**
     * Sets the item panel.
     *
     * @param itpItem the item panel to set
     */
    public void setItpItem(JItemPanel itpItem) {
        this.itpItem = itpItem;
    }
}