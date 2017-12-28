package view;

import java.awt.BorderLayout;              
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import panel.MenuPanel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {
	//private static final MainFrame frame = new MainFrame();
	private String number;
	private JPanel contentPane;
	private JPanel panel_2;
	
	/*private AccountsPanel accP_1;//账号密码表
	private SignDayP signDayP_2;//本日签到
	private PayPanel payPanel_3;//个人工资
	private SignPanel signPanel_4;//个人考勤
	private InforPanel inforPanel_5;//个人信息
	private PayTableP payTable_6;//下级工资表
	private InforTableP inforTableP_7;//下级基本信息表
	private SignTableP signTableP_8;//下级考勤表
	 */	
	private static JTabbedPane tabbled;//选项卡
	
	
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MainFrame(String number) {
		this.number = number;
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/res/app.png")));
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setTitle("企业人事管理");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 800, 600);
		//this.setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setVisible(false);
		
		panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 794, 53);
		contentPane.add(panel_2);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(1, 544, 791, 24);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		JLabel lblNewLabel = new JLabel("已就绪...");
		lblNewLabel.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				lblNewLabel_1.setText(df.format(new Date()));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				}
			}
		});
		thread.start();
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 63, 211, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 197, 211, 337);
		contentPane.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		
		tabbled = new JTabbedPane(JTabbedPane.TOP);
		tabbled.setBounds(231, 63, 553, 471);
		contentPane.add(tabbled);
		
		JPanel panel_4 = new JPanel();
		tabbled.addTab("New tab", null, panel_4, null);
		//addJTabbled("个人工资", PayPanel.getInstance(number), true);
		MenuPanel menuP = new MenuPanel(number);
		menuP.setLocation(0, 0);
		contentPane.add(menuP);
	}
	
	
	
	
	public void setNumber(String number) {
		this.number = number;
	}

	//添加、显示面板
	public static void addJTabbled(String title,Tb_panel panel,Boolean isedit) {
		tabbled.remove((Component) panel);
		if(tabbled.getTabRunCount()>4)
			tabbled.remove(0);
		panel.updata();//更新数据
		tabbled.add(title,(Component) panel);
		if(isedit==true)
			panel.edit();
			
		else 
			panel.unedit();
			
	}
}
