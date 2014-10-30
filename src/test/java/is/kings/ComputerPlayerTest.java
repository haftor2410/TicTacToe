package is.kings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ComputerPlayerTest{

	@Test
	public void testComputerMove(){
		Grid g = new Grid();
		ComputerPlayer c = new ComputerPlayer();
		assertEquals(true, c.computerMove(g));
	}

	@Test
	public void testInsertOnAFullTable(){
		Grid g = new Grid();
		ComputerPlayer c = new ComputerPlayer();
		for(int i = 1; i < 10; i++){
			g.insertToGridPosition(i, 'X');
		}
		assertEquals(false, c.computerMove(g));
	}

}
