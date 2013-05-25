package at.fhhgb.mc.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Circle extends GraphicPrimitive{
	
	int x, y, r;
	
	public Circle(int xPoint1, int yPoint1, int xPoint2, int yPoint2){
	
		x = xPoint1;
		y = yPoint1;
		
		r = (int)Math.sqrt((int)Math.pow((x - xPoint2),2)+(int)Math.pow((y - yPoint2),2));
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle M=("+x+ ","+y+") R="+r;
	}

	@Override
	public java.awt.Rectangle getBoundingBox() {
		java.awt.Rectangle bounds = new java.awt.Rectangle(x-1-r,y-1-r,r*2+2,r*2+2).getBounds();
		return bounds;
	}

	@Override
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

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

	@Override
	public GraphicPrimitive clone() {
		return null;
	}

}
