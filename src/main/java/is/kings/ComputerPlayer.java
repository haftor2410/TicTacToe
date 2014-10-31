package is.kings;

import java.util.Random;

/**
 * A class that will take care of computer player moving.
 */
public class ComputerPlayer{

	/**
	 * A function that will perform a move for the computer.
	 * @param g Grid value.
	 * @return true if move is successful, elsa false.
	 */
	public boolean computerMove(Grid g){
		int theMove = generateNumber();
		if(isFieldTaken(g, theMove)){
			return false;
		}
		else{
			return true;
		}
	}

	private boolean isFieldTaken(Grid g, int theMove){
		return !g.insertToGridPosition(theMove, 'O');
	}

	private int generateNumber(){
		Random computerMoving = new Random();
		return computerMoving.nextInt(9) + 1;
	}

}
