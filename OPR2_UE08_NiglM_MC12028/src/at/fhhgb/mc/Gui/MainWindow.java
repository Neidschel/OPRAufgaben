package at.fhhgb.mc.Gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class MainWindow extends Frame implements ActionListener, WindowListener{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainWindow();
	}

	private Button m_northButton, southButton, m_eastButton, m_westButton;
	private TextField m_text;

	public MainWindow(){
		super("My funny example!");
		setLayout(new BorderLayout()); //North-east-south-west layout

		m_northButton= new Button("north");
		m_northButton.addActionListener(this);
		add("North", m_northButton);

		m_eastButton= new Button("east");
		m_eastButton.addActionListener(this);
		add("East", m_eastButton);

		m_westButton= new Button("west");
		m_westButton.addActionListener(this);
		add("West", m_westButton);

		southButton= new Button("south");
		southButton.addActionListener(this);
		add("South", southButton);

		m_text= new TextField();
		add("Center", m_text);

		setBounds(200, 200, 300, 300);
		addWindowListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s= "the "+e.getActionCommand()+"-button was pressed!";
		m_text.setText(s);
		repaint();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
