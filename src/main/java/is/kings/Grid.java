package is.kings;

 /**
 * A class that will perfom basic grid functions. Moving signs to the grid, check winner and print out the grid.
 */
public class Grid{

	private static Node grid[][];
	private static int counter;
	/**
	 * A class that will keep the position of every grid square, if it's occupied and what sign it contains.
	 */
	private static class Node{
		private int position;
		private boolean marked;
		private char xOrO;
		/**
		 * A constructor.
		 * @param position integer value of grid position.
		 * @param marked boolean value if grid is marked.
		 * @param xOrO char value of sign 
		 */
		public Node(int position, boolean marked, char xOrO){
			this.position = position;
			this.marked = marked;
			this.xOrO = xOrO;
		}
		/**
		 * A get function for position of the grid.
		 * @return the position.
		 */
		public int getPosition() { return position; }
		/**
		 * A get function to check if grid square is taken.
		 * @return grid marked value
		 */
		public boolean getMarked() { return marked; }
		/**
		 * A get function for the character of the grid square.
		 * @return The grid square character.
		 */
		public char getxOrO() { return xOrO; }
	}
	/**
	 * A constructor.
	 * Sets all grid squares with character '.' and marked value false.
	 */
	public Grid(){
		grid = new Node[3][3];
		int p = 1;
		counter = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				grid[i][j] = new Node(p, false, '.');
				p++;
			}
		}
	}

	/**
	 * A function that prints out the game grid.
	 */
	public String printGrid(){
		String gridString = "";
		for(int i = 0; i < 3; i++){
			for(int k = 0; k < 3; k++){
				gridString = addToString(gridString, grid[i][k].xOrO + " ");
			}
			gridString = addToString(gridString, "\n");
		}
		return gridString;
	}

	/**
	 * A function that inserts a sign into the grid.
	 * @param thePosition integer value for the position.
	 * @param humanOrComputer char value for the sign.
	 * @return true if insert is succesfull, else false.
	 */
	public boolean insertToGridPosition(int thePosition, char humanOrComputer){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				//If thePosition is in the grid then check if it can be added to the grid.
				if(isThisTheRightPosition(grid[i][j], thePosition)){
					if(isFieldMarked(grid[i][j])){
						return false;
					}
					//If thePosition is in the grid and it's not marked, then update the grid.
					else{
						updateGrid(grid[i][j], humanOrComputer);
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * A function that checks if there is a winner or there is a draw.
	 * @return true if game is over, else false.
	 */
	public boolean gameConclusion(){
		return isGameOver();
	}

	private boolean isGameOver(){
		if(isGameWonHorizontal()){
			return true;
		}

		if(isGameWonVertical()){
			return true;
		}


		if(isGameWonDiagonal()){
			return true;
		}

		if(isGameTied()){
			return true;
		}

		return false;
	}

	private boolean isGameWonHorizontal(){
		//Check all horizontal lines in the grid, 1-2-3, 4-5-6 and 7-8-9.
		for(int i = 0; i < 3; i++){
			//If the line has the computer character.
                        if(grid[i][0].xOrO == grid[i][1].xOrO && grid[i][0].xOrO == grid[i][2].xOrO){
                                if(grid[i][0].xOrO == 'O'){
                                        System.out.println("Computer wins");
                                        return true;
                                }
				//If the line has the human character.
                                else if(grid[i][0].xOrO == 'X'){
                                        System.out.println("You win!");
                                        return true;
                                }
                        }
                }
		return false;
	}

	private boolean isGameWonVertical(){
		//Check all vertical lines of the grid, 1-4-7, 2-5-8 and 3-6-9.
                for(int i = 0; i < 3; i++){
                        if(grid[0][i].xOrO == grid[1][i].xOrO && grid[0][i].xOrO == grid[2][i].xOrO){
				//If the line has the computer character.
                                if(grid[0][i].xOrO == 'O'){
                                        System.out.println("Computer wins");
                                        return true;
                                }
				//If the line has the human character.
                                else if(grid[0][i].xOrO == 'X'){
                                        System.out.println("You win!");
                                        return true;
                                }
                        }
                }
		return false;
	}

	private boolean isGameWonDiagonal(){
		//Check the diogonal line 1-5-9.
                if(grid[0][0].xOrO == grid[1][1].xOrO && grid[0][0].xOrO == grid[2][2].xOrO){
			//If the line has the computer character.
                        if(grid[0][0].xOrO == 'O'){
                                System.out.println("Computer wins");
                                return true;
                        }
			//If the line has the human character.
                        else if(grid[0][0].xOrO == 'X'){
                                System.out.println("You win!");
                                return true;
                        }
                }
		//Check the diogonal line 3-5-7.
                if(grid[0][2].xOrO == grid[1][1].xOrO && grid[0][2].xOrO == grid[2][0].xOrO){
			//If the line has the computer character.
                        if(grid[0][2].xOrO == 'O'){
                                System.out.println("Computer wins");
                                return true;
                        }
			//If the line has the human character.
                        else if(grid[0][2].xOrO == 'X'){
                                System.out.println("You win!");
                                return true;
                        }
                }

		return false;
	}

	private boolean isGameTied(){
		//Check if there have been 9 moves in the grid.
		if(counter >= 9){
                        System.out.println("The game is tied!");
                        return true;
                }
		return false;
	}

	private void updateGrid(Node position, char humanOrComputer){
		//Mark the grid position as occupied.
		position.marked = true;
		//Set the grids charachter to human or computer.
		position.xOrO = humanOrComputer;
		//Raise the move counter.
		counter++;
		printGrid();
	}

	private boolean isThisTheRightPosition(Node position, int compareToPosition){
		//Return true if compareToPosition is in the grid.
		return position.getPosition() == compareToPosition;
	}

	private boolean isFieldMarked(Node theField){
		//Return true if the theField in the grid is occupied.
		return theField.marked;
	}

	private String addToString(String gridString, String toBeAdded){
		//Add toBeAdded to the end of gridString.
		gridString += toBeAdded;
		return gridString;
	}
}
