package panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import tools.MyActionListener;
import tools.Tools;
import view.AccountsPanel;
import view.InforPanel;
import view.InforTableP;
import view.MainFrame;
import view.PayPanel;
import view.PayTableP;
import view.SignDayP;
import view.SignPanel;
import view.SignTableP;
import view.Tb_panel;

public class MenuPanel extends JPanel {
	String number;
	JMenuBar meunbar;
	JToolBar tool;
	private JButton btn1;
	
	/**
	 * Create the panel.
	 */
	public MenuPanel(String number) {
		this.number = number;
		setSize(800, 53);
		setLayout(null);
		//setLayout(new BorderLayout(0, 0));
		meunbar = new JMenuBar();
		add(meunbar, BorderLayout.NORTH);
		tool = new JToolBar();
		add(tool);
		
		tool.setBounds(0,0,800, 35);
		init(Tools.check(number));
	}
		
	
	
	private void init(int check) {
	
		//菜单栏
		
		JMenu meun2 = new JMenu("编辑");
		JMenu meun3 = new JMenu("查看");
		JMenu menu1 = new JMenu("新建");
		JMenu menu4 = new JMenu("系统");
		JMenu meun5 = new JMenu("帮助");
		
		meunbar.add(menu1);
		
		JMenuItem menuItem11 = new JMenuItem("新建小组");
		menu1.add(menuItem11);
		JMenuItem menuItem12 = new JMenuItem("新建员工");
		menu1.add(menuItem12);
		menuItem12.addActionListener(new MyActionListener(number));
		
		meunbar.add(meun2);
		
		JMenuItem menuItem21 = new JMenuItem("保存");
		meun2.add(menuItem21);
		
		JMenuItem menuItem22 = new JMenuItem("编辑我的信息");
		meun2.add(menuItem22);
		menuItem22.addActionListener(new MyActionListener(number));
		JMenuItem menuItem23 = new JMenuItem("编辑员工信息");
		meun2.add(menuItem23);
		menuItem23.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem24 = new JMenuItem("编辑员工工资");
		meun2.add(menuItem24);
		menuItem24.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem25 = new JMenuItem("编辑员工考勤");
		meun2.add(menuItem25);
		meunbar.add(meun3);
		menuItem25.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem31 = new JMenuItem("刷新");
		menuItem31.addActionListener(new MyActionListener(number));
		meun3.add(menuItem31);
		
		
		JMenuItem menuItem32 = new JMenuItem("查看我的工资");
		meun3.add(menuItem32);
		menuItem32.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem33 = new JMenuItem("查看我的信息");
		meun3.add(menuItem33);
		menuItem33.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem34 = new JMenuItem("查看我的考勤");
		meun3.add(menuItem34);
		menuItem34.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem35 = new JMenuItem("查看员工工资");
		meun3.add(menuItem35);
		menuItem35.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem36 = new JMenuItem("查看员工信息");
		meun3.add(menuItem36);
		menuItem36.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem37 = new JMenuItem("查看员工考勤");
		meun3.add(menuItem37);
		menuItem37.addActionListener(new MyActionListener(number));
		
		
		
		meunbar.add(menu4);
		
		JMenuItem menuItem41 = new JMenuItem("开启/关闭");
		menu4.add(menuItem41);
		menuItem41.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem42 = new JMenuItem("帐号密码");
		menu4.add(menuItem42);
		menuItem42.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem43 = new JMenuItem("密码设置");
		menu4.add(menuItem43);
		menuItem43.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem44 = new JMenuItem("退出");
		menu4.add(menuItem44);
		menuItem44.addActionListener(new MyActionListener(number));
		
		
		meunbar.add(meun5);
		
		JMenuItem menuItem51 = new JMenuItem("使用说明");
		menuItem51.setHorizontalAlignment(SwingConstants.LEFT);
		meun5.add(menuItem51);
		menuItem51.addActionListener(new MyActionListener(number));
		
		JMenuItem menuItem52 = new JMenuItem("关于");
		meun5.add(menuItem52);	
		menuItem52.addActionListener(new MyActionListener(number));
		
		
		
		btn1 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/geren.png")));
		btn1.setFocusable(false);
		btn1.setToolTipText("我的信息");
		JButton btn2 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/pay.png")));
		btn2.setFocusable(false);
		btn2.setToolTipText("我的工资");
		JButton btn3 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/Sign.png")));
		btn3.setFocusable(false);
		btn3.setToolTipText("我的考勤");
		tool.add(btn1);
		tool.add(btn2);
		tool.add(btn3);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("个人信息", InforPanel.getInstance(number), false);
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    MainFrame.addJTabbled("个人工资",PayPanel.getInstance(number), true);
				
			}
		});
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("个人考勤", SignPanel.getInstance(number), false);
				
			}
		});
		//工具栏
		tool.setRollover(true);
		
		
		JButton btn4 = new JButton();
		btn4.setFocusable(false);
		btn4.setToolTipText("编辑");
		btn4.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/edit.PNG")));
		tool.add(btn4);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tb_panel  panel = MainFrame.getJTabbed();
				if(panel!=null)
				panel.edit();
				
			}
		});
		
		JButton btn5 = new JButton();
		btn5.setFocusable(false);
		btn5.setToolTipText("保存");
		btn5.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/save.gif")));
		tool.add(btn5);
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tb_panel  panel = MainFrame.getJTabbed();
				if(panel!=null)
				panel.save();
				
			}
		});
		
		JButton btn6 = new JButton();
		btn6.setFocusable(false);
		btn6.setToolTipText("刷新");
		btn6.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/update.png")));
		tool.add(btn6);
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tb_panel  panel = MainFrame.getJTabbed();
				if(panel!=null)
				panel.updata();
				
			}
		});
		
		JButton btn7 = new JButton();
		btn7.setFocusable(false);
		btn7.setToolTipText("员工签到");
		btn7.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/sign2.png")));
		tool.add(btn7);
		btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("下级签到",SignDayP.getInstance(number), true);
				
			}
		});
		
		JButton btn8 = new JButton();
		btn8.setFocusable(false);
		btn8.setToolTipText("已开启");
		btn8.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/kai.png")));	
		tool.add(btn8);
		
		
		
		if(check==1){
			meun2.remove(menuItem22);
			meun3.remove(menuItem32);
			meun3.remove(menuItem33);
			meun3.remove(menuItem34);
			tool.remove(btn1);
			tool.remove(btn2);
			tool.remove(btn3);
			
		} else if(check==2){
			
			menu4.remove(menuItem42);
			menu4.remove(menuItem41);
			tool.remove(btn8);
			
		} else if(check==3){
			
			meunbar.remove(menu1);
			meun2.remove(menuItem23);
			meun2.remove(menuItem24);
			meun2.remove(menuItem25);
			meun3.remove(menuItem35);
			meun3.remove(menuItem36); 
			meun3.remove(menuItem37);	
			menu4.remove(menuItem42);
			menu4.remove(menuItem41);
			tool.remove(btn8);
			tool.remove(btn7);
		}
	
	}
	
	public JMenuBar getMenuBar(){
		return meunbar;
	}
	public JToolBar getTool(){
		return tool;
	}
}
