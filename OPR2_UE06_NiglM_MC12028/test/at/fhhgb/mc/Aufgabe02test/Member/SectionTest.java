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
		assertEquals("Testsektion",section1.getName());
	}

	@Test
	public void testAddMemberTrue() throws ValueException, NullPointerException{
		ChairMember ch = new ChairMember("Hans Herzog",5);
		Section section1 = new Section("Testsektion");
		assertEquals(true,section1.addMember(ch));
	}
	
	@Test
	public void testAddMemberFalse() throws ValueException, NullPointerException{
		ChairMember ch = new ChairMember("Hans Herzog",5);
		HonoraryMember hm = new HonoraryMember("Hans Herzog");
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		assertEquals(false,section1.addMember(hm));
	}
	
	@Test
	public void testAddMemberNull() throws ValueException, NullPointerException{
		Section section1 = new Section("Testsektion");
		assertEquals(false,section1.addMember(null));
	}
	
	@Test
	public void testAddMemberSectionNameNull() throws ValueException, NullPointerException{
		Section section1 = new Section(null);
		ChairMember ch = new ChairMember("Hans Herzog",5);
		assertEquals(false,section1.addMember(ch));
	}
	
	@Test
	public void testAddMemberSectionMemberNameNull() throws ValueException, NullPointerException{
		Section section1 = new Section("Testsektion");
		ChairMember ch = new ChairMember(null,5);
		assertEquals(false,section1.addMember(ch));
	}

	@Test
	public void testRemoveMemberTrue() throws ValueException, NullPointerException{
		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(true,section1.removeMember("Sepp Maier"));
	}
	
	
	
	@Test
	public void testRemoveMemberFalse() throws ValueException, NullPointerException{
		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(false,section1.removeMember("Hans Herzog"));
	}
	
	@Test
	public void testRemoveMemberNull() throws ValueException, NullPointerException{
		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(false,section1.removeMember(null));
	}
	
	@Test
	public void testRemoveMemberToString() throws ValueException, NullPointerException{
		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		section1.removeMember("Sepp Maier");
		System.out.println(section1.toString(true));
	
	}

	@Test
	public void testGetIncome() throws ValueException, NullPointerException{
		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(360.0,section1.getIncome(),0.1);
	}

	@Test
	public void testGetCosts() throws ValueException, NullPointerException{
		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(2850.0,section1.getCosts(),0.1);	
	}
	
	@Test
	public void testGetSurplus() throws ValueException, NullPointerException{
		Trainer person = new Trainer("Sepp Maier",5);
		TopAthlete person2 = new TopAthlete("Kunigunde",5);
		AmateurAthlete person3 = new AmateurAthlete("Ruediger",5);
		Section section1 = new Section("VolleyBall");
		section1.addMember(person);
		section1.addMember(person2);
		section1.addMember(person3);
		assertEquals(-2490.0,section1.getSurplus(),0.1);	
	}
	
	@Test
	public void testIsMemberTrue() throws ValueException, NullPointerException{
		ChairMember ch = new ChairMember("Hans Herzog",5);
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		assertEquals(true,section1.isMember("Hans Herzog"));
	}
	
	@Test
	public void testIsMemberFalse() throws ValueException, NullPointerException{
		ChairMember ch = new ChairMember("Hans Herzog",5);
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		assertEquals(false,section1.isMember("Hansi Herzog"));
	}
	
	@Test
	public void testIsMemberNull() throws ValueException, NullPointerException{
		ChairMember ch = new ChairMember("Hans Herzog",5);
		Section section1 = new Section("Testsektion");
		section1.addMember(ch);
		assertEquals(false,section1.isMember(null));
	}
	
	@Test
	public void testIsMemberRecursiveTrue() throws ValueException, NullPointerException{

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
		assertEquals(true,section1.isMember("Lila Blau",true));

	}
	
	@Test
	public void testIsMemberRecursiveFalse() throws ValueException, NullPointerException{

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
		assertEquals(false,section1.isMember("Lila",true));

	}
	
	@Test
	public void testIsMemberRecursiveNull() throws ValueException, NullPointerException{

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
		assertEquals(false,section1.isMember(null,true));

	}
	
	@Test
	public void testToStringSection() throws ValueException, NullPointerException{

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


}
