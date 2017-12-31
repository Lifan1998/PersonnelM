package tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class MyActionListener implements ActionListener {
	private String number;
	

	public MyActionListener(String number) {
		this.number = number;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tb_panel  panel = MainFrame.getJTabbed();
		switch(e.getActionCommand()){
			case "新建小组":;break;
			case "新建员工":;break;
			case "刷新":  if(panel!=null)
						panel.updata();
						break;
			case "编辑我的信息":MainFrame.addJTabbled("个人信息", InforPanel.getInstance(number), true);break;
			case "编辑员工信息":MainFrame.addJTabbled("员工信息", InforTableP.getInstance(number), true);break;
			case "编辑员工考勤":MainFrame.addJTabbled("员工考勤", SignDayP.getInstance(number), true);break;
			case "编辑员工工资":MainFrame.addJTabbled("员工工资", PayTableP.getInstance(number), true);break;
			case "查看员工信息":MainFrame.addJTabbled("员工信息", InforTableP.getInstance(number), false);break;
			case "查看员工工资":MainFrame.addJTabbled("员工工资", PayTableP.getInstance(number), false);break;
			case "查看员工考勤":MainFrame.addJTabbled("员工考勤", SignTableP.getInstance(number), false);break;
			case "我的信息":
			case "查看我的信息":MainFrame.addJTabbled("个人信息", InforPanel.getInstance(number), false);break;
			case "查看我的工资":MainFrame.addJTabbled("个人工资", PayPanel.getInstance(number), false);break;
			case "查看我的考勤":MainFrame.addJTabbled("个人考勤", SignPanel.getInstance(number), false);break;
			case "保存": if(panel!=null)
				 		panel.save();
				 		break;
			case "开启/关闭":;
			case "账号密码":MainFrame.addJTabbled("账号密码", AccountsPanel.getInstance(), false);break;
			case "密码设置":;
			case "退出":System.exit(0);break;
			case "使用说明":
			case "关于":;
		
		}

	}
	
}
