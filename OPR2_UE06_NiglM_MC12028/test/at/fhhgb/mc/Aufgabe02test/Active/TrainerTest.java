package at.fhhgb.mc.Aufgabe02test.Active;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Active.*;
import at.fhhgb.mc.Aufgabe02.Member.*;
import at.fhhgb.mc.Aufgabe02.Abstract.*;

public class TrainerTest {

	@Test
	public void testTrainer() throws ValueException {
		Trainer person = new Trainer("Sepp Maier", 5);
		assertEquals("Sepp Maier", person.getName());
	}

	// no throw intended
	@Test
	public void testTrainerNameNoException() throws ValueException {
		try {
			Trainer person = new Trainer("Hubert der Erste", 6);
		} catch (NullPointerException ex) {
			fail(ex.getMessage());
			;
		}
	}

	// throw intended
	@Test
	public void testTrainerNameException() throws ValueException {
		try {
			Trainer person = new Trainer(null, 5);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testGetIncome() throws ValueException {
		Trainer person = new Trainer("Sepp Maier", 5);
		assertEquals(120.0, person.getIncome(), 0.1);
	}

	@Test
	public void testGetCosts() throws ValueException {
		Trainer person = new Trainer("Sepp Maier", 5);
		assertEquals(2400.0, person.getCosts(), 0.1);
	}

	@Test
	public void testGetSurplus() throws ValueException {
		Trainer person = new Trainer("Sepp Maier", 5);
		assertEquals(-2280, person.getSurplus(), 0.1);
	}
	
	//no throw expected
	@Test
	public void testAktivity() throws ValueException {
		Trainer person = new Trainer("Sepp Maier", 5);
		try{
			person.setActivity(8);
		}catch(ValueException ex){
			fail(ex.getMessage());
		}
		assertEquals(3840.0, person.getCosts(), 0.1);
	}

	// throw expected
	@Test
	public void testAktivityToHigh() throws ValueException {
		Trainer person = new Trainer("Sepp Maier", 5);
		try {
			person.setActivity(345);
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected");
	}

	// throw expected
	@Test
	public void testAktivityToLow() throws ValueException {
		Trainer person = new Trainer("Sepp Maier", 5);
		try {
			person.setActivity(-453);
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testToStringBoolean() throws ValueException {
		Trainer person = new Trainer("Sepp Maier", 5);
		Section section1 = new Section("VolleyBall");
		assertEquals("Trainer: Sepp Maier costs -2280.0 for the club.",
				person.toString(true));
	}

}
