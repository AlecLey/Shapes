/*
 * CSC 229 Project 5
 * Alec Leyner
 * Input: There are 11 cases that I created being the 8 shapes being split into 2D and 3D shapes, an about section, an exit button and a color changer. There are coordinates that are set
 * using user input for each shape based on the X, Y, point, sides, perimeter and area of the shape. 
 * Output: After user inputs information it will show a chart of the coordinates and specifications, it will then draw the shape (the shape must fit using the coordinates in the graphics,
 * if the coordinates are entered to be too far or too small there will be no shape). Lastly the user can exit out of the program with the exit button and change the background color.
 */
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Project05 extends Frame implements ActionListener {
	// Objects
	String command = "";

	// Colors
	JColorChooser colorChooser = new JColorChooser();
	Color backgroundColor = new Color(0, 0, 0);
	Color foregroundColor = new Color(255, 255, 255);
	Line l;
	Rectangle r;
	Ellipse e;
	Polygon p;
	Sphere s;
	Cube c;
	Cone n;
	Cylinder y;

	public static void main(String[] args) {
		Frame frame = new Project05();
		frame.setResizable(true);
		frame.setSize(1000, 840);
		frame.setVisible(true);

	}

	public Project05() {
		setTitle("Graphics");

		// Create Menu

		MenuBar mb = new MenuBar();
		setMenuBar(mb);

		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);

		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);

		MenuItem miColor = new MenuItem("Color");
		miColor.addActionListener(this);
		fileMenu.add(miColor);

		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		// 2D Shapes menu

		Menu twoDMenu = new Menu("2D Shapes");
		mb.add(twoDMenu);

		MenuItem miLine = new MenuItem("Line");
		miLine.addActionListener(this);
		twoDMenu.add(miLine);

		MenuItem miRectangle = new MenuItem("Rectangle");
		miRectangle.addActionListener(this);
		twoDMenu.add(miRectangle);

		MenuItem miEllipse = new MenuItem("Ellipse");
		miEllipse.addActionListener(this);
		twoDMenu.add(miEllipse);

		MenuItem miPolygon = new MenuItem("Regular Polygon");
		miPolygon.addActionListener(this);
		twoDMenu.add(miPolygon);

		// 3D Shapes Menu

		Menu threeDMenu = new Menu("3D Shapes");
		mb.add(threeDMenu);

		MenuItem miSphere = new MenuItem("Sphere");
		miSphere.addActionListener(this);
		threeDMenu.add(miSphere);

		MenuItem miCube = new MenuItem("Cube");
		miCube.addActionListener(this);
		threeDMenu.add(miCube);

		MenuItem miCone = new MenuItem("Cone");
		miCone.addActionListener(this);
		threeDMenu.add(miCone);

		MenuItem miCylinder = new MenuItem("Cylinder");
		miCylinder.addActionListener(this);
		threeDMenu.add(miCylinder);

		// End program when window is closed

		WindowListener l = new WindowAdapter() {

			// window closed - exit program
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}

			// menu option selected - go to redraw and display method
			public void listener(WindowEvent ev) {
				repaint();
			}

			// window resized or refocused - redraw
			public void windowStateChanged(WindowEvent ev) {
				repaint();
			}

		};

		ComponentListener k = new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				repaint();
			}
		};

		// register listeners

		this.addWindowListener(l);
		this.addComponentListener(k);

	}

