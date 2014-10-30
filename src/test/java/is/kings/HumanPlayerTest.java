package is.kings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HumanPlayerTest{

	@Test
	public void testCheckInsert(){
		HumanPlayer h = new HumanPlayer();
		assertEquals(true, h.checkInput("7"));
	}

	@Test
	public void testCheckInsertForString(){
		HumanPlayer h = new HumanPlayer();
		assertEquals(false, h.checkInput("Checking"));
	}

}
