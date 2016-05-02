package base;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	private PersonDomainModel p1;
	private PersonDomainModel p2;
	private PersonDomainModel p3;
	private PersonDomainModel p4;
	private PersonDomainModel p5;
	
	private UUID p1_id;
	private UUID p2_id;
	private UUID p3_id;
	private UUID p4_id;
	private UUID p5_id;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
	
		PersonDomainModel p1 = new PersonDomainModel();
		PersonDomainModel p2 = new PersonDomainModel();
		PersonDomainModel p3 = new PersonDomainModel();
		PersonDomainModel p4 = new PersonDomainModel();
		PersonDomainModel p5 = new PersonDomainModel();
		
		UUID p1_id = UUID.randomUUID();
		UUID p2_id = UUID.randomUUID();
		UUID p3_id = UUID.randomUUID();
		UUID p4_id = UUID.randomUUID();
		UUID p5_id = UUID.randomUUID();
		
		p1.setPerID(p1_id);
		p2.setPerID(p2_id);
		p3.setPerID(p3_id);
		p4.setPerID(p4_id);
		p5.setPerID(p5_id);
		
	}
	
	
	@Test
	public void testPerson() {
		
		PersonDAL.addPerson(p1);
		PersonDAL.addPerson(p2);
		PersonDAL.addPerson(p3);
		PersonDAL.addPerson(p4);
		PersonDAL.addPerson(p5);
		
		assertEquals(PersonDAL.getPerson(p1_id), p1);
		assertEquals(PersonDAL.getPerson(p2_id), p2);
		assertEquals(PersonDAL.getPerson(p3_id), p3);
		assertEquals(PersonDAL.getPerson(p4_id), p4);
		assertEquals(PersonDAL.getPerson(p5_id), p5);
		
		p1.setFirstName("Mike");
		p1.setFirstName("Bill");
		p1.setFirstName("Steve");
		p1.setFirstName("Brad");
		p1.setFirstName("Sada");
		
		PersonDAL.updatePerson(p1);
		PersonDAL.updatePerson(p2);
		PersonDAL.updatePerson(p3);
		PersonDAL.updatePerson(p4);
		PersonDAL.updatePerson(p5);
		
		assertEquals(PersonDAL.getPerson(p1_id), p1);
		assertEquals(PersonDAL.getPerson(p2_id), p2);
		assertEquals(PersonDAL.getPerson(p3_id), p3);
		assertEquals(PersonDAL.getPerson(p4_id), p4);
		assertEquals(PersonDAL.getPerson(p5_id), p5);
		
		PersonDAL.deletePerson(p1_id);
		PersonDAL.deletePerson(p2_id);
		PersonDAL.deletePerson(p3_id);
		PersonDAL.deletePerson(p4_id);
		PersonDAL.deletePerson(p5_id);
		
		assertEquals(PersonDAL.getPerson(p1_id), null);
		assertEquals(PersonDAL.getPerson(p2_id), null);
		assertEquals(PersonDAL.getPerson(p3_id), null);
		assertEquals(PersonDAL.getPerson(p4_id), null);
		assertEquals(PersonDAL.getPerson(p5_id), null);
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		PersonDAL.deletePerson(p1_id);
		PersonDAL.deletePerson(p2_id);
		PersonDAL.deletePerson(p3_id);
		PersonDAL.deletePerson(p4_id);
		PersonDAL.deletePerson(p5_id);
		
	}

}
