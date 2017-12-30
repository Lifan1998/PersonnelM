package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Infor;
import model.Sign_in;
import panel.CheckBox;

public class SignDAO {
	private Sign_in sign;
	private ArrayList<Sign_in> list;
	DBO db ;
	
	public SignDAO() {
		db = DBO.getInstance();
	}
	public Sign_in getPersonSign(String number,Date date){
		String str = date.toString();
		//System.out.println(str);
		Sign_in sign = null;
		try {
			ResultSet result = db.excuteQuery("select * from sign where number='"+number+"'and date ='"+str+"'");
			//System.out.println(result.next());
			while(result.next()){
				
			sign = new Sign_in(result.getString(1), result.getString(2), result.getDate(3));
			
			
			}
		} catch (SQLException e) {
			//return null;
			System.out.println("yicahng");
		}
		return sign;
	}
	
	public void setPersonSign(Sign_in sign){
		String sql = "insert into sign values('"+sign.getNumber()+"','"+sign.getSign()+"','"+sign.getDate().toString()+"')";
		try {
			db.excuteUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
