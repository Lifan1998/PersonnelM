package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AccountsPanel extends JPanel implements Tb_panel{
	private JTable table;

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
		
		table = new JTable();
		table.setBounds(38, 29, 275, 273);
		panel.add(table);
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
		// TODO 自动生成的方法存根
		
	}
}
