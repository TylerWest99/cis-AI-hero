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
		List<String> list = Movement.getMoves1(1,12 , t);
		//uses surrounds to get what is surronding the surrounds
		List<String> newList = Movement.getAllMoves("G16",1, t);
		for(int i = 0; i< newList.size(); i++) {
			print(newList.get(i));
		}
		print(newList.size());
	}
}

//works if they are the same just not if they are different