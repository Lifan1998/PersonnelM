package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Accounts;

public class AccountsDAO {

	private ArrayList<Accounts> list ;
	private Accounts  account;
	DBO db;
	
	public AccountsDAO() {
		db = DBO.getInstance();
		
		
	}

	public ArrayList<Accounts> getDate() {
		list = new ArrayList<Accounts>();
		try {
			ResultSet result = db.excuteQuery("select * from accounts");
			while(result.next()){
				account = new Accounts(result.getString(1), result.getString(2));
				//System.out.println(result.getString(1)+"."+result.getString(2)+".");
				list.add(account);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}

	public void insertAccout(Accounts acc) {
		try {
			db.excuteUpdate("insert into accounts values('"+acc.getNumber()+"','"+acc.getPassword()+"')");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	
}
