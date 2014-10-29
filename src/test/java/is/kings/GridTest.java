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
		assertEquals(true, g.insertToGridPosition(4, 'X'));
	}

	@Test
	public void testInsertForNegativeNumbers(){
		Grid g = new Grid();
		assertEquals(false, g.insertToGridPosition(-2, 'X'));
	}

	@Test
	public void testForBiggerNumbers(){
		Grid g = new Grid();
		assertEquals(false, g.insertToGridPosition(12, 'X'));
	}

	@Test
	public void testToInsertInAMarkedField(){
		Grid g = new Grid();
		g.insertToGridPosition(1, 'X');
		assertEquals(false, g.insertToGridPosition(1, 'X'));
	}

	@Test
	public void testToInsertASymbol(){
		Grid g = new Grid();
		g.insertToGridPosition(1, 'X');
		assertEquals("X . . \n. . . \n. . . \n", g.printGrid());
	}

	@Test
	public void testIfGameIsOver(){
		Grid g = new Grid();
		assertEquals(false, g.gameConclusion());
	}

	@Test
	public void testIfGameIsTied(){
		Grid g = new Grid();
		for(int i = 1; i < 10; i++){
			g.insertToGridPosition(i, 'Y');
		}
		assertEquals(true, g.gameConclusion());
	}

}
