package model;

import java.sql.Date;

public class Infor {
	private String number,name,sex,marriage,tele,email,home,idcard;
	private Date birth;
	private int age;
	private String state;
	private Date work;
	private String edu;
	
	public Infor(String number, String name, String sex, String marriage, String tele, String email, String home,
			String idcard, Date birth, int age, String state, Date work, String edu) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.marriage = marriage;
		this.tele = tele;
		this.email = email;
		this.home = home;
		this.idcard = idcard;
		this.birth = birth;
		this.age = age;
		this.state = state;
		this.work = work;
		this.edu = edu;
	}

	
	public Infor(String number, String name, String tele, String email, String idcard, String edu) {
		super();
		this.number = number;
		this.name = name;
		this.tele = tele;
		this.email = email;
		this.idcard = idcard;
		this.edu = edu;
	}


	public Infor(){	
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getWork() {
		return work;
	}

	public void setWork(Date work) {
		this.work = work;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}
	
	
}
