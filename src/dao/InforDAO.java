package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Infor;
import model.Pay;
import tools.Tools;

public class InforDAO {
	private ArrayList<Infor> list;
	private Infor infor;
	private DBO db;
	
	public InforDAO() {
		db = DBO.getInstance();
	}
	public Infor getPersonInfor(String number){
		try {
			ResultSet result = db.excuteQuery("select * from infor where number='"+number+"'");
			result.next();
			infor = new Infor(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),
					result.getString(6),result.getString(7),result.getString(8),result.getDate(9),result.getInt(10),
					result.getString(11),result.getDate(12),result.getString(13));
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
	return infor;
		
	}
	
	public ArrayList<Infor> getTInfor(String number){
		
		String number1 = Tools.sqlnumber(number);
		String number2 = Tools.sqlnumber1(number);
		//System.out.println(number);
		list = new ArrayList<Infor>();
		try {
			
			ResultSet result = db.excuteQuery("select * from infor where number like'"+number1+"' and number not like '"+number2+  "'");
			
			while(result.next()){
				infor = new Infor(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),
						result.getString(6),result.getString(7),result.getString(8),result.getDate(9),result.getInt(10),
						result.getString(11),result.getDate(12),result.getString(13));
				//System.out.println(result.getString(1)+"."+result.getString(2)+".");
				list.add(infor);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
	
	}
	
	
 }
