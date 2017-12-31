package tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.InforDAO;

public class Tools {

	public Tools() {
		
	}
	public static String sqlnumber(String number){
		int i = number.indexOf("0");
		number = number.substring(0, i-1)+"__"+number.substring(i+1);
		return number;
	}
	public static String sqlnumber1(String number) {
		int i = number.indexOf("0");
		
		char[] ch =new char[]{'_','_','_','_','_','_'};
		ch[i] = '0';
		
		return new String(ch);
	}
	
	public static int check(String number){
		if(number.equals("100000"))
			return 1;
		else if(new InforDAO().getTInfor(number).isEmpty()){
			return 3;
		} else
			return 2;
	}
	
	public static String getDefaultDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s=df.format(Calendar.getInstance().getTime());
		int year = Integer.parseInt(s.substring(0,4));
		
		int month = Integer.parseInt(s.substring(5,7));
		
		if(month==1){
			return (year-1)+"-12-21";
		}
		
		return year+"-"+(month-1)+"-21";
	}
	public static String getYear(){
		return getDefaultDate().substring(0,4);
	}
	public static String getMonth(){
		return getDefaultDate().substring(5,7);
	}
	
	public static String getNowDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s=df.format(Calendar.getInstance().getTime());
		return s;
	}
	
	public static String getNowYear(){
		return getNowDate().substring(0, 4);
	}
	
	public static String getNowMonth(){
		return getNowDate().substring(5, 7);
	}
	public static String getDeptNo(String number){
		String deptNo =null;
		int i = number.indexOf("0");
		deptNo = number.substring(0,i-1);
		return deptNo;
		
	}
	
	public static String getInforsql(String deptNo){
		String sql = null;
		int i = deptNo.length();
		String str = "000000";
		sql = deptNo+"_"+str.substring(1,6-i);
		return sql;
	}
	public static void main(String[] args) {
		System.out.println(Tools.getNowDate());
		System.out.println(getDeptNo("110000"));
		System.out.println(getInforsql("1"));
		
	}
	public static String getInforsql1(String deptNo) {
		
		return deptNo +"0%";
	}
}
