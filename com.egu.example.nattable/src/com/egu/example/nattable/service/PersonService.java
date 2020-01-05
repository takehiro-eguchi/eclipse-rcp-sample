package com.egu.example.nattable.service;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.egu.example.nattable.entity.Person;

/**
 * 人間を扱うサービスクラスです。
 * @author t-eguchi
 *
 */
public class PersonService {

	/**
	 * 検索します。
	 * @param i
	 * @return
	 */
	public List<Person> getPersons(int count) {
		List<Person> persons = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			Person person = getPerson(i);
			persons.add(person);
		}
		return persons;
	}

	/** 人間を作成します */
	private Person getPerson(int seed) {
		Person person = new Person();
		person.setFirstName("FirstName-" + seed);
		person.setLastName("LastName-" + seed);
		String gender = seed % 2 == 0 ? "male" : "female";
		person.setGender(gender);
		person.setMarried(seed % 2 != 0);
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, seed);
		Date birthday = calender.getTime();
		person.setBirthday(birthday);
		return person;
	}
}
