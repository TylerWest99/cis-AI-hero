/*******************************************************************************
 * Author: Devin Monday, Tyle West, Paul Hood  
 * Class: CIS 365
 * Date: 9/27/2020
 * Description: The main program that uses depth first search to search a path
 * 				between two nodes.
 ******************************************************************************/

package project;
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
		}else {
			tmpId = t.boards[startRow][startCol].e;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = dfs(tmprow,tmpcol,t,s);
				if(found)
					return true;
			}
			
			tmpId = t.boards[startRow][startCol].se;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = dfs(tmprow,tmpcol,t,s);
				if(found)
					return true;
			}
			
			tmpId = t.boards[startRow][startCol].s;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = dfs(tmprow,tmpcol,t,s);
				if(found)
					return true;
			}
			
			tmpId = t.boards[startRow][startCol].sw;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = dfs(tmprow,tmpcol,t,s);
				if(found)
					return true;
			}
			
			tmpId = t.boards[startRow][startCol].w;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = dfs(tmprow,tmpcol,t,s);
				if(found)
					return true;
			}
			
			tmpId = t.boards[startRow][startCol].nw;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = dfs(tmprow,tmpcol,t,s);
				if(found)
					return true;
			}
			
			tmpId = t.boards[startRow][startCol].n;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = dfs(tmprow,tmpcol,t,s);
				if(found)
					return true;
			}
			
			tmpId = t.boards[startRow][startCol].ne;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = dfs(tmprow,tmpcol,t,s);
				if(found)
					return true;
			}
			s.pop();
			return false;
		}
	}
	
	//Runs the search.
	public static void main(String[] args) {
		Stack nodeStack = new Stack();
		Board test = new Board();
		boolean isFound;

//Prints out the 2d array with the node Ids Not used for searching.
//		int i, j;
		
//		for(i = 0; i < 16; i++) {
//			for (j = 0; j < 16; j++) {
//				System.out.print(test.boards[i][j].getId() + " ");
//				if(test.boards[i][j].getId()/10 == 0)
//					System.out.print(" ");
//				if(test.boards[i][j].getId()/100 == 0)
//					System.out.print(" ");
//			}
//			System.out.println("");
//		}

		test.createMap();
		test.boards[9][9].setGoal(true); //SET GOAL NODE HERE!
		isFound = dfs(2,2,test,nodeStack);

	}
}

