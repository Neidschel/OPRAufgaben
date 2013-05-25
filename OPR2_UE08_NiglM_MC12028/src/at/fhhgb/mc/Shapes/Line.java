package at.fhhgb.mc.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Line extends GraphicPrimitive{
	
	int x, y, x2, y2,width,height;
	
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
	
	@Override
	public String toString() {

		return "Line P1=("+x+ ","+y+") P2=("+x2+ ","+y2+")";
	}

	@Override
	public Rectangle getBoundingBox() {
		java.awt.Rectangle bounds = new java.awt.Rectangle(x,y,width,height).getBounds();
		return bounds;
	}

	@Override
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
		x2 += dx;
		y2 += dy;
		
	}

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

	@Override
	public GraphicPrimitive clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
