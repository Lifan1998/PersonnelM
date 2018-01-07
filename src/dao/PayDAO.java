package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JLabel;

import model.Accounts;
import model.Pay;
import tools.Tools;

public class PayDAO {

	private ArrayList<Pay> list;
	private Pay pay;
	DBO db;

	public PayDAO() {
		db = DBO.getInstance();
		
	}
	
	
	public ArrayList<Pay> getTPay(String number,Date date) throws SQLException{
		String	str = date.toString();
		String number1 = Tools.sqlnumber(number);
		String number2 = Tools.sqlnumber1(number);
		//System.out.println(number);
		list = new ArrayList<Pay>();
		try {
			
			ResultSet result = db.excuteQuery("select * from pay where number like'"+number1+"' and number not like '"+number2+"'and date ='"+str+"'");
			
			while(result.next()){
				pay = new Pay(result.getString(1),result.getInt(2),result.getInt(3),
						result.getInt(4),result.getInt(5),result.getInt(6),result.getInt(7),
						result.getInt(8),result.getString(9),result.getDate(10)
						);
				//System.out.println(result.getString(1)+"."+result.getString(2)+".");
				list.add(pay);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Pay getPay(String number,Date date) throws SQLException {
		String str = date.toString();
		try {
			ResultSet result = db.excuteQuery("select * from pay where number='"+number+"'and date ='"+str+"'");
			while(result.next())
			pay = new Pay(result.getString(1),result.getInt(2),result.getInt(3),
						result.getInt(4),result.getInt(5),result.getInt(6),result.getInt(7),
						result.getInt(8),result.getString(9),result.getDate(10)
						);		
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return pay;
	}
	
}

	