//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

	public void actionPerformed(ActionEvent ev) {
		// figure out which command was issued

		command = ev.getActionCommand();

		// take action accordingly
		switch (command) {
		case "About": {
			repaint();
			break;
		}
		case "Exit": {
			System.exit(0);
		}
		case "Color": {
			backgroundColor = JColorChooser.showDialog(null, "Choose Background Color", colorChooser.getBackground());

			foregroundColor = JColorChooser.showDialog(null, "Choose Drawing Color", colorChooser.getBackground());
			repaint();
			break;
		}
		case "Line": {
			l = line();
			repaint();
			break;
		}
		case "Rectangle": {
			r = rectangle();
			repaint();
			break;
		}
		case "Ellipse": {
			e = ellipse();
			repaint();
			break;
		}
		case "Regular Polygon": {
			p = polygon();
			repaint();
			break;
		}
		case "Sphere": {
			s = sphere();
			repaint();
			break;
		}
		case "Cube": {
			c = cube();
			repaint();
			break;
		}
		case "Cone": {
			n = cone();
			repaint();
			break;
		}
		case "Cylinder": {
			y = cylinder();
			repaint();
			break;
		}

		}
	}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************

	public void paint(Graphics g) {
		// Check Command issued, take action accordingly
		switch (command) {
		case "About": {
			g.drawString(" Geometric Shapes", 400, 100);
			g.drawLine(350, 120, 550, 120);
			g.drawString(
					" This program supports the entry of values of primary attributes and calculation of secondary ",
					200, 140);
			g.drawString(" attributes (sides, angels, perimeter, area, surface, volume of the following shapes: ", 200,
					160);

			g.drawString(" 1.      Line", 400, 200);
			g.drawString(" 2.      Rectangle", 400, 220);
			g.drawString(" 3.      Ellipse", 400, 240);
			g.drawString(" 4.      Regular Polygon", 400, 260);
			g.drawString(" 5.      Sphere", 400, 280);
			g.drawString(" 6.      Cube", 400, 300);
			g.drawString(" 7.      Cone", 400, 320);
			g.drawString(" 8.      Cylinder", 400, 340);
			break;
		}
		case "Color": {
			this.setBackground(backgroundColor);
			this.setForeground(foregroundColor);
			break;
		}
		case "Line": {
			g.drawLine(80, 80, 300, 80);
			g.drawString("Line Properties", 100, 100);
			g.drawLine(80, 120, 300, 120);
			g.drawString("First Point = " + l.getFirstPoint(), 100, 140);
			g.drawString("Second Point = " + l.getSecondPoint(), 100, 160);
			g.drawString("Length = " + l.getLength(), 100, 180);
			g.drawLine(80, 80, 80, 200);
			g.drawLine(300, 80, 300, 200);
			g.drawLine(80, 200, 300, 200);
			g.drawLine(l.getFirstX(), l.getFirstY(), l.getSecondX(), l.getSecondY());
			break;
		}
		case "Rectangle": {
			g.drawLine(80, 80, 300, 80);
			g.drawString("Rectangle Properties", 100, 100);
			g.drawLine(80, 120, 300, 120);
			g.drawString("TopLeft Corner = " + r.getCoordinate(), 100, 140);
			g.drawString("Width = " + r.getWidth(), 100, 160);
			g.drawString("Height = " + r.getHeight(), 100, 180);
			g.drawString("Perimeter = " + r.getPerimeter(), 100, 200);
			g.drawString("Area = " + r.getArea(), 100, 220);
			g.drawLine(80, 80, 80, 240);
			g.drawLine(300, 80, 300, 240);
			g.drawLine(80, 240, 300, 240);
			g.drawRect(r.getXCoordinate(), r.getYCoordinate(), r.getWidth(), r.getHeight());
			break;
		}
		case "Ellipse": {
			g.drawLine(80, 80, 300, 80);
			g.drawString("Ellipse Properties", 100, 100);
			g.drawLine(80, 120, 300, 120);
			g.drawString("TopLeft Corner = " + e.getCoordinate(), 100, 140);
			g.drawString("Width = " + e.getWidth(), 100, 160);
			g.drawString("Height = " + e.getHeight(), 100, 180);
			g.drawString("Perimeter = " + e.getPerimeter(), 100, 200);
			g.drawString("Area = " + e.getArea(), 100, 220);
			g.drawLine(80, 80, 80, 240);
			g.drawLine(300, 80, 300, 240);
			g.drawLine(80, 240, 300, 240);
			g.drawOval(e.getXCoordinate(), e.getYCoordinate(), e.getWidth(), e.getHeight());
			break;
		}
		case "Regular Polygon": {
			DecimalFormat df = new DecimalFormat("0.##");
			double angle = 0.0;
			double step = 2 * Math.PI / p.getSides();
			int [] xPoints = new int [p.getSides()];
			int [] yPoints = new int [p.getSides()];
			for ( int n = 0; n < p.getSides(); n++ ) {
			    double x = p.getRadius() * Math.cos(angle);
			    double y = p.getRadius() * Math.sin(angle);
			    angle += step;
			    xPoints[n] = (int)x + p.getXCoordinate();
			    yPoints[n] = (int)y + p.getXCoordinate();
			}
			g.drawLine(80, 80, 270, 80);
			g.drawString("Polygon Properties", 100, 100);
			g.drawLine(80, 120, 270, 120);
			g.drawString("Center Point = " + p.getCoordinate(), 100, 140);
			g.drawString("Radius = " + p.getRadius(), 100, 160);
			g.drawString("# Sides = " + p.getSides(), 100, 180);
			g.drawLine(80, 200, 270, 200);
			g.drawString("Vertices", 100, 220);
			g.drawLine(80, 240, 270, 240);
			for(int i = 1; i <= p.getSides(); i++) {
				g.drawString("Point " + i + " = ("+xPoints[i - 1] + "," + yPoints[i - 1] + ")", 100, 240 + (20 * i));
			}
			g.drawLine(80, 240 + (20 * (p.getSides() + 1)), 270, 240 + (20 * (p.getSides() + 1)));
			g.drawString("Side = " + df.format(p.getSideLength()), 100, 240 + (20 * (p.getSides() + 2)));
			g.drawString("Perimeter = " + df.format(p.getPerimeter()), 100, 240 + (20 * (p.getSides() + 3)));
			g.drawString("Area = " + df.format(p.getArea()), 100, 240 + (20 * (p.getSides() + 4)));
			g.drawLine(270, 80, 270, 240 + (20 * (p.getSides() + 5)));
			g.drawLine(80, 240 + (20 * (p.getSides() + 5)), 270, 240 + (20 * (p.getSides() + 5)));
			g.drawPolygon(xPoints, yPoints, p.getSides());
			g.drawLine(80, 80, 80, 240 + (20 * (p.getSides() + 5)));
			break;
		}
		case "Sphere": {
			g.drawLine(80, 80, 300, 80);
			g.drawString("Sphere Properties", 100, 100);
			g.drawLine(80, 120, 300, 120);
			g.drawString("Center = " + s.getCoordinate(), 100, 140);
			g.drawString("Radius = " + s.getRadius(), 100, 160);
			g.drawString("Surface = " + s.getSurfaceArea(), 100, 180);
			g.drawString("Volume = " + s.getVolume(), 100, 200);
			g.drawLine(80, 80, 80, 220);
			g.drawLine(300, 80, 300, 220);
			g.drawOval(s.getXCoordinate(), s.getYCoordinate(), s.getRadius(), s.getRadius());
			g.drawOval(s.getXCoordinate(), s.getYCoordinate() + (s.getRadius() / 4), s.getRadius(), s.getRadius() / 2);
			g.drawLine(80, 220, 300, 220);
			break;
		}
		case "Cube": {
			g.drawLine(80, 80, 300, 80);
			g.drawString("Cube Properties", 100, 100);
			g.drawLine(80, 120, 300, 120);
			g.drawString("TopLeft Corner = " + c.getCoordinate(), 100, 140);
			g.drawString("Side = " + c.getSide(), 100, 160);
			g.drawString("Surface = " + c.getSurfaceArea(), 100, 180);
			g.drawString("Volume = " + c.getVolume(), 100, 200);
			g.drawLine(80, 80, 80, 220);
			g.drawLine(300, 80, 300, 220);
			g.drawLine(80, 220, 300, 220);
			g.drawRect(c.getXCoordinate(), c.getYCoordinate(), c.getSide(), c.getSide());
			g.drawLine(c.getXCoordinate() + (c.getSide() / 2), c.getYCoordinate() - (c.getSide() / 4),
					c.getXCoordinate() + (c.getSide() / 2) + c.getSide(), c.getYCoordinate() - (c.getSide() / 4));
			g.drawLine(c.getXCoordinate() + (c.getSide() / 2) + c.getSide(), c.getYCoordinate() - (c.getSide() / 4),
					c.getXCoordinate() + (c.getSide() / 2) + c.getSide(),
					c.getYCoordinate() - (c.getSide() / 4) + c.getSide());
			g.drawLine(c.getXCoordinate() + c.getSide(), c.getYCoordinate() + c.getSide(),
					c.getXCoordinate() + (c.getSide() / 2) + c.getSide(),
					c.getYCoordinate() - (c.getSide() / 4) + c.getSide());
			g.drawLine(c.getXCoordinate() + c.getSide(), c.getYCoordinate(),
					c.getXCoordinate() + (c.getSide() / 2) + c.getSide(), c.getYCoordinate() - (c.getSide() / 4));
			g.drawLine(c.getXCoordinate(), c.getYCoordinate(), c.getXCoordinate() + (c.getSide() / 2),
					c.getYCoordinate() - (c.getSide() / 4));
			break;
		}
		case "Cone": {
			g.drawLine(80, 80, 300, 80);
			g.drawString("Cone Properties", 100, 100);
			g.drawLine(80, 120, 300, 120);
			g.drawString("Center = " + n.getCoordinate(), 100, 140);
			g.drawString("Radius = " + n.getRadius(), 100, 160);
			g.drawString("Height = " + n.getHeight(), 100, 180);
			g.drawString("Surface = " + n.getSurfaceArea(), 100, 200);
			g.drawString("Volume = " + n.getVolume(), 100, 220);
			g.drawLine(80, 80, 80, 240);
			g.drawLine(300, 80, 300, 240);
			g.drawLine(80, 240, 300, 240);
			g.drawOval(n.getXCoordinate(), n.getYCoordinate(), n.getRadius(), n.getHeight() / 4);
			g.drawLine(n.getXCoordinate(), n.getYCoordinate() + (n.getRadius() / 8),
					n.getXCoordinate() + n.getRadius() / 2, n.getYCoordinate() - n.getHeight());
			g.drawLine(n.getXCoordinate() + n.getRadius(), n.getYCoordinate() + (n.getRadius() / 8),
					n.getXCoordinate() + n.getRadius() / 2, n.getYCoordinate() - n.getHeight());
			g.drawLine(n.getXCoordinate() + n.getRadius() / 2, n.getYCoordinate() - n.getHeight(),
					n.getXCoordinate() + n.getRadius() / 2, n.getYCoordinate() + (n.getRadius() / 8));
			g.drawLine(n.getXCoordinate() + n.getRadius() / 2, n.getYCoordinate() + (n.getRadius() / 8),
					n.getXCoordinate() + n.getRadius(), n.getYCoordinate() + (n.getRadius() / 8));
			break;
		}
		case "Cylinder": {
			g.drawLine(80, 80, 300, 80);
			g.drawString("Cylinder Properties", 100, 100);
			g.drawLine(80, 120, 300, 120);
			g.drawString("Center = " + y.getCoordinate(), 100, 140);
			g.drawString("Radius = " + y.getRadius(), 100, 160);
			g.drawString("Height = " + y.getHeight(), 100, 180);
			g.drawString("Surface = " + y.getSurfaceArea(), 100, 200);
			g.drawString("Volume = " + y.getVolume(), 100, 220);
			g.drawLine(80, 80, 80, 240);
			g.drawLine(300, 80, 300, 240);
			g.drawLine(80, 240, 300, 240);
			g.drawOval(y.getXCoordinate(), y.getYCoordinate(), y.getRadius(), y.getHeight() / 4);
			g.drawOval(y.getXCoordinate(), y.getYCoordinate() - y.getHeight(), y.getRadius(), y.getHeight() / 4);
			g.drawLine(y.getXCoordinate(), y.getYCoordinate() + (y.getRadius() / 12), y.getXCoordinate(),
					y.getYCoordinate() - (y.getHeight()) * 7 / 8);
			g.drawLine(y.getXCoordinate() + y.getRadius(), y.getYCoordinate() + (y.getRadius() / 12),
					y.getXCoordinate() + y.getRadius(), y.getYCoordinate() - (y.getHeight()) * 7 / 8);
			g.drawLine(y.getXCoordinate() + (y.getRadius() / 2), y.getYCoordinate() + (y.getRadius() / 12),
					y.getXCoordinate() + (y.getRadius() / 2), y.getYCoordinate() - (y.getHeight()) * 7 / 8);
			g.drawLine(y.getXCoordinate() + (y.getRadius() / 2), y.getYCoordinate() + (y.getRadius() / 12),
					y.getXCoordinate() + y.getRadius(), y.getYCoordinate() + (y.getRadius() / 12));
			break;
		}

		}
	}

	public static Line line() {
		String a, b, x, y;
		a = JOptionPane.showInputDialog(null, "Please Enter the X-Coordinate of the First Point (INTEGER)",
				"X (Start Point of Line)", JOptionPane.QUESTION_MESSAGE);
		b = JOptionPane.showInputDialog(null, "Please Enter the Y-Coordinate of the First Point (INTEGER)",
				"Y (Start Point of Line)", JOptionPane.QUESTION_MESSAGE);
		x = JOptionPane.showInputDialog(null, "Please Enter the X-Coordinate of the Second Point (INTEGER)",
				"X (End Point of Line)", JOptionPane.QUESTION_MESSAGE);
		y = JOptionPane.showInputDialog(null, "Please Enter the Y-Coordinate of the Second Point (INTEGER)",
				"Y (End Point of Line)", JOptionPane.QUESTION_MESSAGE);
		return new Line(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(x), Integer.parseInt(y));
	}

	public static Rectangle rectangle() {
		String x, y, w, h;
		x = JOptionPane.showInputDialog(null, "Please enter an integer:", "Top Left X Corner of Rectangle",
				JOptionPane.QUESTION_MESSAGE);
		y = JOptionPane.showInputDialog(null, "Please enter an integer:", "Top Left Y Corner of Rectangle",
				JOptionPane.QUESTION_MESSAGE);
		w = JOptionPane.showInputDialog(null, "Please enter an integer:", "Width of the Rectangle",
				JOptionPane.QUESTION_MESSAGE);
		h = JOptionPane.showInputDialog(null, "Please enter an integer:", "Height of the Rectangle",
				JOptionPane.QUESTION_MESSAGE);
		return new Rectangle(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(w), Integer.parseInt(h));
	}

	public static Ellipse ellipse() {
		String x, y, w, h;
		x = JOptionPane.showInputDialog(null, "Please enter an integer:", "Top Left X Corner of Ellipse",
				JOptionPane.QUESTION_MESSAGE);
		y = JOptionPane.showInputDialog(null, "Please enter an integer:", "Top Left Y Corner of Ellipse",
				JOptionPane.QUESTION_MESSAGE);
		w = JOptionPane.showInputDialog(null, "Please enter an integer:", "Width of the Ellipse",
				JOptionPane.QUESTION_MESSAGE);
		h = JOptionPane.showInputDialog(null, "Please enter an integer:", "Height of the Ellipse",
				JOptionPane.QUESTION_MESSAGE);
		return new Ellipse(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(w), Integer.parseInt(h));
	}

	public static Polygon polygon() {
		String x, y, s, r;
		x = JOptionPane.showInputDialog(null, "Please enter an integer:", "X-Coordinate of the Corner",
				JOptionPane.QUESTION_MESSAGE);
		y = JOptionPane.showInputDialog(null, "Please enter an integer:", "Y-Coordinate of the Corner",
				JOptionPane.QUESTION_MESSAGE);
		s = JOptionPane.showInputDialog(null, "Please enter an integer:", "Number of Sides",
				JOptionPane.QUESTION_MESSAGE);
		r = JOptionPane.showInputDialog(null, "Please enter an integer:", "Radius of Bounding Circle",
				JOptionPane.QUESTION_MESSAGE);
		return new Polygon(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(s), Integer.parseInt(r));
	}

	public static Sphere sphere() {
		String x, y, r;
		x = JOptionPane.showInputDialog(null, "Please enter an integer:", "X-Coordinate of the Center",
				JOptionPane.QUESTION_MESSAGE);
		y = JOptionPane.showInputDialog(null, "Please enter an integer:", "Y-Coordinate of the Center",
				JOptionPane.QUESTION_MESSAGE);
		r = JOptionPane.showInputDialog(null, "Please enter an integer:", "Radius", JOptionPane.QUESTION_MESSAGE);
		return new Sphere(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(r));
	}

	public static Cube cube() {
		String x, y, s;
		x = JOptionPane.showInputDialog(null, "Please Enter a Positive Integer:", "X-Coordinate of the Topleft Corner",
				JOptionPane.QUESTION_MESSAGE);
		y = JOptionPane.showInputDialog(null, "Please Enter a Positive Integer:", "Y-Coordinate of the Topleft Corner",
				JOptionPane.QUESTION_MESSAGE);
		s = JOptionPane.showInputDialog(null, "Please Please Enter a Positive Integer:", "Side of the Cube",
				JOptionPane.QUESTION_MESSAGE);
		return new Cube(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(s));
	}

	public static Cone cone() {
		String x, y, r, h;
		x = JOptionPane.showInputDialog(null, "Please enter an integer:", "X-Coordinate of the Center",
				JOptionPane.QUESTION_MESSAGE);
		y = JOptionPane.showInputDialog(null, "Please enter an integer:", "Y-Coordinate of the Center",
				JOptionPane.QUESTION_MESSAGE);
		r = JOptionPane.showInputDialog(null, "Please enter an integer:", "Radius", JOptionPane.QUESTION_MESSAGE);
		h = JOptionPane.showInputDialog(null, "Please enter an integer:", "Height", JOptionPane.QUESTION_MESSAGE);
		return new Cone(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(r), Integer.parseInt(h));
	}

	public static Cylinder cylinder() {
		String x, y, r, h;
		x = JOptionPane.showInputDialog(null, "Please enter an integer:", "X-Coordinate of the Center",
				JOptionPane.QUESTION_MESSAGE);
		y = JOptionPane.showInputDialog(null, "Please enter an integer:", "Y-Coordinate of the Center",
				JOptionPane.QUESTION_MESSAGE);
		r = JOptionPane.showInputDialog(null, "Please enter an integer:", "Radius", JOptionPane.QUESTION_MESSAGE);
		h = JOptionPane.showInputDialog(null, "Please enter an integer:", "Height", JOptionPane.QUESTION_MESSAGE);
		return new Cylinder(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(r), Integer.parseInt(h));
	}
}