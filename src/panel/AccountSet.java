package panel;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.AccountsDAO;
import model.Accounts;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AccountSet extends JDialog {
	private String number;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public AccountSet(String number) {
		this.number = number;
		setBounds(400, 100, 306, 253);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("输入新密码：");
		lblNewLabel.setBounds(10, 21, 72, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请再次输入：");
		lblNewLabel_1.setBounds(10, 65, 74, 15);
		getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(104, 109, 93, 23);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String str1 = new String(passwordField.getPassword());
				String str2 = new String(passwordField_1.getPassword());
				if(str1.equals(str2)){
					new AccountsDAO().update(new Accounts(number,str1));
					lblNewLabel_2.setText("设置成功！");
				}else{
					lblNewLabel_2.setText("密码不一致！");;
				}
				
			}
		});
		btnNewButton.setBounds(125, 178, 64, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(207, 178, 64, 23);
		getContentPane().add(btnNewButton_1);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 18, 134, 21);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(104, 62, 134, 21);
		getContentPane().add(passwordField_1);

	}
}
