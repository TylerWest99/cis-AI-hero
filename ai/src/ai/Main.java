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
		g.setLocs(g.enemyCap, g.enemyIronMan, g.enemyThor, "A4", "P13", "P12");
		//g.capAddToken();
		//g.capAddToken();
		List<Move> rankedMoves = g.rankMoves(g.cap, g.t);
		
		for(int i = 0; i < rankedMoves.size(); i++) {
			print(rankedMoves.get(i).getAction());
			print(rankedMoves.get(i).getScore());
		}
		g.printBestMove(g.cap, g.t);
	}
}
