package edu.vt.cs5044;

import static org.junit.Assert.*;

import org.junit.Test;

public class DABGameTest {

	// lets test our drawedge method
	@Test
	public void testGridInitExceptionInDrawEdge() {
		try {
			DABGame DAB = new DABGame();
			DAB.drawEdge(null, null);
			fail(); // remember this line, else 'may' false positive
		} catch (GameException e) {
			assert ("Grid Not initialized".equals(e.getMessage()));
			// assert others
		}
	}

	@Test
	public void testDirectionNullExceptionInDrawEdge() {
		try {
			DABGame DAB = new DABGame();
			DAB.init(3);
			Coordinate c = new Coordinate(1, 1);
			DAB.drawEdge(c, null);
			fail(); // remember this line, else 'may' false positive
		} catch (GameException e) {
			assert ("Direction passed is invalid".equals(e.getMessage()));
			// assert others
		}
	}

	@Test
	public void testDirectionRightExceptionInDrawEdge() {
		try {
			DABGame DAB = new DABGame();
			DAB.init(3);
			Coordinate c = new Coordinate(2,2);
			DAB.drawEdge(c, Direction.RIGHT);
			fail(); // remember this line, else 'may' false positive
		} catch (GameException e) {
			assert ("The direction out of boundException".equals(e.getMessage()));
			// assert others
		}
	}
	
	@Test
	public void testDirectionLeftExceptionInDrawEdge() {
		try {
			DABGame DAB = new DABGame();
			DAB.init(3);
			Coordinate c = new Coordinate(2,0);
			DAB.drawEdge(c, Direction.LEFT);
			fail(); // remember this line, else 'may' false positive
		} catch (GameException e) {
			assert ("The direction out of boundException".equals(e.getMessage()));
			// assert others
		}
	}
	
	@Test
	public void testDirectionTopExceptionInDrawEdge() {
		try {
			DABGame DAB = new DABGame();
			DAB.init(3);
			Coordinate c = new Coordinate(0,0);
			DAB.drawEdge(c, Direction.TOP);
			fail(); // remember this line, else 'may' false positive
		} catch (GameException e) {
			assert ("The direction out of boundException".equals(e.getMessage()));
			// assert others
		}
	}
	
	
	
	@Test
	public void testDirectionBottomExceptionInDrawEdge() {
		try {
			DABGame DAB = new DABGame();
			DAB.init(3);
			Coordinate c = new Coordinate(2,2);
			DAB.drawEdge(c, Direction.BOTTOM);
			fail(); // remember this line, else 'may' false positive
		} catch (GameException e) {
			assert ("The direction out of boundException".equals(e.getMessage()));
			// assert others
		}
	}
	
	@Test
	public void testEdgeAlreadyExists() {
		DABGame DAB = new DABGame();
		DAB.init(2);
		DAB.drawEdge(new Coordinate(0,0),Direction.RIGHT);
		assertEquals(false,DAB.drawEdge(new Coordinate(0,0),Direction.RIGHT));
	}
	
	@Test
	public void testEdgeFormation() {
		DABGame DAB= new DABGame();
		DAB.init(2);
		DAB.drawEdge(new Coordinate(0,0), Direction.RIGHT);
		equals("(0, 0)(0, 1)".equals(DAB.edges.containsKey("(0, 0)(0, 1)")));
	}

	
	
	@Test
	public void testSmallGridException() {
		try {
			DABGame DAB = new DABGame();
			DAB.init(1);
			fail(); // remember this line, else 'may' false positive
		} catch (GameException e) {
			assert ("Cant make grid of this size. Try again".equals(e.getMessage()));
			// assert others
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGridinitialization() {
		DABGame DAB = new DABGame();
		DAB.init(4);
		int[][] testarray = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				testarray[i][j] = 0;
			}
		}
		assertEquals(testarray, DAB.getGrid());
	}

	@Test
	public void testPlayerInitialization() {
		DABGame DAB = new DABGame();
		DAB.init(2);
		assertEquals(Player.ONE, DAB.getCurrentPlayer());
	}

	@Test
	public void testGridNotInitializedException() {
		try {
			DABGame DAB = new DABGame();
			DAB.getSize();
			fail(); // remember this line, else 'may' false positive
		} catch (GameException e) {
			assert ("The girdboard in not ready".equals(e.getMessage()));
			// assert others
		}
	}

	@Test
	public void testGridSize() {
		DABGame DAB = new DABGame();
		DAB.init(4);
		assertEquals(4, DAB.getSize());
	}

}
