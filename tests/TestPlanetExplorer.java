import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	@Test
	public void test_emptyCommand(){
		PlanetExplorer explorer = new PlanetExplorer(50, 50, "");
		
		String report = explorer.executeCommand("");
		
		assertEquals("(0,0,N)", report);
	}
	
	@Test
	public void test_turnRight(){
		PlanetExplorer explorer = new PlanetExplorer(50, 50, "");
		
		String report = explorer.executeCommand("r");
		
		assertEquals("(0,0,E)", report);
	}
	
	@Test
	public void test_turnLeft(){
		PlanetExplorer explorer = new PlanetExplorer(50, 50, "");
		
		String report = explorer.executeCommand("l");
		
		assertEquals("(0,0,W)", report);
	}
	
	@Test
	public void test_move_ffrff(){
		PlanetExplorer explorer = new PlanetExplorer(50, 50, "");
		
		String report = explorer.executeCommand("ffrff");
		
		assertEquals("(2,2,E)", report);
	}
	
	@Test
	public void test_obstacles_2_2(){
		PlanetExplorer explorer = new PlanetExplorer(50, 50, "(2,2)");
		
		String report = explorer.executeCommand("ffrfff");
		
		assertEquals("(1,2,E)(2,2)", report);
	}
	@Test
	public void test_obstacles_2_2__2_1(){
		PlanetExplorer explorer = new PlanetExplorer(50, 50, "(2,2)(2,1)");
		
		String report = explorer.executeCommand("ffrfffrflf");
		
		assertEquals("(1,1,E)(2,2)(2,1)", report);
	}
	
	@Test
	public void test_wrapping(){
		PlanetExplorer explorer = new PlanetExplorer(100, 100, "");
		
		String report = explorer.executeCommand("b");
		
		assertEquals("(0,99,N)", report);
	}
	@Test
	public void test_extractObstacles_1_1_2_5_first(){
		PlanetExplorer explorer = new PlanetExplorer(50, 50, "(1,1)(2,5)");
		
		Obstacle o1 = explorer.getObstacle(0);
		Obstacle temp = new Obstacle(1, 1);
		
		assertTrue(o1.equals(temp));
	}
	@Test
	public void test_extractObstacles_1_1_2_5_second(){
		PlanetExplorer explorer = new PlanetExplorer(50, 50, "(1,1)(2,5)");
		
		Obstacle o1 = explorer.getObstacle(1);
		Obstacle temp = new Obstacle(2, 5);
		
		assertTrue(o1.equals(temp));
	}
	@Test
	public void test_tour(){
		PlanetExplorer explorer = new PlanetExplorer(6, 6, "(2,2)(0,5)(5,0)");
		
		String report = explorer.executeCommand("ffrfffrbbblllfrfrbbl");
		
		assertEquals("(0,0,N)(2,2)(0,5)(5,0)", report);
	}
}
