import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	
	private static final int ROWS = 3;
	private static final int COLS = 3;
	private static int currPlayer = 0;
	private Container c;
	
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
				Button lob = new Button();
				c.add(lob);
			}
		}
		
		this.pack();
		this.setVisible(true);
	}
	
	public static int getCurrPlayer() {
		return currPlayer;
	}

	public static void setCurrPlayer() {
		if(currPlayer == 1) currPlayer = 0;
		else {
			currPlayer = 1;
		}
	}
}
