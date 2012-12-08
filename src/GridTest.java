import static org.junit.Assert.*;

import org.junit.Test;


public class GridTest {
	
	@Test
	public void testSetGet() {
		Grid g = new Grid();
		
		g.setCellState(1, 1, true);
		
		assertEquals( g.isAlive(1, 1), true );
		assertEquals( g.isAlive(1, 2), false );
		
	}
	
	@Test
	public void testBar() {
		Grid g = new Grid();
		
		g.setCellState(2, 1, true);
		g.setCellState(2, 2, true);
		g.setCellState(2, 3, true);
		
		System.out.println("1");
		System.out.println(g.toString());
		
		g.calculateNextState();

		System.out.println("2");
		System.out.println(g.toString());
		
		
		assertEquals( g.isAlive(1, 2), true );
		assertEquals( g.isAlive(2, 2), true );
		assertEquals( g.isAlive(3, 2), true );
		
		assertEquals( g.isAlive(2, 1), false );
		assertEquals( g.isAlive(2, 3), false );
		
		assertEquals( g.isAlive(3, 3), false );
		
	}

}
