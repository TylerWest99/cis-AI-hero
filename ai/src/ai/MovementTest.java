package ai;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import junit.framework.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class MovementTest {
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
	
	//tests converting id in "00" form to loc form "A1"
	@Test
	void testGetName() {
		assertEquals(Movement.getName("00"), "A1");
	}
	
	@Test
	void testGetName2() {
		assertEquals(Movement.getName("86"), "G9");
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

	@Test
	void testGetMoves1() {
		List<String> list = Movement.getMoves1(Movement.getY("D4"), Movement.getX("D4"), t);
		List<String> correct = new ArrayList<String>(Arrays.asList("C4", "C3", "D3"));
		int count = 0;
		String s = "";
		for(int i = 0; i < list.size(); i++) {
			s = list.get(i);
			if(Movement.isInList(correct, s)) {
				count++;
			}
		}
		assertTrue(count == correct.size());
	}

	@Test
	void testGetMovesFromList() {
		
	}

	@Test
	void testGetAllMoves() {
		
	}

}
