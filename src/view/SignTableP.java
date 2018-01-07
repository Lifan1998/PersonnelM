package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;

import dao.InforDAO;
import dao.SignDAO;
import model.Infor;
import model.MyTableModel;
import model.Sign_in;
import panel.CheckBox;
import view.SignDayP.JPan;
import java.awt.BorderLayout;
import java.awt.Color;

public class SignTableP extends JPanel implements Tb_panel {
	
	private static String number;
	private static SignTableP signTp;
	private final String[] strtable = {"工号","姓名","签到","迟到","请假","出差","缺勤","未知"};
	private CheckBox checkBox;
	private JTable table;
	private int[] a;
	//private JTable table_1;
	/**
	 * Create the panel.
	 * @param number2 
	 */
	public SignTableP(String number2) {
		this.number = number2;
		setLayout(null);
		this.setSize(553,471);
		checkBox = new CheckBox();
		this.add(checkBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 60, 533, 362);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 533, 362);
		panel.add(scrollPane);
		
		table= new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionBackground(Color.ORANGE) ;
		
	}

	@Override
	public void edit(){
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void unedit() {
		
		
	}

	@Override
	public void updata() {
		
		MyTableModel mymodel = new MyTableModel();
		for(int i=0;i<strtable.length;i++)
		mymodel.addColumn(strtable[i]);
		
		InforDAO inforDAO = new InforDAO();
		SignDAO signDAO = new SignDAO();
		ArrayList<Infor> list =null;
		list = inforDAO.getTInfor(number);
		java.util.Iterator<Infor> it = list.iterator();
		
		String str = checkBox.getYear()+"-"+checkBox.getMonth();
		while(it.hasNext()){
			Infor infor = it.next();
			a = new int[6];
			Date date;
			for(int i=1;i<31;i++){
				if(i<10)
					date = Date.valueOf(str+"-0"+i);
				else date = Date.valueOf(str+"-"+i);
				Sign_in sign = signDAO.getPersonSign(infor.getNumber(), date);
				if(sign==null)
					a[5]++;
				else{
					switch(sign.getSign()) {
					case "签到": a[0]++;break;
					case "迟到": a[1]++;break;
					case "请假": a[2]++;break;
					case "出差": a[3]++;break;
					case "缺勤": a[4]++;break;
					}
				}
			}
			switch(checkBox.getMonth()){
			case "1":;case "3":;case "5":;case "7":;case "8":;case "10":;case "12":
				date = Date.valueOf(str+"-31");
				Sign_in sign = signDAO.getPersonSign(number, date);
				if(sign==null)
					a[5]++;
				else {	
					switch(sign.getSign()) {
						case "签到": a[0]++;break;
						case "迟到": a[1]++;break;
						case "请假": a[2]++;break;
						case "出差": a[3]++;break;
						case "缺勤": a[4]++;break;
					}
				}
			}
			mymodel.addRow(new Object[]{infor.getNumber(),infor.getName(),a[0]+"",
					a[1]+"",a[2]+"",a[3]+"",a[4]+"",a[5]+""});
		}
		
		
		table.setModel(mymodel);
	}

	@Override
	public void save() {
		// TODO 自动生成的方法存根
		
	}
	
	public static SignTableP getInstance(String number){
		if(number.equals(SignTableP.number))
			return signTp;
		else 
			signTp = new SignTableP(number);
		return signTp;
	}
}
