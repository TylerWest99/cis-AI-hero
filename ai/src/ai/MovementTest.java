package ai;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
		assertEquals(Movement.getY("D14"), 13);
	}
	
	//tests getting the column from a loc
	@Test
	void testGetCol2() {
		assertEquals(Movement.getY("L7"), 6);
	}

	//tests getting the row from a loc
	@Test
	void testGetRow() {
		assertEquals(Movement.getX("D14"), 3);
	}
	
	//tests getting the row from a loc
	@Test
	void testGetRow2() {
		assertEquals(Movement.getX("L7"), 11);
	}

	//tests is in list function
	@Test
	void testIsInListTrue() {
		List<String> list = new ArrayList<String>(Arrays.asList("A1", "A2", "A3"));
		assertTrue(Movement.isInList(list, "A1"));
	}
	
	@Test
	void testIsInListFalse() {
		List<String> list = new ArrayList<String>(Arrays.asList("A1", "A2", "A3"));
		assertFalse(Movement.isInList(list, "A4"));
	}
	
	//test directions functionality
	//errors with goE and goW I think
	@Test
	void testE() {
		String id;
		id = Movement.goE(1, 12, t);
		assertTrue(id.equals("N2"));
	}
	

}