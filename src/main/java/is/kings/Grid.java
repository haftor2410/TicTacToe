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
				gridString += "." + " ";
			}
			gridString += "\n";
		}
		return gridString;
	}
}
