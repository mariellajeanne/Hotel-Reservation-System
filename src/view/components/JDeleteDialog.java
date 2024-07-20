package view.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDeleteDialog extends JPanel {

    // VARIABLES
    private JButton btnDelete;
    private JDialog dlgDelete;
    private JLabel lblQuestion;
    private JPanel pnlChoice;
    private JButton btnYes;
    private JButton btnNo;

    // CONSTRUCTOR
    public JDeleteDialog(JFrame frame) {

        this.setBackground(Color.YELLOW);

        // Initialize components
        this.btnDelete = new JButton("Delete");
        this.dlgDelete = new JDialog(frame, "Delete", true);
        this.pnlChoice = new JPanel(null);
        this.lblQuestion = new JLabel("Would you like to Delete?");
        this.btnYes = new JButton("Yes");
        this.btnNo = new JButton("No");

        // Add the button to the panel
        this.btnDelete.setSize(btnDelete.getPreferredSize());
        this.add(btnDelete);

        this.setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height, this.getPreferredSize().width, this.getPreferredSize().height);

        //Set layout for the dialog and panel
        this.dlgDelete.setLayout(new GridLayout());
        this.pnlChoice.setLayout(new FlowLayout());

        // Add components to the dialog panel
        this.pnlChoice.add(lblQuestion);
        this.pnlChoice.add(btnYes);
        this.pnlChoice.add(btnNo);
        this.dlgDelete.add(pnlChoice);

        //Set dialog size and center it relative to the parent frame
        this.dlgDelete.pack();
        this.dlgDelete.setLocationRelativeTo(frame);

        // Hide certain components initially
        this.dlgDelete.setVisible(false);

        // Add action listener to the delete button
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDlgDeleteVisibility(true);
            }
        });

        // Add action listeners for Yes and No buttons
        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the deletion logic here
                System.out.println("Deleted!");
                setDlgDeleteVisibility(false);
            }
        });

        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDlgDeleteVisibility(false);
            }
        });
    }

    // SET VISIBILITY
    public void setDlgDeleteVisibility(boolean tf) {
        this.dlgDelete.setVisible(tf);
    }
}