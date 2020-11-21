//package project;
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
		static boolean goSE(int tmpId, int tmprow, int tmpcol, int startRow, int startCol, boolean found, int goalRow, int goalCol, Board t, Stack s) {
			
				tmpId = t.boards[startRow][startCol].se;
				tmprow = tmpId/16;
				tmpcol = tmpId%16;
				if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
					found = is(tmprow,tmpcol,t,s, goalRow, goalCol);
					if(found)
						return true;
				}else {
					return false;
				}
				return true;
		}
		static boolean goS(int tmpId, int tmprow, int tmpcol, int startRow, int startCol, boolean found, int goalRow, int goalCol, Board t, Stack s) {
			
			tmpId = t.boards[startRow][startCol].s;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = is(tmprow,tmpcol,t,s, goalRow, goalCol);
				if(found)
					return true;
			}else {
				return false;
			}
			return true;
		}		
		static boolean goSW(int tmpId, int tmprow, int tmpcol, int startRow, int startCol, boolean found, int goalRow, int goalCol, Board t, Stack s) {
			
			tmpId = t.boards[startRow][startCol].sw;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = is(tmprow,tmpcol,t,s, goalRow, goalCol);
				if(found)
					return true;
			}else {
				return false;
			}
			return true;
	}
		static boolean goW(int tmpId, int tmprow, int tmpcol, int startRow, int startCol, boolean found, int goalRow, int goalCol, Board t, Stack s) {
			
			tmpId = t.boards[startRow][startCol].w;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = is(tmprow,tmpcol,t,s, goalRow, goalCol);
				if(found)
					return true;
			}else {
				return false;
			}
			return true;
	}
		static boolean goNW(int tmpId, int tmprow, int tmpcol, int startRow, int startCol, boolean found, int goalRow, int goalCol, Board t, Stack s) {
			
			tmpId = t.boards[startRow][startCol].nw;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted()) {
				found = is(tmprow,tmpcol,t,s, goalRow, goalCol);
				if(found)
					return true;
			}else {
				return false;
			}
			return true;
	}
		static boolean goN(int tmpId, int tmprow, int tmpcol, int startRow, int startCol, boolean found, int goalRow, int goalCol, Board t, Stack s) {
			
			tmpId = t.boards[startRow][startCol].n;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted() && tmprow != goalRow && tmpcol != goalCol) {
				found = is(tmprow,tmpcol,t,s, goalRow, goalCol);
				if(found)
					return true;
			}else {
				return false;
			}
			return true;
	}
		static boolean goNE(int tmpId, int tmprow, int tmpcol, int startRow, int startCol, boolean found, int goalRow, int goalCol, Board t, Stack s) {
			
			tmpId = t.boards[startRow][startCol].ne;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted() && tmprow != goalRow && tmpcol != goalCol) {
				found = is(tmprow,tmpcol,t,s, goalRow, goalCol);
				if(found)
					return true;
			}else {
				return false;
			}
			return true;
	}
		static boolean goE(int tmpId, int tmprow, int tmpcol, int startRow, int startCol, boolean found, int goalRow, int goalCol, Board t, Stack s) {
			
			tmpId = t.boards[startRow][startCol].e;
			tmprow = tmpId/16;
			tmpcol = tmpId%16;
			if(tmpId != -1 && !t.boards[tmprow][tmpcol].hasVisted() && tmprow != goalRow && tmpcol != goalCol) {
				found = is(tmprow,tmpcol,t,s, goalRow, goalCol);
				if(found)
					return true;
			}else {
				return false;
			}
			return true;
	}
		
		
		//new basic alg.
				static boolean is(int startRow, int startCol, Board t, Stack s, int goalRow, int goalCol) {
					int tmpId = 0;
					int tmprow = 0;
					int tmpcol = 0;
					boolean goalTopRight = false;
					boolean goalTopLeft = false;
					boolean goalBottomLeft = false;
					boolean goalBottomRight = false;
					
					boolean startTopLeft = false;
					boolean startTopRight = false;
					boolean startBottomLeft = false;
					boolean startBottomRight = false;
					
					if(startRow < 8 && startCol < 8) {
						startTopLeft = true;
					}
					if(startRow < 8 && startCol >= 8) {
						startTopRight = true;
					}
					if(startRow >= 8 && startCol >= 8) {
						startBottomRight = true;
					}
					if(startRow < 8 && startCol >= 8) {
						startBottomLeft = true;
					}
					if(goalRow >= 8 && goalCol >= 8) {
						goalBottomRight = true;
					}
					if(goalRow < 8 && goalCol >= 8) {
						goalTopRight = true;
					}
					if(goalRow < 8 && goalCol < 8 ) {
						goalTopLeft = true;
					}
					if(goalRow >= 8 && goalCol < 8) {
						goalBottomLeft = true;
					}
					char c;
					boolean found = false;
					
					t.boards[startRow][startCol].setHasVisted(true);
					s.push(t.boards[startRow][startCol]);
					c = (char)(startCol + 'a');
					System.out.print(c + "" + (startRow+1) + "->");
					
					if(startCol == goalCol && startRow == goalRow) {
						System.out.println("Goal Found!");
						found = true;
						return found;
					}else {
						//the next 4 ifs are for going to bootom right goal the other 4 ends need to be specified later
						if(startTopLeft && goalBottomRight) {
							goSE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goS(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goNE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goSW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goN(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
						}
						if(startTopRight && goalBottomRight) {
							goS(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goSW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goSE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goNW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goNE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
						}
						if(startBottomLeft && goalBottomRight) {
							goW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goNW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goSW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goN(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goS(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goNE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goSE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
						}
						if(startBottomRight && goalBottomRight) {
							//do some code still need ide but testing with this
							goSE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goS(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goNE(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goSW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goN(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
							goW(tmpId, tmprow, tmpcol, startRow, startCol, found, goalRow, goalCol, t, s);
						}
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
			isFound = is(0,0,test,nodeStack, 15, 15);
		}
}

