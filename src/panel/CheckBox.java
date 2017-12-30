package panel;

import javax.swing.JPanel;

import tools.Tools;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class CheckBox extends JPanel {
	JComboBox comboBox;
	JComboBox comboBox_1;
	/**
	 * Create the panel.
	 */
	public CheckBox() {
		setLayout(null);
		setBounds(0, 0, 550, 50);
		comboBox = new JComboBox();
		comboBox.setBounds(320, 5, 70, 21);
		comboBox.addItem("2016");
		comboBox.addItem("2017");
		comboBox.addItem("2018");
		comboBox.setSelectedItem(Tools.getYear());
		add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItem("01");
		comboBox_1.addItem("02");
		comboBox_1.addItem("03");
		comboBox_1.addItem("04");
		comboBox_1.addItem("05");
		comboBox_1.addItem("06");
		comboBox_1.addItem("07");
		comboBox_1.addItem("08");
		comboBox_1.addItem("09");
		comboBox_1.addItem("10");
		comboBox_1.addItem("11");
		comboBox_1.addItem("12");
		comboBox_1.setBounds(460, 5, 47, 21);
		comboBox_1.setSelectedItem(Tools.getMonth());
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("年份");
		lblNewLabel.setBounds(271, 8, 39, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("月份");
		lblNewLabel_1.setBounds(411, 8, 39, 15);
		add(lblNewLabel_1);

	}
	
	
	public String getYear(){
		return (String) comboBox.getSelectedItem();
	}
	public String getMonth(){
		return (String) comboBox_1.getSelectedItem();
	}

}
