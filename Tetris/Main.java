package Tetris;

import javax.swing.*;
import java.util.*;

public class Main {
    public static void main() {
        JFrame frame = new JFrame();
        Panel p = new Panel();
        frame.add(p);
        frame.pack();
        frame.setVisible(true);
        TimerTask task = new TimerTask() {
            public void run() {
                p.update();
            }
        };
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 0, 250);
    }
}

