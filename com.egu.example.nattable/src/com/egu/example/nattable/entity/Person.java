package com.egu.example.nattable.entity;

import java.util.Date;

/**
 * 人間を表すエンティティです。
 * @author t-eguchi
 *
 */
public class Person {

	/** 姓 */
	private String firstName;

	/** 名 */
	private String lastName;

	/** 性別 */
	private String gender;

	/** 結婚 */
	private boolean married;

	/** 誕生日 */
	private Date birthday;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
