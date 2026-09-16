package App.Button;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import App.Frame;
import App.utils.defualtInterface;

public class CheckButoons implements defualtInterface {
    private final JButton newBatrry = new JButton("is new battry installed?");
    private final JButton isAlltestPass = new JButton("is all test pass?");
    private final JButton isRIOandRadioCheck = new JButton("is radio and RIO connected properly?");
    private final JButton isAllSpicelRobotCurrect = new JButton("is all spicel robotc urrect (eg tape to open kick bar)");
    public CheckButoons(){
        newBatrry.setBounds(0, 570, 200, 80);
        setButtonConfig(newBatrry);
        isAlltestPass.setBounds(200, 570, 200, 80);
        setButtonConfig(isAlltestPass);
    }
    private void setButtonConfig(JButton button){
        button.setBackground(Color.red);
        button.addActionListener((ActionEvent e) -> {
            JButton button1 = (JButton)e.getSource();
            if (button1.getBackground().getRGB() == Color.green.getRGB()) {
                button1.setBackground(Color.red);
            } else {
                button1.setBackground(Color.green);
            } 
        });
    }

    @Override
    public void addToFrame() {
        Frame.getFrame().add(newBatrry);
        Frame.getFrame().add(isAlltestPass);
        Frame.getFrame().add(isRIOandRadioCheck);
        Frame.getFrame().add(isAllSpicelRobotCurrect);
    }

    @Override
    public void reset() {
        newBatrry.setBackground(Color.red);
        isAlltestPass.setBackground(Color.red);
        isRIOandRadioCheck.setBackground(Color.red);
        isAllSpicelRobotCurrect.setBackground(Color.red);
    }

    @Override
    public void hide() {
        newBatrry.setVisible(false);
        isAlltestPass.setVisible(false);
        isRIOandRadioCheck.setVisible(false);
        isAllSpicelRobotCurrect.setVisible(false);
    }
}

