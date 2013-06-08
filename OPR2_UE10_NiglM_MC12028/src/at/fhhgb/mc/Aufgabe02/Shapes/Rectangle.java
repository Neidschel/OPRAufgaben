package at.fhhgb.mc.Aufgabe02.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

/**
 * This Class provides methods for drawing a Rectangle. 
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class Rectangle extends GraphicPrimitive{
	
	int x, y, width, height;
	
	/**
	 * The constructor of Rectangle which get's the necessary points for drawing this rectangle.
	 * 
	 * @param xPoint1 the X coordinate of the top left corner of the rectangle
	 * @param yPoint1 the Y coordinate of the top left corner of the rectangle
	 * @param xPoint2 the X coordinate of the bottom right corner of the rectangle
	 * @param yPoint2 the y coordinate of the bottom right corner of the rectangle
	 */
	public Rectangle(int xPoint1, int yPoint1, int xPoint2, int yPoint2){
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
		
		width = xPoint2 - x;
		height = yPoint2 - y;
	}
	
	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#toString()
	 */
	@Override
	public String toString() {
		return "Rectangle X="+x+ " Y="+y+" W="+width+" H="+height;
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#getBoundingBox()
	 */
	public java.awt.Rectangle getBoundingBox() {
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
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0, 255, 0));
		g.drawRect(x, y, width, height);
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
		// TODO Auto-generated method stub
		return new Rectangle(x,y,x+width-1,y+height-1);
	}

}
