package dao;

import java.sql.*;

public class DBO {
	
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Personnel";
	
	public static final String DBUSER = "sa";
	public static final String DBPASS = "songxia1998";
	
	private Connection conn;
	private Statement stateMent;
	public static final DBO db = new DBO();
	
	private DBO() {
		
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			//System.out.println("Connection Successful!");
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			//TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public int excuteUpdate(String sql) throws SQLException{
		stateMent = conn.createStatement();
		
		return stateMent.executeUpdate(sql);
	}
	public ResultSet excuteQuery(String sql) throws SQLException{
		stateMent = conn.createStatement();
		return stateMent.executeQuery(sql);
	}
	public void closeConn() throws SQLException {
		
		stateMent.close();
		conn.close();
	}
	public static DBO getInstance(){
		return db;
	}
	
	
	
}
