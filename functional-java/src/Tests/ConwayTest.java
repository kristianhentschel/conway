package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.Conway;
import static org.hamcrest.CoreMatchers.*;

public class ConwayTest {

	@Test
	public void testConstruct() {
		Conway c = new Conway();
		assertFalse(c == null);
	}
	
	@Test
	public void testGenerationZero() {
		Conway c = new Conway();
		c.addInitialLife(3,3);
		assertThat(c.calculateState(3,3,0), is(true));
		assertThat(c.calculateState(1,1,0), is(false));
		
	}
	
	/**
	 * a cell with less than 2 neighbours dies.
	 */
	@Test
	public void testUnderpopulation0(){
		Conway c = new Conway();
		c.addInitialLife(3,3);
		
		//generation 1
		assertThat(c.calculateState(3,3,0), is(true));
		
		//generation 2
		assertThat(c.calculateState(3,3,1), is(false));
	}
	
	@Test
	public void testUnderpopulation1(){
		Conway c = new Conway();
		c.addInitialLife(3,3);
		c.addInitialLife(3,2);
		
		//generation 1
		assertThat(c.calculateState(3,3,0), is(true));
		assertThat(c.calculateState(3,2,0), is(true));
		
		//generation 2
		assertThat(c.calculateState(3,3,1), is(false));
		assertThat(c.calculateState(3,2,1), is(false));
	}
	
	/**
	 * add a cell with four neighbours that will die due to overpopulation.
	 */
	@Test
	public void testOverpopulation(){
		Conway c = new Conway();
		c.addInitialLife(2,2);
		
		c.addInitialLife(3,3);
		c.addInitialLife(3,2);
		c.addInitialLife(2,1);
		c.addInitialLife(2,3);
		
		assertThat(c.calculateState(2, 2, 1), is(false));
	}
	
	/**
	 * cells with 2 or 3 neighbours live happily ever after
	 */
	@Test
	public void testLiveOn2() {
		Conway c = new Conway();
		c.addInitialLife(1, 2);
		//two neighbours:
		c.addInitialLife(1, 1);
		c.addInitialLife(1, 3);
		
		assertThat(c.calculateState(1, 2, 1), is(true));
	}
	
	@Test
	public void testLiveOn3() {
		Conway c = new Conway();
		c.addInitialLife(1, 2);
		//three neighbours:
		c.addInitialLife(1, 1);
		c.addInitialLife(2, 2);
		c.addInitialLife(1, 3);
		
		assertThat(c.calculateState(1, 2, 1), is(true));
	}
	
	/**
	 * cells with exactly three neighbours will develop life
	 */
	@Test
	public void testReproduction() {
		Conway c = new Conway();
		c.addInitialLife(1, 1);
		c.addInitialLife(1, 3);
		c.addInitialLife(2, 2);
		
		assertThat(c.calculateState(1,2,1), is(true));
	}
	
	/**
	 * cells with 
	 */
	
	/**
	 * add three cells in a bar (oscillating pattern)
	 */
	@Test
	public void testPatternBar(){
		Conway c = new Conway();
		
		//generation 0: vertical bar
		c.addInitialLife(2,1);
		c.addInitialLife(2,2);
		c.addInitialLife(2,3);
		
		//generation 1: horizontal bar
		assertThat(c.calculateState(1, 2, 1), is(true));
		assertThat(c.calculateState(2, 2, 1), is(true));
		assertThat(c.calculateState(3, 2, 1), is(true));
		
		assertThat(c.calculateState(2, 1, 1), is(false));
		assertThat(c.calculateState(2, 3, 1), is(false));
		
		//generation 2: vertical bar
		assertThat(c.calculateState(2, 1, 2), is(true));
		assertThat(c.calculateState(2, 2, 2), is(true));
		assertThat(c.calculateState(2, 3, 2), is(true));
		
		assertThat(c.calculateState(1, 2, 2), is(false));
		assertThat(c.calculateState(3, 2, 2), is(false));
	}

	
	@Test
	public void failureVerticalBar(){
		Conway c = new Conway();
		
		c.addInitialLife(2,1);
		c.addInitialLife(2,2);
		c.addInitialLife(2,3);
		
		assertThat(c.calculateState(2, 3, 1), is(false));
	}
	
	@Test
	public void viewBeacon(){
		Conway c = new Conway();
		c.addInitialLife(1, 1);
		c.addInitialLife(2, 1);
		c.addInitialLife(1, 2);
		c.addInitialLife(2, 2);
		
		c.addInitialLife(3, 3);
		c.addInitialLife(4, 3);
		c.addInitialLife(3, 4);
		c.addInitialLife(4, 4);
		
		for(int n = 0; n < 3; n++){
			System.out.printf("Generation %d\n", n);
			System.out.println(c.stringWindow(n, 0, 0, 6, 6));
		}
	}

	@Test
	public void viewBar(){
		Conway c = new Conway();

		c.addInitialLife(2,1);
		c.addInitialLife(2,2);
		c.addInitialLife(2,3);
		
		for(int n = 0; n < 3; n++){
			System.out.printf("Generation %d\n", n);
			System.out.println(c.stringWindow(n, 0, 0, 6, 6));
		}
	}

}
