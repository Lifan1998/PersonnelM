package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AccountsDAO;
import dao.InforDAO;
import model.Accounts;
import model.Infor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreatUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public CreatUser() {
		setTitle("新建员工");
		this.setLocation(400, 100);
		setSize(450, 293);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("工号：");
		label.setBounds(26, 14, 54, 15);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setBounds(27, 48, 54, 15);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("邮箱：");
		label_2.setBounds(27, 156, 54, 15);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("电话：");
		label_3.setBounds(27, 119, 54, 15);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("学历：");
		label_4.setBounds(26, 83, 54, 15);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("身份证号：");
		label_5.setBounds(25, 187, 83, 15);
		contentPanel.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(112, 12, 106, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 47, 106, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 81, 106, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(112, 115, 104, 21);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(112, 153, 105, 21);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(112, 185, 162, 21);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(270, 14, 106, 34);
		contentPanel.add(lblNewLabel);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确认");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						Accounts acc = new Accounts(textField.getText(), textField.getText());
						new AccountsDAO().insertAccout(acc);
						Infor infor = new Infor(textField.getText(),textField_1.getText(),textField_3.getText(),textField_4.getText(),textField_5.getText(),textField_2.getText());
						new InforDAO().insertInfor(infor);
						lblNewLabel.setText("创建成功!");
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
}
