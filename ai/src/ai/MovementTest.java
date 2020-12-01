package ai;

import static org.junit.jupiter.api.Assertions.*;

import junit.framework.*;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MovementTest {
	Board t = new Board();

	//testing water
	@Test
	void testIsInWater1() {
		assertEquals(Movement.isInWater("A1"), false);
	}
	
	@Test
	void testIsInWater2() {
		assertEquals(Movement.isInWater("E9"), false);
	}
	
	//tests converting id in x,y format form to loc form "A1"
	@Test
	void testGetName() {
		assertEquals(Movement.getName(1, 15), "B16");
	}
	
	@Test
	void testGetName2() {
		assertEquals(Movement.getName(6, 8), "G9");
	}
	
	//tests getting the column from a loc
	@Test
	void testGetCol() {
		assertEquals(Movement.getY("C1"), 0);
	}
	
	//tests getting the column from a loc
	@Test
	void testGetCol2() {
		assertEquals(Movement.getY("L7"), 6);
	}

	//tests getting the row from a loc
	@Test
	void testGetRow() {
		assertEquals(Movement.getX("C1"), 2);
	}
	
	//tests getting the row from a loc
	@Test
	void testGetRow2() {
		assertEquals(Movement.getX("L7"), 11);
	}
	
	//tests the is next to enemy function
	@Test
	void testIsNextToEnemy() {
		Hero cap = new Hero("Captain America", false);
		Hero enemyCap = new Hero("Captain America", true);
		
		cap.setLoc("A1");
		enemyCap.setLoc("B1");
		List<Hero> enemies = new ArrayList<Hero>();
		enemies.add(enemyCap);
		assertTrue(Movement.isNextToEnemy(cap.getName(), enemies, t));
	}
}
