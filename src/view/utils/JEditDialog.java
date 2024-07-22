package view.utils;

/**
 *
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 *
 * JEditDialog is an abstract class that creates and manage a dialog for editing properties.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JEditDialog an abstract class that extends JPanel
 */
public abstract class JEditDialog extends JPanel{

    protected JLabel lblProperty;
    protected JButton btnEdit;
    protected JDialog dlgEdit;
    protected JPanel pnlEdit;
    protected JTextField txtError;
    protected JPanel pnlChoices;
    protected JButton btnSave;
    protected JButton btnCancel;


    /**
     * Constructs a JEditDialog with the specified parent frame.
     *
     * @param frame the parent JFrame to which this dialog belongs
     */
    protected JEditDialog(JFrame frame){
        this.setBackground(Color.YELLOW);
        this.setLayout(new GridLayout(2, 1));

        this.lblProperty = new JLabel("Property");
        this.btnEdit = new JButton("Edit");
        this.dlgEdit = new JDialog(frame, "Editing");
        this.pnlEdit = new JPanel(new GridLayout(2, 1));
        this.txtError = new JTextField("");
        this.pnlChoices = new JPanel(new FlowLayout());
        this.btnSave = new JButton("Save");
        this.btnCancel = new JButton("Cancel");

        lblProperty.setHorizontalAlignment(SwingConstants.CENTER);
        btnEdit.setHorizontalAlignment(SwingConstants.CENTER);

        add(lblProperty);
        add(btnEdit);
        setBounds(1980 / 2 - this.getPreferredSize().width, 1080 / 2 - this.getPreferredSize().height, this.getPreferredSize().width, this.getPreferredSize().height);

        pnlChoices.add(btnSave);
        pnlChoices.add(btnCancel);

        pnlEdit.add(txtError);
        pnlEdit.add(pnlChoices);

        dlgEdit.add(pnlEdit);

        dlgEdit.pack();
        dlgEdit.setLocationRelativeTo(frame);

        dlgEdit.setVisible(false);

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDlgEditVisibility(true);
            }
        });

        btnCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                disposeDlgEdit();
            }
        });


    }

    /**
     * Sets the visibility of the edit dialog.
     *
     * @param visible true to make the dialog visible, false to hide it
     */
    protected void setDlgEditVisibility(boolean visible) {
        dlgEdit.setVisible(visible);
    }

    /**
     * Disposes of the edit dialog, effectively closing it.
     */
    protected void disposeDlgEdit(){
        dlgEdit.dispose();
    }
}
