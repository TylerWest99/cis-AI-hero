package ai;
import java.util.*;

public class Game {
	//makes all the game heros 
	Hero cap;
	Hero ironMan;
	Hero thor;
	
	Hero enemyCap;
	Hero enemyIronMan;
	Hero enemyThor;
	
		public Game() {
			cap = new Hero("Captain America", false);
			ironMan = new Hero("Iron Man", false);
			thor = new Hero("Thor", false);
			
			enemyCap = new Hero("Captain America", true);
			enemyIronMan = new Hero("Iron Man", true);
			enemyThor = new Hero("Thor", true);
		}
		
		//sets locations for any of the two hero sets
		public void setLocs(Hero cap, Hero ironMan, Hero thor, String capLoc, String ironLoc, String thorLoc) {
			cap.setLoc(capLoc);
			ironMan.setLoc(ironLoc);
			thor.setLoc(thorLoc);
		}
		
		public List<Hero> getAllEnemies() {
			List<Hero> enemies = new ArrayList<Hero>();
			enemies.add(enemyCap);
			enemies.add(enemyIronMan);
			enemies.add(enemyThor);
			return enemies;
		}
		
	
}
