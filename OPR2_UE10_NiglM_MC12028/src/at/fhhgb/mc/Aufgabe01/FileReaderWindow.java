package at.fhhgb.mc.Aufgabe01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FileReaderWindow extends Frame implements WindowListener{
	private Button read,clear;
private TextField m_text;

/**
* A anonymous class which represents the window where the buttons and the
* drawpanel are displayed.
*/
public FileReaderWindow() {
super("File Reader Window");
Panel panel1 = new Panel();
PeriodicFileReader pfr1 = new PeriodicFileReader();
ObservingTextArea textArea = new ObservingTextArea(pfr1);
// layout for Button + drawpanel
setLayout(new BorderLayout()); // North-east-south-west layout
// layout for the Buttons
panel1.setLayout(new FlowLayout());

// line Button with ActionListener when its pressed
read = new Button("Read");
read.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	}
});
panel1.add(read);

// rectangle Button with ActionListener when its pressed
clear = new Button("Clear");
clear.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	}
});
panel1.add(clear);

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

