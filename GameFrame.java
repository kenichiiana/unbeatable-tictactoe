import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	
	private static final int ROWS = 3;
	private static final int COLS = 3;
	private static int currPlayer = -1;
	private static int prevPlayer = -1;
	private static int[][] status = new int[ROWS][COLS];
	private Container c;
	private static int count = 2;
	public static int moves_left=9;
	
	public GameFrame() {
		super("Tic Tac Grace Poe");
		setComponents();
	}
	
	public void setComponents() {
		this.setPreferredSize(new Dimension(300,300));
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		c = this.getContentPane();
		c.setLayout(new GridLayout(ROWS,COLS));
		
		for(int i = 0; i<ROWS; i++) {
			for(int j = 0; j<COLS; j++) {
				Button lob = new Button(j,i);
				c.add(lob);
			}
		}
		
		for(int i = 0; i<ROWS; i++) {
			for(int j = 0; j<COLS; j++) {
				status[i][j] = 99;
			}
		}
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void print() {
		for(int i = 0; i<ROWS; i++) {
			for(int j = 0; j<ROWS; j++) {
				System.out.print(status[i][j]+" ");
			}	
			System.out.println("");
		}
	}
	
	public static int[][] getStatus() {
		return status;
	}
	
	public static int getCurrPlayer() {
		return currPlayer;
	}
	
	public static int getPrevPlayer() {
		return prevPlayer;
	}

	public static void setCurrPlayer() {
		prevPlayer = currPlayer;
		if(currPlayer == 1) currPlayer = -1;
		else {
			currPlayer = 1;
		}
		
	}
}
