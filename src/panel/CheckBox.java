package panel;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class CheckBox extends JPanel {

	/**
	 * Create the panel.
	 */
	public CheckBox() {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(153, 5, 32, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(309, 5, 32, 21);
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("年份");
		lblNewLabel.setBounds(89, 8, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("月份");
		lblNewLabel_1.setBounds(246, 8, 54, 15);
		add(lblNewLabel_1);

	}
	
	

}
