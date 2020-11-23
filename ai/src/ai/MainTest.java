package ai;
import java.util.*;

public class MainTest {
	
	//Used for testing. Prints out the node and all connected nodes. (-1 for walls)
	static void printBlock(int i, int j,Board t) {
		System.out.println("_______________________");
		
		System.out.println(i + "," + j);
		System.out.println(t.boards[i][j].nw + " " + t.boards[i][j].n + " " + t.boards[i][j].ne);
		System.out.println(t.boards[i][j].w + " " + t.boards[i][j].getId() + " " + t.boards[i][j].e);
		System.out.println(t.boards[i][j].sw + " " + t.boards[i][j].s + " " + t.boards[i][j].se);
	}
	
	//Goes east
	static void goE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].e;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		if(tmpId != -1) {
			System.out.println(Integer.toString(tmpRow)+Integer.toString(tmpCol));
		}
	}
	
	//Goes west
	static void goW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].w;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		if(tmpId != -1) {
			System.out.println(Integer.toString(tmpRow)+Integer.toString(tmpCol));
		}
	}
	
	//Goes north
	static void goN(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].n;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		if(tmpId != -1) {
			System.out.println(Integer.toString(tmpRow)+Integer.toString(tmpCol));
		}
	}
	
	//Goes south
	static void goS(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].s;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		if(tmpId != -1) {
			System.out.println(Integer.toString(tmpRow)+Integer.toString(tmpCol));
		}
	}
	
	//Goes north east
	static void goNE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].ne;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		if(tmpId != -1) {
			System.out.println(Integer.toString(tmpRow)+Integer.toString(tmpCol));
		}
	}
	
	//Goes south east
	static void goSE(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].se;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		if(tmpId != -1) {
			System.out.println(Integer.toString(tmpRow)+Integer.toString(tmpCol));
		}
	}
	
	//Goes south west
	static void goSW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].sw;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		if(tmpId != -1) {
			System.out.println(Integer.toString(tmpRow)+Integer.toString(tmpCol));
		}
	}
	
	//Goes north west
	static void goNW(int startRow, int startCol, Board t){
		int tmpId = t.boards[startRow][startCol].nw;
		int tmpRow = tmpId/16;
		int tmpCol = tmpId%16;
		if(tmpId != -1) {
			System.out.println(Integer.toString(tmpRow)+Integer.toString(tmpCol));
		}
	}
	
	//Depth first search algorithm. The program will always travel to the east node, then clockwise if it can't travel east.
	static boolean dfs(int startRow, int startCol, Board t, Stack s) {
		int tmpId = 0;
		int tmprow = 0;
		int tmpcol = 0;
		char c;
		boolean found;
		
		t.boards[startRow][startCol].setHasVisted(true);
		s.push(t.boards[startRow][startCol]);
		c = (char)(startCol + 'a');
		System.out.print(c + "" + (startRow+1) + "->");
		
		if(t.boards[startRow][startCol].isGoal()) {
			System.out.println("Goal Found!");
			return true;
		}
			return true;
		}
	
	
	//Runs the search.
	public static void main(String[] args) {
		Stack nodeStack = new Stack();
		Board test = new Board();
		boolean isFound;

		test.createMap();
		//test.boards[9][9].setGoal(true); //SET GOAL NODE HERE!
		//isFound = dfs(2,2,test,nodeStack);
		
		goE(0,0,test);

	}
}