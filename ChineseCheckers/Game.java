package ChineseCheckers;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Game extends JPanel {
    Piece[][] board;
    int teams;

    public Game(int teams) {
        super();
        this.teams = teams;
        board = new Piece[17][];
        for (int i = 0; i < 4; i++) {
            board[i] = new Piece[i+1];
            board[17-i-1] = new Piece[i];
        }
        for (int i = 12; i > 8; i--) {
            board[13-i+4] = new Piece[i];
            board[i] = new Piece[i];
        }
        board[8] = new Piece[9];
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.GRAY);
        Polygon polygon = new Polygon();
        for (int i = 0; i < 6; i++) {
            int xval = (int) (250 + 125 * Math.cos(i * Math.PI/3));
            int yval = (int) (250 - 125 * Math.sin(i * Math.PI/3));
            polygon.addPoint(xval, yval);
        }
        g.fillPolygon(polygon);

        Color[] colors = new Color[] {
                Color.RED, Color.BLUE, Color.CYAN, Color.YELLOW, Color.PINK, Color.GREEN
            };
        Polygon tri;
        //(int)(250+250*Math.sin(Math.PI/3))
        for (int i = 0; i < 6; i++) {
            g.setColor(colors[i]);
            tri = new Polygon();
            tri.addPoint(250 + (int)(216.5*(Math.cos(Math.PI/3 * i + Math.PI/6))), 250 - (int)(216.5*(Math.sin(Math.PI/3 * i + Math.PI/6))));
            tri.addPoint(polygon.xpoints[i], polygon.ypoints[i]);
            if (i == 5) {
                tri.addPoint(polygon.xpoints[0], polygon.ypoints[0]);
            } else {
                tri.addPoint(polygon.xpoints[i+1], polygon.ypoints[i+1]);
            }
            g.fillPolygon(tri);
        }
    }
}