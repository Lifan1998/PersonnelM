package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.text.html.HTMLDocument.Iterator;

import dao.InforDAO;
import dao.PayDAO;
import model.Infor;
import model.MyTableModel;
import model.Pay;
import panel.CheckBox;
import javax.swing.JScrollPane;

public class PayTableP extends JPanel implements Tb_panel{
	private static PayTableP payTableP;
	private JTable table;
	private static String  number;
	private MyTableModel mymodel;
	private CheckBox checkBox;
	private String[] string = {"姓名","基本工资","奖金","扣除","加班","补贴","保险","总计"};

	/**
	 * Create the panel.
	 */
	private PayTableP(String number) {
		this.number = number;
		setLayout(null);
		this.setSize(553,471);
		checkBox = new CheckBox();
		add(checkBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 533, 322);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionBackground(Color.ORANGE) ;
		
		
	}

	@Override
	public void edit() {
		mymodel.edit();
		
	}

	@Override
	public void unedit() {
		mymodel.unedit();
		
	}

	@Override
	public void updata() {
		String str = checkBox.getYear()+"-"+checkBox.getMonth()+"-21";
		Date date = Date.valueOf(str);
		PayDAO payDAO = new PayDAO();
		InforDAO inforDAO = new InforDAO();
		mymodel = new MyTableModel();
		for(int i=0;i<string.length;i++){
			mymodel.addColumn(string[i]);
		//System.out.println(string[i]);
		}
		
		ArrayList<Pay> list = null;
		ArrayList<Infor> list_1 = null;
		try {
			list = payDAO.getTPay(number, date);
			list_1 = inforDAO.getTInfor(number);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		java.util.Iterator<Pay> it = list.iterator();
		java.util.Iterator<Infor> it_1 = list_1.iterator();
		while(it_1.hasNext()){
			Pay pay = null;
			if(it.hasNext()==true)
			pay = it.next();
			Infor infor = it_1.next();
			if(pay!=null)
			mymodel.addRow(new Object[]{infor.getName(),pay.getBase()+"",pay.getBonus()+"",pay.getDeduct(),pay.getExtra(),
					pay.getSubsidy(),pay.getOther(),pay.getFact()
					
			});
			else {
				mymodel.addRow(new Object[]{infor.getName()
						
				});
			}
			//System.out.println(mymodel);
		}
		
		table.setModel(mymodel);
	}
	
	public static PayTableP getInstance(String number){
		if(number.equals(PayTableP.number))
			return payTableP;
		else {
			payTableP = new PayTableP(number);
			return payTableP;
		}
			
	}

	@Override
	public void save() {
		// TODO 自动生成的方法存根
		mymodel.unedit();
	}
}
