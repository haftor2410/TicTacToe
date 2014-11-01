package is.kings;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

/**
 * A class that implements SparkApplication and makes TicTacToe a web app.
 */
public class TicTacToeWeb implements SparkApplication{
	private Grid grid = new Grid();

	public static void main(String[] args){
		staticFileLocation("/public");
		SparkApplication TTTWeb = new TicTacToeWeb();
		String port = System.getenv("PORT");
		if (port != null) {
           		 setPort(Integer.valueOf(port));
       		 }
		TTTWeb.init();
	}

	public void init(){
		final HumanPlayer hPlayer = new HumanPlayer();
		final ComputerPlayer cPlayer = new ComputerPlayer();
		get(new Route("/newgame"){
			@Override
                        public Object handle(Request req, Response res){
				grid = new Grid();
				res.redirect("/");
				return res;
			}
		});
		post(new Route("/fight"){
			@Override
			public Object handle(Request req, Response res){
				//Check if game is over to prevent further user input.
				if(grid.gameConclusion()){
					StringBuilder html = new StringBuilder();
                                        html.append("<pre>").append(grid.printGrid()).append("</pre>");
                                        html.append("<pre>").append("GAME OVER").append("</pre>");
                                        String gridOut = html.toString();
                                        return gridOut;
				}
				//Get the user input.
				String inString = String.valueOf(req.queryParams("move"));
				//Check if input is valid.
				if(!hPlayer.checkInput(inString)){
					StringBuilder html = new StringBuilder();
                                        html.append("<pre>").append(grid.printGrid()).append("</pre>");
                                        html.append("<pre>").append("Invalid move , try again").append("</pre>");
                                        String gridOut = html.toString();
					return gridOut;

				}
				//If input is valid, then get the integer value of the user input.
				Integer number = Integer.valueOf(req.queryParams("move"));
				//Try to move the player.
				if(!hPlayer.playerMove(grid, number)){
					StringBuilder html = new StringBuilder();
                                	html.append("<pre>").append(grid.printGrid()).append("</pre>");
					html.append("<pre>").append("Invalid move, try again").append("</pre>");
                                	String gridOut = html.toString();
                                	return gridOut;
				}
				//Check if the user wins.
				if(grid.gameConclusion()){
					StringBuilder html = new StringBuilder();
                                        html.append("<pre>").append(grid.printGrid()).append("</pre>");
                                        html.append("<pre>").append("YOU WIN!").append("</pre>");
                                        String gridOut = html.toString();
                                        return gridOut;
				}
				//Insert the copmuter's move to the input.
				while(!cPlayer.computerMove(grid)){}
				//Check if the computer wins.
				if(grid.gameConclusion()){
                                        StringBuilder html = new StringBuilder();
                                        html.append("<pre>").append(grid.printGrid()).append("</pre>");
                                        html.append("<pre>").append("COMPUTER WINS!").append("</pre>");
                                        String gridOut = html.toString();
                                        return gridOut;
                                }
				//Return the grid if there is valid moves and the game is not over.
				StringBuilder html = new StringBuilder();
				html.append("<pre>").append(grid.printGrid()).append("</pre>");
				String gridOut = html.toString();
				return gridOut;
			}
		});
	}
}
