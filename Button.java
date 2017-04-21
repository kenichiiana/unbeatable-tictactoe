import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button extends JButton implements ActionListener {
	
	private int xPos;
	private int yPos; 

	public Button(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.addActionListener(this);
	}
	
	public void checkIfWin() {
		int[][] status = GameFrame.getStatus();
		if(
		(status[0][0]==status[0][1]&&status[0][2]==status[0][1])
		||
		(status[1][0]==status[1][1]&&status[1][2]==status[0][1])
		||
		(status[2][0]==status[2][1]&&status[2][2]==status[2][1])
		||
		(status[0][0]==status[1][0]&&status[2][0]==status[1][0])
		||
		(status[0][1]==status[1][1]&&status[2][1]==status[1][1])
		||
		(status[0][2]==status[1][2]&&status[2][2]==status[1][2])
		||
		(status[0][0]==status[1][1]&&status[2][2]==status[1][1])
		||
		(status[0][2]==status[1][1]&&status[2][0]==status[1][1])
		) {
			String s;
			if(GameFrame.getPrevPlayer() == -1) {
				s = "X";
			} else {
				s = "O";
			}
			System.out.println("Player "+ s +" won!");
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setFont(new Font("Helvetica", Font.BOLD, 40));
		if(GameFrame.getCurrPlayer() == -1) {
			this.setText("X");
		} else {
			this.setText("O");
		}
		GameFrame.getStatus()[this.yPos][this.xPos] = GameFrame.getCurrPlayer();
		GameFrame.print();
		GameFrame.setCurrPlayer();
		this.setEnabled(false);
		checkIfWin();
	}	
}
