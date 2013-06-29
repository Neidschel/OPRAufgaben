package at.fhhgb.mc.Aufgabe02test.Active;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Active.AmateurAthlete;
import at.fhhgb.mc.Aufgabe02.Active.TopAthlete;
import at.fhhgb.mc.Aufgabe02.Active.Trainer;
import at.fhhgb.mc.Aufgabe02.Member.Section;

public class AmateurAthleteTest {
	
	@Test
	public void testAmateurAthlete() {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier",5);
		assertEquals("Sepp Maier",person.getName());
	}
	
	@Test
	public void testAmateurAthleteNull() {
		AmateurAthlete person = new AmateurAthlete(null,5);
		assertEquals("failfailfail",person.getName());
	}
	
	@Test
	public void testGetIncome() {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier",5);
		assertEquals(120.0,person.getIncome(),0.1);
	}

	@Test
	public void testGetCosts() {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier",5);
		assertEquals(150.0,person.getCosts(),0.1);
	}
	
	@Test
	public void testGetSurplus() {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier",5);
		assertEquals(-30,person.getSurplus(),0.1);
	}
	
	@Test
	public void testAktivity() {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier",5);
		person.setActivity(8);
		assertEquals(240.0,person.getCosts(),0.1);
	}
	
	@Test
	public void testAktivityToHigh() {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier",5);
		person.setActivity(345);
		assertEquals(10.0,person.getActivity(),0.1);
	}
	
	@Test
	public void testAktivityToLow() {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier",5);
		person.setActivity(-453);
		assertEquals(0.0,person.getCosts(),0.1);
	}
	
	@Test
	public void testToStringBoolean() {
		AmateurAthlete person = new AmateurAthlete("Sepp Maier",5);
		Section section1 = new Section("VolleyBall");
		assertEquals("AmateurAthlete: Sepp Maier costs -30.0 for the club.",person.toString(true));
	}

}
