package is.kings;

public class HumanPlayer{

	public boolean checkInput(String inputString){
		try{
			Integer.parseInt(inputString);
		} catch(Exception notInt){
			System.out.println("Input has to be a number");
			return false;
		}
		if(Integer.parseInt(inputString) < 1 || Integer.parseInt(inputString) > 9){
			System.out.println("Input is not in the right range");
			return false;
		}
		return true;
	}

}
