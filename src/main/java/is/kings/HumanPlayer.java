package is.kings;

public class HumanPlayer{

	public boolean checkInput(String inputString){
		try{
			Integer.parseInt(inputString);
		} catch(Exception notInt){
			return false;
		}
		return true;
	}

}
