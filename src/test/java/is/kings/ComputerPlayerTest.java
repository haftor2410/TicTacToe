package is.kings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ComputerPlayerTest{

	@Test
	public void testComputerMove(){
		ComputerPlayer c = new ComputerPlayer();
		assertEquals(true, c.computerMove());
	}

}
