package App;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import App.dialogs.askPermssion;
import App.utils.defualtInterface;

public class Frame {
    private Frame(){}
    private final static List<defualtInterface> list= new ArrayList<>();
    private final static Map<Component,Rectangle> compSize = new HashMap<>();
    private final static Map<Component,Float> compFont = new HashMap<>();
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
        frame.setBounds(constants.OldFrameSize);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                double scaleX = (double) frame.getWidth() / constants.OldFrameSize.getWidth();
                double scaleY = (double) frame.getHeight() / constants.OldFrameSize.getHeight();
                double fontScale = (scaleX + scaleX ) / 2;
                for (Component comp : frame.getContentPane().getComponents()) {
                    Rectangle orig = compSize.get(comp);

                    int newX = (int) (orig.x * scaleX);
                    int newY = (int) (orig.y * scaleY);
                    int newWidth = (int) (orig.width * scaleX);
                    int newHeight = (int) (orig.height * scaleY);

                    comp.setBounds(newX, newY, newWidth, newHeight);
                    Float origSize = compFont.get(comp);
                    if (origSize != null) {
                        float newFontSize = (float) (origSize * fontScale);
                        comp.setFont(comp.getFont().deriveFont(newFontSize));
                    }
                }

                frame.revalidate();
                frame.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
            
        });
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
        for (Component comp : frame.getContentPane().getComponents()) {
            compSize.put(comp, comp.getBounds());
            compFont.put(comp, comp.getFont().getSize2D());
        }
        frame.revalidate();
        frame.repaint();
    }
    
}
