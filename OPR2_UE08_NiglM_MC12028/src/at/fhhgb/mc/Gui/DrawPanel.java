package at.fhhgb.mc.Gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import at.fhhgb.mc.Shapes.*;
import at.fhhgb.mc.Shapes.Rectangle;
import at.fhhgb.mc.Shapes.Polygon;

/**
 * This class implements a Panel where all of the drawings are done. With
 * buttons can be chosen which element should be drawn and with mouse clicks on
 * this panel the coordinates for the GrahpicPrimitive are determined.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class DrawPanel extends Panel implements ActionListener {

	private int xPoint;
	private int yPoint;
	// boolean array for checking which button is pressed
	private boolean[] checkButton = { false, false, false, false, false, false,
			false };
	protected boolean drawfilled = false;
	// x points for the new GraphicPrimitive to be drawn
	protected ArrayList<Integer> xpoints = new ArrayList<Integer>();
	// y points for the new GraphicPrimitive to be drawn
	protected ArrayList<Integer> ypoints = new ArrayList<Integer>();
	// all drawn GraphicPrimitives
	private ArrayList<GraphicPrimitive> shapes = new ArrayList<GraphicPrimitive>();

	private String status = "";
	private int mouseX;
	private int mouseY;
	private int dx;
	private int dy;

	/**
	 * A anonymous class which represents the panel where every GraphicPrimitive
	 * is drawn.
	 */
	public DrawPanel() {
		super();
		// addMouseMotionListener(this); //register mouse motion events
		// m_okButton=new Button(OK);
		// m_okButton.addListener(this); //register for clicks to m_okButton
		this.setBackground(Color.gray);
		this.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent
			 * )
			 */
			public void mouseClicked(MouseEvent e) {
				// System.out.println("Mouse clicked at (" + e.getX() + "/"
				// + e.getY() + ")");
				if (getButton() != -1) {
					xpoints.add(e.getX());
					ypoints.add(e.getY());
					checkPoints();
				}

				for (int i = 0; i < shapes.size(); i++) {
					if (shapes.get(i).getBoundingBox()
							.contains(e.getX(), e.getY())) {
						shapes.get(i).setSelected(true);

					} else {
						shapes.get(i).setSelected(false);
						shapes.get(i).setHovered(false);
					}
				}
				repaint();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent
			 * )
			 */
			public void mousePressed(MouseEvent e) {

				dx = e.getX();
				dy = e.getY();
				// for (int i = 0; i < shapes.size(); i++) {
				// if (shapes.get(i).getBoundingBox()
				// .contains(e.getX(), e.getY())
				// && shapes.get(i).getSelected()) {
				//
				//
				// } else {
				// shapes.get(i).setSelected(false);
				// shapes.get(i).setHovered(false);
				// }
				// }
				repaint();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent
			 * )
			 */
			public void mouseEntered(MouseEvent e) {
				repaint();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.MouseAdapter#mouseExited(java.awt.event.MouseEvent
			 * )
			 */
			public void mouseExited(MouseEvent e) {
				repaint();
			}

		});
		/**
		 * The MousmotionListener checks if the mouse is over a GraphicPrimitive
		 * and calls its toString method. Furthermore the mouse position is
		 * displayed. If the mouse drags something the move method of the
		 * corresponding GraphicPrimitive is called.
		 */
		this.addMouseMotionListener(new MouseMotionListener() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event
			 * .MouseEvent)
			 */
			public void mouseDragged(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				for (int i = 0; i < shapes.size(); i++) {

					if (shapes.get(i).getBoundingBox()
							.contains(e.getX(), e.getY())
							&& shapes.get(i).getSelected()
							|| shapes.get(i).getHovered()) {

						shapes.get(i).move((e.getX() - dx), (e.getY() - dy));
						System.out
								.println("Moving " + shapes.get(i).toString());
						status = "(" + e.getX() + ", " + e.getY() + ")"
								+ shapes.get(i).toString();
						;

					}

				}
				dx = e.getX();
				dy = e.getY();
				repaint();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.
			 * MouseEvent)
			 */
			public void mouseMoved(MouseEvent e) {
				status = "(" + e.getX() + ", " + e.getY() + ")";
				mouseX = e.getX();
				mouseY = e.getY();

				for (int i = 0; i < shapes.size(); i++) {

					if (shapes.get(i).getBoundingBox()
							.contains(e.getX(), e.getY())) {
						shapes.get(i).setHovered(true);
						status = status + " " + shapes.get(i).toString();
					} else {
						shapes.get(i).setHovered(false);
					}

				}

				repaint();

			}

		});

	}

	/**
	 * Resets the previous clicked button and sets the new clicked one active.
	 * 
	 * @param index
	 *            the number of the activated button
	 */
	public void setButton(int index) {
		for (int i = 0; i < checkButton.length; i++) {
			checkButton[i] = false;
		}

		xpoints.clear();
		ypoints.clear();
		repaint();
		if (index != -1) {
			checkButton[index] = true;
		}
	}

	/**
	 * Checks which button is at the moment pressed.
	 * 
	 * @return the number of the pressed button or -1 if no button is pressed
	 */
	public int getButton() {
		for (int i = 0; i < checkButton.length; i++) {
			if (checkButton[i])
				return i;
		}
		return -1;
	}

	/**
	 * This Method checks which button is at the moment used. This determines
	 * which object the user attempts to draw next. Furthermore the method
	 * counts the already drawn points and determines if there is enough
	 * information to draw the GraphicPrimitive.
	 */
	public void checkPoints() {

		// conditions for line
		if (getButton() == 0 && xpoints.size() == 2) {
			Line line = new Line(xpoints.get(0), ypoints.get(0),
					xpoints.get(1), ypoints.get(1));
			line.setFilled(drawfilled);
			xpoints.clear();
			ypoints.clear();
			shapes.add(line);
			setButton(-1);
			repaint();
		}

		// conditions for rectangle
		if (getButton() == 1 && xpoints.size() == 2) {
			Rectangle rec = new Rectangle(xpoints.get(0), ypoints.get(0),
					xpoints.get(1), ypoints.get(1));
			rec.setFilled(drawfilled);
			xpoints.clear();
			ypoints.clear();
			shapes.add(rec);
			setButton(-1);
			repaint();
		}

		// conditions for circle
		if (getButton() == 2 && xpoints.size() == 2) {
			Circle circle = new Circle(xpoints.get(0), ypoints.get(0),
					xpoints.get(1), ypoints.get(1));
			circle.setFilled(drawfilled);
			xpoints.clear();
			ypoints.clear();
			shapes.add(circle);
			setButton(-1);
			repaint();
		}

		// conditions for triangle
		if (getButton() == 3 && xpoints.size() == 3) {
			int x[] = new int[3];
			int y[] = new int[3];
			for (int i = 0; i < xpoints.size(); i++) {
				x[i] = xpoints.get(i);
				y[i] = ypoints.get(i);
			}

			Triangle triangle = new Triangle(x, y, xpoints.size());
			triangle.setFilled(drawfilled);

			xpoints.clear();
			ypoints.clear();
			shapes.add(triangle);
			setButton(-1);
			repaint();
		}

		// conditions for polygon
		if (getButton() == 4 && xpoints.size() >= 3) {
			int resultx = Math.abs(xpoints.get(0)
					- xpoints.get(xpoints.size() - 1));
			int resulty = Math.abs(ypoints.get(0)
					- ypoints.get(ypoints.size() - 1));
			resultx = (int) Math.pow(resultx, 2);
			resulty = (int) Math.pow(resulty, 2);

			if (resultx <= 400 && resulty <= 400) {
				int x[] = new int[xpoints.size() - 1];
				int y[] = new int[ypoints.size() - 1];
				for (int i = 0; i < x.length; i++) {
					x[i] = xpoints.get(i);
					y[i] = ypoints.get(i);
				}

				Polygon polygon = new Polygon(x, y, x.length);
				polygon.setFilled(drawfilled);

				xpoints.clear();
				ypoints.clear();
				shapes.add(polygon);
				setButton(-1);
				repaint();
			}

		}

		// conditions for clear
		if (getButton() == 5) {
			for (int i = 0; i < shapes.size(); i++) {
				if (shapes.get(i).getSelected()) {
					shapes.remove(i);
				}
			}
			xpoints.clear();
			ypoints.clear();
			setButton(-1);
			repaint();
		}

		// conditions for remove all
		if (getButton() == 6) {
			xpoints.clear();
			ypoints.clear();
			shapes.clear();
			setButton(-1);
			repaint();
		}

	}

	/**
	 * Draws a selected Shape with the given rgb values.
	 * 
	 * @param r
	 *            red value of the color
	 * @param g
	 *            green value of the color
	 * @param b
	 *            blue value of the color
	 */
	public void setColorShapes(int r, int g, int b) {
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i).getSelected()) {
				shapes.get(i).setColor(r, g, b);

			}
		}
		repaint();
	}

	/**
	 * Helping method which checks if the Objects are filled or not.
	 */
	public void fillShapes() {
		for (int i = 0; i < shapes.size(); i++) {

			shapes.get(i).setFilled(drawfilled);
		}
		repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		for (int i = 0; i < xpoints.size(); i++) {
			g.setColor(new Color(255, 0, 0));
			g.drawRect(xpoints.get(i), ypoints.get(i), 1, 1);
		}

		// g.create();
		g.drawString(status, mouseX + 10, mouseY + 10);

		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(g);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
