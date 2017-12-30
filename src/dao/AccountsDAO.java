package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Accounts;

public class AccountsDAO {

	private ArrayList<Accounts> list ;
	private Accounts  account;
	
	public AccountsDAO() {
		DBO db = DBO.getInstance();
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
		
	}

	public ArrayList<Accounts> getDate() {
		return list;
	}

	
}
