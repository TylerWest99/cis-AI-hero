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
		Board test = new Board();

		test.createMap();

		List<String> list = Movement.getAllMoves("A1", 3, test);
		for(int i = 0; i < list.size(); i++) {
			print(list.get(i));
		}
		print("printing all possible moves from A1 in range of 3");
		print(list.size());
	}
}