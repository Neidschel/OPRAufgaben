package at.fhhgb.mc.Aufgabe02Gui;

import java.awt.*;
import java.awt.event.*;

import at.fhhgb.mc.interfaces.*;
import at.fhhgb.mc.Aufgabe01.*;
import at.fhhgb.mc.Aufgabe02Shapes.*;
import at.fhhgb.mc.Aufgabe02Shapes.Polygon;
import at.fhhgb.mc.Aufgabe02Shapes.Rectangle;

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
	// x points for the new GraphicPrimitive to be drawn
	protected DoubleLinkedList<Integer> xpoints = new DoubleLinkedList<Integer>();
	// y points for the new GraphicPrimitive to be drawn
	protected DoubleLinkedList<Integer> ypoints = new DoubleLinkedList<Integer>();
	// all drawn GraphicPrimitives
	private DoubleLinkedList<GraphicPrimitive> shapes = new DoubleLinkedList<GraphicPrimitive>();

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
					xpoints.pushBack(e.getX());
					ypoints.pushBack(e.getY());
					try {
						checkPoints();
					} catch (InvalidAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				GraphicPrimitive g1;
				Iterator<GraphicPrimitive> iter = shapes.iterator();
				while (iter.hasNext()) {
					try {
						g1 = iter.next();
						if (g1.getBoundingBox()
								.contains(e.getX(), e.getY())) {
							g1.setSelected(true);
							dx = e.getX();
							dy = e.getY();

						} else {
							g1.setSelected(false);
							g1.setHovered(false);
						}
					} catch (InvalidAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
				Iterator<GraphicPrimitive> iter = shapes.iterator();
				GraphicPrimitive g1;
				while (iter.hasNext()) {
					try {
						g1 = iter.next();
						if (g1.getBoundingBox()
								.contains(e.getX(), e.getY())
								&& g1.getSelected()) {
							
							dx = e.getX();
							dy = e.getY();
							System.out.println(dx);

						} else {
							g1.setSelected(false);
							g1.setHovered(false);
						}
					} catch (InvalidAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
				Iterator<GraphicPrimitive> iter = shapes.iterator();
				GraphicPrimitive g1;
				while (iter.hasNext()) {

					try {
						g1 = iter.next();
						if (g1.getBoundingBox()
								.contains(e.getX(), e.getY())
								&& g1.getSelected()) {

							g1.move((e.getX() - dx), (e.getY() - dy));
							dx = e.getX();
							dy = e.getY();
						}
					} catch (InvalidAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
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

				Iterator<GraphicPrimitive> iter = shapes.iterator();
				GraphicPrimitive g1;
				while (iter.hasNext()) {

					try {
						g1 = iter.next();
						if (g1.getBoundingBox()
								.contains(e.getX(), e.getY())) {
							g1.setHovered(true);
							status = status + " " + g1.toString();
						} else {
							g1.setHovered(false);
						}
					} catch (InvalidAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
	 * @throws InvalidAccessException 
	 */
	public void checkPoints() throws InvalidAccessException {

		// conditions for line
		if (getButton() == 0 && xpoints.elements() == 2) {
			Line line = new Line(xpoints.popFront(), ypoints.popFront(),
					xpoints.popFront(), ypoints.popFront());
			xpoints.clear();
			ypoints.clear();
			shapes.pushBack(line);
			setButton(-1);
			repaint();
		}

		// conditions for rectangle
		if (getButton() == 1 && xpoints.elements() == 2) {
			Rectangle rec = new Rectangle(xpoints.popFront(), ypoints.popFront(),
					xpoints.popFront(), ypoints.popFront());
			xpoints.clear();
			ypoints.clear();
			shapes.pushBack(rec);
			setButton(-1);
			repaint();
		}

		// conditions for circle
		if (getButton() == 2 && xpoints.elements() == 2) {
			Circle circle = new Circle(xpoints.popFront(), ypoints.popFront(),
					xpoints.popFront(), ypoints.popFront());
			xpoints.clear();
			ypoints.clear();
			shapes.pushBack(circle);
			setButton(-1);
			repaint();
		}

		// conditions for triangle
		if (getButton() == 3 && xpoints.elements() == 3) {
			int x[] = new int[3];
			int y[] = new int[3];
			for (int i = 0; i < 3; i++) {
				x[i] = xpoints.popFront();
				y[i] = ypoints.popFront();
				System.out.println(x[i]+"   "+y[i]);
			}
			Triangle triangle = new Triangle(x, y, 3);
			xpoints.clear();
			ypoints.clear();
			shapes.pushBack(triangle);
			setButton(-1);
			repaint();
		}

		// conditions for polygon
		if (getButton() == 4 && xpoints.elements() >= 3) {
			int resultx = Math.abs(xpoints.peekFront()
					- xpoints.peekBack());
			int resulty = Math.abs(ypoints.peekFront()
					- ypoints.peekBack());
			resultx = (int) Math.pow(resultx, 2);
			resulty = (int) Math.pow(resulty, 2);

			if (resultx <= 400 && resulty <= 400) {
				int x[] = new int[xpoints.elements()-1];
				int y[] = new int[ypoints.elements()-1];
				
				Iterator<Integer> iter = xpoints.iterator();
				Iterator<Integer> iter2 = ypoints.iterator();

				for (int i = 0; i < x.length;i++) {
					x[i] = iter.next();
					y[i] = iter2.next();
				}

				Polygon polygon = new Polygon(x, y, x.length);
				xpoints.clear();
				ypoints.clear();
				shapes.pushBack(polygon);
				setButton(-1);
				repaint();
			}

		}

		// conditions for clear
		if (getButton() == 5) {
			Iterator<GraphicPrimitive> iter = shapes.iterator();
			GraphicPrimitive g1;
			while (iter.hasNext()) {
				if (iter.next().getSelected()) {
					iter.previous();
					iter.remove();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		Iterator<Integer> iter = xpoints.iterator();
		Iterator<Integer> iter2 = ypoints.iterator();

		while (iter.hasNext()) {
			g.setColor(new Color(255, 0, 0));
			try {
				g.drawRect(iter.next(), iter2.next(), 1, 1);
			} catch (InvalidAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		g.drawString(status, mouseX + 10, mouseY + 10);
		Iterator<GraphicPrimitive> iter3 = shapes.iterator();

		while (iter3.hasNext()) {
			try {
				iter3.next().draw(g);
			} catch (InvalidAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
