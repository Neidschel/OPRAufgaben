package at.fhhgb.mc.Aufgabe02test.Active;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Abstract.ValueException;
import at.fhhgb.mc.Aufgabe02.Active.TopAthlete;
import at.fhhgb.mc.Aufgabe02.Member.Section;

public class TopAthleteTest {

	@Test
	public void testTopAthlete() throws ValueException{
		TopAthlete person = new TopAthlete("Sepp Maier",5);
		assertEquals("Sepp Maier",person.getName());
	}
	
	@Test
	public void testTopAthleteNull() throws ValueException{
		TopAthlete person = new TopAthlete(null,5);
		assertEquals("failfailfail",person.getName());
	}
	
	@Test
	public void testGetIncome() throws ValueException{
		TopAthlete person = new TopAthlete("Sepp Maier",5);
		assertEquals(120.0,person.getIncome(),0.1);
	}

	@Test
	public void testGetCosts() throws ValueException{
		TopAthlete person = new TopAthlete("Sepp Maier",5);
		assertEquals(300.0,person.getCosts(),0.1);
	}
	
	@Test
	public void testGetSurplus() throws ValueException{
		TopAthlete person = new TopAthlete("Sepp Maier",5);
		assertEquals(-180,person.getSurplus(),0.1);
	}
	
	@Test
	public void testAktivity() throws ValueException{
		TopAthlete person = new TopAthlete("Sepp Maier",5);
		person.setActivity(8);
		assertEquals(480.0,person.getCosts(),0.1);
	}
	
	@Test
	public void testAktivityToHigh() throws ValueException{
		TopAthlete person = new TopAthlete("Sepp Maier",5);
		person.setActivity(345);
		assertEquals(10.0,person.getActivity(),0.1);
	}
	
	@Test
	public void testAktivityToLow() throws ValueException{
		TopAthlete person = new TopAthlete("Sepp Maier",5);
		person.setActivity(-453);
		assertEquals(0.0,person.getCosts(),0.1);
	}
	
	@Test
	public void testToStringBoolean() throws ValueException{
		TopAthlete person = new TopAthlete("Sepp Maier",5);
		Section section1 = new Section("VolleyBall");
		assertEquals("TopAthlete: Sepp Maier costs -180.0 for the club.",person.toString(true));
	}

}
