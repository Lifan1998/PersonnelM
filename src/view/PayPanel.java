package view;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import dao.PayDAO;
import model.Pay;
import panel.CheckBox;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Checkbox;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JScrollPane;

public class PayPanel extends JPanel implements Tb_panel{

	/**
	 * Create the panel.
	 */
	
	private static PayPanel payPanel;
	private static String number;
	private Date date;
	private JLabel Label_1,Label_2,Label_3,Label_4,Label_5,Label_6,Label_7;
	private JLabel newlabel;
	JTextArea textArea;
	private CheckBox checkBox;
	String str = "2017-11-21";
	private JScrollPane scrollPane;
	
	private PayPanel(String number) {
		this.number = number;
		setBackground(Color.WHITE);
		setLayout(null);
		this.setSize(553,471);
		
		JLabel lblNewLabel_1 = new JLabel("基本工资：");
		lblNewLabel_1.setBounds(60, 95, 63, 22);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("奖金：");
		lblNewLabel_2.setBounds(60, 127, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("扣除：");
		lblNewLabel_3.setBounds(60, 152, 54, 22);
		add(lblNewLabel_3);
		
		JLabel newLabel = new JLabel("详细：");
		newLabel.setBounds(60, 322, 54, 15);
		add(newLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 338, 312, 84);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		Label_1 = new JLabel("");
		Label_1.setBounds(156, 102, 54, 15);
		add(Label_1);
		
		Label_2 = new JLabel("");
		Label_2.setBounds(156, 127, 54, 15);
		add(Label_2);
		
		Label_3 = new JLabel("");
		Label_3.setBounds(156, 159, 54, 15);
		add(Label_3);
		
		JLabel lblNewLabel = new JLabel("加班：");
		lblNewLabel.setBounds(60, 185, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("补贴：");
		lblNewLabel_5.setBounds(60, 223, 54, 15);
		add(lblNewLabel_5);
		
		JLabel label = new JLabel("五险一金：");
		label.setBounds(60, 248, 74, 15);
		add(label);
		
		newlabel = new JLabel("实发：");
		newlabel.setBounds(60, 281, 54, 15);
		add(newlabel);
		
		Label_4 = new JLabel("");
		Label_4.setBounds(156, 185, 54, 15);
		add(Label_4);
		
		Label_5 = new JLabel("");
		Label_5.setBounds(156, 223, 54, 15);
		add(Label_5);
		
		Label_6 = new JLabel("");
		Label_6.setBounds(156, 248, 54, 15);
		add(Label_6);
		
		Label_7 = new JLabel("");
		Label_7.setBounds(156, 281, 54, 15);
		add(Label_7);
		
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
		str = checkBox.getYear()+"-"+checkBox.getMonth()+"-21";
		Date date = Date.valueOf(str);
		PayDAO payDAO = new PayDAO();
		try {
			Pay pay = payDAO.getPay(number, date);
			//System.out.println(pay.getNumber()+"fffffffff");
			setDate(pay);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	private void setDate(Pay pay){
		if(pay==null)
			return;
		Label_1.setText(pay.getBase()+"");
		//System.out.println(pay);
		Label_2.setText(pay.getBonus()+"");
		Label_3.setText(String.valueOf(pay.getDeduct()));
		Label_4.setText(String.valueOf(pay.getExtra()));
		Label_5.setText(String.valueOf(pay.getSubsidy()));
		Label_6.setText(String.valueOf(pay.getOther()));
		Label_7.setText(String.valueOf(pay.getFact()));
		textArea.setText(pay.getState());
	}
	
	//返回相等面板或新面板，限制2个类型面板，第三个将无法比较
	//解决方法：多例设计模式
	public static PayPanel getInstance(String number){
		if(number.equals(PayPanel.number))
			return payPanel;
		else {
			payPanel = new PayPanel(number);
			return payPanel;
		}
			
	}

	@Override
	public void save() {
		// TODO 自动生成的方法存根
		
	}
}
