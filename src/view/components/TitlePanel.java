package view.components;

import java.awt.*;
import javax.swing.*;

public class TitlePanel{

    private static TitlePanel titlePanel;

    private static JPanel pnlTitlePanel;
    private static JPanel pnlAuthorPanel;
    private static JLabel appName;
    private static JLabel author1;
    private static JLabel author2;


    private TitlePanel(){
        pnlTitlePanel = new JPanel();
        pnlAuthorPanel = new JPanel(new GridLayout (2, 1, 0, 0));
        appName = new JLabel("HotelHub");
        author1 = new JLabel("Stephen M. Borja");
        author2 = new JLabel("Mariella Jeanne A. Dellosa");

        author1.setFont(new Font("OpenSans", Font.PLAIN, 20));
        author2.setFont(new Font("OpenSans", Font.PLAIN, 20));
        appName.setFont(new Font("OpenSans", Font.BOLD, 70));


        pnlAuthorPanel.add(author1);
        pnlAuthorPanel.add(author2);
        author1.setBounds(0, 0, pnlAuthorPanel.getPreferredSize().width, pnlAuthorPanel.getPreferredSize().height);
        author2.setBounds(0, 0, pnlAuthorPanel.getPreferredSize().width, pnlAuthorPanel.getPreferredSize().height);
        pnlAuthorPanel.setBounds(0, 0, pnlAuthorPanel.getPreferredSize().width, pnlAuthorPanel.getPreferredSize().height);

        pnlTitlePanel.setLayout(new GridLayout(10,1));
        for(int i = 0; i < 5; i++){
            JPanel hold = new JPanel();
            hold.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pnlTitlePanel.add(hold);
        }
        pnlTitlePanel.add(appName);
        pnlTitlePanel.add(new JPanel());
        pnlTitlePanel.add(pnlAuthorPanel);
        for(int i = 0; i < 5; i++){
            JPanel hold = new JPanel();
            hold.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pnlTitlePanel.add(hold);
        }
        pnlTitlePanel.setBounds(1980 / 2 - pnlTitlePanel.getPreferredSize().width, 0, pnlTitlePanel.getPreferredSize().width, 1080);
    }

    public static TitlePanel getInstance(){
        if(TitlePanel.titlePanel == null)
            TitlePanel.titlePanel = new TitlePanel();
        return titlePanel;
    }

    public JPanel getPnlTitlePanel() {
        return pnlTitlePanel;
    }
}
