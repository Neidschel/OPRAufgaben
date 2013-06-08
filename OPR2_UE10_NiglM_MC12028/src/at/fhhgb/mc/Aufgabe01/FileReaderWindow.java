package at.fhhgb.mc.Aufgabe01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The main window which is generated when the program is started. The buttons
 * and the TextArea are displayed hier. ButtonClicks and changes to the TextArea
 * are notified by an Observer.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class FileReaderWindow extends Frame implements WindowListener {
	private Button read, clear, stop;
	private PeriodicFileReader pfr1;
	private ObservingTextArea<String> textArea;

	/**
	 * A anonymous class which represents the window where the buttons and the
	 * TextArea are displayed.
	 */
	public FileReaderWindow() {
		super("File Reader Window");
		Panel panel1 = new Panel();
		textArea = new ObservingTextArea<String>();
		pfr1 = new PeriodicFileReader();
		// layout for Button + drawpanel
		setLayout(new BorderLayout()); // North-east-south-west layout
		// layout for the Buttons
		panel1.setLayout(new FlowLayout());

		// Read Button with ActionListener when its pressed
		read = new Button("Read");
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pfr1 = new PeriodicFileReader();
				pfr1.start(textArea);
			}
		});
		panel1.add(read);

		// Clear Button with ActionListener when its pressed
		clear = new Button("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		panel1.add(clear);

		// Stop Button with ActionListener when its pressed
		stop = new Button("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pfr1.stop();
			}
		});

		panel1.add(stop);

		add("North", panel1);
		add("Center", textArea);

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
