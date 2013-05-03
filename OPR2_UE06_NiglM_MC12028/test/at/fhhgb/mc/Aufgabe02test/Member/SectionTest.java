package at.fhhgb.mc.Aufgabe02test.Member;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Abstract.*;
import at.fhhgb.mc.Aufgabe02.Active.*;
import at.fhhgb.mc.Aufgabe02.Member.*;

public class SectionTest {

	@Test
	public void testSection() {
		Section section1 = new Section("Testsektion");
		assertEquals("Testsektion", section1.getName());
	}

	@Test
	public void testAddMemberTrue() throws ValueException, NullPointerException {
		ChairMember ch = new ChairMember("Hans Herzog", 5);
		Section section1 = new Section("Testsektion");
		assertEquals(true, section1.addMember(ch));
	}

	@Test
	public void testAddMemberFalse() throws ValueException,
			NullPointerException {
		ChairMember ch = new ChairMember("Hans Herzog", 5);
		HonoraryMember hm = new HonoraryMember("Hans Herzog");
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		assertEquals(false, section1.addMember(hm));
	}

	// exception expected member null
	@Test
	public void testAddMemberNull() throws ValueException, NullPointerException {
		Section section1 = new Section("Testsektion");
		try {
			section1.addMember(null);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");
	}

	// exception expected section name null
	@Test
	public void testAddMemberSectionNameNull() throws ValueException,
			NullPointerException {
		try {
			Section section1 = new Section(null);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");

	}

	// exception expected member name null
	@Test
	public void testAddMemberSectionMemberNameNull() throws ValueException,
			NullPointerException {
		Section section1 = new Section("Testsektion");

		try {
			ChairMember ch = new ChairMember(null, 5);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testRemoveMemberTrue() throws ValueException,
			NullPointerException {
		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(true, section1.removeMember("Sepp Maier"));
	}

	@Test
	public void testRemoveMemberFalse() throws ValueException,
			NullPointerException {
		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(false, section1.removeMember("Hans Herzog"));
	}
	
	//no exception expected remove 
	@Test
	public void testRemoveMemberFalseNoException() throws ValueException,
			NullPointerException {
		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		try{
			assertEquals(false, section1.removeMember("Hans Herzog"));
		}catch(NullPointerException ex){
			fail(ex.getMessage());
		}
	}
	
	//exception expected remove null
	@Test
	public void testRemoveMemberNull() throws ValueException,
			NullPointerException {
		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		try{
			section1.removeMember(null);
		}catch(NullPointerException ex){
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testRemoveMemberToString() throws ValueException,
			NullPointerException {
		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		section1.removeMember("Sepp Maier");
		System.out.println(section1.toString(true));

	}

	@Test
	public void testGetIncome() throws ValueException, NullPointerException {
		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(360.0, section1.getIncome(), 0.1);
	}

	@Test
	public void testGetCosts() throws ValueException, NullPointerException {
		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(2850.0, section1.getCosts(), 0.1);
	}

	@Test
	public void testGetSurplus() throws ValueException, NullPointerException {
		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(-2490.0, section1.getSurplus(), 0.1);
	}

	@Test
	public void testIsMemberTrue() throws ValueException, NullPointerException {
		ChairMember ch = new ChairMember("Hans Herzog", 5);
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		assertEquals(true, section1.isMember("Hans Herzog"));
	}

	@Test
	public void testIsMemberFalse() throws ValueException, NullPointerException {
		ChairMember ch = new ChairMember("Hans Herzog", 5);
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		assertEquals(false, section1.isMember("Hansi Herzog"));
	}

	// no exception expected
	@Test
	public void testIsMemberFalseNoException() throws ValueException,
			NullPointerException {
		ChairMember ch = new ChairMember("Hans Herzog", 5);
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		try {
			assertEquals(false, section1.isMember("Hansi Herzog"));
		} catch (NullPointerException ex) {
			fail(ex.getMessage());
		}
	}

	// Expcetion expected is Member null
	@Test
	public void testIsMemberNull() throws ValueException, NullPointerException {
		ChairMember ch = new ChairMember("Hans Herzog", 5);
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		try {
			section1.isMember(null);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");
	}

	@Test
	public void testIsMemberRecursiveTrue() throws ValueException,
			NullPointerException {

		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);

		Trainer person4 = new Trainer("Ralph Maurer", 7);
		TopAthlete person5 = new TopAthlete("Lila Blau", 2);
		AmateurAthlete person6 = new AmateurAthlete("GUENTAAA gueni", 3);
		Section section2 = new Section("Tischtennis");
		section2.addMember(person4);
		section2.addMember(person5);
		section2.addMember(person6);

		section1.addMember(section2);
		assertEquals(true, section1.isMember("Lila Blau", true));

	}

	@Test
	public void testIsMemberRecursiveFalse() throws ValueException,
			NullPointerException {

		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);

		Trainer person4 = new Trainer("Ralph Maurer", 7);
		TopAthlete person5 = new TopAthlete("Lila Blau", 2);
		AmateurAthlete person6 = new AmateurAthlete("GUENTAAA gueni", 3);
		Section section2 = new Section("Tischtennis");
		section2.addMember(person4);
		section2.addMember(person5);
		section2.addMember(person6);

		section1.addMember(section2);
		assertEquals(false, section1.isMember("Lila", true));

	}

	// no Exception expected
	@Test
	public void testIsMemberRecursiveNoException() throws ValueException,
			NullPointerException {

		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);

		Trainer person4 = new Trainer("Ralph Maurer", 7);
		TopAthlete person5 = new TopAthlete("Lila Blau", 2);
		AmateurAthlete person6 = new AmateurAthlete("GUENTAAA gueni", 3);
		Section section2 = new Section("Tischtennis");
		section2.addMember(person4);
		section2.addMember(person5);
		section2.addMember(person6);

		section1.addMember(section2);
		try {
			assertEquals(false, section1.isMember("Lila", true));
		} catch (NullPointerException ex) {
			fail(ex.getMessage());
		}

	}

	// exception expected recursive is member
	@Test
	public void testIsMemberRecursiveNull() throws ValueException,
			NullPointerException {

		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);

		Trainer person4 = new Trainer("Ralph Maurer", 7);
		TopAthlete person5 = new TopAthlete("Lila Blau", 2);
		AmateurAthlete person6 = new AmateurAthlete("GUENTAAA gueni", 3);
		Section section2 = new Section("Tischtennis");
		section2.addMember(person4);
		section2.addMember(person5);
		section2.addMember(person6);

		section1.addMember(section2);
		try {
			section1.isMember(null, true);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected");

	}

	@Test
	public void testToStringSection() throws ValueException,
			NullPointerException {

		Trainer person = new Trainer("Sepp Maier", 5);
		TopAthlete person2 = new TopAthlete("Kunigunde", 5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger", 5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);

		Trainer person4 = new Trainer("Ralph Maurer", 7);
		TopAthlete person5 = new TopAthlete("Lila Blau", 2);
		AmateurAthlete person6 = new AmateurAthlete("GUENTAAA gueni", 3);
		Section section2 = new Section("Tischtennis");
		section2.addMember(person4);
		section2.addMember(person5);
		section2.addMember(person6);

		section1.addMember(section2);

		System.out.println(section1.toString(true));
	}

}
