package at.fhhgb.mc.Shapes;

import java.awt.*;
import java.awt.Rectangle;

public abstract class GraphicPrimitive {
	
	//checks if the object is selected
	private boolean selected = false;
	//checks if the object is hovered
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

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
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
