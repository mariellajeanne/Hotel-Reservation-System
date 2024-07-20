/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * Frame is a singleton class that creates a JFrame
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Frame class
 */
public class Frame {

    //VARIABLES
    private static Frame frame;

    private JLayeredPane lypPane;
    private JFrame frmFrame;
    private JPanel pnlPagePanel;
    private JButton btnBack;

    //CONSTRUCTOR
    /**
     * Private constructor to initialize the frame and its components.
     */
    private Frame() {
        frmFrame = new JFrame("HotelHub");
        frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmFrame.setSize(1920, 1080);

        btnBack = new JButton("Back");
        lypPane = new JLayeredPane();

        lypPane.setBounds(0, 0, 1920, 1080);

        // Initialize as starting page
        pnlPagePanel = new JPanel();
        pnlPagePanel.setBounds(0, 0, 1920, 1080);

        btnBack.setBounds(10, 10, btnBack.getPreferredSize().width, btnBack.getPreferredSize().width);

        lypPane.add(btnBack, Integer.valueOf(1));
        lypPane.add(pnlPagePanel, Integer.valueOf(0));
        frmFrame.add(lypPane);
        frmFrame.setLayout(null);
        frmFrame.setVisible(true);
    }

    /**
     * Returns the singleton instance of the Frame class.
     *
     * @return the singleton instance of Frame
     */
    public static Frame getInstance() {
        if (Frame.frame == null) {
            Frame.frame = new Frame();
        }
        return frame;
    }

    /**
     * Returns the JFrame instance.
     *
     * @return the JFrame instance
     */
    public JFrame getFrmFrame() {
        return frmFrame;
    }

    /**
     * Sets the panel to a new panel. This method should be extended to include
     * logic to switch between different panels based on some input.
     */
    public void setPanel() {
        // For testing
        lypPane.remove(pnlPagePanel);
        pnlPagePanel = new JPanel(null);

        pnlPagePanel.setBounds(0, 0, 1920, 1080);
        pnlPagePanel.setBackground(Color.BLUE);
        lypPane.add(pnlPagePanel, Integer.valueOf(0));

//        lypPane.revalidate();
//        lypPane.repaint();
    }

    /**
     * Sets the visibility of the back button.
     *
     * @param visible True to make the back button visible, false to make it invisible.
     */
    public void setBackButtonVisible(boolean visible) {
        btnBack.setVisible(visible);
    }
}
