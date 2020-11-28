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

		//gets surrounds
		List<String> list = Movement.getAllMoves("G7",2 , t);
		for(int i = 0; i< list.size(); i++) {
			print(list.get(i));
		}
		print(list.size());
	}
}

//works if they are the same just not if they are different