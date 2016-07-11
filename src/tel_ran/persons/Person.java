package tel_ran.persons;

import java.util.*;
import java.text.*;

public class Person {
private static final String DEFAULT_FORMAT = "dd/MM/yyyy";
private static final long MSEC_OF_DAY = 86400000;
String name;
String country;
Date birthDay;

static DateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);

public static DateFormat getDf() {
	return df;
}
public static void setDf(DateFormat df) {
	Person.df = df;
}
public String getName() {
	return name;
}
public Date getBirthDay() {
	return birthDay;
}
public String getCountry() {
	return country;
}

public Person(String name, String country, Date birthDay) {
	super();
	this.name = name;
	this.birthDay = birthDay;
	this.country = country;
}
/**
 * text presentation including the birthday.
 * If DateFormate has hours the should be presented according to the TimeZone.
 * TimeZone should be taken according to the country.
 */
public String toString(){
	StringBuilder sb = new StringBuilder();
	sb.append(this.name);
	sb.append('\t');
	sb.append(this.country);
	sb.append('\t');
	Person.df.setTimeZone(TimeZone.getTimeZone(country));
	sb.append(Person.df.format(birthDay));
	String res = sb.toString();
	return res;
}
@SuppressWarnings("deprecation")
public int getDaysToBirthDayCelebration(){
	Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone(country));
	calendar.add(Calendar.HOUR, 0);
	calendar.add(Calendar.MINUTE, 0);
	calendar.add(Calendar.SECOND, 0);
	Date date = calendar.getTime();
	Date bd = (Date) birthDay.clone();
	bd.setYear(calendar.get(Calendar.YEAR) - 1900);
	if(date.compareTo(bd) <= 0){
		long res = ((bd.getTime() - date.getTime())/MSEC_OF_DAY);
		if(res < 1)return 1;
		return (int) res;
	}
	int res = calendar.getActualMaximum(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR);
	calendar.set(Calendar.YEAR, Calendar.YEAR + 1);
	calendar.set(Calendar.MONTH, bd.getMonth());
	calendar.set(Calendar.DAY_OF_MONTH, bd.getDate());
	res += calendar.get(Calendar.DAY_OF_YEAR);
	return res;
}
/**
 * 
 * @return number of full years
 */
@SuppressWarnings({"deprecation"})
public int getAge(){
	Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone(country));
	calendar.add(Calendar.DAY_OF_MONTH, -birthDay.getDate());
	calendar.add(Calendar.MONTH, -birthDay.getMonth());
	return calendar.get(1) - birthDay.getYear() - 1900;
}
}
