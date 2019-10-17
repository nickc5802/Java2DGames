package Tetris;

import java.awt.*;

public class Block {
    Color color;
    int posX;
    int posY;
    
    public Block(Color c, int x, int y) {
        posX = x;
        posY = y;
        color = c;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    
    public void setPosX(int x) {
        posX = x;
    }
    public void setPosY(int y) {
        posY = y;
    }
    
    public static Block[] makePiece() {
        int rand = (int)(Math.random() * 7);
        if (rand == 0) {
            return square();
        } else if (rand == 1) {
            return line();
        } else if (rand == 2) {
            return lLeft();
        } else if (rand == 3) {
            return lRight();
        } else if (rand == 4) {
            return sLeft();
        } else if (rand == 5) {
            return sRight();
        } else {
            return t();
        }
    }
    
    private static Block[] square() {
        return new Block[] {
            new Block(Color.RED, 0, 0),
            new Block(Color.RED, 0, 1),
            new Block(Color.RED, 1, 0),
            new Block(Color.RED, 1, 1)
        };
    }
    private static Block[] line() {
        return new Block[] {
            new Block(Color.CYAN, 0, 0),
            new Block(Color.CYAN, 0, 1),
            new Block(Color.CYAN, 0, 2),
            new Block(Color.CYAN, 0, 3)
        };
    }
    private static Block[] lRight() {
        return new Block[] {
            new Block(Color.GREEN, 0, 0),
            new Block(Color.GREEN, 0, 1),
            new Block(Color.GREEN, 0, 2),
            new Block(Color.GREEN, 1, 2)
        };
    }
    private static Block[] lLeft() {
        return new Block[] {
            new Block(Color.YELLOW, 1, 0),
            new Block(Color.YELLOW, 1, 1),
            new Block(Color.YELLOW, 1, 2),
            new Block(Color.YELLOW, 0, 2)
        };
    }
    private static Block[] sRight() {
        return new Block[] {
            new Block(Color.ORANGE, 0, 0),
            new Block(Color.ORANGE, 1, 0),
            new Block(Color.ORANGE, 1, 1),
            new Block(Color.ORANGE, 2, 1)
        };
    }
    private static Block[] sLeft() {
        return new Block[] {
            new Block(Color.BLUE, 0, 1),
            new Block(Color.BLUE, 1, 1),
            new Block(Color.BLUE, 1, 0),
            new Block(Color.BLUE, 2, 0)
        };
    }
    private static Block[] t() {
        return new Block[] {
            new Block(Color.PINK, 0, 0),
            new Block(Color.PINK, 1, 1),
            new Block(Color.PINK, 1, 0),
            new Block(Color.PINK, 2, 0)
        };
    }
}
