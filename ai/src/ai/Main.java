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

	public static void heroSetup() {
		Board t = new Board();
		t.createMap();
		Hero cap = new Hero("Captain America");
		Hero ironMan = new Hero("Iron Man");
		Hero thor = new Hero("Thor");
	}
	
	public static void main(String[] args) {
		//initialization stuff
		Board t = new Board();
		t.createMap();
		Hero cap = new Hero("Captain America");
		Hero ironMan = new Hero("Iron Man");
		Hero thor = new Hero("Thor");
		
		List<String> moves = Movement.getAllMoves("C11", 2, t, ironMan);
		for(int i = 0; i < moves.size(); i++) {
			print(moves.get(i));
		}
	}

}
