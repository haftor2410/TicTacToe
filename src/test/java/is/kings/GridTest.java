package is.kings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GridTest{

	@Test
	public void testPrintGrid(){
		Grid g = new Grid();
		assertEquals(". . . \n. . . \n. . . \n", g.printGrid());
	}

	@Test
	public void testInsertToGridPosition(){
		Grid g = new Grid();
		assertEquals(true, g.insertToGridPosition(4));
	}

	@Test
	public void testInsertForNegativeNumbers(){
		Grid g = new Grid();
		assertEquals(false, g.insertToGridPosition(-2));
	}

	@Test
	public void testForBiggerNumbers(){
		Grid g = new Grid();
		assertEquals(false, g.insertToGridPosition(12));
	}

}
