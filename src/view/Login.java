package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.html.HTMLDocument.Iterator;

import dao.AccountsDAO;
import model.Accounts;

import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JButton btnNewButton;
	private JPasswordField passwordField;
	private AccountsDAO accdao = new AccountsDAO();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Login() {
		
		
		InitGlobalFont(new Font("宋体", Font.PLAIN, 12));

		 UIManager.put("Menu.font", new Font("宋体", Font.PLAIN, 12));//设置Menubar的字体 
		 UIManager.put("MenuItem.font", new Font("宋体", Font.PLAIN, 12));//设置MenuItem的字体

		setResizable(false);
		setTitle("登录");
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Java");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 99));
		lblNewLabel.setBounds(0, 0, 351, 228);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("企业人事管理系统");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("幼圆", Font.ITALIC, 60));
		lblNewLabel_1.setBounds(0, 255, 574, 96);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("用户名：");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(379, 43, 54, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("密码：");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setBounds(377, 98, 54, 15);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(441, 40, 91, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("登录");
		btnNewButton.setFont(UIManager.getFont("Button.font"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(467, 148, 65, 23);
		panel.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(441, 95, 91, 21);
		panel.add(passwordField);
		createbtn(this);
		
		
	}
	
	private void createbtn(JFrame frame){
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList list = accdao.getDate();
				java.util.Iterator it = list.iterator();
				String number = textField.getText();
				String pass = new String(passwordField.getPassword());
				//System.out.println(pass+number);
				Accounts account;
				while(it.hasNext()){
					account = (Accounts) it.next();
					if(account.getNumber().equals(number)){
						//System.out.println(account.getNumber()+""+account.getPassword()+".");
						if(account.getPassword().equals(pass)){
							MainFrame mframe = new MainFrame(number);
							
							mframe.setVisible(true);
							frame.setVisible(false);
							return;
						} else {
							JOptionPane.showConfirmDialog(frame, "密码错误！","操作提示",
									JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);	
							return;
						}
					}
					
				}
				if(it.hasNext()==false){
					JOptionPane.showConfirmDialog(frame, "账号不存在！","操作提示",
							JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);	
				}
					
				
					
				
			}
		});
	}
	private static void InitGlobalFont(Font font) {
	    FontUIResource fontRes = new FontUIResource(font);
	    for (Enumeration<Object> keys = UIManager.getDefaults().keys();
	         keys.hasMoreElements(); ) {
	      Object key = keys.nextElement();
	      Object value = UIManager.get(key);
	      if (value instanceof FontUIResource) {
	        UIManager.put(key, fontRes);
	      }
	    }
	}
}
