package edu.vt.cs5044;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DABGame implements DotsAndBoxes {

	private int[][] grid;
	private Player p;
	Map<String, Edge> edges = new HashMap();
	int playerAScore=0;
	int playerBScore=0;
	
	
	@Override
	public boolean drawEdge(Coordinate coord, Direction dir) {
		// TODO Auto-generated method stub

		if (grid == null) {
			throw new GameException("Grid Not initialized");
		}

		Edge e = new Edge(coord, this.getDirectionCoordinate(coord, dir));
		if (edges.containsKey(e.toString())) {
			return false;
		}
		edges.put(e.toString(), e);
		
		
	
		return false;
	}

	@Override
	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return this.p;
	}

	@Override
	public Collection<Direction> getDrawnEdgesAt(Coordinate coord) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Player getOwnerAt(Coordinate coord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Player, Integer> getScores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		if (grid == null) {
			throw new GameException("The girdboard in not ready");
		}
		return grid.length;
	}

	@Override
	public void init(int size) {
		// TODO Auto-generated method stub
		if (size < 2) {
			throw new GameException("Cant make grid of this size. Try again");
		}

		// initializing the grid with 0 which means not yet market
		grid = new int[size][size];

		p = Player.ONE;

	}

	// helper method for testing
	public int[][] getGrid() {
		return this.grid;
	}

	public Coordinate getDirectionCoordinate(Coordinate cord, Direction dir) {
		if (dir == null) {
			throw new GameException("Direction passed is invalid");
		} else if (dir == Direction.LEFT && !(cord.getY() - 1 < 0)) {
			return new Coordinate(cord.getX(), cord.getY() - 1);
		} else if (dir == Direction.RIGHT && !(cord.getY() + 1 >= this.getSize())) {
			return new Coordinate(cord.getX(), cord.getY() + 1);
		} else if (dir == Direction.TOP && !(cord.getX() - 1 < 0)) {
			return new Coordinate(cord.getX() - 1, cord.getY());
		} else if (dir == Direction.BOTTOM && !(cord.getX() + 1 <= this.getSize())) {
			return new Coordinate(cord.getX() + 1, cord.getY());
		} else {
			throw new GameException("The direction out of boundException");
		}
	}
	
	/*public boolean isBoxFormed(Edge e,Direction dir)
	{
		if(dir == Direction.LEFT || dir == Direction.RIGHT)
		{
			
		}else
		{
			
		}
	}*/

}
