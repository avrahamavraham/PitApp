package App;

import App.Button.CheckButoons;
import App.Button.CommandCheck;
import App.dialogs.TeamNumber;
import edu.wpi.first.networktables.NetworkTableInstance;

public class App {
    public static void main(String[] args) {
        var nt = NetworkTableInstance.getDefault();
        nt.startClient4("PitApp");
        int teamNumber = TeamNumber.getTeamNumber();
        nt.setServer(new String[]{"10." + teamNumber / 100 + "." + teamNumber % 100 + ".2",
            "roboRIO-" + teamNumber + "-frc.local","localhost"});
        System.out.println(teamNumber);
        CommandCheck commandCheck = new CommandCheck();
        CheckButoons checkButoons = new CheckButoons();
        Frame.add(checkButoons);
        Frame.add(commandCheck);
        Frame.addTOFrame();
    }
}
