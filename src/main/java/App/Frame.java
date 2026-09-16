package App;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import App.dialogs.askPermssion;
import App.utils.defualtInterface;

public class Frame {
    private Frame(){}
    private final static List<defualtInterface> list= new ArrayList<>();
    private final static  JFrame frame = new JFrame("Pit app");
    private static boolean init = false;
    public static JFrame getFrame(){
        if(!init){
            init();
        }
        return frame;
    }
    private static void init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setVisible(true);
        askPermssion souldClose = new askPermssion(frame,"are you sure ?", ()-> System.exit(0));
    }
    public static void reset(){
        list.forEach((value)-> value.reset());
    }
    public static void add(defualtInterface toAdd){
        list.add(toAdd);
    }
    public static void addTOFrame(){
        list.forEach((value)-> value.addToFrame());
    }
    
}
