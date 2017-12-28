package model;

import java.sql.Date;
import java.sql.Time;

public class Sign_in {
	
	private String number;
	private String sign;
	private Date date;
	private Time time;

	public Sign_in() {
		// TODO 自动生成的构造函数存根
	}
	

	public Sign_in(String number, String sign, Date date, Time time) {
		super();
		this.number = number;
		this.sign = sign;
		this.date = date;
		this.time = time;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	

}
