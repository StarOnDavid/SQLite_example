package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
	private int id;
	private String name;
	private String surname;
	private String mail;
	private String country;
	private LocalDateTime reg_dateTime;
	
	public User(String name, String surname, String mail, String country) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.country = country;
		this.reg_dateTime = LocalDateTime.now();
	}
	
	public User(int id, String name, String surname, String mail, String country, LocalDateTime reg_dateTime) {
		this(name, surname, mail, country);
		this.id = id;
		this.reg_dateTime = reg_dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDateTime getReg_dateTime() {
		return reg_dateTime;
	}

	public void setReg_dateTime(LocalDateTime reg_dateTime) {
		this.reg_dateTime = reg_dateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", mail=" + mail + ", country=" + country
				+ ", reg_dateTime=" + reg_dateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss")) + "]";
	}
	
	

}
