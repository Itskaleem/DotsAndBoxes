package edu.vt.cs5044;

import java.util.LinkedList;
import java.util.List;

public class Box {

	private Player Owner;
	private boolean isBoxComplete;
	Coordinate Main;
	Coordinate Right;
	Coordinate below;
	Coordinate Corner;
	
	

	public Box(List<Coordinate> coordinates) {
		Owner = null;
		isBoxComplete = false;
		Main=coordinates.get(0);
		Right=coordinates.get(1);
		below=coordinates.get(2);
		Corner=coordinates.get(3);
		
	}

	public Player getOwner() {
		return Owner;
	}

	public void setOwner(Player owner) {
		Owner = owner;
	}
	

	
	
	
}
