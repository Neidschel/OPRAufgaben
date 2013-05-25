package at.fhhgb.mc.Gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import at.fhhgb.mc.Shapes.*;
import at.fhhgb.mc.Shapes.Rectangle;

public class DrawPanel extends Panel implements ActionListener {

	private int xPoint;
	private int yPoint;
	private boolean[] checkButton = { false, false, false, false, false };
	protected ArrayList<Integer> xpoints = new ArrayList<Integer>();
	protected ArrayList<Integer> ypoints = new ArrayList<Integer>();
	private ArrayList<GraphicPrimitive> shapes = new ArrayList<GraphicPrimitive>();
	private String status = "";
	private int mouseX;
	private int mouseY;
	private int dx;
	private int dy;

	public DrawPanel() {
		super();
		// addMouseMotionListener(this); //register mouse motion events
		// m_okButton=new Button(OK);
		// m_okButton.addListener(this); //register for clicks to m_okButton
		this.setBackground(Color.gray);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				System.out.println("Mouse clicked at (" + e.getX() + "/"
//						+ e.getY() + ")");
				if (getButton() != -1) {
					xpoints.add(e.getX());
					ypoints.add(e.getY());
					checkPoints();
				}
				
				for (int i = 0; i < shapes.size(); i++) {
					if (shapes.get(i).getBoundingBox()
							.contains(e.getX(), e.getY())) {
						shapes.get(i).setSelected(true);
						dx = e.getX();
						dy = e.getY();
						System.out.println(dx);
						
					} else {
						shapes.get(i).setSelected(false);
					}
				}
				repaint();
			}
			
			public void mousePressed(MouseEvent e) {
				for (int i = 0; i < shapes.size(); i++) {
					if (shapes.get(i).getBoundingBox()
							.contains(e.getX(), e.getY())) {
						shapes.get(i).setSelected(true);
						dx = e.getX();
						dy = e.getY();
						System.out.println(dx);
						
					} else {
						shapes.get(i).setSelected(false);
					}
				}
				repaint();
			}
			
			public void mouseEntered(MouseEvent e) {
				repaint();
			}
			
			public void mouseExited(MouseEvent e) {
				repaint();
			}
			
			
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				for (int i = 0; i < shapes.size(); i++) {

					if (shapes.get(i).getBoundingBox()
							.contains(e.getX(), e.getY())) {
						shapes.get(i).setSelected(true);
						
						System.out.println(dx);
						shapes.get(i).move((e.getX()-dx), (e.getY()-dy));
						dx = e.getX();
						dy = e.getY();
					} else {
						shapes.get(i).setSelected(false);
					}

				}
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
				status = "(" + e.getX() + ", " + e.getY() + ")";
				mouseX = e.getX();
				mouseY = e.getY();

				for (int i = 0; i < shapes.size(); i++) {

					if (shapes.get(i).getBoundingBox()
							.contains(e.getX(), e.getY())) {
						shapes.get(i).setHovered(true);
						status = status + " " + shapes.get(i).toString();
					} else {
						shapes.get(i).setHovered(false);
					}

				}

				repaint();

			}

		});

	}

	public void setButton(int index) {
		for (int i = 0; i < checkButton.length; i++) {
			checkButton[i] = false;
		}

		xpoints.clear();
		ypoints.clear();
		repaint();
		if (index != -1) {
			checkButton[index] = true;
		}
	}

	public int getButton() {
		for (int i = 0; i < checkButton.length; i++) {
			if (checkButton[i])
				return i;
		}
		return -1;
	}

	public void checkPoints() {
		if (getButton() == 1 && xpoints.size() == 2) {
			Rectangle rec = new Rectangle(xpoints.get(0), ypoints.get(0),
					xpoints.get(1), ypoints.get(1));
			xpoints.clear();
			ypoints.clear();
			shapes.add(rec);
			setButton(-1);
			repaint();
		}

	}

	public void paint(Graphics g) {
		for (int i = 0; i < xpoints.size(); i++) {
			g.setColor(new Color(255, 0, 0));
			g.drawRect(xpoints.get(i), ypoints.get(i), 1, 1);
		}
		
		g.create();
		g.drawString(status, mouseX + 10, mouseY + 10);

		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(g);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
