public class Rectangle {
	private int x, y, width, height;

	public Rectangle() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	public Rectangle(int xCoord, int yCoord, int w, int h) {
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
		return 2 * (width + height);
	}

	public double getArea() {
		return width * height;
	}

	public String toString() {
		return "TopLeft Corner = " + getCoordinate() + "\n" + "Width = " + getWidth() + "\n" + "Height = " + getHeight()
				+ "\n" + "Perimeter = " + getPerimeter() + "\n" + "Area = " + getArea();
	}
}
