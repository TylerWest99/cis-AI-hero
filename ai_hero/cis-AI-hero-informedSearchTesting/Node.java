//package project;

public class Node {
	private int id;
	private int x,y;
	public int n, s, e, w, ne, nw, se, sw;
	private boolean isGoal, hasVisted;
	
	public Node() {
		setId(0);
		setGoal(false);
		setHasVisted(false);
		x = y = 0;
		n = s = e = w = ne = nw = se = sw = -1;
	}
	
	
	public void setCordinates(int row, int col) {
		x = row;
		y = col;
	}
	
	public void connectNode(int nodeId, int row, int col) {
		if(row == x && col > y)  //East
			e = nodeId;
		else if (row == x && col < y) //West
			w = nodeId;
		else if (row > x && col == y) //South
			s = nodeId;
		else if (row < x && col == y) //North
			n = nodeId;
		else if(row > x && col > y) //SouthEast
			se = nodeId;
		else if(row < x && col >y) //NorthEast
			ne = nodeId;
		else if(row > x && col < y) //SouthWest
			sw = nodeId;
		else if(row < x && col < y) //NorthWest
			nw = nodeId;
		else
			 System.out.println("Error connecting Node!");
	}
	
	public void disconnectNode(int nodeId) {
		if(n == nodeId)
			n = -1;
		else if(s == nodeId)
			s = -1;
		else if (e == nodeId)
			e = -1;
		else if (w == nodeId)
			w = -1;
		else if (ne == nodeId)
			ne = -1;
		else if (nw == nodeId)
			nw = -1;
		else if (se == nodeId)
			se = -1;
		else if (sw == nodeId)
			sw = -1;
		else
			System.out.print("");
			
	}
	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isGoal() {
		return isGoal;
	}

	public void setGoal(boolean isGoal) {
		this.isGoal = isGoal;
	}

	public boolean hasVisted() {
		return hasVisted;
	}

	public void setHasVisted(boolean hasVisted) {
		this.hasVisted = hasVisted;
	}
}
