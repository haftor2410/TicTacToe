package is.kings;

import java.util.Random;

public class ComputerPlayer{

	public boolean computerMove(Grid g){
		Random computerMoving = new Random();
		int theMove = computerMoving.nextInt(9) + 1;
		if(!g.insertToGridPosition(theMove, 'O')){
			return false;
		}
		else{
			return true;
		}
	}

}
