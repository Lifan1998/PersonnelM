package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class InforTableP extends JPanel implements Tb_panel{
	private JTable table;

	/**
	 * Create the panel.
	 */
	public InforTableP() {
		setLayout(null);
		this.setSize(553,471);
		
		JLabel lblNewLabel = new JLabel("部门");
		lblNewLabel.setBounds(32, 10, 54, 15);
		add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(32, 74, 455, 300);
		add(table);
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
