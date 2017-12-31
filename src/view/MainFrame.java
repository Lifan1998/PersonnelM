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
import panel.TreePanel;

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
import java.awt.Font;

public class MainFrame extends JFrame {
	//private static final MainFrame frame = new MainFrame();
	private String number;
	private JPanel contentPane;
	
	private TreePanel treePanel;
	
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
		setBounds(300, 50, 800, 588);
		//this.setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 513, 791, 24);
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
					Thread.sleep(1000);
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
		panel.setBounds(10, 44, 211, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.ORANGE);
		panel_5.setBounds(0, 0, 211, 20);
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel(" 快速访问");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		panel_5.add(label, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 211, 330);
		contentPane.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.ORANGE);
		panel_6.setBounds(0, 0, 209, 20);
		panel_3.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel(" 资源管理器");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBackground(Color.WHITE);
		panel_6.add(label_1);
		
		treePanel = new TreePanel(number);
		treePanel.setBounds(0, 24, 209, 330);
		panel_3.add(treePanel);
		
		tabbled = new JTabbedPane(JTabbedPane.TOP);
		tabbled.setBounds(231, 44, 553, 464);
		contentPane.add(tabbled);
		
		
		
		JPanel panel_4 = new JPanel();
		
		MenuPanel menuP = new MenuPanel(number);
		//menuP.setLocation(0, 0);
		this.setJMenuBar(menuP.getMenuBar());
		JToolBar tool = menuP.getTool();
		//tool.setBounds(0, 0, 800, 50);
		contentPane.add(tool);
	}
	
	
	
	
	public void setNumber(String number) {
		this.number = number;
	}

	//添加、显示面板
	public static void addJTabbled(String title,Tb_panel panel,Boolean isedit) {
		tabbled.remove((Component) panel);
		
		panel.updata();//更新数据
		tabbled.add(title,(Component) panel);
		
		if(isedit==true)
			panel.edit();
			
		else 
			panel.unedit();
			
	}
	public static void f(){
		System.out.println(tabbled.getSelectedIndex()+"//"+tabbled.getTabCount()+"//"+tabbled.getTabRunCount());
	}
	public static Tb_panel getJTabbed(){
		return (Tb_panel) tabbled.getSelectedComponent();
	}
}
