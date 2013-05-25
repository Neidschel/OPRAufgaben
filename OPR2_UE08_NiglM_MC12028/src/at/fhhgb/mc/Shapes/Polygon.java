package at.fhhgb.mc.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Polygon extends GraphicPrimitive{

	private int[] x;
	private int[] y;
	private int points;
	
	public Polygon(int[] x, int[] y, int points){
		
		this.x = new int[x.length];
		this.y = new int[x.length];
		
		for(int i = 0; i < this.x.length;i++){
			this.x[i] = x[i];
			this.y[i] = y[i];
		}
		this.points = points;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Polygon ");
		for(int i = 0; i < this.x.length;i++){
			output.append("P"+(i+1)+"=("+x[i]+ ","+y[i]+")");
			if((i%3)==0){
				output.append("\n");
			}
		}
		return output.toString();
	}

	@Override
	public java.awt.Rectangle getBoundingBox() {
		java.awt.Rectangle bounds = new java.awt.Polygon(x,y,points).getBounds();
		return bounds;
	}

	@Override
	public void move(int dx, int dy) {
		
		for(int i = 0; i < this.x.length;i++){
			this.x[i] += dx;
			this.y[i] += dy;
		}
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(120, 150, 230));
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

	@Override
	public GraphicPrimitive clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
