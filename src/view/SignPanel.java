package view;

import javax.swing.JPanel;

import dao.SignDAO;
import model.Sign_in;
import panel.CheckBox;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.sql.Date;

public class SignPanel extends JPanel implements Tb_panel{
	private CheckBox checkBox;
	private JPan[] jpan = new JPan[31];
	private static String number;
	private static SignPanel signPanel;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	private SignPanel(String number) {
		setLayout(null);
		this.setSize(553,471);
		this.number = number;
		
		
		checkBox = new CheckBox();
		add(checkBox);
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
		panel.setBounds(10, 67, 533, 360);
		add(panel);
		panel.setLayout(new GridLayout(5, 7));
		String str = checkBox.getYear()+"-"+checkBox.getMonth();
		SignDAO signDAO = new SignDAO();
		Date date;
		for(int i=1;i<31;i++){
			if(i<10)
				date = Date.valueOf(str+"-0"+i);
			else date = Date.valueOf(str+"-"+i);
			Sign_in sign = signDAO.getPersonSign(number, date);
			if(sign==null)
				jpan[i-1] = new JPan(i,"null");
			else jpan[i-1] = new JPan(i,sign.getSign());
			panel.add(jpan[i-1]);
		}
		switch(checkBox.getMonth()){
		case "1":;case "3":;case "5":;case "7":;case "8":;case "10":;case "12":
			date = Date.valueOf(str+"-31");
			Sign_in sign = signDAO.getPersonSign(number, date);
			if(sign==null)
				jpan[30] = new JPan(31,"null");
			jpan[30] = new JPan(31,sign.getSign());
			panel.add(jpan[30]);
		
		}
		
	}
	
	public static SignPanel getInstance(String number){	
		if(number.equals(SignPanel.number))
			return signPanel;
		else {
			signPanel = new SignPanel(number);
			return signPanel;
		}
			
	}
	
	class JPan extends JPanel {
		public JPan(int i,String sign){
			this.setSize(76, 72);
			setLayout(new BorderLayout(3,1));
			JLabel lab1 = new JLabel();
			JLabel lab2 = new JLabel();
			add(lab1,BorderLayout.NORTH);
			add(lab2,BorderLayout.CENTER);
			lab1.setText(i+"");
			lab2.setText(sign);
			
		}
	
	}

	@Override
	public void save() {
		// TODO 自动生成的方法存根
		
	}
	
}
