package panel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import tools.Tools;

public class MenuPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuPanel(String number) {
		setSize(800, 53);
		init(Tools.check(number));
	}
	
	
	private void init(int check) {
		
		
		
		if(check==1)
			;
		else if(check==2){
			
		} else if(check==3){
			
		}
		addmenu(this);
		addtool(this);
	}


	private void addmenu(JPanel panel){
		setLayout(new BorderLayout(0, 0));
		
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
		
		JMenuItem menuItem_12 = new JMenuItem("开启/关闭");
		menu.add(menuItem_12);
		
		JMenuItem mntmZ = new JMenuItem("帐号密码");
		menu.add(mntmZ);
		
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
		JButton btn1 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/info.jpg")));
		JButton btn2 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/pay.jpg")));
		JButton btn3 = new JButton(new ImageIcon(MenuPanel.class.getResource("/res/sign.jpg")));
		tool.add(btn1);
		tool.add(btn2);
		tool.add(btn3);        
		
		
		tool.setRollover(true);
		panel.add(tool, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/edit.PNG")));
		tool.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/btn1.PNG")));
		tool.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/pM.PNG")));
		tool.add(button);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/sign2.png")));
		tool.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(MenuPanel.class.getResource("/res/kai.png")));	
		tool.add(btnNewButton_3);
		
	}
}
