package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;

import model.MyTableModel;

public class PayTableP extends JPanel implements Tb_panel{
	private static PayTableP payTableP;
	private JTable table;
	private static String  number;
	private MyTableModel mymodel;

	/**
	 * Create the panel.
	 */
	private PayTableP(String number) {
		setLayout(null);
		this.setSize(553,471);
		
		JLabel lblNewLabel = new JLabel("部门：");
		lblNewLabel.setBounds(32, 29, 54, 15);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(139, 26, 32, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(234, 26, 32, 21);
		add(comboBox_1);
		
		table = new JTable();
		table.setBounds(40, 103, 415, 298);
		add(table);
		mymodel.addColumn(new String[]{"姓名","基本工资","奖金"});
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
	public static PayTableP getInstance(String number){
		if(number.equals(PayTableP.number))
			return payTableP;
		else {
			payTableP = new PayTableP(number);
			return payTableP;
		}
			
	}
}
