package is.kings;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicTacToeWeb implements SparkApplication{
	public static void main(String[] args){
		SparkApplication TTTWeb = new TicTacToeWeb();
		String port = System.getenv("PORT");
		if (port != null) {
           		 setPort(Integer.valueOf(port));
       		 }
		TTTWeb.init();
	}

	public void init(){
		final Grid grid = new Grid();

		get(new Route("/"){
			@Override
			public Object handle(Request req, Response res){
				Grid g = new Grid();
				StringBuilder html = new StringBuilder();
				html.append("<pre>").append(g.printGrid()).append("</pre>");
				return html.toString();
			}
		});
	}
}
