package at.fhhgb.mc.Gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The main window which is generated when the program is started. The buttons
 * and the drawpanel are displayed and called with Listeners.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class Window extends Frame implements WindowListener {

	/**
	 * The main Method which starts the program.
	 * 
	 * @param args
	 *            no arguments here
	 */
	public static void main(String[] args) {
		new Window();
	}

	private Button triangleButton, rectangleButton, polygonButton,
			circleButton, lineButton, clearButton, deleteAllButton;
	private Checkbox filled;

	/**
	 * A anonymous class which represents the window where the buttons and the
	 * drawpanel are displayed.
	 */
	public Window() {
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
				drawings.checkPoints();
			}
		});
		panel1.add(clearButton);

		// ClearAll Button with ActionListener when its pressed
		deleteAllButton = new Button("Clear All");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawings.setButton(6);
				drawings.checkPoints();
			}
		});
		panel1.add(deleteAllButton);
		filled = new Checkbox("filled", false);
		filled.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(filled.getState()){
					drawings.drawfilled = true;
				}else{
					drawings.drawfilled = false;
					System.out.println("here");
				}
				drawings.fillShapes();
			}
		});
		panel1.add(filled);
		//scrollbar for the red value
		final Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL, 50, 0, 0, 255);
		//scrollbar for the green value
		final Scrollbar sb2 = new Scrollbar(Scrollbar.HORIZONTAL, 50, 0, 0, 255);
		//scrollbar for the blue value
		final Scrollbar sb3 = new Scrollbar(Scrollbar.HORIZONTAL, 50, 0, 0, 255);
		
		
		sb.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged (AdjustmentEvent e) {
				drawings.setColorShapes(sb.getValue(),sb2.getValue(),sb3.getValue());
				}
		});
		
		sb2.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged (AdjustmentEvent e) {
				drawings.setColorShapes(sb.getValue(),sb2.getValue(),sb3.getValue());
				}
		});
		sb3.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged (AdjustmentEvent e) {
				drawings.setColorShapes(sb.getValue(),sb2.getValue(),sb3.getValue());
				}
		});
		panel1.add(sb);
		panel1.add(sb2);
		panel1.add(sb3);
		
		add("North", panel1);
		add("Center", drawings);

		setBounds(100, 100, 1200, 800);
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
