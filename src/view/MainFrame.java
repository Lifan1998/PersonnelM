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

public class MainFrame extends JFrame {
	private static final MainFrame frame = new MainFrame();
	private JPanel contentPane;
	private JPanel panel_2;
	
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
		
		JMenu meun2 = new JMenu(" 帮助 ");
		
		meunbar.add(meun0);
		meunbar.add(meun1);
		meunbar.add(meun2);
		panel.add(meunbar, BorderLayout.NORTH);
		
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
	public static MainFrame getInstance(){
		return frame;
	}
}
