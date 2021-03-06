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
			while(result.next())
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
	
	
public ArrayList<Infor> getDeptInfor(String deptNo){
		String number = Tools.getInforsql(deptNo);
		String number1 = Tools.getInforsql1(deptNo);
		list = new ArrayList<Infor>();
		try {
			
			ResultSet result = db.excuteQuery("select * from infor where number like'"+number+"'and number not like '"+number1+"'");
			
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
	public void insertInfor(Infor infor) {
		String sql = "insert into infor(number,name,edu,tele,email,idcard) values ('"+infor.getNumber()
						+"','"+infor.getName()+"','"+infor.getEdu()+"','"+infor.getTele()+"','"+infor.getEmail()
						+"','"+infor.getIdcard()+"')";
		try {
			db.excuteUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
				
	}
	public void updateInfor(Infor infor1) {
		// TODO 自动生成的方法存根
		String sql = "update infor set edu = '"+infor1.getEdu()+"',sex = '"
				+infor1.getSex()+"',marriage = '"+infor1.getMarriage()+"',home ='"
				+infor1.getHome()+"',birth = '"+infor1.getBirth()+"',state = '"
				+infor1.getState()+"',woork = '"+infor1.getWork()+"' where number = '"
				+infor1.getNumber()+"'";
		//System.out.println(sql);
		try {
			db.excuteUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}	
	public String getNumber(String name) throws SQLException{
		String sql = "select number from infor where name = '"+name+"'";
		ResultSet result = db.excuteQuery(sql);
		String number = null;
		while(result.next()){
			number = result.getString(1);
		}
		
		return number;
	}
 }
