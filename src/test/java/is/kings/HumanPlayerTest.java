package is.kings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HumanPlayerTest{

	@Test
	public void testCheckInput(){
		HumanPlayer h = new HumanPlayer();
		assertEquals(true, h.checkInput("7"));
	}

	@Test
	public void testCheckInputForString(){
		HumanPlayer h = new HumanPlayer();
		assertEquals(false, h.checkInput("Checking"));
	}

	@Test
	public void testCheckInputForSymbol(){
		HumanPlayer h = new HumanPlayer();
		assertEquals(false, h.checkInput("$"));
	}

	@Test
	public void testCheckInputForChar(){
		HumanPlayer h = new HumanPlayer();
		assertEquals(false, h.checkInput("H"));
	}

}
