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
		//List<String> newList = Movement.getMovesFromList(list, t);
		
		//for(int i = 0; i < list.size(); i++) {
			//print(list.get(i));
		//}
		String id;
		id = Movement.goW(1, 12, t);
		print("E " + id);
		id = Movement.goE(1, 12, t);
		print("W " + id);
		//id = Movement.goN(1, 12, t);
		//print("N " +id);
		//id = Movement.goS(1, 12, t);
		//print("S " + id);
		//id = Movement.goSE(1, 12, t);
		//print("SE " + id);
		//id = Movement.goNE(1, 12, t);
		//print("NE " + id);
		//id = Movement.goSW(1, 12, t);
		//print("SW " + id);
		//id = Movement.goNW(1, 12, t);
		//print("NW " + id);
	}
}

//works if they are the same just not if they are different