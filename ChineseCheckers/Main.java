package ChineseCheckers;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Main {
    static Game game;
    static JFrame frame;
    static JPanel menu;
    public static void main() {
        frame = new JFrame("Chinese Checkers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu = new JPanel();
        menu.setPreferredSize(new Dimension(500, 500));
        menu.setLayout(null);
        frame.getContentPane().add(menu);
        frame.pack();
        JLabel label = new JLabel("Enter number of players");
        JTextField text = new JTextField();
        JButton button = new JButton("Play!");
        menu.add(label);
        menu.add(text);
        menu.add(button);
        label.setBounds(200, 150, 200, 50);
        text.setBounds(220, 200, 80, 30);
        button.setBounds(220, 250, 80, 50);
        Game game;
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    try {
                        int num = Integer.valueOf(text.getText());
                        if (num >= 2 && num <= 6) {
                            start(num);
                        } else {
                            System.out.println("Invalid input");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
    }

    static void start(int numPlayers) {
        game = new Game(numPlayers);
        frame.getContentPane().remove(menu);
        frame.getContentPane().add(game);
        frame.revalidate();
    }
}
