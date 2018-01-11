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
	Date date ;
	ArrayList<Infor> list_1 = null;
	PayDAO payDAO = new PayDAO();
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
		date = Date.valueOf(str);
		
		InforDAO inforDAO = new InforDAO();
		mymodel = new MyTableModel();
		for(int i=0;i<string.length;i++){
			mymodel.addColumn(string[i]);
		//System.out.println(string[i]);
		}
		
		
		
		list_1 = inforDAO.getTInfor(number);
		
		java.util.Iterator<Infor> it_1 = list_1.iterator();
		while(it_1.hasNext()){
			Infor infor = it_1.next();
			Pay pay =null;
			try {
				pay = payDAO.getPay(infor.getNumber(), date);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			
			if(pay!=null)
			mymodel.addRow(new Object[]{infor.getName(),pay.getBase()+"",pay.getBonus()+"",pay.getDeduct(),pay.getExtra(),
					pay.getSubsidy(),pay.getOther(),pay.getFact()
					
			});
			else {
				mymodel.addRow(new Object[]{infor.getName(),0,0,0,0,0,0,0
						
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
		ArrayList<Integer> ilist = mymodel.getEditedIndex();
		java.util.Iterator<Integer> it = ilist.iterator();
		while(it.hasNext()){
			int i = it.next().intValue();
			
			System.out.println(i);
			//System.out.println(Integer.parseInt(mymodel.getValueAt(i, 3).toString()));
			Pay pay = new Pay();
			
			
			pay.setNumber(list_1.get(i).getNumber());
			pay.setBase(Integer.parseInt(mymodel.getValueAt(i, 1).toString()));
			pay.setBonus(Integer.parseInt(mymodel.getValueAt(i, 2).toString()));
			pay.setDeduct(Integer.parseInt(mymodel.getValueAt(i, 3).toString()));			
			pay.setExtra(Integer.parseInt(mymodel.getValueAt(i, 4).toString()));
			pay.setSubsidy(Integer.parseInt(mymodel.getValueAt(i, 5).toString()));
			pay.setOther(Integer.parseInt(mymodel.getValueAt(i, 6).toString()));
			pay.setFact(Integer.parseInt(mymodel.getValueAt(i, 7).toString()));
			pay.setDate(date);
			payDAO.addPay(pay);
			System.out.println(pay);

				//删除原记录
				
				//插入新纪录  
		}
		
		
		mymodel.unedit();
	}
}
