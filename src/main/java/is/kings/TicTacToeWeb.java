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

		post(new Route("/fight"){
			@Override
			public Object handle(Request req, Response res){
				Integer number = Integer.valueOf(req.queryParams("move"));
				hPlayer.playerMove(grid, number);
				StringBuilder html = new StringBuilder();
				html.append("<pre>").append(grid.printGrid()).append("</pre>");
				String gridOut = html.toString();
				return gridOut;
			}
		});
	}
}
