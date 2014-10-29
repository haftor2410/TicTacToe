package is.kings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GridTest{

	@Test
	public void testPrintGrid(){
		Grid g = new Grid();
		assertEquals(". . . \n. . . \n. . . \n", g.printGrid());
	}

}
