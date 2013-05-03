package at.fhhgb.mc.Aufgabe02test.Active;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Abstract.ValueException;
import at.fhhgb.mc.Aufgabe02.Active.*;
import at.fhhgb.mc.Aufgabe02.Member.Section;

public class TopAthleteTest {

	@Test
	public void testTopAthlete() throws ValueException {
		TopAthlete person = new TopAthlete("Sepp Maier", 5);
		assertEquals("Sepp Maier", person.getName());
	}

	// no throw intended
	@Test
	public void testTopAthleteNameNoException() throws ValueException {
		try {
			TopAthlete person = new TopAthlete("Hubert der Erste", 6);
		} catch (NullPointerException ex) {
			fail(ex.getMessage());
			;
		}
	}

	// throw intended
	@Test
	public void testTopAthleteNameException() throws ValueException {
		try {
			TopAthlete person = new TopAthlete(null, 5);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testGetIncome() throws ValueException {
		TopAthlete person = new TopAthlete("Sepp Maier", 5);
		assertEquals(120.0, person.getIncome(), 0.1);
	}

	@Test
	public void testGetCosts() throws ValueException {
		TopAthlete person = new TopAthlete("Sepp Maier", 5);
		assertEquals(300.0, person.getCosts(), 0.1);
	}

	@Test
	public void testGetSurplus() throws ValueException {
		TopAthlete person = new TopAthlete("Sepp Maier", 5);
		assertEquals(-180, person.getSurplus(), 0.1);
	}

	// no throw expected
	@Test
	public void testAktivity() throws ValueException {
		TopAthlete person = new TopAthlete("Sepp Maier", 5);
		try {
			person.setActivity(8);
		} catch (ValueException ex) {
			fail(ex.getMessage());
		}
		assertEquals(480.0, person.getCosts(), 0.1);
	}

	// throw expected
	@Test
	public void testAktivityToHigh() throws ValueException {
		TopAthlete person = new TopAthlete("Sepp Maier", 5);
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
		TopAthlete person = new TopAthlete("Sepp Maier", 5);
		try {
			person.setActivity(-453);
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testToStringBoolean() throws ValueException {
		TopAthlete person = new TopAthlete("Sepp Maier", 5);
		Section section1 = new Section("VolleyBall");
		assertEquals("TopAthlete: Sepp Maier costs -180.0 for the club.",
				person.toString(true));
	}

}
