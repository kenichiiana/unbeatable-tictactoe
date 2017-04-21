import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button extends JButton implements ActionListener {
	private int xPos;
	private int yPos;
	private int[][] array;
	private Button[][] button;

	public Button() {
	// public Button(int xPos, int yPos, int turn) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.setFont(new Font("Helvetica", Font.BOLD, 40));
		if(GameFrame.getCurrPlayer() == 0) {
			this.setText("X");
		} else {
			this.setText("O");
		}
		GameFrame.setCurrPlayer();
		this.setEnabled(false);
	}	
}