import java.text.DecimalFormat;

public class Ellipse {
	private int x, y, width, height;

	public Ellipse() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	public Ellipse(int xCoord, int yCoord, int w, int h) {
		x = xCoord;
		y = yCoord;
		width = w;
		height = h;
	}

	public void setXCoordinate(int xCoord) {
		x = xCoord;
	}

	public void setYCoordinate(int yCoord) {
		y = yCoord;
	}

	public void setWidth(int w) {
		width = w;
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

	public String getCoordinate() {
		return "(" + x + "," + y + ")";
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public double getPerimeter() {
		return Math.PI * ((3 * (width + height) / 2)
				- Math.sqrt((3 * width / 2 + height / 2) * (width / 2 + 3 * height / 2)));
	}

	public double getArea() {
		return Math.PI * width * height / 4;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.##");
		return "TopLeft Corner = " + getCoordinate() + "\n" + "Width = " + getWidth() + "\n" + "Height = " + getHeight()
				+ "\n" + "Perimeter = " + df.format(getPerimeter()) + "\n" + "Area = " + df.format(getArea());
	}
}
