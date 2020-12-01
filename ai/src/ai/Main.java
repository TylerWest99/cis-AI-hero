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
		Game g = new Game();
		g.setLocs(g.cap, g.ironMan, g.thor, "A1", "P15", "P14");
		g.setLocs(g.enemyCap, g.enemyIronMan, g.enemyThor, "A2", "P13", "P12");
		//g.rankMoves(g.cap);
		List<String> allEnemyAttacks = g.inSightsOfEnemies(g.cap, g.t);
		for(int i = 0; i < allEnemyAttacks.size(); i++) {
			print(allEnemyAttacks.get(i));
		}

		
		
		//gets team one moves
		
	

		
		
		

	}
}
