package at.fhhgb.mc.Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends GraphicPrimitive{
	
	int x, y, width, height;
	
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.awt.Rectangle getBoundingBox() {
		
		return getBoundingBox();
	}

	@Override
	public void move(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0, 255, 0));
		g.drawRect(x, y, width, height);		
	}

	@Override
	public GraphicPrimitive clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
