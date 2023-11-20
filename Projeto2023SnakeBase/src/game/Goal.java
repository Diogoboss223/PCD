package game;

import environment.Board;
import java.util.Random;
import environment.LocalBoard;

public class Goal extends GameElement  {
	Random aleatorio= new Random();
	private int value=aleatorio.nextInt(9)+1;
	private Board board;
	public static final int MAX_VALUE=10;
	public Goal( Board board2) {
		this.board = board2;
	}
	
	public int getValue() {
		return value;
	}
	public void incrementValue() throws InterruptedException {
		//TODO
	}

	public int captureGoal() {
//		TODO
		return -1;
	}
}
