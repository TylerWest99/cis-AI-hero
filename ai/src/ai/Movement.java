package ai;

public class Movement {
	//takes in a id position and "YX" y is up down x is left right
	//method gets and returns new name id with A1, B2, A4, etc format
	public static String getName(String id) {
		String name;
		char row = id.charAt(0);
		char col = id.charAt(1);
		String rows = Character.toString(row);
		String cols = Character.toString(col);
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
}
