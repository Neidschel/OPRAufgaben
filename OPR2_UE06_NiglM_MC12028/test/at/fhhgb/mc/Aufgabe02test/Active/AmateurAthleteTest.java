package at.fhhgb.mc.Aufgabe02test.Active;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Abstract.*;
import at.fhhgb.mc.Aufgabe02.Active.*;
import at.fhhgb.mc.Aufgabe02.Member.*;

public class AmateurAthleteTest {

	@Test
	public void testAmateurAthlete() throws ValueException {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier", 5);
		assertEquals("Sepp Maier", person.getName());
	}

	// no throw intended
	@Test
	public void testAmateurAthleteNameNoException() throws ValueException {
		try {
			AmateurAthlete person = new AmateurAthlete("Hubert der Erste", 6);
		} catch (NullPointerException ex) {
			fail(ex.getMessage());
			;
		}
	}

	// throw intended
	@Test
	public void testAmateurAthleteNameException() throws ValueException {
		try {
			AmateurAthlete person = new AmateurAthlete(null, 5);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testGetIncome() throws ValueException {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier", 5);
		assertEquals(120.0, person.getIncome(), 0.1);
	}

	@Test
	public void testGetCosts() throws ValueException {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier", 5);
		assertEquals(150.0, person.getCosts(), 0.1);
	}

	@Test
	public void testGetSurplus() throws ValueException {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier", 5);
		assertEquals(-30, person.getSurplus(), 0.1);
	}

	// no throw expected
	@Test
	public void testAktivity() throws ValueException {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier", 5);
		try {
			person.setActivity(8);
		} catch (ValueException ex) {
			fail(ex.getMessage());
		}
		assertEquals(240.0, person.getCosts(), 0.1);
	}

	// throw expected
	@Test
	public void testAktivityToHigh() throws ValueException {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier", 5);
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
		AmateurAthlete person = new AmateurAthlete("Sepp Maier", 5);
		try {
			person.setActivity(-453);
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testToStringBoolean() throws ValueException {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier", 5);
		Section section1 = new Section("VolleyBall");
		assertEquals("AmateurAthlete: Sepp Maier costs -30.0 for the club.",
				person.toString(true));
	}

}
