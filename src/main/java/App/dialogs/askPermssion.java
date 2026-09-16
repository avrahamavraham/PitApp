package App.dialogs;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class askPermssion {
    private final JDialog dialog;
    private final JLabel label = new JLabel();
    private final JButton ok = new JButton("OK");
    private final JButton canecl = new JButton("canecl");
    private final int width = 250;
    private final int height = 150;
    public askPermssion(JFrame frame,String askWhat,Runnable runnable) {
        dialog = new JDialog(frame, askWhat,true);
        dialog.setLocationRelativeTo(null);
        dialog.setSize(width,height);
        dialog.getContentPane().setBackground(Color.BLACK);
        dialog.setLayout(null);
        dialog.setAlwaysOnTop(true);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        label.setText(askWhat);
        label.setBounds(10, 10, 215, 40);
        label.setForeground(Color.white);
        label.setFont(label.getFont().deriveFont(20f));
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        dialog.add(label);
        ok.setActionCommand("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runnable.run();
                dialog.setVisible(false);
                System.out.println("OK");
            }
 
        });
        ok.setBounds(30, 70, 80, 30);
        dialog.add(ok);
        canecl.setActionCommand("cancel");
        canecl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                System.out.println("canecl");
            }});
        canecl.setBounds(120, 70, 80, 30);
        dialog.add(canecl);
    }

    public void show(){
        dialog.setVisible(true);
    }
    
}
