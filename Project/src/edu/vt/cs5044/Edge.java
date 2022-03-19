package edu.vt.cs5044;

public class Edge {
	private Coordinate from;
	private Coordinate to;

	public Edge(Coordinate from, Coordinate to) {
		super();
		this.from = from;
		this.to = to;
	}

	public Coordinate getFrom() {
		return from;
	}

	public void setFrom(Coordinate from) {
		this.from = from;
	}

	public Coordinate getTo() {
		return to;
	}

	public void setTo(Coordinate to) {
		this.to = to;
	}
	
	public String toString()
	{
		return from.toString() + to.toString();
	}

}
