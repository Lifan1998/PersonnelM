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
	private static final MainFrame frame = new MainFrame();
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
	private JTabbedPane tabbled;//选项卡
	
	
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	private MainFrame() {
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
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		JLabel lblNewLabel_1 = new JLabel(df.format(new Date()));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);
		addmenu(panel_2);
		addtool(panel_2);
		
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(231, 63, 553, 471);
		contentPane.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
	}
	
	
	private void addmenu(JPanel panel){
		panel_2.setLayout(new BorderLayout(0, 0));
		JMenuBar meunbar = new JMenuBar();
		
		JMenu meun0 = new JMenu("   编辑 ");
		
		JMenu meun1 = new JMenu(" 查看 ");
		
		JMenu menu_1 = new JMenu("新建");
		meunbar.add(menu_1);
		
		JMenuItem menuItem_10 = new JMenuItem("新建小组");
		menu_1.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("新建员工");
		menu_1.add(menuItem_11);
		
		meunbar.add(meun0);
		
		JMenuItem menuItem_3 = new JMenuItem("编辑我的信息");
		meun0.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("编辑下级信息");
		meun0.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("编辑下级工资");
		meun0.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("编辑下级考勤");
		meun0.add(menuItem_6);
		meunbar.add(meun1);
		
		JMenuItem menuItem = new JMenuItem("查看我的工资");
		meun1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("查看我的信息");
		meun1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("查看我的考勤");
		meun1.add(menuItem_2);
		
		JMenuItem menuItem_7 = new JMenuItem("查看下级工资");
		meun1.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("查看下级信息");
		meun1.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("查看下级考勤");
		meun1.add(menuItem_9);
		panel.add(meunbar, BorderLayout.NORTH);
		
		JMenu menu = new JMenu("系统");
		meunbar.add(menu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("密码设置");
		menu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("退出");
		menu.add(mntmNewMenuItem_2);
		
		JMenu meun2 = new JMenu(" 帮助 ");
		meunbar.add(meun2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("使用说明");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		meun2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("关于");
		meun2.add(mntmNewMenuItem_1);
		
	}
	private void addtool(JPanel panel){
		JToolBar tool = new JToolBar();
		JButton btn1 = new JButton(new ImageIcon("src\\res\\btn1.png"));
		JButton btn2 = new JButton(new ImageIcon("src\\res\\btn1.png"));
		JButton btn3 = new JButton(new ImageIcon("src\\res\\btn1.png"));
		tool.add(btn1);
		tool.add(btn2);
		tool.add(btn3);        
		
		
		tool.setRollover(true);
		panel.add(tool, BorderLayout.CENTER);
		
	}
	
	public void setNumber(String number) {
		this.number = number;
	}


	public static MainFrame getInstance(){
		return frame;
	}
	
	//添加、显示面板
	private void addJTabbled(String title,Tb_panel panel,Boolean isedit) {
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
