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
		
		g.setLocs(g.cap, g.ironMan, g.thor, "A1", "A3", "A4");
		g.setLocs(g.enemyCap, g.enemyIronMan, g.enemyThor, "I7", "I9", "C1");
		
		List<Hero> enemies = g.getAllEnemies();
		List<String> moves = Movement.getAllMoves(g.cap, t, enemies);
		List<String> empty = new ArrayList<String>();
		List<String> attackLane = Movement.getEastLane("A1", 10, t);
		
		for(int i = 0; i < attackLane.size(); i++) {
			print(attackLane.get(i));
		}
		print(attackLane.size());
		
		
		
		

	}
}
