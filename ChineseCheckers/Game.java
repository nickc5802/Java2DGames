package ChineseCheckers;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Game extends JPanel {
    Piece[][] board;
    int teams;
    Point mouseBoardLoc;

    public Game(int teams) {
        super();
        this.teams = teams;
        board = new Piece[17][1];
        for (int i = 0; i < 4; i++) {
            board[i] = new Piece[i+1];
            board[17-i-1] = new Piece[i+1];
        }
        for (int i = 4; i < 8; i++) {
            board[i] = new Piece[13-(i-4)];
            board[12-(i-4)] = new Piece[13-(i-4)];
        }
        board[8] = new Piece[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = null;
            }
        }
        setUpPlayers(teams);
        repaint();
    }

    private void setUpPlayers(int numPlayers) {
        if (numPlayers == 2) {
            for (int i =0; i < 4; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = new Piece(1);
                    board[16-i][j] = new Piece(1);
                }
            }
        } else if (numPlayers == 3) {
            for (int i =0; i < 4; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = new Piece(1);
                }
            }
            for (int i = 9; i < 13; i++) {
                for (int j = 12-i; j < 4; j++) {
                    board[i][4-j-1] = new Piece(1);
                    board[i][board[i].length-(4-j)] = new Piece(1);
                }
            }
        } else if (numPlayers == 4) {
            for (int i = 9; i < 13; i++) {
                for (int j = 12-i; j < 4; j++) {
                    board[i][4-j-1] = new Piece(1);
                    board[i][board[i].length-(4-j)] = new Piece(1);
                }
            }
            for (int i = 4; i < 8; i++) {
                for (int j = 0; j < 8-i; j++) {
                    board[i][j] = new Piece(1);
                    board[i][board[i].length-j-1] = new Piece(1);
                }
            }
        } else if (numPlayers == 6) {
            for (int i =0; i < 4; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = new Piece(1);
                    board[16-i][j] = new Piece(1);
                }
            }
            for (int i = 9; i < 13; i++) {
                for (int j = 12-i; j < 4; j++) {
                    board[i][4-j-1] = new Piece(1);
                    board[i][board[i].length-(4-j)] = new Piece(1);
                }
            }
            for (int i = 4; i < 8; i++) {
                for (int j = 0; j < 8-i; j++) {
                    board[i][j] = new Piece(1);
                    board[i][board[i].length-j-1] = new Piece(1);
                }
            }
        }
    }


    public void update() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBoard(g);
        boardSpots(g);
        mouseDetection(g);
    }

    private void drawBoard(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
        //hexagon
        g.setColor(Color.GRAY);
        Polygon polygon = new Polygon();
        for (int i = 0; i < 6; i++) {
            int xval = (int) (250 + 130 * Math.cos(i * Math.PI/3));
            int yval = (int) (250 - 130 * Math.sin(i * Math.PI/3));
            polygon.addPoint(xval, yval);
        }
        g.fillPolygon(polygon);
        //points of star
        Color[] colors = new Color[] {
                Color.RED, Color.BLUE, Color.CYAN, Color.YELLOW, Color.PINK, Color.GREEN
            };
        Polygon tri;
        for (int i = 0; i < 6; i++) {
            g.setColor(colors[i]);
            tri = new Polygon();
            tri.addPoint(250 + (int)(260*Math.sin(Math.PI/3)*(Math.cos(Math.PI/3 * i + Math.PI/6))), 250 - (int)(260*Math.sin(Math.PI/3)*(Math.sin(Math.PI/3 * i + Math.PI/6))));
            tri.addPoint(polygon.xpoints[i], polygon.ypoints[i]);
            if (i == 5) {
                tri.addPoint(polygon.xpoints[0], polygon.ypoints[0]);
            } else {
                tri.addPoint(polygon.xpoints[i+1], polygon.ypoints[i+1]);
            }
            g.fillPolygon(tri);
        }
    }

    private void boardSpots(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    g.setColor(Color.BLACK);
                }
                if (board[i].length%2==1) {
                    g.fillOval(250 + (j-(board[i].length-1)/2)*28-8, 250-216+8+(int)(24.9*i), 16, 16);
                } else {
                    g.fillOval(250 + (j-(board[i].length-1)/2)*28-8-14, 250-216+8+(int)(24.9*i), 16, 16);
                }
                g.setColor(Color.LIGHT_GRAY);
            }
        }
    }

    private void mouseDetection(Graphics g) {
        Point loc = MouseInfo.getPointerInfo().getLocation();
        Point screen = getLocationOnScreen();
        Point mouse = new Point((int)(loc.getX()-screen.getX()), (int)(loc.getY()-screen.getY()));
        boolean mouseSet = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Rectangle r = new Rectangle();
                if (board[i].length%2==1) {
                    r.setBounds(250 + (j-(board[i].length-1)/2)*28-8, 250-216+8+(int)(24.9*i), 16, 16);
                } else {
                    r.setBounds(250 + (j-(board[i].length-1)/2)*28-8-14, 250-216+8+(int)(24.9*i), 16, 16);
                }
                if (r.contains(mouse)) {
                    g.setColor(Color.ORANGE);
                    g.drawOval((int)r.getX() - 2, (int)r.getY()- 2, (int)r.getWidth() + 4, (int)r.getHeight() + 4);
                    mouseBoardLoc = new Point(i, j);
                    mouseSet = true;
                }
            }
        }
        if (!mouseSet) {
            mouseBoardLoc = null;
        }
    }
}