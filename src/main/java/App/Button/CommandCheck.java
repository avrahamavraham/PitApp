package App.Button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.EnumSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import App.Frame;
import edu.wpi.first.networktables.BooleanEntry;
import edu.wpi.first.networktables.NetworkTableEvent;
import edu.wpi.first.networktables.NetworkTableInstance;

public class CommandCheck{
    private final JButton startCommand = new JButton("Start command for check");
    private final JButton stopCommand = new JButton("Stop check command");
    private final JLabel label = new JLabel();
    private final BooleanEntry commandEntry = 
        NetworkTableInstance.getDefault()
        .getBooleanTopic("/SmartDashboard/checkCommand/running").getEntry(false);
    public CommandCheck(){
        startCommand.setBounds(0, 0, 200, 80);
        startCommand.addActionListener((ActionEvent e) -> {
            commandEntry.accept(true);
        });
        stopCommand.setBounds(0, 80, 200, 80);
        stopCommand.addActionListener((ActionEvent e) -> {
            commandEntry.accept(false);
        });
        label.setBounds(0,160,200,80);
        label.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setText(commandEntry.get() ? "Running" : "Stopped");

        NetworkTableInstance.getDefault().addListener(
            commandEntry,
            EnumSet.of(NetworkTableEvent.Kind.kValueAll),
            event -> {
                boolean running = event.valueData.value.getBoolean();
                SwingUtilities.invokeLater(() -> {
                    label.setText(running ? "Running" : "Stopped");
                });
            }
        );
        Frame.getFrame().add("start cehck command",startCommand);
        Frame.getFrame().add("start cehck command",stopCommand);
        Frame.getFrame().add("is command active",label);
    }
}