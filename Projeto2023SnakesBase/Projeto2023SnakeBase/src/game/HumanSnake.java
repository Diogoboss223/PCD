package game;

import environment.Board;
import environment.BoardPosition;
import environment.Cell;
import java.awt.event.KeyEvent;


 /** Class for a remote snake, controlled by a human 
  * 
  * @author luismota
  *
  */
public abstract class HumanSnake extends Snake {
    
    public HumanSnake(int id, Board board) {
        super(id, board);
    }
	

    public void moveBasedOnInput(int keyCode) {
        BoardPosition currentPosition = getCells().getFirst().getPosition();
        BoardPosition newPosition = calculateNewPosition(currentPosition, keyCode);
        Cell nextCell = getBoard().getCell(newPosition);

        if (nextCell.isOcupied()) {
            // Terminar o jogo
            System.out.println("Game Over!");
            System.exit(0);
        } else {
            try {
                move(nextCell);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private BoardPosition calculateNewPosition(BoardPosition currentPosition, int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                return new BoardPosition(currentPosition.getX(), currentPosition.getY() - 1);
            case KeyEvent.VK_DOWN:
                return new BoardPosition(currentPosition.getX(), currentPosition.getY() + 1);
            case KeyEvent.VK_LEFT:
                return new BoardPosition(currentPosition.getX() - 1, currentPosition.getY());
            case KeyEvent.VK_RIGHT:
                return new BoardPosition(currentPosition.getX() + 1, currentPosition.getY());
            default:
                return currentPosition;
        }
    }
    
    
    /*public void run() {
		doInitialPositioning();
		System.err.println("initial size:"+cells.size());
		try {
			cells.getLast().request(this);
			moveBasedOnInput(keyCode);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO: automatic movement
	}*/
}
