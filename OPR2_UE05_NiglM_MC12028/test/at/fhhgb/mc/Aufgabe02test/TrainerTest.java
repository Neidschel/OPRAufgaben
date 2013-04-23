package at.fhhgb.mc.Aufgabe02test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Active.*;
import at.fhhgb.mc.Aufgabe02.Member.*;
import at.fhhgb.mc.Aufgabe02.Abstract.*;

public class TrainerTest {

	@Test
	public void testToStringTrainer() {

		Trainer person = new Trainer("Sepp Maier",5);
		System.out.println(person.toString(true));
	}
	
	@Test
	public void testToStringSection() {

		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Sepp Maier",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		
		System.out.println(section1.toString(true));
	}

	
	@Test
	public void testTrainer() {
		fail("Not yet implemented");
	}

}
