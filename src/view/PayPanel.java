package view;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class PayPanel extends JPanel implements Tb_panel{

	/**
	 * Create the panel.
	 */
	
	private static PayPanel payPanel;
	private static String number;
	
	private PayPanel(String number) {
		setLayout(null);
		this.setSize(553,471);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(221, 10, 64, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(364, 10, 76, 21);
		add(comboBox_1);
		
		JLabel label = new JLabel("员工：");
		label.setBounds(23, 13, 54, 15);
		add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(64, 75, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(61, 111, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(70, 153, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(64, 191, 54, 32);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(61, 347, 54, 15);
		add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(143, 349, 170, 60);
		add(textArea);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(161, 74, 54, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(158, 112, 54, 15);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(164, 154, 54, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(162, 186, 54, 15);
		add(lblNewLabel_8);
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
		// TODO 自动生成的方法存根
		
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
