package at.fhhgb.mc.Aufgabe02test.Member;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Member.*;

public class HonoraryMemberTest {

	@Test
	public void testAmatherAthlete() {
		HonoraryMember person = new HonoraryMember("Sepp Maier");
		assertEquals("Sepp Maier",person.getName());
	}
	
	@Test
	public void testAmatherAthleteNull() {
		HonoraryMember person = new HonoraryMember(null);
		assertEquals("failfailfail",person.getName());
	}
	
	@Test
	public void testGetIncome() {
		HonoraryMember person = new HonoraryMember("Sepp Maier");
		assertEquals(0.0,person.getIncome(),0.1);
	}

	@Test
	public void testGetCosts() {
		HonoraryMember person = new HonoraryMember("Sepp Maier");
		assertEquals(20.0,person.getCosts(),0.1);
	}
	
	@Test
	public void testGetSurplus() {
		HonoraryMember person = new HonoraryMember("Sepp Maier");
		assertEquals(-20,person.getSurplus(),0.1);
	}
	
	
	@Test
	public void testToStringBoolean() {
		HonoraryMember person = new HonoraryMember("Sepp Maier");
		Section section1 = new Section("VolleyBall");
		assertEquals("HonoraryMember: Sepp Maier costs -20.0 for the club.",person.toString(true));
	}

}
