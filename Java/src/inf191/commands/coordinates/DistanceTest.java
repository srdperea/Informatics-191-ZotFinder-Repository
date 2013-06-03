package inf191.commands.coordinates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DistanceTest {
	
	@Before
	public void setUp() throws Exception {
		Distance newDistance = new Distance();
	}
	
	@Test
	public void testDistanceFormula(){
		assertEquals (2.82, Distance.calculateDistance("5","5","3","3"), 0.009); 
		//have to have a random delta value for floats hence the 0.009
	}

}
