package at.fhhgb.mc.Gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends Frame implements WindowListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Window();
	}

	private Button triangleButton, rectangleButton, polygonButton, circleButton, lineButton,
			clearButton, deleteAllButton;
	private TextField m_text;

	public Window() {
		super("My Draw Window");
		Panel panel1 = new Panel();
		final DrawPanel drawings = new DrawPanel();
		setLayout(new BorderLayout()); // North-east-south-west layout

		panel1.setLayout(new FlowLayout());
		
		lineButton = new Button("Line");
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(0);
				lineButton.setEnabled(true);
			}
		});
		panel1.add(lineButton);
		
		rectangleButton = new Button("Rectangle");
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(1);
				rectangleButton.setEnabled(true);
			}
		});
		panel1.add(rectangleButton);

		circleButton = new Button("Circle");
		circleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(2);
			}
		});
		panel1.add(circleButton);

		triangleButton = new Button("Triangle");
		triangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(3);
			}
		});
		panel1.add(triangleButton);

		polygonButton = new Button("Polygon");
		polygonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(4);
			}
		});
		panel1.add(polygonButton);

		clearButton = new Button("Delete");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(5);
				drawings.checkPoints();
			}
		});
		panel1.add(clearButton);

		deleteAllButton = new Button("Clear All");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(6);
				drawings.checkPoints();
			}
		});
		panel1.add(deleteAllButton);

		add("North", panel1);
		add("Center", drawings);

		setBounds(100, 100, 1024, 768);
		addWindowListener(this);
		setVisible(true);

	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.setVisible(false);
		System.exit(0);

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
