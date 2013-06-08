package at.fhhgb.mc.Aufgabe02.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * This Class provides methods for drawing a Circle. 
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class Circle extends GraphicPrimitive{
	
	int x, y,x2,y2, r;
	
	/**
	 * The constructor of Circle which get's the necessary points for drawing this circle.
	 * 
	 * @param xPoint1 X coordinate for the middle point of the circle
	 * @param yPoint1 Y coordinate for the middle point of the circle
	 * @param xPoint2 X coordinate for the border point of the circle
	 * @param yPoint2 Y coordinate for the border point of the circle
	 */
	public Circle(int xPoint1, int yPoint1, int xPoint2, int yPoint2){
	
		x = xPoint1;
		y = yPoint1;
		x2 = xPoint2;
		y2 = yPoint2;
		
		r = (int)Math.sqrt((int)Math.pow((x - xPoint2),2)+(int)Math.pow((y - yPoint2),2));
	}
	
	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle M=("+x+ ","+y+") R="+r;
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#getBoundingBox()
	 */
	@Override
	public java.awt.Rectangle getBoundingBox() {
		java.awt.Rectangle bounds = new java.awt.Rectangle(x-1-r,y-1-r,r*2+2,r*2+2).getBounds();
		return bounds;
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#move(int, int)
	 */
	@Override
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(255, 255, 0));
		g.drawOval(x-r, y-r, r*2, r*2);
		if(getHovered()){
			java.awt.Rectangle bounds = getBoundingBox();
			g.setColor(new Color(10, 10, 10));
			g.drawRect((int)bounds.getX(),(int) bounds.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
		}
		if(getSelected()){
			java.awt.Rectangle bounds = getBoundingBox();
			g.setColor(new Color(255, 0, 0));
			Graphics2D g2 = (Graphics2D) g;
	        g2.setStroke(new BasicStroke(3));
			g2.drawRect((int)bounds.getX(),(int) bounds.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
		}
		
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#clone()
	 */
	@Override
	public GraphicPrimitive clone() {
		return new Circle(x,y,x2,y2);
	}

}
