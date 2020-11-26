package ai;
import java.util.*;

public class MainTest {
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void print(int s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		Board t = new Board();

		t.createMap();

		List<String> moves = Movement.getAllMoves("B15", 2, t);
		for(int i = 0; i < moves.size(); i++) {
			print(moves.get(i));
		}
		print(moves.size());
	}
}