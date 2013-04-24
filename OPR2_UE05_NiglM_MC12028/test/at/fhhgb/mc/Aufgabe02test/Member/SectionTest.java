package at.fhhgb.mc.Aufgabe02test.Member;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Active.*;
import at.fhhgb.mc.Aufgabe02.Member.*;

public class SectionTest {

	@Test
	public void testSetIncome() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCosts() {
		fail("Not yet implemented");
	}

	@Test
	public void testToStringSection() {

		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		
		Trainer person4 = new Trainer("Ralph Maurer",7);
		TopAthlete person5 = new TopAthlete("Lila Blau",2);
		AmateurAthlete person6 = new AmateurAthlete("GUENTAAA gueni",3);
		Section section2 = new Section("Tischtennis");
		section2.addMember(person4);
		section2.addMember(person5);
		section2.addMember(person6);
		
		section1.addMember(section2);
		
		System.out.println(section1.toString(true));
	}


	@Test
	public void testSection() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsMember() {
		fail("Not yet implemented");
	}

}
