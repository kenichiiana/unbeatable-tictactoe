// import necessary libraries
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class Button extends JButton implements ActionListener{

    // holds the position of the button
    private int xPos;
    private int yPos;

    // button constructor
    public Button(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.addActionListener(this);
    }

    // player move
    public void actionPerformed(ActionEvent e) {
        // tweak game appearance
        this.setFont(new Font("Helvetica", Font.BOLD, 150));
        // update the number of moves left
        GameFrame.setMovesLeft();

        // change button text
        int curr = GameFrame.getCurrPlayer();
        if(curr == -1) {
            // -1 = X 
            this.setText("X"); 
        } else {
            // O
            this.setText("O");
        }

        // update board values
        GameFrame.getStatus()[this.yPos][this.xPos] = curr;
        GameFrame.print();
        GameFrame.setCurrPlayer();

        // disables the button when pressed
        this.setEnabled(false);
        checkIfWin();
    }

    public void checkIfWin() {
        int[][] status = GameFrame.getStatus();
        for(int i=0; i<3; i++) {
            int hor_sum = 0;
            int ver_sum = 0;
            int left_dia_sum = 0;
            int right_dia_sum = 0;
            int max = 2;    
            // checks horizontal/vertical
            for(int j=0; j<3; j++) {
                hor_sum += status[i][j];
                ver_sum += status[j][i];
            }

            // checks diagonal
            for(int k=0; k<3; k++) {
                left_dia_sum += status[k][k];
            }
            for(int k=0; k<3; k++) {
                right_dia_sum += status[k][max];
                max--;
            }

            System.out.println(hor_sum);

            // checks win case
            if(hor_sum == 3 || ver_sum == 3 || left_dia_sum == 3 || right_dia_sum == 3) {
                System.out.println("Player O won!");
                JOptionPane.showMessageDialog(null, "Player O won!");
                GameFrame.c.removeAll();
                break;
            } else if (hor_sum == -3 || ver_sum == -3 || left_dia_sum == -3 || right_dia_sum == -3) {
                System.out.println("Player X won!");
                JOptionPane.showMessageDialog(null, "Player X won!");
                break;
            } else if (GameFrame.getMovesLeft() == 0) {
                System.out.println("Draw!");
                break;
            }
        }       
    }
}
