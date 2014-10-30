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
	}
}
