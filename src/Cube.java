import java.text.DecimalFormat;

public class Cube {
	private int x, y, side;

	public Cube() {
		x = 0;
		y = 0;
		side = 0;
	}

	public Cube(int xCoord, int yCoord, int s) {
		x = xCoord;
		y = yCoord;
		side = s;
	}

	public void setXCoordinate(int xCoord) {
		x = xCoord;
	}

	public void setYCoordinate(int yCoord) {
		y = yCoord;
	}

	public void setSide(int s) {
		side = s;
	}

	public int getXCoordinate() {
		return x;
	}

	public int getYCoordinate() {
		return y;
	}

	public int getSide() {
		return side;
	}

	public String getCoordinate() {
		return "(" + x + "," + y + ")";
	}

	public double getSurfaceArea() {
		return 6.0 * side * side;
	}

	public double getVolume() {
		return side * side * side;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#.0");
		return "TopLeft Corner = " + getCoordinate() + "\n" + "Side = " + getSide() + "\n" + "Surface = "
				+ df.format(getSurfaceArea()) + "\n" + "Volume = " + df.format(getVolume());
	}
}
