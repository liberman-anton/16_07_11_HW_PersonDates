package tel_ran.persons.tests;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

import tel_ran.persons.Person;

public class PersonTest {
	Person person;
	Calendar calendar;
	Date date1;
	@Before
	public void setUp() throws Exception {
		TimeZone tz = TimeZone.getTimeZone("Israel");
		calendar = Calendar.getInstance(tz); 
        calendar.set(1984,6,9); 
        date1 = calendar.getTime();
        person = new Person("Name1","Israel",date1);
	}
	@Test
	public void testToString() {
		assertEquals("Name1\tIsrael\t09/07/1984", person.toString());
		calendar.set(1950,11,30);
		date1 = calendar.getTime();
        person = new Person("Name2","Israel",date1);
        assertEquals("Name2\tIsrael\t30/12/1950", person.toString());
        calendar.set(1951, 11, 30, 13, 01, 00);
        date1 = calendar.getTime();
        person = new Person("Name2","Israel",date1);
		Person.setDf(new SimpleDateFormat("dd/MM/YYYY HH:mm"));
		assertEquals("Name2\tIsrael\t30/12/1951 13:01", person.toString());
		
	}
	@Test
	public void testGetAge() {
		assertEquals(32, person.getAge());
		calendar.set(1984,10,23); 
        date1 = calendar.getTime();
        person = new Person("Name1","Israel",date1);
		assertEquals(31, person.getAge());
		calendar.set(1914,10,23); 
        date1 = calendar.getTime();
        person = new Person("Name1","Israel",date1);
		assertEquals(101, person.getAge());
		calendar.set(2014,10,23); 
        date1 = calendar.getTime();
        person = new Person("Name1","Israel",date1);
		assertEquals(1, person.getAge());
	}
	@Test
	public void testGetDaysToBirthDayCelebration() {
		assertEquals(363,person.getDaysToBirthDayCelebration());
		calendar.set(1984,06,11); 
        date1 = calendar.getTime();
        person = new Person("Name1","Israel",date1);
		assertEquals(365, person.getDaysToBirthDayCelebration());
		calendar.set(1984,06,12); 
        date1 = calendar.getTime();
        person = new Person("Name1","Israel",date1);
		assertEquals(1, person.getDaysToBirthDayCelebration());
	}

}
