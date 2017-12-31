package view;

import javax.swing.JPanel;

import dao.InforDAO;
import dao.SignDAO;
import model.Infor;
import model.Sign_in;
import panel.CheckBox;
import tools.Tools;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Label;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class SignDayP extends JPanel implements Tb_panel{
	private static String number;
	private static SignDayP signDayP;
	private JPanel panel;
	private ArrayList<JPan> jpan;
	private ArrayList<Sign_in> saveSign;
	private JPan jp;
	private Date date = Date.valueOf(Tools.getNowDate());
	/**
	 * Create the panel.
	 */
	public SignDayP(String number) {
		setLayout(null);
		this.setSize(553,471);
		this.number = number;
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 21, 522, 48);
		add(panel_1);
		
		JLabel label = new JLabel("今日签到");
		label.setFont(new Font("宋体", Font.PLAIN, 35));
		panel_1.add(label);
	}

	@Override
	public void edit() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void unedit() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void updata() {
		panel = new JPanel();
		panel.setBounds(10, 68, 522, 342);
		add(panel);
		jpan = new ArrayList<>();
		InforDAO inforDAO = new InforDAO();
		SignDAO signDAO = new SignDAO();
		ArrayList<Infor> list =null;
		list = inforDAO.getTInfor(number);
		java.util.Iterator<Infor> it = list.iterator();
		
		while(it.hasNext()){
			Infor infor = it.next();
			Sign_in sign = signDAO.getPersonSign(infor.getNumber(),date);
			if(sign==null){
				jp = new JPan(infor.getNumber(), infor.getName(), "未选择");
				jpan.add(jp);
				panel.add(jp);
			}
				
			
		}
		
	}
	
	public void save(){
		Iterator<JPan> it = jpan.iterator();
		SignDAO signDAO = new SignDAO();
		
		while(it.hasNext()){
			Sign_in sign = it.next().getSign();
			if(sign!=null)
				signDAO.setPersonSign(sign);
				
		}
	}
	public static SignDayP getInstance(String number){
		if(number.equals(SignDayP.number))
			return signDayP;
		else
			signDayP = new SignDayP(number);
		return signDayP;
	}
	
	
	class JPan extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JLabel lab1,lab2;
		JComboBox<String> check;
		String number;
		
		public JPan(String str1,String str2,String str3){
			this.number = str1;
			setSize(522, 50);
			setLayout(new GridLayout(1, 3));
			lab1 = new JLabel("工号："+str1+"   ");
			lab2 = new JLabel("姓名："+str2);
			check = new JComboBox<String>();
			check.addItem("签到");
			check.addItem("迟到");
			check.addItem("请假");
			check.addItem("缺勤");
			check.addItem("出差");
			check.addItem("未选择");
			check.setSelectedItem(str3);
			this.add(lab1);
			this.add(lab2);
			this.add(check);
			
		}
		public Sign_in getSign() {
			System.out.println(check.getSelectedItem());
			if(((String)check.getSelectedItem()).equals("未选择"))
				return null;
			Sign_in sign = new Sign_in(number, (String) check.getSelectedItem(), date);
			return sign;
		}
		
		
	}
}
