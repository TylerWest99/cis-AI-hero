package ai;

public class Move {
	String action;
	int score;
	public Move(String l, int s) {
		this.score = s;
		this.action = l;
	}
	
	public String getAction(){
		return action;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int s) {
		score = s;
	}
	
	public void addToScore(int amt) {
		score = score + amt;
	}
	
}
