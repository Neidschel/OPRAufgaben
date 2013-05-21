package at.fhhgb.mc.Shapes;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Rectangle;


public abstract class GraphicPrimitive{
	
	private boolean selected = false;
	
	public abstract String toString();
	
	public abstract Rectangle getBoundingBox();

	public abstract void move(int dx, int dy);
	
	public abstract void draw(Graphics g);
	
	public abstract GraphicPrimitive clone();
	
	public void setSelected(boolean selected){
		this.selected = selected;
	}
	
	public boolean getSelected(){
		return selected;
	}
	
}
