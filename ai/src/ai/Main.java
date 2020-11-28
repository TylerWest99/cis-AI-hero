package ai;

public class Main {
	
	//just some helper printing methods because I am used to Python
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void print(int s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		Hero cap = new Hero("Captain America");
		Hero ironMan = new Hero("Iron Man");
		Hero thor = new Hero("Thor");
		cap.printValues();
		print("");
		thor.printValues();
		print("");
		ironMan.printValues();

	}

}
