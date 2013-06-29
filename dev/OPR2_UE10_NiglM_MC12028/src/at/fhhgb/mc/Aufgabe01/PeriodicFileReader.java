package at.fhhgb.mc.Aufgabe01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import at.fhhgb.mc.Observable.MyObservable;
import at.fhhgb.mc.Observable.MyObserver;

/**
 * Class that reads the contents line-wise from a specified file
 * 
 * @author Paul Latzelsperger
 * @author Michael Nigl (implemented the TODOs)
 * @version 1.1
 */
public class PeriodicFileReader extends MyObservable<String> implements Runnable {

	private static String filename = "/at/fhhgb/mc/Aufgabe01/dummydata.log";

	private Thread m_readThread;
	private boolean m_running = true;

	/**
	 * Constructs a new PeriodicFileReader object.
	 */
	public PeriodicFileReader() {

	}

	/**
	 * Gets the path to the file which will be read
	 * 
	 * @return The file's path in package notation e.g.
	 *         <code>"/my/package/file.log"</code>
	 */
	public String getFileName() {
		return filename;
	}

	/**
	 * The internal thread's work method, where the magic happens
	 */
	@Override
	public void run() {

		BufferedReader rdr = null;
		try {

			// obtain a buffered reader to read file contents
			InputStream in = getClass().getResourceAsStream(filename);
			rdr = new BufferedReader(new InputStreamReader(in));

			String line = null;
			// as long as there is still content left to be read...
			while ((line = rdr.readLine()) != null && m_running) {
				if (!line.equals("")) {
					notifyObservers(line);
				}
				// yield for a little while
				Thread.sleep(50);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {

		} finally {
			if (rdr != null) { // gracefully free any resources
				try {
					rdr.close();
				} catch (IOException e) {
				}
			}

		}
	}

	/**
	 * Lets the PeriodicFileReader begin reading the file. Reading is done in a
	 * separate thread.
	 * 
	 * @param _obs
	 *            An instance of a {@link MyOvserver}, which receives update
	 *            calls as each line is read
	 */
	public synchronized void start(MyObserver<String> _obs) {
		addObserver(_obs);
		
		m_readThread = new Thread(this);
		m_running = true;
		m_readThread.start();
	}

	/**
	 * Interrupts reading a file and resets the thread object
	 */
	public synchronized void stop() {
		m_running = false;
		try {
			if (m_readThread != null)
				m_readThread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			m_readThread = null;
		}
	}
}
