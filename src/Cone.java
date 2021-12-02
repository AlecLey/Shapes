import java.text.DecimalFormat;

public class Cone {
	private int x, y, radius, height;

	public Cone() {
		x = 0;
		y = 0;
		radius = 0;
		height = 0;
	}

	public Cone(int xCoord, int yCoord, int r, int h) {
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
		return Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
	}

	public double getVolume() {
		return 1.0 / 3 * (Math.PI * radius * radius * height);

	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("0.##");
		return "Center = " + getCoordinate() + "\n" + "Radius = " + getRadius() + "\n" + "Height = " + getHeight()
				+ "\n" + "Surface Area = " + df.format(getSurfaceArea()) + "\n" + "Volume = " + df.format(getVolume());
	}
}
