import java.text.DecimalFormat;

public class Cylinder {
	private int x, y, radius, height;

	public Cylinder() {
		x = 0;
		y = 0;
		radius = 0;
		height = 0;
	}

	public Cylinder(int xCoord, int yCoord, int r, int h) {
		x = xCoord;
		y = yCoord;
		radius = r;
		height = h;
	}

	public void setXCoordinate(int xCoord) {
		x = xCoord;
	}

	public void setYCoordinate(int yCoord) {
		y = yCoord;
	}

	public void setRadius(int r) {
		radius = r;
	}

	public void setHeight(int h) {
		height = h;
	}

	public int getXCoordinate() {
		return x;
	}

	public int getYCoordinate() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	public int getHeight() {
		return height;
	}

	public String getCoordinate() {
		return "(" + x + "," + y + ")";
	}

	public double getSurfaceArea() {
		return 2 * Math.PI * radius * (radius + height);
	}

	public double getVolume() {
		return Math.PI * radius * radius * height;

	}
}
