package edu.vt.cs5044;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DABGameTest {

	private DotsAndBoxes game;
	
	@Before
	public void setUp() throws Exception{
		game = new DABGame();
	}
	
	
	@Test
	public void testInitInvalidSize()
	{
		try{
			game.init(1);
			fail("Couldnt catch the exception in small size");
		}catch(Exception e)
		{
			equals("Cant make grid of this size. Try again".equals(e.getMessage()));
		}
	}
	
	
	@Test
	public void testInitialPlayer()
	{
		game.init(3);
		assertEquals(Player.ONE,game.getCurrentPlayer());
	}
	
	//checking getsize
	
	@Test
	public void correctSizeInitialization()
	{
		game.init(4);
		assertEquals(4,game.getSize());
	}
	
	@Test
	public void getSizewithoutInitException()
	{
		try
		{
			game.getSize();
			fail("Failed to catch the exception in getsize");
		}catch(Exception e)
		{
			equals("The Grid needs to be initialized first".equals(e.getMessage()));
		}
		
	}
	
	//checking getplayer
	@Test
	public void GetPLayerValid()
	{
		game.init(3);
		assertEquals(Player.ONE, game.getCurrentPlayer());
	}
	
	
	@Test
	public void GetPlayerInitException()
	{
		try
		{
			game.getCurrentPlayer();
			fail();
		}catch (Exception e)
		{
			equals("The Grid needs to be initialized first".equals(e.getMessage()));
		}
	}
	
	
	//Testing getowner method
	@Test
	public void getBoxOwnerWithoutInitException()
	{
		try
		{
			game.getOwnerAt(new Coordinate(0,0));
			fail("Failed to catch the exception in getsize");
		}catch(Exception e)
		{
			equals("The Grid needs to be initialized first".equals(e.getMessage()));
		}
		
	}
	
	@Test
	public void invalidCoordinateOwnerTest()
	{
		try
		{
			game.init(3);
			game.getOwnerAt(new Coordinate(-1,0));
			fail("Failed to catch the exception in getsize");
		}catch(Exception e)
		{
			equals("Location is not valid".equals(e.getMessage()));
		}
	}
	
	@Test 
	public void getOwnerValid()
	{
		game.init(3);
		assertEquals(null,game.getOwnerAt(new Coordinate(0,0)));
	}
	
	
	//testing the getedges method
	
	@Test
	public void getBoxEdgesWithoutInitException()
	{
		try
		{
			game.getOwnerAt(new Coordinate(0,0));
			fail("Failed to catch the exception in getsize");
		}catch(Exception e)
		{
			equals("The Grid needs to be initialized first".equals(e.getMessage()));
		}
		
	}
	
	@Test
	public void invalidCoordinateEdgesTest()
	{
		try
		{
			game.init(3);
			game.getOwnerAt(new Coordinate(-1,0));
			fail("Failed to catch the exception in getsize");
		}catch(Exception e)
		{
			equals("Location is not valid".equals(e.getMessage()));
		}
	}
	
	
	
	
	
}
