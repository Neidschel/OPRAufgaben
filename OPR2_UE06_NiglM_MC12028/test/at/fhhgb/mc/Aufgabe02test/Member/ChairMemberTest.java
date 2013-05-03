package at.fhhgb.mc.Aufgabe02test.Member;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Abstract.ValueException;
import at.fhhgb.mc.Aufgabe02.Active.*;
import at.fhhgb.mc.Aufgabe02.Member.*;

public class ChairMemberTest {

	@Test
	public void testChairMember() throws ValueException {
		ChairMember person = new ChairMember("Sepp Maier", 5);
		assertEquals("Sepp Maier", person.getName());
	}

	// no throw intended
	@Test
	public void testChairMemberNameNoException() throws ValueException {
		try {
			ChairMember person = new ChairMember("Hubert der Erste", 6);
		} catch (NullPointerException ex) {
			fail(ex.getMessage());
			
		}
	}

	// throw intended
	@Test
	public void testChairMemberNameException() throws ValueException {
		try {
			ChairMember person = new ChairMember(null, 5);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testGetIncome() throws ValueException {
		ChairMember person = new ChairMember("Sepp Maier", 5);
		assertEquals(500.0, person.getIncome(), 0.1);
	}

	@Test
	public void testGetCosts() throws ValueException {
		ChairMember person = new ChairMember("Sepp Maier", 5);
		assertEquals(100.0, person.getCosts(), 0.1);
	}

	@Test
	public void testGetSurplus() throws ValueException {
		ChairMember person = new ChairMember("Sepp Maier", 5);
		assertEquals(400, person.getSurplus(), 0.1);
	}

	// no throw expected
	@Test
	public void testCompetence() throws ValueException {
		ChairMember person = new ChairMember("Sepp Maier", 5);
		try {
			person.setCompetence(8);
		} catch (ValueException ex) {
			fail(ex.getMessage());
		}
		assertEquals(160.0, person.getCosts(), 0.1);
	}

	// throw expected
	@Test
	public void testCompetenceToHigh() throws ValueException {
		ChairMember person = new ChairMember("Sepp Maier", 5);
		try {
			person.setCompetence(345);
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected");
	}

	// throw expected
	@Test
	public void testCompetenceToLow() throws ValueException {
		ChairMember person = new ChairMember("Sepp Maier", 5);
		try {
			person.setCompetence(-453);
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testToStringBoolean() throws ValueException {
		ChairMember person = new ChairMember("Sepp Maier", 5);
		Section section1 = new Section("VolleyBall");
		assertEquals("ChairMember: Sepp Maier earns 400.0 for the club.",
				person.toString(true));
	}

}
