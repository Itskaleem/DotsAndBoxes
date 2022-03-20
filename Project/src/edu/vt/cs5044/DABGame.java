package edu.vt.cs5044;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DABGame implements DotsAndBoxes {

	private Player currentPlayer;
	private Map<Coordinate, Box> GridBoxes;
	private int gridSize;
	private boolean isGridInitialized;

	public DABGame() {
		this.currentPlayer = null;
		GridBoxes = null;
		this.isGridInitialized = false;
		gridSize = 0;

	}

	@Override
	public boolean drawEdge(Coordinate coord, Direction dir) {
		// TODO Auto-generated method stub

		return true;
	}

	@Override
	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		this.checkGridInitialization();
		return this.currentPlayer;
	}

	@Override
	public Collection<Direction> getDrawnEdgesAt(Coordinate coord) {
		// TODO Auto-generated method stub
		this.checkGridInitialization();
		if (!GridBoxes.containsKey(coord)) {
			throw new GameException("Location is not valid");
		}

		return null;
	}

	@Override
	public Player getOwnerAt(Coordinate coord) {
		// TODO Auto-generated method stub
		this.checkGridInitialization();
		if (!GridBoxes.containsKey(coord)) {
			throw new GameException("Location is not valid");
		}

		return this.GridBoxes.get(coord).getOwner();
	}

	@Override
	public Map<Player, Integer> getScores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		this.checkGridInitialization();
		return this.gridSize;
	}

	@Override
	public void init(int size) {
		// TODO Auto-generated method stub
		if (size < 2) {
			throw new GameException("Cant make grid of this size. Try again");
		}

		this.currentPlayer = Player.ONE;
		this.GridBoxes = new HashMap();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Coordinate c = new Coordinate(i, j);
				this.GridBoxes.put(c, new Box(this.getBoxVertices(c)));
			}
		}
		this.isGridInitialized = true;
		this.gridSize = size;
	}

	public boolean checkGridInitialization() {
		if (!this.isGridInitialized) {
			throw new GameException("The Grid needs to be initialized first");
		}
		return true;
	}

	public List<Coordinate> getBoxVertices(Coordinate c) {
		List<Coordinate> cs = new LinkedList<>();
		cs.add(c);
		cs.add(c.getNeighbor(Direction.RIGHT));
		cs.add(c.getNeighbor(Direction.BOTTOM));
		cs.add(c.getNeighbor(Direction.RIGHT).getNeighbor(Direction.BOTTOM));
		return cs;
	}

}
