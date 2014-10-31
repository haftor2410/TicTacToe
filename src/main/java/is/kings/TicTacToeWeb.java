package is.kings;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicTacToeWeb implements SparkApplication{
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
		final Grid grid = new Grid();
		final HumanPlayer hPlayer = new HumanPlayer();
		final ComputerPlayer cPlayer = new ComputerPlayer();

		post(new Route("/fight"){
			@Override
			public Object handle(Request req, Response res){
				String inString = String.valueOf(req.queryParams("move"));
				if(!hPlayer.checkInput(inString)){
					StringBuilder html = new StringBuilder();
                                        html.append("<pre>").append(grid.printGrid()).append("</pre>");
                                        html.append("<pre>").append("Invalid move , try again").append("</pre>");
                                        String gridOut = html.toString();
					return gridOut;

				}
				Integer number = Integer.valueOf(req.queryParams("move"));
				if(!hPlayer.playerMove(grid, number)){
					StringBuilder html = new StringBuilder();
                                	html.append("<pre>").append(grid.printGrid()).append("</pre>");
					html.append("<pre>").append("Invalid move, try again").append("</pre>");
                                	String gridOut = html.toString();
                                	return gridOut;
				}
				while(!cPlayer.computerMove(grid)){}

				StringBuilder html = new StringBuilder();
				html.append("<pre>").append(grid.printGrid()).append("</pre>");
				String gridOut = html.toString();
				return gridOut;
			}
		});
	}
}
