package ai;

public class Hero {
	String heroName;
	int click;
	int move;
	int attack;
	int defense;
	int damage;
	int range; 
	
	public Hero(String name) {
		this.heroName = name;
		this.setStartValues();
	}
	
	//sets starting hero values/ click 1 values used at the start of making a character
	public void setStartValues() {
		//sets start values for Captain America 
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.click = 1;
			this.move = 8;
			this.attack = 11;
			this.defense = 17;
			this.damage = 3;
			this.range = 5;
		}
		//sets start value for Thor 
		if(heroName.equalsIgnoreCase("Thor")) {
			this.click = 1;
			this.move = 10;
			this.attack = 11;
			this.defense = 18;
			this.damage = 4;
			this.range = 6;
		}
		//sets start value for Iron Man 
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.click = 1;
			this.move = 10;
			this.attack = 10;
			this.defense = 18;
			this.damage = 4;
			this.range = 7;			
		}
	}
	
	//sets each heros values at click 2
	public void setClickTwoValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 7;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 10;
			this.attack = 11;
			this.defense = 17;
			this.damage = 4;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 10;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
	}
	
	//sets each heros values at click 3 
	public void setClickThreeValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 7;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 10;
			this.attack = 11;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 10;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
	}
	
	//sets each heros values at click 4
	public void setClickFourValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 6;
			this.attack = 9;
			this.defense = 16;
			this.damage = 2;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 10;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 9;
			this.attack = 9;
			this.defense = 17;
			this.damage = 2;
		}
	}
	
	//sets each heros values at click 5
	public void setClickFiveValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 6;
			this.attack = 9;
			this.defense = 16;
			this.damage = 2;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 10;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 9;
			this.attack = 9;
			this.defense = 17;
			this.damage = 2;
		}
	}
	
	//sets values for click 6
	public void setClickSixValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 5;
			this.attack = 9;
			this.defense = 17;
			this.damage = 2;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 10;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 8;
			this.attack = 9;
			this.defense = 16;
			this.damage = 2;
		}
	}
	
	//sets values for click 7
	public void setClickSevenValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			//cap is now koed
			this.move = 0;
			this.attack = 0;
			this.defense = 0;
			this.damage = 0;
			this.range = 0;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 9;
			this.attack = 9;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 8;
			this.attack = 9;
			this.defense = 16;
			this.damage = 2;
		}
	}
	
	//sets values for click 8
	public void setClickEightValues(){
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 9;
			this.attack = 9;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			//iron man now koed
			this.move = 0;
			this.attack = 0;
			this.defense = 0;
			this.damage = 0;
			this.range = 0;
		}
	}
	
	//sets values for click 9
	public void setClickNineValues(){
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 9;
			this.attack = 9;
			this.defense = 16;
			this.damage = 3;
		}
	}
	
	public void setClickTenValues() {
		if(heroName.equalsIgnoreCase("Thor")) {
			//thor now koed
			this.move = 0;
			this.attack = 0;
			this.defense = 0;
			this.damage = 0;
			this.range = 0;
		}
	}
	
	//prints a current heros values 
	public void printValues() {
		System.out.println(heroName);
		System.out.println("click: " + click + ", move: " + move + ", attack: " + attack + ", defense: " + defense + ", damage: " + damage + ", range: " + range);
	}
}

