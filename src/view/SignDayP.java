package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class SignDayP extends JPanel implements Tb_panel{

	/**
	 * Create the panel.
	 */
	public SignDayP() {
		setLayout(null);
		this.setSize(553,471);
		
		JLabel lblNewLabel = new JLabel("部门：");
		lblNewLabel.setBounds(40, 29, 54, 15);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 26, 32, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(229, 26, 32, 21);
		add(comboBox_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(89, 120, 214, 226);
		add(panel);
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
