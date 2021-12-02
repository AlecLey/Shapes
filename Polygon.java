import java.text.DecimalFormat;

public class Polygon {
	private int x, y, sides, radius;

	Polygon() {
		x = 0;
		y = 0;
		sides = 3;
		radius = 1;
	}

	Polygon(int xCoord, int yCoord, int n, int r) {
		x = xCoord;
		y = yCoord;
		sides = n;
		radius = r;
	}

	public void setXCoordinate(int xCoord) {
		x = xCoord;
	}

	public void setYCoordinate(int yCoord) {
		y = yCoord;
	}

	public void setSides(int n) {
		sides = n;
	}

	public void setRaius(int r) {
		radius = r;
	}

	public int getXCoordinate() {
		return x;
	}

	public int getYCoordinate() {
		return y;
	}

	public String getCoordinate() {
		return "(" + x + "," + y + ")";
	}

	public int getSides() {
		return sides;
	}

	public int getRadius() {
		return radius;
	}

	public double getSideLength() {
		return 2 * radius * Math.sin(Math.PI / sides);
	}

	public double getPerimeter() {
		return getSideLength() * sides;
	}

	public double getArea() {
		return (sides * Math.pow(getSideLength(), 2)) / (4 * Math.tan(Math.PI / sides));
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("0.##");
		return "Center = " + getCoordinate() + "\n" + "# Sides = " + getSides() + "\n" + "Radius = " + getRadius()
				+ "\n" + "SideLength = " + df.format(getSideLength()) + "\n" + "Perimeter = " + df.format(getPerimeter()) + "\n"
				+ "Area = " + df.format(getArea());
	}
}
