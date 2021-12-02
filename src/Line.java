import java.text.DecimalFormat;

public class Line {
	private int a, b, x, y;

	public Line() {
		a = 0;
		b = 0;
		x = 0;
		y = 0;
	}

	public Line(int xOne, int yOne, int xTwo, int yTwo) {
		a = xOne;
		b = yOne;
		x = xTwo;
		y = yTwo;
	}

	public void setFirstX(int xOne) {
		a = xOne;
	}

	public void setFirstY(int yOne) {
		b = yOne;
	}

	public void setSecondX(int xTwo) {
		x = xTwo;
	}

	public void setSecondY(int yTwo) {
		y = yTwo;
	}

	public int getFirstX() {
		return a;
	}

	public int getFirstY() {
		return b;
	}

	public int getSecondX() {
		return x;
	}

	public int getSecondY() {
		return y;
	}

	public String getFirstPoint() {
		return "(" + a + "," + b + ")";
	}

	public String getSecondPoint() {
		return "(" + x + "," + y + ")";
	}

	public double getLength() {
		return Math.sqrt(Math.pow((x - a), 2) + Math.pow((b - y), 2));
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("0.##");
		return "First Point = " + getFirstPoint() + "\n" + "Second Point = " + getSecondPoint() + "\n" + "Length = "
				+ df.format(getLength());
	}
}
