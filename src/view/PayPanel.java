package view;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import dao.PayDAO;
import model.Pay;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;

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
	
	private PayPanel(String number) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		this.setSize(553,471);
		
		JLabel lblNewLabel_1 = new JLabel("基本工资：");
		lblNewLabel_1.setBounds(31, 98, 63, 22);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("奖金：");
		lblNewLabel_2.setBounds(31, 128, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("扣除：");
		lblNewLabel_3.setBounds(31, 153, 54, 22);
		add(lblNewLabel_3);
		
		JLabel newLabel = new JLabel("详细：");
		newLabel.setBounds(31, 353, 54, 15);
		add(newLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(83, 360, 261, 60);
		add(textArea);
		
		Label_1 = new JLabel("New label");
		Label_1.setBounds(120, 102, 54, 15);
		add(Label_1);
		
		JLabel Label_2 = new JLabel("New label");
		Label_2.setBounds(120, 128, 54, 15);
		add(Label_2);
		
		Label_3 = new JLabel("New label");
		Label_3.setBounds(120, 157, 54, 15);
		add(Label_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 533, 60);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("加班：");
		lblNewLabel.setBounds(31, 185, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("补贴：");
		lblNewLabel_5.setBounds(31, 210, 54, 15);
		add(lblNewLabel_5);
		
		JLabel label = new JLabel("五险一金：");
		label.setBounds(31, 235, 74, 15);
		add(label);
		
		newlabel = new JLabel("实发：");
		newlabel.setBounds(31, 270, 54, 15);
		add(newlabel);
		
		Label_4 = new JLabel("New label");
		Label_4.setBounds(120, 185, 54, 15);
		add(Label_4);
		
		Label_5 = new JLabel("New label");
		Label_5.setBounds(120, 210, 54, 15);
		add(Label_5);
		
		Label_6 = new JLabel("New label");
		Label_6.setBounds(120, 235, 54, 15);
		add(Label_6);
		
		Label_7 = new JLabel("New label");
		Label_7.setBounds(120, 270, 54, 15);
		add(Label_7);
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
		PayDAO payDAO = new PayDAO();
		try {
			Pay pay = payDAO.getPay(number, date);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	private void setDate(Pay pay){
		Label_1.setText(pay.getBase()+"");
		Label_2.setText(pay.getBonus()+"");
		Label_3.setText(pay.getDeduct()+"");
		Label_4.setText(pay.getExtra()+"");
		Label_5.setText(pay.getSubsidy()+"");
		Label_6.setText(pay.getOther()+"");
		Label_7.setText(pay.getFact()+"");
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
}
