package ai;
import java.util.*;

public class Main {
	
	//just some helper printing methods because I am used to Python
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void print(int s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		//initialization stuff
		Board t = new Board();
		t.createMap();
		Game g = new Game();
		
		//sets both team locations
		g.setLocs(g.cap, g.ironMan, g.thor, "A1", "E16", "E16");
		g.setLocs(g.enemyCap, g.enemyIronMan, g.enemyThor, "A3", "B5", "P16");
		
		//gets team one moves
		List<Move> capMoves = g.getCapMoves();
		List<Move> ironManMoves = g.getIronMoves();
		List<Move> thorMoves = g.getThorMoves();
		
		for(int i = 0; i < thorMoves.size(); i++) {
			print(thorMoves.get(i).getSpot());
			print(thorMoves.get(i).getScore());
		}
		
		
		
		

	}
}
