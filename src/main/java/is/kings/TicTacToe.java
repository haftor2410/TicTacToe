package is.kings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 /**
 * A class that will play the game.
 */
public class TicTacToe{

	public static void main(String[] args){
		Grid gameGrid = new Grid();
		HumanPlayer human = new HumanPlayer();
		ComputerPlayer computer = new ComputerPlayer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//This loop will run while the game is not over.
		while(!gameGrid.gameConclusion())
		{
			String humanInput = "";
			System.out.println("Please enter a number from 1-9");
			try{
				humanInput = br.readLine();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			//Run this loop while the human input is not correct.
			while(!human.checkInput(humanInput)){
				System.out.println("Please enter a number from 1-9");
				try{
                                	humanInput = br.readLine(); 
                        	}
                        	catch(Exception e){
                                	e.printStackTrace();
                        	}
			}
			//If human move is unsuccessful, then continue
			if(!human.playerMove(gameGrid, Integer.parseInt(humanInput))){
				continue;
			}
			System.out.println(gameGrid.printGrid());
			//Check if the human wins.
			if(gameGrid.gameConclusion()){
				return;
			}
			System.out.println("Computer's turn");
			//Run this loop while the computer find an occupied grid position. 
			while(!computer.computerMove(gameGrid)){
			}
			System.out.println(gameGrid.printGrid());
			//Check if the computer wins.
			if(gameGrid.gameConclusion()){
				return;
			}
		}
	}

}
