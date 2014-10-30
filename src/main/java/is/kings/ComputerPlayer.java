package is.kings;

import java.util.Random;

public class ComputerPlayer{

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
