package is.kings;

/**
 * A class that will take care of human player moving.
 */
public class HumanPlayer{

	/**
         * A function that  moves the player in the grid.
         * @param g Grid value,
         * @param number integer value of the insert position.
         * @return true if move is successful, else false.
         */
	public boolean playerMove(Grid g, int number){
		if(isFieldTaken(g, number)){
			return false;
		}
		else{
			return true;
		}
	}

	/**
         * A function that checks if the human input is valid.
         * @param inputString String value of the input string.
         * @return true if input is valid, else false.
         */
	public boolean checkInput(String inputString){
		int inputNumber = 0;
		try{
			inputNumber = parseString(inputString);
		} catch(Exception notInt){
			System.out.println("Input has to be a number");
			return false;
		}
		if(isNumberNotInTheRightRange(inputNumber)){
			System.out.println("Input is not in the right range");
			return false;
		}
		return true;
	}

        private boolean isFieldTaken(Grid g, int number){
                return !g.insertToGridPosition(number, 'X');
        }


	private int parseString(String inputString){
		return Integer.parseInt(inputString);
	}

	private boolean isNumberNotInTheRightRange(int inputNumber){
		return (inputNumber < 1 || inputNumber > 9);
	}

}
