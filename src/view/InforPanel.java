package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class InforPanel extends JPanel implements Tb_panel{
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public InforPanel() {
		setLayout(null);
		this.setSize(553,471);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InforPanel.class.getResource("/res/app.png")));
		lblNewLabel.setBounds(44, 6, 112, 144);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(199, 11, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别：");
		lblNewLabel_2.setBounds(199, 54, 54, 15);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("工号：");
		label.setBounds(198, 88, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("年龄：");
		label_1.setBounds(196, 121, 54, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("学历：");
		label_2.setBounds(195, 153, 54, 15);
		add(label_2);
		
		textField = new JTextField();
		textField.setBounds(278, 8, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(277, 50, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("出生日期：");
		label_3.setBounds(49, 204, 69, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("家庭住址：");
		label_4.setBounds(50, 239, 103, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("身份证号：");
		label_5.setBounds(54, 269, 54, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("入职时间：");
		label_6.setBounds(47, 308, 54, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("详细：");
		label_7.setBounds(49, 339, 54, 15);
		add(label_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(95, 341, 326, 101);
		add(textArea);
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
}
