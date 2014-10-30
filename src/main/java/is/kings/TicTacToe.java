package is.kings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TicTacToe{

	public static void main(String[] args){
		Grid gameGrid = new Grid();
		HumanPlayer human = new HumanPlayer();
		ComputerPlayer computer = new ComputerPlayer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
			while(!human.checkInput(humanInput)){
				System.out.println("Please enter a number from 1-9");
				try{
                                	humanInput = br.readLine(); 
                        	}
                        	catch(Exception e){
                                	e.printStackTrace();
                        	}
			}

			if(!human.playerMove(gameGrid, Integer.parseInt(humanInput))){
				continue;
			}
			System.out.println(gameGrid.printGrid());
			if(gameGrid.gameConclusion()){
				return;
			}
			System.out.println("Computer's turn");
			while(!computer.computerMove(gameGrid)){
			}
			System.out.println(gameGrid.printGrid());
			if(gameGrid.gameConclusion()){
				return;
			}
		}
	}

}
