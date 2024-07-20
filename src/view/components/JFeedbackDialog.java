package view.components;

import java.awt.*;
import javax.swing.*;

public class JFeedbackDialog  extends JDialog{

    private JLabel lblfeedback;
    private JButton btnOK;
    private JPanel pnlDesign;

    public JFeedbackDialog(JFrame frame){
        this.setTitle("Feedback");
//        this.setModal(true);

        this.setBackground(Color.YELLOW);

        this.lblfeedback = new JLabel();
        this.btnOK = new JButton("OK");
        this.pnlDesign = new JPanel();

        this.pnlDesign.setLayout(new FlowLayout());
        this.pnlDesign.add(btnOK);

        this.setLayout(new BorderLayout());

        this.lblfeedback.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(lblfeedback, BorderLayout.NORTH);
        this.add(pnlDesign, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }

    public void setLblfeedback(String feedbackText){
        this.lblfeedback.setText("Feedback: " + feedbackText);
        this.pack();
    }


}
