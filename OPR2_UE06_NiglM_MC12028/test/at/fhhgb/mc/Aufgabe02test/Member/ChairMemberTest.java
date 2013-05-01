package at.fhhgb.mc.Aufgabe02test.Member;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Abstract.ValueException;
import at.fhhgb.mc.Aufgabe02.Member.*;

public class ChairMemberTest {

	@Test
	public void testChairMember() throws ValueException{
		ChairMember person = new ChairMember("Sepp Maier", 5);
		assertEquals("Sepp Maier", person.getName());
	}

	@Test
	public void testChairMemberNull() throws ValueException{
		ChairMember person = new ChairMember(null, 5);
		assertEquals("failfailfail", person.getName());
	}

	@Test
	public void testGetIncome() throws ValueException{
		ChairMember person = new ChairMember("Sepp Maier", 5);
		assertEquals(500.0, person.getIncome(), 0.1);
	}

	@Test
	public void testGetCosts() throws ValueException{
		ChairMember person = new ChairMember("Sepp Maier", 5);
		assertEquals(100.0, person.getCosts(), 0.1);
	}

	@Test
	public void testGetSurplus() throws ValueException{
		ChairMember person = new ChairMember("Sepp Maier", 5);
		assertEquals(400, person.getSurplus(), 0.1);
	}

	@Test
	public void testCompetence() throws ValueException{
		ChairMember person = new ChairMember("Sepp Maier", 5);
		person.setCompetence(8);
		assertEquals(160.0, person.getCosts(), 0.1);
	}

	@Test
	public void testCompetenceToHigh() throws ValueException{
		ChairMember person = new ChairMember("Sepp Maier", 5);
		person.setCompetence(345);
		assertEquals(10.0, person.getCompetence(), 0.1);
	}

	@Test
	public void testCompetenceToLow() throws ValueException{
		ChairMember person = new ChairMember("Sepp Maier", 5);
		person.setCompetence(-453);
		assertEquals(0.0, person.getCosts(), 0.1);
	}

	@Test
	public void testToStringBoolean() throws ValueException{
		ChairMember person = new ChairMember("Sepp Maier", 5);
		Section section1 = new Section("VolleyBall");
		assertEquals("ChairMember: Sepp Maier earns 400.0 for the club.",
				person.toString(true));
	}

}
