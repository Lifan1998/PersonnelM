package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.text.html.HTMLDocument.Iterator;

import dao.InforDAO;
import model.Infor;
import model.MyTableModel;
import javax.swing.JScrollPane;

public class InforTableP extends JPanel implements Tb_panel{
	private static InforTableP inforTableP;
	private static String number;
	private JTable table;
	private String[] str ={"工号","姓名","学历","电话","邮箱","身份证号"};
	MyTableModel mymodel;

	/**
	 * Create the panel.
	 * @param number2 
	 */
	private InforTableP(String number) {
		this.number = number;
		setLayout(null);
		this.setSize(553,471);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 29, 533, 384);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 533, 384);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionBackground(Color.ORANGE) ;
		table.setFillsViewportHeight(true) ;
		

	}

	@Override
	public void edit() {
		// TODO 自动生成的方法存根
		mymodel.edit();
	}

	@Override
	public void unedit() {
		mymodel.unedit();
		
	}

	@Override
	public void updata() {
		mymodel = new MyTableModel();
		for(int i=0;i<str.length;i++)
			mymodel.addColumn(str[i]);
		InforDAO inforDAO = new InforDAO();
		ArrayList<Infor> list =null;
		list = inforDAO.getTInfor(number);
		java.util.Iterator<Infor> it = list.iterator();
		while(it.hasNext()){
			Infor infor = it.next();
			mymodel.addRow(new Object[]{infor.getNumber(),infor.getName(),
					infor.getEdu(),infor.getTele(),infor.getEmail(),
					infor.getIdcard()});
		}
		table.setModel(mymodel);
		

	}
	
	public static InforTableP getInstance(String number){
		if(number.equals(InforTableP.number))
			return inforTableP;
		else
			inforTableP = new InforTableP(number);
		return inforTableP;
				
	}

	@Override
	public void save() {
		// TODO 自动生成的方法存根
		mymodel.unedit();
	}
}
