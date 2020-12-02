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
	Random r;
	
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
			r = new Random();
		}
		
		public boolean isHero(Hero h) {
			if(h.getIsEnemy()) {
				return false;
			}else {
				return true;
			}
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
		
		//ways to add action tokens for each
		public void capAddToken() {
			cap.addActionToken();
		}
		public void ironAddToken() {
			ironMan.addActionToken();
		}
		public void thorAddToken() {
			thor.addActionToken();
		}
		public void enemyCapAddToken() {
			enemyCap.addActionToken();
		}
		public void enemyIronAddToken() {
			enemyIronMan.addActionToken();
		}
		public void enemyThorAddToken() {
			enemyThor.addActionToken();
		}
		
		//ways to add click to each
		public void capAddClick() {
			cap.addClick();
		}
		public void ironAddClick() {
			ironMan.addClick();
		}
		public void thorAddClick() {
			thor.addClick();
		}
		public void enemyCapAddClick() {
			enemyCap.addClick();
		}
		public void enemyIronAddClick() {
			enemyIronMan.addClick();
		}
		public void enemyThorAddClick() {
			enemyThor.addClick();
		}
		
		//gets all moves for a hero used to get all moves for a single hero
		private List<Move> getAllMoves(List<String> moves, List<String> attacks){
			List<String> allMoves = new ArrayList<String>(); 
			List<Move> allMoves2 = new ArrayList<Move>(); 
			for(int i = 0; i < moves.size(); i++) {
				allMoves.add("move: " + moves.get(i));
			}
			for(int i = 0; i < attacks.size(); i++) {
				allMoves.add("attack: " + attacks.get(i));
			}
			allMoves.add("Clear actions");
			for(int i = 0; i < allMoves.size(); i++) {
				Move m = new Move(allMoves.get(i), 0);
				allMoves2.add(m);
			}
			return allMoves2;
		}
		
		//gets all moves for captain 
		private List<Move> getCapMoves(){
			List<String> capMoves = Movement.getAllMoves(cap, enemies, t);
			List<String> capAttacks = Movement.getAttacks(cap, enemies, t);
			return getAllMoves(capMoves, capAttacks);
		}
		
		//gets all moves for iron man 
		private List<Move> getIronMoves(){
			List<String> ironMoves = Movement.getAllMoves(ironMan, enemies, t);
			List<String> ironAttacks = Movement.getAttacks(ironMan, enemies, t);
			return getAllMoves(ironMoves, ironAttacks);
		}
		
		//gets all moves for thor
		private List<Move> getThorMoves(){
			List<String> thorMoves = Movement.getAllMoves(thor, enemies, t);
			List<String> thorAttacks = Movement.getAttacks(thor, enemies, t);
			return getAllMoves(thorMoves, thorAttacks);
		}
		
		//gets enemy moves
		//gets all moves for enemy captain
		private List<Move> getEnemyCapMoves(){
			List<String> capMoves = Movement.getAllMoves(enemyCap, enemies, t);
			List<String> capAttacks = Movement.getAttacks(enemyCap, enemies, t);
			return getAllMoves(capMoves, capAttacks);
		}
		
		//gets all moves for enemy iron man 
		public List<Move> getEnemyIronMoves(){
			List<String> ironMoves = Movement.getAllMoves(enemyIronMan, enemies, t);
			List<String> ironAttacks = Movement.getAttacks(enemyIronMan, enemies, t);
			return getAllMoves(ironMoves, ironAttacks);
		}
		
		//gets all moves for enemy thor
		private List<Move> getEnemyThorMoves(){
			List<String> thorMoves = Movement.getAllMoves(enemyThor, enemies, t);
			List<String> thorAttacks = Movement.getAttacks(enemyThor, enemies, t);
			return getAllMoves(thorMoves, thorAttacks);
		}
		
		//gets moves for a hero
		public List<Move> getMoves(Hero h) {
			//makes moves to be ranked
			List<Move> moves = new ArrayList<Move>();
			
			//if friendly set moves
			if(h.getName().equalsIgnoreCase("Captain America") && !h.getIsEnemy()) {
				moves = getCapMoves();
			}
			if(h.getName().equalsIgnoreCase("Iron Man") && !h.getIsEnemy()) {
				moves = getIronMoves();
			}
			if(h.getName().equalsIgnoreCase("Thor") && !h.getIsEnemy()) {
				moves = getThorMoves();
			}
			
			//sets enemy moves
			if(h.getName().equalsIgnoreCase("Captain America") && h.getIsEnemy()) {
				moves = getEnemyCapMoves();
			}
			if(h.getName().equalsIgnoreCase("Iron Man") && h.getIsEnemy()) {
				moves = getEnemyIronMoves();
			}
			if(h.getName().equalsIgnoreCase("Thor") && h.getIsEnemy()) {
				moves = getEnemyThorMoves();
			}
			
			return moves;
		}
		
		public boolean isAnAttack(String s) {
			if(s.length() >= 10 && s.length()!= 13){
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean isAMove(String s) {
			if(s.length() < 10) {
				return true;
			}else {
				return false;
			}
		}
		
		//important method that sees if this hero can be attacked by enemies
		//will be useful for attacking if I can attack and they cannot and for running away
		public boolean inSightOfEnemies(Hero h, Board t) {
			List<Hero> allies = new ArrayList<Hero>();
			List<Hero> foes = new ArrayList<Hero>();
			List<String> allEnemyMoves = new ArrayList<String>();
			//if enemy allies are enemies and foes are heros
			if(h.getIsEnemy()) {
				allies = enemies;
				foes = heros;
			//if hero allies are heros and foes are enemies
			}else {
				allies = heros;
				foes = enemies;
			}
			//goes through each foe
			for(int i = 0; i < foes.size(); i++) {
				Hero foe = foes.get(i);
				List<String> tempList = Movement.getAllPossibleAttacks(foe, t);
				//makes a list of all possible attacks for that foe
				for(int j = 0; j < tempList.size(); j++) {
					//if not in the allEnemyMoves list adds it
					if(!Movement.isInList(allEnemyMoves, tempList.get(j))) {
						allEnemyMoves.add(tempList.get(j));
					}
				}
			}
			return Movement.isInList(allEnemyMoves, h.getLoc());
		}
		
		public boolean inSightOfEnemiesString(Hero h, Board t, String s) {
			List<Hero> allies = new ArrayList<Hero>();
			List<Hero> foes = new ArrayList<Hero>();
			List<String> allEnemyMoves = new ArrayList<String>();
			//if enemy allies are enemies and foes are heros
			if(h.getIsEnemy()) {
				allies = enemies;
				foes = heros;
			//if hero allies are heros and foes are enemies
			}else {
				allies = heros;
				foes = enemies;
			}
			//goes through each foe
			for(int i = 0; i < foes.size(); i++) {
				Hero foe = foes.get(i);
				List<String> tempList = Movement.getAllPossibleAttacks(foe, t);
				//makes a list of all possible attacks for that foe
				for(int j = 0; j < tempList.size(); j++) {
					//if not in the allEnemyMoves list adds it
					if(!Movement.isInList(allEnemyMoves, tempList.get(j))) {
						allEnemyMoves.add(tempList.get(j));
					}
				}
			}
			return Movement.isInList(allEnemyMoves, s);
		}
		
		
		public List<Move> rankMoves (Hero h, Board t) {
			List<Move> allMoves = getMoves(h);
			List<Hero> allies = new ArrayList<Hero>();
			List<Hero> foes = new ArrayList<Hero>();
			
			//sets the allies and foes
			if(h.getIsEnemy()) {
				allies = enemies;
				foes = heros;
			//if hero allies are heros and foes are enemies
			}else {
				allies = heros;
				foes = enemies;
			}
			
			Hero foe1 = foes.get(0);
			Hero foe2 = foes.get(1);
			Hero foe3 = foes.get(2);
			
			String enemyLoc1 = foes.get(0).getLoc();
			String enemyLoc2 = foes.get(1).getLoc();
			String enemyLoc3 = foes.get(2).getLoc();
			
			//goes through every move and edits score variable to track how good a move is 
			for(int i = 0; i < allMoves.size(); i++) {
				String s = allMoves.get(i).getAction();
				
				//sets the clear actions score depending on how many action tokens a hero has 
				if(s.equalsIgnoreCase("Clear actions") && h.getActionTokens() == 2) {
					allMoves.get(i).setScore(1000000);
				}
				else if(s.equalsIgnoreCase("Clear actions") && h.getActionTokens() == 1) {
					allMoves.get(i).setScore(100);
				}
				else if(s.equalsIgnoreCase("Clear actions") && h.getActionTokens() == 0) {
					allMoves.get(i).setScore(-1000000);
				}
				
				//bonuses to attack moves
				if(isAnAttack(s)) {
					int length = s.length();
					String enemyLoc;
					if(length == 10) {
						enemyLoc = s.substring(8,10);
					}
					else if(length == 11) {
						enemyLoc = s.substring(8,11);
					}
					else {
						enemyLoc = "";
					}
					//gets +500 if enemy cannot attack -50 if has a action token
					if(!inSightOfEnemies(h,t)) {
						allMoves.get(i).addToScore(500);
						if(h.getActionTokens() == 1) {
							allMoves.get(i).addToScore(-50);
						}
					}
					//points awarded if the enemy has action tokens 
					if((foe1.getActionTokens() == 2 || foe2.getActionTokens() == 2 || foe3.getActionTokens() == 2) || (foe1.getActionTokens() == 1 || foe2.getActionTokens() == 1 || foe3.getActionTokens() == 1)) {
						//if enemy that our hero will attack has 2 action attack them
						if((foe1.getLoc().equals(enemyLoc) && foe1.getActionTokens() ==2) || (foe2.getLoc().equals(enemyLoc) && foe2.getActionTokens() ==2) || (foe3.getLoc().equals(enemyLoc) && foe3.getActionTokens() ==2)) {
							allMoves.get(i).addToScore(500);
						}
						//if the enemy that we could attack has an action token more point to attack but less than if it was 2 action tokens
						if((foe1.getLoc().equals(enemyLoc) && foe1.getActionTokens() ==1) || (foe2.getLoc().equals(enemyLoc) && foe2.getActionTokens() ==1) || (foe3.getLoc().equals(enemyLoc) && foe3.getActionTokens() ==1)) {
							allMoves.get(i).addToScore(150);
						}
						if((foe1.getLoc().equals(enemyLoc) && foe1.getActionTokens() ==0) || (foe2.getLoc().equals(enemyLoc) && foe2.getActionTokens() ==0) || (foe3.getLoc().equals(enemyLoc) && foe3.getActionTokens() ==0)) {
							allMoves.get(i).addToScore(-100);
						}
						
					}
					
					//gets +250 if attacking a weak enemy or +100 for attacking a strong enemy -100 if they already have an action token
					if(s.substring(8, s.length()).equalsIgnoreCase(enemyLoc1)){
						//weak enemy
						if(foe1.getClick() >= foe1.totalClicks / 2) {
							allMoves.get(i).addToScore(250);
						}else {
							allMoves.get(i).addToScore(150);
						}
						if(h.getActionTokens() == 1) {
							allMoves.get(i).addToScore(-100);
						}
					}
					if(s.substring(8, s.length()).equalsIgnoreCase(enemyLoc2)){
						//weak enemy
						if(foe1.getClick() >= foe2.totalClicks / 2) {
							allMoves.get(i).addToScore(250);
						}else {
							allMoves.get(i).addToScore(150);
						}
						if(h.getActionTokens() == 1) {
							allMoves.get(i).addToScore(-100);
						}
					}
					if(s.substring(8, s.length()).equalsIgnoreCase(enemyLoc3)){
						//weak enemy
						if(foe1.getClick() >= foe3.totalClicks / 2) {
							allMoves.get(i).addToScore(250);
						}else {
							allMoves.get(i).addToScore(150);
						}
						if(h.getActionTokens() == 1) {
							allMoves.get(i).addToScore(-100);
						}
					}
				}
				
				if(isAMove(s)) {
					if(inSightOfEnemies(h,t)) {
						//if move is out of range to attack gives +200
						if(!inSightOfEnemiesString(h,t,(s.substring(6, s.length())))) {
							allMoves.get(i).addToScore(200);
						}
						//if move is in range -250
						if(inSightOfEnemiesString(h,t,(s.substring(6, s.length())))) {
							allMoves.get(i).addToScore(-250);
						}
					}
				}
			}
			for(int i = 0; i < allMoves.size(); i++) {
				allMoves.get(i).addToScore(r.nextInt(16));
			}
			return allMoves;
		}
		
		public Move findHighestMove(Hero h, Board t) {
			List<Move> movesWithScores = rankMoves(h,t);
			int highestScore = -100000;
			Move bestMove = new Move("", 0); 
			for(int i = 0; i < movesWithScores.size(); i++) {
				if(movesWithScores.get(i).getScore() > highestScore) {
					bestMove = movesWithScores.get(i);
					highestScore = bestMove.getScore();
				}
			}
			return bestMove;
		}
		
		public void printBestMove(Hero h, Board t) {
			System.out.println(findHighestMove(h,t).getAction());
		}
		
}	

