package at.fhhgb.mc.Aufgabe02test.Member;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Member.SupportingMember;
import at.fhhgb.mc.Aufgabe02.Member.Section;

public class SupportingMemberTest {

	@Test
	public void testAmatherAthlete() {
		SupportingMember person = new SupportingMember("Sepp Maier");
		assertEquals("Sepp Maier",person.getName());
	}
	
	@Test
	public void testAmatherAthleteNull() {
		SupportingMember person = new SupportingMember(null);
		assertEquals("failfailfail",person.getName());
	}
	
	@Test
	public void testGetIncome() {
		SupportingMember person = new SupportingMember("Sepp Maier");
		assertEquals(100.0,person.getIncome(),0.1);
	}

	@Test
	public void testGetCosts() {
		SupportingMember person = new SupportingMember("Sepp Maier");
		assertEquals(15.0,person.getCosts(),0.1);
	}
	
	@Test
	public void testGetSurplus() {
		SupportingMember person = new SupportingMember("Sepp Maier");
		assertEquals(85,person.getSurplus(),0.1);
	}
	
	
	@Test
	public void testToStringBoolean() {
		SupportingMember person = new SupportingMember("Sepp Maier");
		Section section1 = new Section("VolleyBall");
		assertEquals("SupportingMember Sepp Maier earns 85.0 for the club.",person.toString(true));
	}

}
