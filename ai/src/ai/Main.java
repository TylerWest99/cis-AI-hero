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
		g.setLocs(g.enemyCap, g.enemyIronMan, g.enemyThor, "A2", "B2", "B1");
		
		List<Hero> enemies = g.getAllEnemies();
		List<String> moves = Movement.getAllMoves(g.cap, t, enemies);
		
		for( int i = 0; i < moves.size(); i++) {
			print(moves.get(i));
		}
		print(moves.size());
		
		

	}
}
