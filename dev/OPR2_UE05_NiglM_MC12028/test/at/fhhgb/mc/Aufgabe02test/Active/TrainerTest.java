package at.fhhgb.mc.Aufgabe02test.Active;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Active.*;
import at.fhhgb.mc.Aufgabe02.Member.*;
import at.fhhgb.mc.Aufgabe02.Abstract.*;

public class TrainerTest {

	@Test
	public void testTrainer() {
		Trainer person = new Trainer("Sepp Maier", 5);
		assertEquals("Sepp Maier", person.getName());
	}

	@Test
	public void testTrainerNull() {
		Trainer person = new Trainer(null, 5);
		assertEquals("failfailfail", person.getName());
	}

	@Test
	public void testGetIncome() {
		Trainer person = new Trainer("Sepp Maier", 5);
		assertEquals(120.0, person.getIncome(), 0.1);
	}

	@Test
	public void testGetCosts() {
		Trainer person = new Trainer("Sepp Maier", 5);
		assertEquals(2400.0, person.getCosts(), 0.1);
	}

	@Test
	public void testGetSurplus() {
		Trainer person = new Trainer("Sepp Maier", 5);
		assertEquals(-2280, person.getSurplus(), 0.1);
	}

	@Test
	public void testAktivity() {
		Trainer person = new Trainer("Sepp Maier", 5);
		person.setActivity(8);
		assertEquals(3840.0, person.getCosts(), 0.1);
	}

	@Test
	public void testAktivityToHigh() {
		Trainer person = new Trainer("Sepp Maier", 5);
		person.setActivity(345);
		assertEquals(10.0, person.getActivity(), 0.1);
	}

	@Test
	public void testAktivityToLow() {
		Trainer person = new Trainer("Sepp Maier", 5);
		person.setActivity(-453);
		assertEquals(0.0, person.getCosts(), 0.1);
	}

	@Test
	public void testToStringBoolean() {
		Trainer person = new Trainer("Sepp Maier", 5);
		Section section1 = new Section("VolleyBall");
		assertEquals("Trainer: Sepp Maier costs -2280.0 for the club.",
				person.toString(true));
	}

}
