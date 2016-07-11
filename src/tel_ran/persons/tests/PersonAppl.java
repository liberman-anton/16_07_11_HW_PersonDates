package tel_ran.persons.tests;

import java.util.*;

import tel_ran.persons.Person;

import java.text.*;

public class PersonAppl {

	public static void main(String[] args) {
	
		TimeZone tz = TimeZone.getTimeZone("Israel");
		Calendar calendar = Calendar.getInstance(tz); 
        calendar.set(1984,6,9); 
        Date date1 = calendar.getTime();
		//Person person = new Person("Name1","America/Los_Angeles",date1);
        Person person = new Person("Name1","Israel",date1);
		System.out.println("getAge: " + person.getAge());
		System.out.println("getDaysToBirthDayCelebration: " + person.getDaysToBirthDayCelebration());
		System.out.println("Person: " + person);
		Person.setDf(new SimpleDateFormat("dd/MM/YYYY HH:mm"));
		System.out.println("Person: " + person);
	}

}
