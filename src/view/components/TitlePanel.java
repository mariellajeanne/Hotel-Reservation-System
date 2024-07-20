/**
 *
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * JTitlePanel is a singleton class that creates a title panel with application name and author information.
 */

import javax.swing.*;
import java.awt.*;

/**
 * TitlePanel class
 */
public class TitlePanel {


    //VARIABLES
    private static TitlePanel titlePanel;

    private JPanel pnlTitlePanel;
    private JPanel pnlAuthorPanel;
    private JLabel appName;
    private JLabel author1;
    private JLabel author2;

    /**
     * Private constructor to prevent instantiation.
     * Initializes the components and sets up the layout.
     */
    private TitlePanel() {
        pnlTitlePanel = new JPanel();
        pnlAuthorPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        appName = new JLabel("HotelHub");
        author1 = new JLabel("Stephen M. Borja");
        author2 = new JLabel("Mariella Jeanne A. Dellosa");

        // Set fonts for labels
        author1.setFont(new Font("OpenSans", Font.PLAIN, 20));
        author2.setFont(new Font("OpenSans", Font.PLAIN, 20));
        appName.setFont(new Font("OpenSans", Font.BOLD, 70));

        // Add authors to the author panel
        pnlAuthorPanel.add(author1);
        pnlAuthorPanel.add(author2);

        // Layout and bounds for the main title panel
        pnlTitlePanel.setLayout(new GridLayout(10, 1));
        for (int i = 0; i < 5; i++) {
            JPanel hold = new JPanel();
            pnlTitlePanel.add(hold);
        }
        pnlTitlePanel.add(appName);
        pnlTitlePanel.add(new JPanel());
        pnlTitlePanel.add(pnlAuthorPanel);
        for (int i = 0; i < 5; i++) {
            JPanel hold = new JPanel();
            pnlTitlePanel.add(hold);
        }
        pnlTitlePanel.setBounds(1980 / 2 - pnlTitlePanel.getPreferredSize().width, 0, pnlTitlePanel.getPreferredSize().width, 1080);
    }

    /**
     * Provides access to the single instance of the TitlePanel class.
     *
     * @return the single instance of TitlePanel
     */
    public static TitlePanel getInstance() {
        if (TitlePanel.titlePanel == null) {
            TitlePanel.titlePanel = new TitlePanel();
        }
        return titlePanel;
    }

    /**
     * Returns the JPanel containing the title panel components.
     *
     * @return the title panel JPanel
     */
    public JPanel getPnlTitlePanel() {
        return pnlTitlePanel;
    }

}