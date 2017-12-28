package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Accounts;
import model.Pay;

public class PayDAO {

	private ArrayList<Pay> list;
	private Pay pay;
	DBO db;

	public PayDAO() {
		db = DBO.getInstance();
		
	}
	public ArrayList getAllPay(){
		return list;
	}
	public ArrayList getAllPay(String number){
		return list;
	}
	
	public ArrayList<Pay> getPay(String number) throws SQLException{
		list = new ArrayList<Pay>();
		try {
			ResultSet result = db.excuteQuery("select * from pay");
			while(result.next()){
				pay = new Pay(result.getString(1),result.getInt(2),result.getInt(3),
						result.getInt(4),result.getInt(5),result.getInt(6),result.getInt(7),
						result.getInt(8),result.getString(9),result.getDate(10)
						);
				System.out.println(result.getString(1)+"."+result.getString(2)+".");
				list.add(pay);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		list.add(pay);
		return list;
	}

}
