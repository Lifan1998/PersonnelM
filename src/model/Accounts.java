package model;

public class Accounts {
	private String number;
	
	private String password;
	
	public Accounts(String number, String password) {
		super();
		this.number = number;
		this.password = password;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	

}
