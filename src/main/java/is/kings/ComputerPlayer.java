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
		//Get a random number.
		int theMove = generateNumber();
		//IsFieldTaken tries to insert to the grid.
		if(isFieldTaken(g, theMove)){
			return false;
		}
		else{
			return true;
		}
	}

	private boolean isFieldTaken(Grid g, int theMove){
		//If insertion is successful, then return false.
		return !g.insertToGridPosition(theMove, 'O');
	}

	private int generateNumber(){
		Random computerMoving = new Random();
		//nextInt return random number Ã0 <= x <= 8, + 1 to get 1 <= x <= 9
		return computerMoving.nextInt(9) + 1;
	}

}
