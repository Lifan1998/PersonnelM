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
	/**
	 * Create the panel.
	 */
	public MenuPanel(String number) {
		this.number = number;
		setSize(800, 53);
		init(Tools.check(number));
	}
	
	
	private void init(int check) {
		setLayout(new BorderLayout(0, 0));
		
		//菜单栏
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
		menuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("个人信息", InforPanel.getInstance(number), true);
				
			}
		});
		JMenuItem menuItem_4 = new JMenuItem("编辑下级信息");
		meun0.add(menuItem_4);
		menuItem_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("下属信息",InforTableP.getInstance(number), true);
				
			}
		});
		
		JMenuItem menuItem_5 = new JMenuItem("编辑下级工资");
		meun0.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("编辑下级考勤");
		meun0.add(menuItem_6);
		meunbar.add(meun1);
		menuItem_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("下级签到",SignDayP.getInstance(number), true);
				
			}
		});
		
		JMenuItem menuItem = new JMenuItem("查看我的工资");
		meun1.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    MainFrame.addJTabbled("个人工资",PayPanel.getInstance(number), true);
				
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("查看我的信息");
		meun1.add(menuItem_1);
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("个人信息", InforPanel.getInstance(number), false);
				
			}
		});
		
		JMenuItem menuItem_2 = new JMenuItem("查看我的考勤");
		meun1.add(menuItem_2);
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("个人考勤", SignPanel.getInstance(number), false);
				
			}
		});
		
		JMenuItem menuItem_7 = new JMenuItem("查看下级工资");
		meun1.add(menuItem_7);
		menuItem_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("下属工资",PayTableP.getInstance(number), false);
				
			}
		});
		
		JMenuItem menuItem_8 = new JMenuItem("查看下级信息");
		meun1.add(menuItem_8);
		menuItem_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("下属信息",InforTableP.getInstance(number), false);
				
			}
		});
		
		JMenuItem menuItem_9 = new JMenuItem("查看下级考勤");
		meun1.add(menuItem_9);
		menuItem_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("下级考勤",SignTableP.getInstance(number),true);
				
			}
		});
		add(meunbar, BorderLayout.NORTH);
		
		JMenu menu = new JMenu("系统");
		meunbar.add(menu);
		
		JMenuItem menuItem_12 = new JMenuItem("开启/关闭");
		menu.add(menuItem_12);
		
		JMenuItem mntmZ = new JMenuItem("帐号密码");
		menu.add(mntmZ);
		mntmZ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("账号密码",AccountsPanel.getInstance(), false);
				
			}
		});
		
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
		
		
		
		JToolBar tool = new JToolBar();
		JButton btn1 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/info.jpg")));
		JButton btn2 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/pay.jpg")));
		JButton btn3 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/sign.jpg")));
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
		add(tool, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/edit.PNG")));
		tool.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tb_panel  panel = MainFrame.getJTabbed();
				panel.edit();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/btn1.PNG")));
		tool.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tb_panel  panel = MainFrame.getJTabbed();
				panel.save();
				
			}
		});
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/pM.PNG")));
		tool.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tb_panel  panel = MainFrame.getJTabbed();
				panel.updata();
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/sign2.png")));
		tool.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.addJTabbled("下级签到",SignDayP.getInstance(number), true);
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/kai.png")));	
		tool.add(btnNewButton_3);
		
		
		
		if(check==1){
			meun0.remove(menuItem_3);
			meun1.remove(menuItem);
			meun1.remove(menuItem_1);
			meun1.remove(menuItem_2);
			tool.remove(btn1);
			tool.remove(btn2);
			tool.remove(btn3);
			
		} else if(check==2){
			menu.remove(mntmZ);
			menu.remove(menuItem_12);
			tool.remove(btnNewButton_3);
			
		} else if(check==3){
			
			meunbar.remove(menu_1);
			meun0.remove(menuItem_4);
			meun0.remove(menuItem_5);
			meun0.remove(menuItem_6);
			meun1.remove(menuItem_7);
			meun1.remove(menuItem_8); 
			meun1.remove(menuItem_9);	
			menu.remove(mntmZ);
			menu.remove(menuItem_12);
			tool.remove(btnNewButton_3);
			tool.remove(btnNewButton_2);
		}
	
	}

}
