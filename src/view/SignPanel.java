package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;

public class SignPanel extends JPanel implements Tb_panel{

	/**
	 * Create the panel.
	 */
	public SignPanel() {
		setLayout(null);
		this.setSize(553,471);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(32, 23, 54, 15);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(146, 22, 32, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(236, 18, 32, 21);
		add(comboBox_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 67, 450, 360);
		add(panel);
		panel.setLayout(new GridLayout(6, 6, 0, 0));
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
