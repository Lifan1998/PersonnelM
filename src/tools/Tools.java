package tools;

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
		return 1;
	}
}
