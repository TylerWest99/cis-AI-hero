package ai;
import java.util.*;

public class Movement {
	
	//list for all water spots on the board
	static List<String> waterSpots = new ArrayList<String>(Arrays.asList("D10", "D11", "D12", "E10", "E0", "E8", "E1", "F1", "F9", "G1", "G2", "G3", "G7", "G8",
			"G9", "H10", "H7", "H6", "H5", "H4", "H3", "I3", "I4", "I5", "I7", "I10", "I11", "J14", "J13", "J12", "J10", "J9", "J8", "J3", "J2", "J1", "K1",
			"K14", "L1", "L14", "L15"));

	//returns if a location is water
	public static boolean isInWater(String loc) {
		for(int i = 0; i < waterSpots.size(); i++) {
			if(loc.equals(waterSpots.get(i))){
				return true;
			}
		}
		return false;
	}
	
	//returns true if enemy is within a bloom
	//used later to kill bloom if in range of a enemy
	public static boolean isNextToEnemy(String h, List<Hero> enemies, Board t) {
		//gets hero location
		//String loc = h.getLoc();
		int x = getX(h);
		int y = getY(h);
		//gets surrounds of a hero
		List<String> surrounds = bloom(y,x,t);
		for(int i = 0; i < surrounds.size(); i++) {
			//a surrounding spot of loc
			String surroundSpot = surrounds.get(i);
			for(int k = 0; k < enemies.size(); k++) {
				//enemy location
				String enemyLoc = enemies.get(k).getLoc();
				if(surroundSpot.equalsIgnoreCase(enemyLoc)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//is in list function sees if a string is in a list or not
	public static boolean isInList(List<String> list, String s) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	//Goes east
	public static String goE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].e;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			return getName(tmpCol, tmpRow);
		}
		return "None";
	}
			
	//Goes west
	public static String goW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].w;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			return getName(tmpCol, tmpRow);
		}
		return "None";
	}
			
	//Goes north
	public static String goN(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].n;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			return getName(tmpCol, tmpRow);
		}
		return "None";
	}
			
	//Goes south
	public static String goS(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].s;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			return getName(tmpCol, tmpRow);
		}
		return "None";
	}
			
	//Goes north east
	public static String goNE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].ne;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			return getName(tmpCol, tmpRow);
		}
		return "None";
	}
			
	//Goes south east
	public static String goSE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].se;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			return getName(tmpCol, tmpRow);
		}
		return "None";
	}
			
	//Goes south west
	public static String goSW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].sw;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			return getName(tmpCol, tmpRow);
		}
		return "None";
	}
			
	//Goes north west
	public static String goNW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].nw;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			return getName(tmpCol, tmpRow);
		}
		return "None";
	}
	
	//takes in a id position string "YX" y is up down x is left right
	//method gets and returns new string name id with A1, B2, A4, etc format
	//Y is row X is col
	//Returns string version of position id
	//this function has errors if size is 3 and starts with 1
	public static String getName(int y, int x) {
		String name;
		String rows = Integer.toString(x);
		String cols = Integer.toString(y);

		String col2 = "";
		String row2 = "";
		String[] lettersArray = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
		String[] numsArray = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
			
		for(int i = 0; i < lettersArray.length; i++) {
			String index = String.valueOf(i);
			if(index.equals(cols)) {
				col2 = lettersArray[i];
			}
		}
		for(int j = 0; j < numsArray.length; j++) {
			String index2 = String.valueOf(j);
			if(index2.equals(rows)) {
				row2 = numsArray[j];
			}
		}
		name = col2 + row2;
		return name;
	}
	
	//gets the column in int form from an loc string
	public static int getY(String loc) {
		String colChar = "";
		int colInt = 0;
		if(loc.length() == 2) {
			colChar = loc.substring(1);
			colInt = Integer.parseInt(colChar)-1;
		}
		if(loc.length() == 3) {
			if(loc.charAt(0) == '1') {
				colChar = loc.substring(2,3);
				colInt = Integer.parseInt(colChar)-1;
			}else {
				colChar = loc.substring(1,3);
				colInt = Integer.parseInt(colChar)-1;
			}
		}
		return colInt;
	}
		
	//gets the row in int form from an loc string
	public static int getX(String loc) {
		String rowChar = "";
		int rowInt = 0;
		String[] lettersArray = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
		rowChar = loc.substring(0,1);
		for(int i = 0; i < lettersArray.length; i++) {
			if(rowChar.equals(lettersArray[i])) {
				rowInt = i;
			}
		}
		return rowInt;
	}
	
	//returns list of moves within 1 square range
	//basically a bloom out in dfs but only one of them
	//PUT IN Y,X format row = y col = x
	public static List<String> bloom(int y, int x, Board t) {
		List<String> moves = new ArrayList<String>();
		List<String> directions = new ArrayList<String>();
		
		//each pos id around a square in string format
		String N = goN(y,x, t);
		String S = goS(y,x,t);
		String E = goE(y,x,t);
		String W = goW(y,x,t);
		String NW = goNW(y,x,t);
		String NE = goNE(y,x,t);
		String SW = goSW(y,x,t);
		String SE = goSE(y,x,t);
		
		directions.add(N);
		directions.add(S);
		directions.add(E);
		directions.add(W);
		directions.add(NE);
		directions.add(NW);
		directions.add(SE);
		directions.add(SW);
		
		for(int i = 0; i < directions.size(); i++) {
			if(directions.get(i).length() != 0 && directions.get(i).length() != 4) {
				moves.add(directions.get(i));	
			}
		}
		return moves;
	}
	
	//WORKING ON THIS FOR STOPPING NEAR ENEMY 
	//takes in a list of moves and gets all around each of them
	public static List<String> getMovesFromList(List<String> list, List<Hero> enemies, Board t, Hero h, boolean startedInWater) {
		List<String> moves = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		int x;
		int y;
		String s;
		String v;
		boolean waterSpot;
		
		for(int i = 0; i< list.size(); i++) {

			s = list.get(i);
		 	waterSpot = isInWater(s);
			
		 	x = getX(s);
			y = getY(s);
			
			//if next to enemy cant keep moving
			if(isNextToEnemy(s, enemies, t)) {
				//does nothing
			}
			//if name is not captain america or if started in water do nothing different 
			else if(!h.getName().equalsIgnoreCase("Captain America") || startedInWater) {
				temp = bloom(y,x,t);
				for(int k = 0; k < temp.size(); k++) {
					v = temp.get(k);
					if(!isInList(moves, v)) {
						moves.add(v);
					}
				}
			}
			//if captain is hero then water stops blooming
			else if(h.getName().equalsIgnoreCase("Captain America")) {
				if(!waterSpot) {
						temp = bloom(y,x,t);
						for(int k = 0; k < temp.size(); k++) {
							v = temp.get(k);
							if(!isInList(moves, v)) {
								moves.add(v);
							}
						}
				}
			}
		}
		return moves;
	}
	//gets all the moves in a set distance using a loc string ex A1 and a distance number like 8
	//eventually goal is to remove dist and use hero class to access move dist
	public static List<String> getAllMoves (Hero h, List<Hero> enemies, Board t){
		List<String> allMoves = new ArrayList<String>();
		String loc = h.getLoc();
		int dist = h.getMove();
		int x = getX(loc);
		int y = getY(loc);
		boolean startedInWater = isInWater(loc);
		List<String> firstMoves = bloom(y,x,t);
		if(startedInWater && h.getName().equalsIgnoreCase("Captain America")) {
			dist = dist / 2;
		}
		allMoves = bloom(y, x, t);
		dist = dist -1;
		
		for(int i = 0; i < dist; i++) {
			allMoves = getMovesFromList(allMoves, enemies, t, h, startedInWater);
		}
		//adds start point if not in 
		if(!isInList(allMoves, loc)) {
			allMoves.add(loc);
		}
		//adds first bloom if not in 
		for(int j = 0; j < firstMoves.size(); j++) {
			String s = firstMoves.get(j);
			if(!isInList(allMoves, s)) {
				allMoves.add(s);
			}
		}
		for(int k = 0; k < enemies.size(); k++) {
			String s = enemies.get(k).getLoc();
			allMoves.remove(new String(s));
		}
		
		return allMoves;
	}
	
	//helper methods to move one spot only one direction for eventual attacking
	public static String getWestOne(int y, int x, Board t) {
		String s = goW(y,x,t);
		return s;
	}
	public static String getEastOne(int y, int x, Board t) {
		String s = goE(y,x,t);
		return s;
	}
	public static String getSouthOne(int y, int x, Board t) {
		String s = goS(y,x,t);
		return s;
	}
	public static String getNorthOne(int y, int x, Board t) {
		String s = goN(y,x,t);
		return s;
	}
	public static String getSouthWestOne(int y, int x, Board t) {
		String s = goSW(y,x,t);
		return s;
	}
	public static String getNorthWestOne(int y, int x, Board t) {
		String s = goNW(y,x,t);
		return s;
	}
	public static String getSouthEastOne(int y, int x, Board t) {
		String s = goSE(y,x,t);
		return s;
	}
	public static String getNorthEastOne(int y, int x, Board t) {
		String s = goNE(y,x,t);
		return s;
	}
	
	//helper methods that get a lane in a direction
	//east lane
	public static List<String> getEastLane(String loc, int range, Board t, String e1, String e2, String e3){
		List<String> list = new ArrayList<String>();
		int x = getX(loc);
		int y = getY(loc);
		String s;
		for(int i = 0; i < range; i++) {
			s = goE(y,x,t);
			if(!s.equals("None")) {
				list.add(s);
				if(s.equals(e1) || s.equals(e2) || s.equals(e3)) {
					i = range;
				}
			}else {
				i = range;
			}
			x = getX(s);
			y = getY(s);
		}
		return list;
	}
	//west lane
	public static List<String> getWestLane(String loc, int range, Board t,String e1, String e2, String e3){
		List<String> list = new ArrayList<String>();
		int x = getX(loc);
		int y = getY(loc);
		String s;
		for(int i = 0; i < range; i++) {
			s = goW(y,x,t);
			if(!s.equals("None")) {
				list.add(s);
				if(s.equals(e1) || s.equals(e2) || s.equals(e3)) {
					i = range;
				}
			}else {
				i = range;
			}
			x = getX(s);
			y = getY(s);
		}
		return list;
	}
	
	//north lane
	public static List<String> getNorthLane(String loc, int range, Board t, String e1, String e2, String e3){
		List<String> list = new ArrayList<String>();
		int x = getX(loc);
		int y = getY(loc);
		String s;
		for(int i = 0; i < range; i++) {
			s = goN(y,x,t);
			if(!s.equals("None")) {
				list.add(s);
				if(s.equals(e1) || s.equals(e2) || s.equals(e3)) {
					i = range;
				}
			}else {
				i = range;
			}
			x = getX(s);
			y = getY(s);
		}
		return list;
	}
	
	//South lane
	public static List<String> getSouthLane(String loc, int range, Board t, String e1, String e2, String e3){
		List<String> list = new ArrayList<String>();
		int x = getX(loc);
		int y = getY(loc);
		String s;
		for(int i = 0; i < range; i++) {
			s = goS(y,x,t);
			if(!s.equals("None")) {
				list.add(s);
				if(s.equals(e1) || s.equals(e2) || s.equals(e3)) {
					i = range;
				}
			}else {
				i = range;
			}
			x = getX(s);
			y = getY(s);
		}
		return list;
	}
	
	//SouthEast lane
	public static List<String> getSouthEastLane(String loc, int range, Board t, String e1, String e2, String e3){
		List<String> list = new ArrayList<String>();
		int x = getX(loc);
		int y = getY(loc);
		String s;
		for(int i = 0; i < range; i++) {
			s = goSE(y,x,t);
			if(!s.equals("None")) {
				list.add(s);
				if(s.equals(e1) || s.equals(e2) || s.equals(e3)) {
					i = range;
				}
			}else {
				i = range;
			}
			x = getX(s);
			y = getY(s);
		}
		return list;
	}
	
	//SouthWest lane
	public static List<String> getSouthWestLane(String loc, int range, Board t, String e1, String e2, String e3){
		List<String> list = new ArrayList<String>();
		int x = getX(loc);
		int y = getY(loc);
		String s;
		for(int i = 0; i < range; i++) {
			s = goSW(y,x,t);
			if(!s.equals("None")) {
				list.add(s);
				if(s.equals(e1) || s.equals(e2) || s.equals(e3)) {
					i = range;
				}
			}else {
				i = range;
			}
			x = getX(s);
			y = getY(s);
		}
		return list;
	}
	
	//North East lane
	public static List<String> getNorthEastLane(String loc, int range, Board t, String e1, String e2, String e3){
		List<String> list = new ArrayList<String>();
		int x = getX(loc);
		int y = getY(loc);
		String s;
		for(int i = 0; i < range; i++) {
			s = goNE(y,x,t);
			if(!s.equals("None")) {
				list.add(s);
				if(s.equals(e1) || s.equals(e2) || s.equals(e3)) {
					i = range;
				}
			}else {
				i = range;
			}
			x = getX(s);
			y = getY(s);
		}
		return list;
	}
	
	//North west lane
	public static List<String> getNorthWestLane(String loc, int range, Board t, String e1, String e2, String e3){
		List<String> list = new ArrayList<String>();
		int x = getX(loc);
		int y = getY(loc);
		String s;
		for(int i = 0; i < range; i++) {
			s = goNW(y,x,t);
			if(!s.equals("None")) {
				list.add(s);
				if(s.equals(e1) || s.equals(e2) || s.equals(e3)) {
					i = range;
				}
			}else {
				i = range;
			}
			x = getX(s);
			y = getY(s);
		}
		return list;
	}
	
	//returns a list of all spots a hero in a location could possibly attack
	public static List<String> getAttacks(Hero h, List<Hero> enemies, Board t) {
		List<String> allPossibleAttacks = new ArrayList<String>();
		List<String> attacks = new ArrayList<String>();
		String loc = h.getLoc();
		int range = h.getRange();
		String eLoc1 = enemies.get(0).getLoc();
		String eLoc2 = enemies.get(1).getLoc();
		String eLoc3 = enemies.get(2).getLoc();
		
		List<String> west = getWestLane(loc,range,t, eLoc1, eLoc2, eLoc3);
		List<String> east = getEastLane(loc,range,t, eLoc1, eLoc2, eLoc3);
		List<String> south = getSouthLane(loc,range,t, eLoc1, eLoc2, eLoc3);
		List<String> north = getNorthLane(loc,range,t, eLoc1, eLoc2, eLoc3);
		List<String> northWest = getNorthWestLane(loc,range,t, eLoc1, eLoc2, eLoc3);
		List<String> southWest = getSouthWestLane(loc,range,t, eLoc1, eLoc2, eLoc3);
		List<String> northEast= getNorthEastLane(loc,range,t, eLoc1, eLoc2, eLoc3);
		List<String> southEast = getSouthEastLane(loc,range,t, eLoc1, eLoc2, eLoc3);
		
		//combines all lanes into all possible attacks
		for(int i = 0; i < west.size(); i++) {
			allPossibleAttacks.add(west.get(i));
		}
		for(int i = 0; i < east.size(); i++) {
			allPossibleAttacks.add(east.get(i));
		}
		for(int i = 0; i < south.size(); i++) {
			allPossibleAttacks.add(south.get(i));
		}
		for(int i = 0; i < north.size(); i++) {
			allPossibleAttacks.add(north.get(i));
		}
		for(int i = 0; i < southWest.size(); i++) {
			allPossibleAttacks.add(southWest.get(i));
		}
		for(int i = 0; i < northWest.size(); i++) {
			allPossibleAttacks.add(northWest.get(i));
		}
		for(int i = 0; i < southEast.size(); i++) {
			allPossibleAttacks.add(southEast.get(i));
		}
		for(int i = 0; i < northEast.size(); i++) {
			allPossibleAttacks.add(northEast.get(i));
		}
		for(int k = 0; k < allPossibleAttacks.size(); k++){
			String s = allPossibleAttacks.get(k);
			if(s.equalsIgnoreCase(eLoc1) || s.equalsIgnoreCase(eLoc2) || s.equalsIgnoreCase(eLoc3)) {
				attacks.add(s);
			}
		}
		return attacks;
	}
}
