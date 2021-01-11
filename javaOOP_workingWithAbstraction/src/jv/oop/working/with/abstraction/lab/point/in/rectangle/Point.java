package jv.oop.working.with.abstraction.lab.point.in.rectangle;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean isLessOrEqual(Point point) {
		return this.x <= point.x && this.y <= point.y;
	}
	
	public boolean isGreaterOrEqual(Point point) {
		return this.x >= point.x && this.y >= point.y;
	}
	
}
