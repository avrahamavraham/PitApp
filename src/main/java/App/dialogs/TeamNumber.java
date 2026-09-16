package App.dialogs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * TeamNumber
 * 
 * 
 */
public class TeamNumber {
    private TeamNumber(){}
    private static final JDialog dialog = new JDialog();
    private static final JTextField text = new JTextField();
    private static final JLabel label = new JLabel("Enter team number");
    private static final JButton sendNumber = new JButton("OK");
    public static int getTeamNumber(){
        dialog.setName("Enter team  number");
        dialog.setLocationRelativeTo(null);
        dialog.setSize(400,200);
        dialog.setLayout(null);
        dialog.setAlwaysOnTop(true);
        dialog.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        text.setBounds(200, 20, 100, 50);
        label.setBounds(50,20,140,40);
        dialog.add(label);
        dialog.add(text);
        sendNumber.setBounds(200,120,60,30);
        sendNumber.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
            
        });
        dialog.add(sendNumber);
        dialog.setVisible(true);
        String teamNumber = text.getText();
        if (teamNumber.equals("")) {
            teamNumber = "1";
        }
        return Integer.parseInt(teamNumber);
    }
}
