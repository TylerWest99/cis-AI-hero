package ai;
import java.util.*;

public class Movement {
	
	
	//Goes east
	static String goE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].e;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			pos = Integer.toString(tmpRow)+Integer.toString(tmpCol);
		}
		return getName(pos);
	}
			
	//Goes west
	static String goW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].w;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
		pos = Integer.toString(tmpRow)+Integer.toString(tmpCol);
		}
		return getName(pos);
	}
			
	//Goes north
	static String goN(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].n;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			pos = Integer.toString(tmpRow)+Integer.toString(tmpCol);
		}
		return getName(pos);
	}
			
	//Goes south
	static String goS(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].s;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			pos = Integer.toString(tmpRow)+Integer.toString(tmpCol);
		}
		return getName(pos);
	}
			
	//Goes north east
	static String goNE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].ne;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			pos = Integer.toString(tmpRow)+Integer.toString(tmpCol);
		}
		return getName(pos);
	}
			
	//Goes south east
	static String goSE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].se;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			pos = Integer.toString(tmpRow)+Integer.toString(tmpCol);
		}
		return getName(pos);
	}
			
	//Goes south west
	static String goSW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].sw;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			pos = Integer.toString(tmpRow)+Integer.toString(tmpCol);
		}
		return getName(pos);
	}
			
	//Goes north west
	static String goNW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].nw;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		String pos = "None";
		if(tmpId != -1) {
			pos = Integer.toString(tmpRow)+Integer.toString(tmpCol);
		}
		return getName(pos);
	}
	
	//takes in a id position string "YX" y is up down x is left right
	//method gets and returns new string name id with A1, B2, A4, etc format
	//Y is row X is col
	//Returns string version of position id
	public static String getName(String id) {
		String name;
		String rows = "";
		String cols = "";
		if(id.length() == 4) {
			rows = id.substring(0, 2);
			cols = id.substring(2,4);
		}
		if(id.length() == 2) {
			rows = id.substring(0,1);
			cols = id.substring(1,2);
		}
		if(id.length() ==3) {
			if(id.charAt(0) == '1') {
				rows = id.substring(0,2);
				cols = id.substring(2,3);
			}else {
				rows = id.substring(0,1);
				cols = id.substring(1,3);
			}
		}
		//String rows = id.substring(0,1);
		//String cols = id.substring(1);
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
	
	//gets the column in int form from an id string
	public static int getCol(String id) {
		String colChar = "";
		int colInt = 0;
		if(id.length() == 2) {
			colChar = id.substring(1);
			colInt = Integer.parseInt(colChar)-1;
		}
		if(id.length() == 3) {
			if(id.charAt(0) == '1') {
				colChar = id.substring(2,3);
				colInt = Integer.parseInt(colChar)-1;
			}else {
				colChar = id.substring(1,3);
				colInt = Integer.parseInt(colChar)-1;
			}
		}
		return colInt;
	}
		
	//gets the row in int form from an id string
	public static int getRow(String id) {
		String rowChar = "";
		int rowInt = 0;
		String[] lettersArray = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
		rowChar = id.substring(0,1);
		for(int i = 0; i < lettersArray.length; i++) {
			if(rowChar.equals(lettersArray[i])) {
				rowInt = i;
			}
		}
		return rowInt;
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
	
	//returns list of moves within 1 square range
	public static List<String> getMoves1(int row, int col, Board t) {
		List<String> moves = new ArrayList<String>();
		List<String> directions = new ArrayList<String>();
		
		//each pos id around a square in string format
		String N = goN(row,col, t);
		String S = goS(row,col,t);
		String E = goE(row,col,t);
		String W = goW(row,col,t);
		String NW = goNW(row,col,t);
		String NE = goNE(row,col,t);
		String SW = goSW(row,col,t);
		String SE = goSE(row,col,t);
		
		directions.add(N);
		directions.add(S);
		directions.add(E);
		directions.add(W);
		directions.add(NE);
		directions.add(NW);
		directions.add(SE);
		directions.add(SW);
		
		for(int i = 0; i < directions.size(); i++) {
			String s = directions.get(i);
			if(s.length() != 0) {
				moves.add(s);	
			}
		}
		return moves;
	}
	
	//takes in a list of moves and gets all around each of them
	public static List<String> getMovesFromList(List<String> list, Board t) {
		List<String> moves = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		int row;
		int col;
		String s;
		String v;
		for(int i = 0; i< list.size(); i++) {
			s = list.get(i);
			row = getRow(s);
			col = getCol(s);
			temp = getMoves1(row,col,t);
			for(int k = 0; k < temp.size(); k++) {
				v = temp.get(k);
				if(!isInList(moves, v)) {
					moves.add(v);
				}
			}
		}
		return moves;
	}
	//gets all the moves in a set distance using a loc string ex A1 and a distance number like 8
	public static List<String> getAllMoves (String loc, int dist, Board t){
		List<String> allMoves = new ArrayList<String>();
		int row = getRow(loc);
		int col = getCol(loc);
		allMoves = getMoves1(row, col, t);
		dist = dist -1;
		
		for(int i = 0; i < dist; i++) {
			allMoves = getMovesFromList(allMoves, t);
		}
		if(!isInList(allMoves, loc)) {
			allMoves.add(loc);
		}
		return allMoves;
	}
}
