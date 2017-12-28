package model;

import java.sql.Date;

public class Pay {
	private String number;
	private int base,bonus,deduct,extra,subsidy,other,fact;
	private String state;
	private Date date;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getDeduct() {
		return deduct;
	}

	public void setDeduct(int deduct) {
		this.deduct = deduct;
	}

	public int getExtra() {
		return extra;
	}

	public void setExtra(int extra) {
		this.extra = extra;
	}

	public int getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(int subsidy) {
		this.subsidy = subsidy;
	}

	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	public int getFact() {
		return fact;
	}

	public void setFact(int fact) {
		this.fact = fact;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Pay(String number, int base, int bonus, int deduct, int extra, int subsidy, int other, int fact,
			String state, Date date) {
		super();
		this.number = number;
		this.base = base;
		this.bonus = bonus;
		this.deduct = deduct;
		this.extra = extra;
		this.subsidy = subsidy;
		this.other = other;
		this.fact = fact;
		this.state = state;
		this.date = date;
	}

	public Pay() {
		
	}

}
