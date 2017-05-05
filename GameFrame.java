import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    // board dimensions
    private static final int ROWS = 3;
    private static final int COLS = 3;

    // keeps track of the current player
    private static int currPlayer = -1;
    // and the number of moves left for checking if DRAW
    private static int moves_left = 9;
    public static Container c;

    // game board
    private static int[][] status = new int[ROWS][COLS];

    // GameFrame constructor
    public GameFrame() {
        super("The Supposedly Unbeatable Tic Tac Toe");
        setComponents();
    }

    // JFrame configuration
    public void setComponents() {
        this.setPreferredSize(new Dimension(500,500));
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        c = this.getContentPane();
        // creates a grid of ROWS x COLS
        c.setLayout(new GridLayout(ROWS, COLS)); 
        setGrid();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);  
    }

    public static void setGrid() {
        c.removeAll();
        // add buttons to container
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                Button lob = new Button(j,i);
                c.add(lob);
            }
        }

        // set board initial state to 99
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                status[i][j] = 99;
            }
        }
    }

    public static void print() {
        // prints the current state of the board
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < ROWS; j ++) {
                System.out.print(status[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    // Getters
    public static int[][] getStatus() {
        return status;
    }

    public static int getMovesLeft() {
        return moves_left;
    }

    public static int getCurrPlayer() {
        return currPlayer;
    }

    // Setter
    public static void setCurrPlayer() {
        if(currPlayer == 1) currPlayer = -1;
        else {
            currPlayer = 1;
        }
    }

    public static void setMovesLeft() {
        moves_left--;
    }
}
