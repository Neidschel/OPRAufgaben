package at.fhhgb.mc.Aufgabe02.Shapes;

import java.awt.*;
import java.awt.Rectangle;

/**
 * An abstract class which provides necessary methods for different graphic
 * objects like circle, triangle, rectangle and so on for right behavior when
 * those are drawn.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public abstract class GraphicPrimitive {

	// checks if the object is selected
	private boolean selected = false;
	// checks if the object is hovered
	private boolean hovered = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();

	/**
	 * Generates a Bounding Box of a GraphicPrimitive Object.
	 * 
	 * @return the Bounding Box Rectangle of this object.
	 */
	public abstract Rectangle getBoundingBox();

	/**
	 * Moves an GraphicPrimitive object.
	 * 
	 * @param dx
	 *            position change for the x coordinate
	 * @param dy
	 *            position change for the y coordinate
	 */
	public abstract void move(int dx, int dy);

	/**
	 * Draws this object on the DrawPanel.
	 * 
	 * @param g
	 *            the Graphic Container
	 */
	public abstract void draw(Graphics g);

	/**
	 * Makes a copy of the GraphicPrimitive object which called this method. All
	 * Points are copied and a new Object can be drawn.
	 * 
	 * @return a clone of that graphic primitive object
	 */
	public abstract GraphicPrimitive clone();

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean getSelected() {
		return selected;
	}

	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}

	public boolean getHovered() {
		return hovered;
	}

}
