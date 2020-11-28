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
		for(int i = 0; i < 10; i++) {
			ironMan.printValues();
			System.out.println(ironMan.isKoed());
			ironMan.addClick();
			ironMan.updateHeroValues();
			print("");
		}

	}

}
