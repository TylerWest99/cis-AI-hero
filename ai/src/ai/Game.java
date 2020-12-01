package ai;
import java.util.*;

//class Game that talks to movement and hero to get simplified game info to be used by Gui and displayed to user 
public class Game {
	//makes all the game heros 
	Hero cap;
	Hero ironMan;
	Hero thor;
	
	Hero enemyCap;
	Hero enemyIronMan;
	Hero enemyThor;
	
	List<Hero> enemies;
	List<Hero> heros;
	
	Board t;
	
		public Game() {
			t = new Board();
			t.createMap();
			heros = new ArrayList<Hero>();
			enemies = new ArrayList<Hero>();
			cap = new Hero("Captain America", false);
			ironMan = new Hero("Iron Man", false);
			thor = new Hero("Thor", false);
			heros.add(cap);
			heros.add(ironMan);
			heros.add(thor);
			
			enemyCap = new Hero("Captain America", true);
			enemyIronMan = new Hero("Iron Man", true);
			enemyThor = new Hero("Thor", true);
			enemies.add(enemyCap);
			enemies.add(enemyIronMan);
			enemies.add(enemyThor);
		}
		
		//sets locations for any of the two hero sets
		public void setLocs(Hero cap, Hero ironMan, Hero thor, String capLoc, String ironLoc, String thorLoc) {
			cap.setLoc(capLoc);
			ironMan.setLoc(ironLoc);
			thor.setLoc(thorLoc);
		}
		
		//individual hero and enemy location setters
		public void setLocCap(String loc) {
			cap.setLoc(loc);
		}
		
		public void setLocIron(String loc) {
			ironMan.setLoc(loc);
		}
		
		public void setLocThor(String loc) {
			thor.setLoc(loc);
		}
		
		//for enemy
		public void setLocEnemyCap(String loc) {
			enemyCap.setLoc(loc);
		}
		
		public void setLocEnemyIron(String loc) {
			enemyIronMan.setLoc(loc);
		}
		
		public void setLocEnemyThor(String loc) {
			enemyThor.setLoc(loc);
		}

		
		//gets all moves for a hero used to get all moves for a single hero
		private List<Move> getAllMoves(List<String> moves, List<String> attacks){
			List<String> allMoves = new ArrayList<String>(); 
			List<Move> allMoves2 = new ArrayList<Move>(); 
			for(int i = 0; i < moves.size(); i++) {
				allMoves.add("move: " + moves.get(i));
			}
			for(int i = 0; i < attacks.size(); i++) {
				allMoves.add("attacks: " + attacks.get(i));
			}
			allMoves.add("Clear actions");
			for(int i = 0; i < allMoves.size(); i++) {
				Move m = new Move(allMoves.get(i), 0);
				allMoves2.add(m);
			}
			return allMoves2;
		}
		
		//gets all moves for captain 
		public List<Move> getCapMoves(){
			List<String> capMoves = Movement.getAllMoves(cap, enemies, t);
			List<String> capAttacks = Movement.getAttacks(cap, enemies, t);
			return getAllMoves(capMoves, capAttacks);
		}
		
		//gets all moves for iron man 
		public List<Move> getIronMoves(){
			List<String> ironMoves = Movement.getAllMoves(ironMan, enemies, t);
			List<String> ironAttacks = Movement.getAttacks(ironMan, enemies, t);
			return getAllMoves(ironMoves, ironAttacks);
		}
		
		//gets all moves for thor
		public List<Move> getThorMoves(){
			List<String> thorMoves = Movement.getAllMoves(thor, enemies, t);
			List<String> thorAttacks = Movement.getAttacks(thor, enemies, t);
			return getAllMoves(thorMoves, thorAttacks);
		}
		
		//still gotta do a get all moves from enemies
}		
		//More code 
		//and add a way for game to know num action tokens and update click
