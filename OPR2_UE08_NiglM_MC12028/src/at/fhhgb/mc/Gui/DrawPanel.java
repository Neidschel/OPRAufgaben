package at.fhhgb.mc.Gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import at.fhhgb.mc.Shapes.*;
import at.fhhgb.mc.Shapes.Rectangle;

public class DrawPanel extends Panel implements ActionListener {
    
	private int xPoint;
	private int yPoint;
	private boolean[] checkButton = {false,false,false,false,false};
	protected ArrayList<Integer> xpoints = new ArrayList<Integer>();
	protected ArrayList<Integer> ypoints = new ArrayList<Integer>();
	private ArrayList<GraphicPrimitive> shapes = new ArrayList<GraphicPrimitive>();
	
    public DrawPanel(){
    	super();
//    	addMouseMotionListener(this); //register mouse motion events m_okButton=new Button(OK);
//    	m_okButton.addListener(this); //register for clicks to m_okButton
    	this.setBackground(Color.gray);
    	this.addMouseListener(new MouseListener(){
    		public void mouseClicked(MouseEvent e) { 
    			System.out.println("Mouse clicked at ("+e.getX()+"/"+e.getY()+")");  
    			xpoints.add( e.getX());
    			ypoints.add( e.getY());
    			checkPoints();
//    			g.drawRect(e.getX(), e.getY(), 1,1);
    			repaint();
    		}
    		
    		public void mouseDragged(MouseEvent e) {
       		 String s = "("+ e.getX()
       		 + ", " + e.getY()+")";
       		 }

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
    	});
    	
    	class MyMouseMotionListener extends MouseMotionAdapter {
    		public void mouseDragged(MouseEvent e) {
       		 String s = "("+ e.getX()
       		 + ", " + e.getY()+")";
       		 }
    	 }
    	
    }
    
    public void setButton(int index){
    	for(int i = 0;i < checkButton.length;i++){
    		checkButton[i] = false;
    	}
    	
    	xpoints.clear();
    	ypoints.clear();
    	repaint();
    	checkButton[index]=true;
	}
    
    public int getButton(){
    	for(int i = 0;i < checkButton.length;i++){
    		if(checkButton[i]) return i;
    	}
    	return -1;
	}
    
    public void paint (Graphics g){
    	for(int i = 0; i<xpoints.size();i++){
    		g.setColor(new Color(255, 0, 0));
    		g.drawRect(xpoints.get(i), ypoints.get(i), 1,1);
    	}
    	
    	for(int i = 0; i<shapes.size();i++){
    		shapes.get(i).draw(g);
    	}
	 
	
    }
    
    public void checkPoints(){
    	if(getButton() == 1 && xpoints.size()==2){
    		Rectangle rec = new Rectangle(xpoints.get(0),ypoints.get(0),xpoints.get(1),ypoints.get(1));
    		xpoints.clear();
        	ypoints.clear();
    		shapes.add(rec);
    		
    		System.out.println("here");
    		
    		repaint();
    	}
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
