import java.text.DecimalFormat;

public class Sphere {
	private int x, y, radius;

	public Sphere() {
		x = 0;
		y = 0;
		radius = 0;
	}

	public Sphere(int xCoord, int yCoord, int r) {
		x = xCoord;
		y = yCoord;
		radius = r;
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

	public int getXCoordinate() {
		return x;
	}

	public int getYCoordinate() {
		return y;
	}

	public String getCoordinate() {
		return "(" + x + "," + y + ")";
	}

	public int getRadius() {
		return radius;
	}

	public double getSurfaceArea() {
		return 4.0 * Math.PI * radius * radius;
	}

	public double getVolume() {
		return (4.0 / 3.0) * Math.PI * radius * radius * radius;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("0.##");
		return "Center = " + getCoordinate() + "\n" + "Radius = " + getRadius() + "\n" + "Surface Area = "
				+ df.format(getSurfaceArea()) + "\n" + "Volume = " + df.format(getVolume());
	}
}
