package ai;

public class Move {
	String spot;
	int score;
	public Move(String l, int s) {
		this.score = s;
		this.spot = l;
	}
	
	public String getSpot(){
		return spot;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addToScore(int amt) {
		score = score + amt;
	}
	
}
