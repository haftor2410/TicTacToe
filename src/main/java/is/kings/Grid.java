package is.kings;

public class Grid{

	private static Node grid[][];
	private static int counter;

	private static class Node{
		private int position;
		private boolean marked;
		private char xOrO;

		public Node(int position, boolean marked, char xOrO){
			this.position = position;
			this.marked = marked;
			this.xOrO = xOrO;
		}

		public int getPosition() { return position; }
		public boolean getMarked() { return marked; }
		public char getxOrO() { return xOrO; }
	}

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

	public boolean insertToGridPosition(int thePosition, char humanOrComputer){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(isThisTheRightPosition(grid[i][j], thePosition)){
					if(isFieldMarked(grid[i][j])){
						return false;
					}
					else{
						updateGrid(grid[i][j], humanOrComputer);
						return true;
					}
				}
			}
		}
		return false;
	}

	private void updateGrid(Node position, char humanOrComputer){
		position.marked = true;
		position.xOrO = humanOrComputer;
		counter++;
		printGrid();
	}

	private boolean isThisTheRightPosition(Node position, int compareToPosition){
		return position.getPosition() == compareToPosition;
	}

	private boolean isFieldMarked(Node theField){
		return theField.marked;
	}

	private String addToString(String gridString, String toBeAdded){
		gridString += toBeAdded;
		return gridString;
	}
}
