package ai;

public class Hero {
	String heroName;
	String loc; 
	boolean isEnemy;
	int click;
	int totalClicks;
	int move;
	int attack;
	int defense;
	int damage;
	int range; 
	int actionTokens;
	boolean isKo;
	
	//hero constructor and adds starting values
	public Hero(String name, Boolean isEnemy) {
		this.heroName = name;
		this.loc = "Not on board!";
		this.isEnemy = isEnemy;
		this.setStartValues();
	}
	
	//adds one to the click 
	public void addClick() {
		this.click = this.click + 1;
	}
	
	//adds an actionToken
	public void addActionToken() {
		this.actionTokens++;
	}
	
	//SETTERS
	//sets a hero location
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	//GETTERS!
	//returns the click of hero
	public int getClick() {
		return this.click;
	}
	
	//gets the heros movement
	public int getMove() {
		return this.move;
	}
	
	//gets the heros name
	public String getName() {
		return this.heroName;
	}
	
	//gets the hero range
	public int getRange() {
		return this.range;
	}
	
	//gets location
	public String getLoc() {
		return this.loc;
	}
	
	//gets max click
	public int maxClick() {
		return this.totalClicks;
	}
	
	//gets action tokens
	public int getActionTokens() {
		return this.actionTokens;
	}
	
	public boolean getIsEnemy() {
		return this.isEnemy;
	}
	
	//returns true if hero is koed false if still alive
	public boolean isKoed() {
		if(isKo) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//sets starting hero values/ click 1 values used at the start of making a character
	private void setStartValues() {
		//sets start values for Captain America 
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.click = 1;
			this.move = 9;
			this.attack = 11;
			this.defense = 17;
			this.damage = 3;
			this.range = 5;
			this.actionTokens = 0;
			this.isKo = false;
			this.totalClicks = 6;
		}
		//sets start value for Thor 
		if(heroName.equalsIgnoreCase("Thor")) {
			this.click = 1;
			this.move = 11;
			this.attack = 11;
			this.defense = 18;
			this.damage = 4;
			this.range = 6;
			this.actionTokens = 0;
			this.isKo = false;
			this.totalClicks = 9;
		}
		//sets start value for Iron Man 
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.click = 1;
			this.move = 11;
			this.attack = 10;
			this.defense = 18;
			this.damage = 4;
			this.range = 7;		
			this.actionTokens = 0;
			this.isKo = false;
			this.totalClicks = 7;
		}
	}
	
	//sets each heros values at click 2
	private void setClickTwoValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 8;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 11;
			this.attack = 11;
			this.defense = 17;
			this.damage = 4;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 11;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
	}
	
	//sets each heros values at click 3 
	private void setClickThreeValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 8;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 11;
			this.attack = 11;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 11;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
	}
	
	//sets each heros values at click 4
	private void setClickFourValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 7;
			this.attack = 9;
			this.defense = 16;
			this.damage = 2;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 11;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 10;
			this.attack = 9;
			this.defense = 17;
			this.damage = 2;
		}
	}
	
	//sets each heros values at click 5
	private void setClickFiveValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 7;
			this.attack = 9;
			this.defense = 16;
			this.damage = 2;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 11;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 10;
			this.attack = 9;
			this.defense = 17;
			this.damage = 2;
		}
	}
	
	//sets values for click 6
	private void setClickSixValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			this.move = 6;
			this.attack = 9;
			this.defense = 17;
			this.damage = 2;
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 11;
			this.attack = 10;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 9;
			this.attack = 9;
			this.defense = 16;
			this.damage = 2;
		}
	}
	
	//sets values for click 7
	private void setClickSevenValues(){
		if(heroName.equalsIgnoreCase("Captain America")) {
			//cap is now koed
			this.isKo = true;
			this.move = 0;
			this.attack = 0;
			this.defense = 0;
			this.damage = 0;
			this.range = 0;
			this.loc = "Off Board";
		}
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 10;
			this.attack = 9;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			this.move = 9;
			this.attack = 9;
			this.defense = 16;
			this.damage = 2;
		}
	}
	
	//sets values for click 8
	private void setClickEightValues(){
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 10;
			this.attack = 9;
			this.defense = 17;
			this.damage = 3;
		}
		if(heroName.equalsIgnoreCase("Iron Man")) {
			//iron man now koed
			this.isKo = true;
			this.move = 0;
			this.attack = 0;
			this.defense = 0;
			this.damage = 0;
			this.range = 0;
			this.loc = "Off Board";
		}
	}
	
	//sets values for click 9
	private void setClickNineValues(){
		if(heroName.equalsIgnoreCase("Thor")) {
			this.move = 10;
			this.attack = 9;
			this.defense = 16;
			this.damage = 3;
		}
	}
	
	//sets values for click 10
	private void setClickTenValues() {
		if(heroName.equalsIgnoreCase("Thor")) {
			//thor now koed
			this.isKo = true;
			this.move = 0;
			this.attack = 0;
			this.defense = 0;
			this.damage = 0;
			this.range = 0;
			this.loc = "Off Board";
		}
	}
	
	//method that updates the heros stats on different clicks
	public void updateHeroValues() {
		if(this.click == 2) {
			setClickTwoValues();
		}
		if(this.click == 3) {
			setClickThreeValues();
		}
		if(this.click == 4) {
			setClickFourValues();
		}
		if(this.click == 5) {
			setClickFiveValues();
		}
		if(this.click == 6) {
			setClickSixValues();
		}
		if(this.click == 7) {
			setClickSevenValues();
		}
		if(this.click == 8) {
			setClickEightValues();
		}
		if(this.click == 9) {
			setClickNineValues();
		}
		if(this.click == 10) {
			setClickTenValues();
		}
	}
	
	//prints a current heros name and values 
	public void printValues() {
		System.out.println(heroName);
		System.out.println("click: " + click + ", move: " + move + ", attack: " + attack + ", defense: " + defense + ", damage: " + damage + ", range: " + range + ", location: " + loc);
	}
}

