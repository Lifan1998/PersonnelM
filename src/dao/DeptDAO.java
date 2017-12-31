package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Accounts;
import model.Dept;

public class DeptDAO {

	private ArrayList<Dept> list;
	private Dept dept;
	DBO db ;

	public DeptDAO() {
		db = DBO.getInstance();
		
	}

	public ArrayList<Dept> getDate() {
		list = new ArrayList<Dept>();
		try {
			ResultSet result = db.excuteQuery("select * from dept");
			while (result.next()) {
				dept = new Dept(result.getString(1), result.getString(2));
				// System.out.println(result.getString(1)+"."+result.getString(2)+".");
				list.add(dept);

			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return list;
	}
	
	public ArrayList<Dept> getNext(String dept1){
		list = new ArrayList<Dept>();
		
		try {
			ResultSet result = db.excuteQuery("select * from dept where deptNo like '"+dept1+"_'");
			while (result.next()) {
				dept = new Dept(result.getString(1), result.getString(2));
				// System.out.println(result.getString(1)+"."+result.getString(2)+".");
				list.add(dept);

			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return list;
	}
	
	public String getDeptName(String deptNo){
		try {
			ResultSet result = db.excuteQuery("select deptName from dept where deptNo like '"+deptNo+"'");
			while (result.next()) {
				return result.getString(1);	

			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;	
	}
}
