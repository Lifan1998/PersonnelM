package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.text.html.HTMLDocument.Iterator;

import dao.AccountsDAO;
import model.Accounts;
import model.MyTableModel;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class AccountsPanel extends JPanel implements Tb_panel{
	private JTable table;
	private static final AccountsPanel accP = new AccountsPanel();

	/**
	 * Create the panel.
	 */
	public AccountsPanel() {
		setLayout(null);
		this.setSize(553,471);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 21, 465, 413);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 49, 161, 316);
		panel.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
	}

	@Override
	public void edit() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void unedit() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void updata() {
		AccountsDAO accDAO = new AccountsDAO();
		ArrayList<Accounts> list =accDAO.getDate();
		MyTableModel mymodel = new MyTableModel();
		mymodel.addColumn("账号");mymodel.addColumn("密码");
		java.util.Iterator<Accounts> it =  list.iterator();
		while(it.hasNext()){
			Accounts acc = it.next();
			mymodel.addRow(new String[]{acc.getNumber(),acc.getPassword()});
		}
		
		table.setModel(mymodel);
		
	}
	
	public static AccountsPanel getInstance(){
		return accP;
	}

	@Override
	public void save() {
		// TODO 自动生成的方法存根
		
	}
}
