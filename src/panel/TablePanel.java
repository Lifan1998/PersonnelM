package panel;

import javax.swing.JPanel;
import javax.swing.JTable;

import model.MyTableModel;

public class TablePanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TablePanel(MyTableModel tableModel) {
		setLayout(null);
		
		table = new JTable(tableModel);
		table.setBounds(30, 20, 398, 253);
		add(table);
		
	}
	
	public void update(MyTableModel tableModel){
		table.setModel(tableModel);
	}
	
}
