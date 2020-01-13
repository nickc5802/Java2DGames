package Tetris;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel {
    Block[][] board;
    Block[] currPiece;
    public Panel() {
        setPreferredSize(new Dimension(300, 480));
        board = new Block[8][14];
        currPiece = Block.makePiece();
    }

    public void update() {
        if (currPiece == null) {
            currPiece = Block.makePiece();
        }
        for (int i = 0; i < currPiece.length; i++) {
            currPiece[i].setPosY(currPiece[i].getPosY() + 1);
        }
        lockPiece();
        repaint();
    }

    private void lockPiece() {
        for (Block curr : currPiece) {
            if (board[curr.getPosX()][curr.getPosY()+1] != null || curr.getPosY()+1 == 25) {
                for (Block block : currPiece) {
                    board[curr.getPosX()][curr.getPosY()] = block;
                }
                currPiece = null;
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 300, 480);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 30, 480);
        g.fillRect(270, 0, 30, 480);
        g.fillRect(0, 0, 300, 30);
        g.fillRect(0, 450, 300, 30);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null) {
                    g.setColor(board[i][j].getColor());
                    g.fillRect(30 + 30 * i, 30 + 30 * j, 30, 30);
                }
            }
        }
        if (currPiece != null) {
            for (int i = 0; i < currPiece.length; i++) {
                g.setColor(currPiece[i].getColor());
                g.fillRect(30 + 30 * currPiece[i].getPosX(), 30 + 30 * currPiece[i].getPosY(), 30, 30);
            }
        }
    }
}

