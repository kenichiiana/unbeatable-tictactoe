import java.util.*;

public class State {
	
	private final int POSINF = 999999;
	private final int NEGINF = -999999;
	private State parent;
	
	public State(State parent) {
		this.parent = parent;
	}
	
	public int value(State s) {
		
	}
	
	public int max_value(State s) {
		int m = NEGINF;
	}
	
	public int min_value(State s) {
		int m = POSINF;
	}
	
	public int utility(State s) {
		
	}
	
	public ArrayList<State> result() {
		
	}
	
}
