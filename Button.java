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
		int hor_sum = 0;
		int ver_sum = 0;
		int left_dia_sum = 0;
		int right_dia_sum = 0;
		int max = 2;
		for(int i=0; i<3; i++) {
			
			// checks horizontal/vertical
			for(int j=0; j<3; j++) {
				hor_sum += status[i][j];
				ver_sum += status[j][i];
			}

			// checks diagonal
			for(i=0; i<3; i++) {
				left_dia_sum += status[i][i];
			}
			for(i=0; i<3; i++) {
				right_dia_sum += status[i][max];
				max--;
			}

			// checks win case
			if(hor_sum == 3 || ver_sum == 3 || left_dia_sum == 3 || right_dia_sum == 3) {
				System.out.println("Player O won!");
			} else if (hor_sum == -3 || ver_sum == -3 || left_dia_sum == -3 || right_dia_sum == -3) {
				System.out.println("Player X won!");
			} else if (GameFrame.moves_left == 0) {
				System.out.println("Draw!");
			}

			// checks if draw

		}		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setFont(new Font("Helvetica", Font.BOLD, 40));
		GameFrame.moves_left--;
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
