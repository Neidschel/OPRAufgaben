package at.fhhgb.mc.Aufgabe02Gui;

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

import at.fhhgb.mc.Aufgabe01.InvalidAccessException;

/**
 * The main window which is generated when the program is started. The buttons
 * and the drawpanel are displayed and called with Listeners.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class DrawWindow extends Frame implements WindowListener {

	private Button triangleButton, rectangleButton, polygonButton,
			circleButton, lineButton, clearButton, deleteAllButton;
	private TextField m_text;

	/**
	 * A anonymous class which represents the window where the buttons and the
	 * drawpanel are displayed.
	 */
	public DrawWindow() {
		super("My Draw Window");
		Panel panel1 = new Panel();
		final DrawPanel drawings = new DrawPanel();
		// layout for Button + drawpanel
		setLayout(new BorderLayout()); // North-east-south-west layout
		// layout for the Buttons
		panel1.setLayout(new FlowLayout());

		// line Button with ActionListener when its pressed
		lineButton = new Button("Line");
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(0);
				lineButton.setEnabled(true);
			}
		});
		panel1.add(lineButton);

		// rectangle Button with ActionListener when its pressed
		rectangleButton = new Button("Rectangle");
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(1);
				rectangleButton.setEnabled(true);
			}
		});
		panel1.add(rectangleButton);

		// circle Button with ActionListener when its pressed
		circleButton = new Button("Circle");
		circleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(2);
			}
		});
		panel1.add(circleButton);

		// triangle Button with ActionListener when its pressed
		triangleButton = new Button("Triangle");
		triangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(3);
			}
		});
		panel1.add(triangleButton);

		// polygon Button with ActionListener when its pressed
		polygonButton = new Button("Polygon");
		polygonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(4);
			}
		});
		panel1.add(polygonButton);

		// Delete Button with ActionListener when its pressed
		clearButton = new Button("Delete");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(5);
				try {
					drawings.checkPoints();
				} catch (InvalidAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel1.add(clearButton);

		// ClearAll Button with ActionListener when its pressed
		deleteAllButton = new Button("Clear All");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(6);
				try {
					drawings.checkPoints();
				} catch (InvalidAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
