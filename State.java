import java.util.*;
import java.awt.*;

public class State {
	
	private final int POSINF = 999999;
	private final int NEGINF = -999999;
	private State parent;
	private int[][] board;
	public int player;
	
	public State(State parent, int player, int[][] board) {
		this.parent = parent;
		this.player = player;
		this.board = board;
	}
	
	public int value(State s) {
		if(s.player == 0) return utility(s);
		else if(s.player == 1) return max_value(s);
		else if(s.player == -1) return min_value(s);
		return 0;
	}
	
	public int max_value(State s) {
		int m = NEGINF;
		int v = 0;
		ArrayList<State> su = successors(s);
		for(State stat : su) {
			v = value(stat);
		}
		return 0;
	}
	
	public int min_value(State s) {
		int m = POSINF;
		return 0;
	}
	
	public boolean xWins() {
		return true;
	}

	public int utility(State s) {
		return 0;
	}
	
	public ArrayList<State> successors(State s) {
		ArrayList<State> succ = new ArrayList<State>();
		ArrayList<Point> acts = actions();
		for(Point p: acts) {
			State next = result(s, p);
			succ.add(next);
		}
		return succ;
	}

	public ArrayList<Point> actions() {
		ArrayList<Point> possible = new ArrayList<Point>();
		for(int i =0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(board[i][j]==99) {
					Point p = new Point(i,j);
					possible.add(p);
				}
			}
		}
		return possible;
	}

	public State result(State s, Point a) {
		int[][] newBoard = new int[3][3];
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		int xPos = (int) a.getX();
		int yPos = (int) a.getY();

		newBoard[xPos][yPos] = player;
		int nextPlayer = 99;
		if(checkIfOver(newBoard)) nextPlayer = 0;
		else if(player==1) nextPlayer=-1;
		else if(player==-1) nextPlayer=1;

		State newstate = new State(this, nextPlayer,newBoard);
		return newstate;
	}

	public boolean checkIfOver(int[][] board) {
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(board[i][j]>1 || board[i][j]<-1)
					return false;
			}
		}
		return true;
	}
	
}
