package at.fhhgb.mc.Aufgabe02Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * This Class provides methods for drawing a Line. 
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class Line extends GraphicPrimitive{
	
	int x, y, x2, y2,width,height;
	
	/**
	 * The constructor of Line which get's the necessary points for drawing this line.
	 * 
	 * @param xPoint1 the X coordinate of the starting point of the line
	 * @param yPoint1 the y coordinate of the starting point of the line
	 * @param xPoint2 the X coordinate of the ending point of the line
	 * @param yPoint2 the Y coordinate of the ending point of the line
	 */
	public Line(int xPoint1, int yPoint1, int xPoint2, int yPoint2){
		if(xPoint1 > xPoint2){
			int tmp = xPoint1;
			xPoint1 = xPoint2;
			xPoint2 = tmp;
			
		}
		x = xPoint1;
		
		if(yPoint1 > yPoint2){
			int tmp = yPoint1;
			yPoint1 = yPoint2;
			yPoint2 = tmp;
		}
		y = yPoint1;
		
		x2 = xPoint2;
		y2 = yPoint2;
		width = xPoint2 - x;
		height = yPoint2 - y;
	}
	
	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#toString()
	 */
	@Override
	public String toString() {

		return "Line P1=("+x+ ","+y+") P2=("+x2+ ","+y2+")";
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#getBoundingBox()
	 */
	@Override
	public Rectangle getBoundingBox() {
		java.awt.Rectangle bounds = new java.awt.Rectangle(x,y,width,height).getBounds();
		return bounds;
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#move(int, int)
	 */
	@Override
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
		x2 += dx;
		y2 += dy;
		
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0, 0, 255));
		g.drawLine(x, y, x2, y2);
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
		return new Line(x,y,x2,y2);
	}

}
