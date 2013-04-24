package at.fhhgb.mc.Aufgabe02test.Active;

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
	public void testTrainer() {
		fail("Not yet implemented");
	}

}
