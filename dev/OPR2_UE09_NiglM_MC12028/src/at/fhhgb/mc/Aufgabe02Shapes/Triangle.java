package at.fhhgb.mc.Aufgabe02Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * This Class provides methods for drawing a Triangle. 
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class Triangle extends GraphicPrimitive{
	
	private int[] x = new int[3];
	private int[] y = new int[3];
	private int points;
	
	/**
	 * The constructor of Triangle which get's the necessary points for drawing this triangle.
	 * 
	 * @param x the X coordinates of the triangle
	 * @param y the Y coordinates of the triangle
	 * @param points the number of points
	 */
	public Triangle(int[] x, int[] y, int points){
		for(int i = 0; i < this.x.length;i++){
			this.x[i] = x[i];
			this.y[i] = y[i];
		}
		this.points = points;
	}
	
	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Triangle P1=("+x[0]+ ","+y[0]+") P2=("+x[1]+ ","+y[1]+") P3=("+x[2]+ ","+y[2]+")";
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#getBoundingBox()
	 */
	@Override
	public java.awt.Rectangle getBoundingBox() {
		java.awt.Rectangle bounds = new java.awt.Polygon(x,y,points).getBounds();
		return bounds;
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#move(int, int)
	 */
	@Override
	public void move(int dx, int dy) {
		x[0] += dx;
		y[0] += dy;
		x[1] += dx;
		y[1] += dy;
		x[2] += dx;
		y[2] += dy;
		
	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Shapes.GraphicPrimitive#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(100, 255, 255));
		g.drawPolygon(x,y,points);
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
		return new Triangle(x,y,points);
	}

}
