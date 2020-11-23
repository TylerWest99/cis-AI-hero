package ai;

public class Board {
	public Node[][] boards = new Node[16][16];
	private final int size = 16;
	
	public Board() {
		int row, col, num = 0;
		
		//Set IDs and coordinates for each tile.
		for(row = 0; row < size; row++) {
			for(col = 0; col < size; col++) {
				boards[row][col] = new Node();
				boards[row][col].setId(num);
				boards[row][col].setCordinates(row, col);
				num++;
			}
		}
		
		//connects all the nodes as if they re are no walls.
		for(row = 0; row < size; row++) {
			for(col = 0; col < size; col++) {
				if(row - 1 >= 0) {
					boards[row][col].connectNode(boards[row - 1][col].getId(), row - 1, col);  //West
					if(col - 1 >= 0)
						boards[row][col].connectNode(boards[row -1][col-1].getId(), row - 1, col - 1); //NorthWest
					if(col + 1 < size)
						boards[row][col].connectNode(boards[row-1][col+1].getId(),row - 1,col + 1); //SouthWest
				}
				
				if(row + 1 < size) {
					boards[row][col].connectNode(boards[row + 1][col].getId(), row + 1, col);  //East
					if(col - 1 >= 0)
						boards[row][col].connectNode(boards[row + 1][col - 1].getId(), row + 1, col -1); //NorthEast
					if(col + 1 < size)
						boards[row][col].connectNode(boards[row + 1][col + 1].getId(),row + 1,col+1); //SouthEast
				}
				
				if(col - 1 >= 0)
					boards[row][col].connectNode(boards[row][col - 1].getId(), row, col - 1); //North
				
				if(col + 1 < size)
					boards[row][col].connectNode(boards[row][col + 1].getId(), row, col + 1); //South
			}
		}
		
		
	}
	
	//Adds a "Wall" to a pair of nodes.
	public void addWall(Node one, Node two) {
		one.disconnectNode(two.getId());
		two.disconnectNode(one.getId());
	}
	
	public void addVertWallLine(int r, int c, int dist) {
		int i;
		if(dist == 1)
			addWall(boards[r+1][c],boards[r+1][c+1]);
		else {
			for(i = r; i < (r + dist); i++)
				addWall(boards[i][c],boards[i+1][c+1]);
			for(i = r+1; i < (r + dist + 1); i++)
				addWall(boards[i][c],boards[i][c+1]);
			for(i = r+2; i < (r + dist + 1); i++)
				addWall(boards[i][c],boards[i-1][c+1]);
		}
	}
	
	public void addHorizWallLine(int r, int c, int dist) {
		int i;
		if(dist == 1)
			addWall(boards[r][c+1],boards[r+1][c+1]);
		else {
			for(i = c; i < (c + dist); i++)
				addWall(boards[r][i],boards[r+1][i+1]);
			for(i = c+1; i < (c + dist + 1); i++)
				addWall(boards[r][i],boards[r+1][i]);
			for(i = c+2; i < (c + dist + 1); i++)
				addWall(boards[r][i],boards[r+1][i-1]);
		}
	}
	
	//Adds walls at the corners
	public void addCorners(Node tile, int r, int c) {
		if(tile.n == tile.w && tile.nw != -1)
			addWall(boards[r][c],boards[r-1][c-1]);
		
		if(tile.n == tile.e && tile.ne != -1)
			addWall(boards[r][c],boards[r-1][c+1]);
		
		if(tile.s == tile.w && tile.sw != -1)
			addWall(boards[r][c],boards[r+1][c-1]);
		
		if(tile.s == tile.e && tile.se != -1)
			addWall(boards[r][c],boards[r+1][c+1]);
	}
	
	//Add blocking terrain
	public void addBlock(int r, int c) {
		addWall(boards[r][c],boards[r-1][c-1]);
		addWall(boards[r][c],boards[r-1][c]);
		addWall(boards[r][c],boards[r-1][c+1]);
		addWall(boards[r][c],boards[r+1][c-1]);
		addWall(boards[r][c],boards[r+1][c]);
		addWall(boards[r][c],boards[r+1][c+1]);
		addWall(boards[r][c],boards[r][c-1]);
		addWall(boards[r][c],boards[r][c+1]);	
	}
	//Adds the walls.
	public void createMap() {
		int c, r;
		
		//Adds vertical Walls
		c = 1;
		addVertWallLine(3,c,4);
		addVertWallLine(8,c,3);

		c = 3;
		addVertWallLine(1,c,3);
		addVertWallLine(11,c,3);

		c = 5;
		addVertWallLine(0,c,1);
		addVertWallLine(3,c,4);
		addVertWallLine(8,c,2);
		addVertWallLine(12,c,2);

		c = 7;
		addVertWallLine(0,c,2);
		addWall(boards[0][c],boards[0][c+1]);
		addWall(boards[1][c],boards[0][c+1]);
		addVertWallLine(11,c,3);
		addWall(boards[15][c],boards[15][c+1]);
		addWall(boards[14][c],boards[15][c+1]);
		
		c = 9;
		addVertWallLine(0,c,1);
		addVertWallLine(5,c,3);
		
		c = 10;
		addVertWallLine(12,c,1);
		addVertWallLine(13,c,1);
		addWall(boards[15][c],boards[15][c+1]);
		addWall(boards[14][c],boards[15][c+1]);
		
		c = 11;
		addVertWallLine(1,c,2);
		
		c = 13;
		addVertWallLine(3,c,2);
		addVertWallLine(9,c,2);
		
		
		//Adds Horizontal Walls
		
		r = 1;
		addHorizWallLine(r,3,2);
		addHorizWallLine(r,9,2);
		
		r = 3;
		addHorizWallLine(r,1,2);
		addHorizWallLine(r,5,1);
		addHorizWallLine(r,9,4);
		
		r = 5;
		addHorizWallLine(r,6,5);
		addHorizWallLine(r,13,1);
		
		r = 6;
		addHorizWallLine(r,1,2);
		
		r = 7;
		addHorizWallLine(r,11,4);
		addWall(boards[7][15],boards[8][15]);
		addWall(boards[7][15],boards[8][14]);
		
		r = 8;
		addHorizWallLine(r,0,4);
		addWall(boards[8][0],boards[9][0]);
		addWall(boards[8][1],boards[9][0]);
		
		r = 9;
		addHorizWallLine(r,5,2);
		addHorizWallLine(r,8,3);
		addHorizWallLine(r,13,1);
		
		r = 11;
		addHorizWallLine(r,1,1);
		addHorizWallLine(r,9,4);
		
		r = 13;
		addHorizWallLine(r,3,2);
		addHorizWallLine(r,7,1);
		
		//adds the blocking blocks
		addBlock(7,7);
		addBlock(7,8);
		addBlock(8,7);
		addBlock(8,8);
		
		for(r = 0; r < size; r++)
			for(c = 0; c < size; c++)
				addCorners(boards[r][c],r,c);
	}
}
