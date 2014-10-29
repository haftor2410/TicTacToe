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

	@Test
	public void testIfGameIsWonHorizontalWhenItIsNot(){
		Grid g = new Grid();
		for(int i = 1; i < 3; i++){
			g.insertToGridPosition(i, 'X');
		}
		g.insertToGridPosition(3, 'O');
		assertEquals(false, g.gameConclusion());
	}

	@Test
	public void testIfGameIsWonHorizontalRow1(){
		Grid g = new Grid();
		for(int i = 1; i < 4; i++){
			g.insertToGridPosition(i, 'X');
		}
		assertEquals(true, g.gameConclusion());
	}

	@Test
        public void testIfGameIsWonHorizontalRow2(){
                Grid g = new Grid();
                for(int i = 4; i < 7; i++){
                        g.insertToGridPosition(i, 'X');
                }
                assertEquals(true, g.gameConclusion());
        }

	@Test
        public void testIfGameIsWonHorizontalRow3(){
                Grid g = new Grid();
                for(int i = 7; i < 10; i++){
                        g.insertToGridPosition(i, 'X');
                }
                assertEquals(true, g.gameConclusion());
        }

	@Test
	public void testIfGameIsWonVerticalWhenItIsNot(){
		Grid g = new Grid();
		g.insertToGridPosition(2, 'O');
		g.insertToGridPosition(5, 'X');
		g.insertToGridPosition(8, 'X');
		assertEquals(false, g.gameConclusion());
	}

	@Test
	public void testIfGameIsWonVerticalColumn1(){
		Grid g = new Grid();
		g.insertToGridPosition(1, 'X');
                g.insertToGridPosition(4, 'X');
                g.insertToGridPosition(7, 'X');
		assertEquals(true, g.gameConclusion());
	}

        @Test
        public void testIfGameIsWonVerticalColumn2(){
                Grid g = new Grid();
                g.insertToGridPosition(2, 'X');
                g.insertToGridPosition(5, 'X');
                g.insertToGridPosition(8, 'X');
                assertEquals(true, g.gameConclusion());
        }

        @Test
        public void testIfGameIsWonVerticalColumn3(){
                Grid g = new Grid();
                g.insertToGridPosition(3, 'X');
                g.insertToGridPosition(6, 'X');
                g.insertToGridPosition(9, 'X');
                assertEquals(true, g.gameConclusion());
        }

	@Test
	public void testIfGameIsWonFromDiagonalLeftTopToRightBottomWhenItIsNot(){
		Grid g = new Grid();
		g.insertToGridPosition(1, 'X');
		g.insertToGridPosition(5, 'O');
		g.insertToGridPosition(9, 'X');
		assertEquals(false, g.gameConclusion());
	}

        @Test
        public void testIfGameIsWonFromDiagonalLeftTopToRightBottom(){ 
                Grid g = new Grid();
                g.insertToGridPosition(1, 'X');
                g.insertToGridPosition(5, 'X');
                g.insertToGridPosition(9, 'X');
                assertEquals(true, g.gameConclusion());
        }

	@Test
	public void testIfGameIsWonFromDiagonalRightTopToLeftBottomWhenItIsNot(){
		Grid g = new Grid();
		g.insertToGridPosition(3, 'O');
		g.insertToGridPosition(5, 'O');
		g.insertToGridPosition(7, 'X');
		assertEquals(false, g.gameConclusion());
	}

        @Test
        public void testIfGameIsWonFromDiagonalRightTopToLeftBottom(){ 
                Grid g = new Grid();
                g.insertToGridPosition(3, 'O');
                g.insertToGridPosition(5, 'O');
                g.insertToGridPosition(7, 'O');
                assertEquals(true, g.gameConclusion());
        }

}
