package jv.oop.working.with.abstraction.lab.point.in.rectangle;

public class Rectangle {
	private Point bottomLeft;
	private Point topRight;

	public Rectangle(Point bottomLeft, Point topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}

	public boolean contains(Point pnt) {
		return bottomLeft.isLessOrEqual(pnt) && topRight.isGreaterOrEqual(pnt);
	}
}
