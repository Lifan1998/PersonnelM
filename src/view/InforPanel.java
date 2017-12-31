package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import dao.InforDAO;
import model.Infor;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class InforPanel extends JPanel implements Tb_panel{
	private static String number;
	private static InforPanel inforPanel;
	private JTextField txtname;
	private JTextField textsex;
	private JTextField textnumber;
	private JTextField textage;
	private JTextField textedu;
	private JTextField textbirth;
	private JTextField texthome;
	private JTextField textid;
	private JTextField textmarri;
	private JTextField texttele;
	private JTextField textemail;
	private JTextArea textstate;
	private JTextField textwork;

	/**
	 * Create the panel.
	 */
	private InforPanel(String number) {
		this.number=number;
		
		setLayout(null);
		this.setSize(553,471);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InforPanel.class.getResource("/res/app.png")));
		lblNewLabel.setBounds(10, 10, 112, 144);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(150, 10, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别：");
		lblNewLabel_2.setBounds(321, 10, 54, 15);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("工号：");
		label.setBounds(150, 50, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("年龄：");
		label_1.setBounds(321, 50, 54, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("学历：");
		label_2.setBounds(150, 96, 54, 15);
		add(label_2);
		
		txtname = new JTextField();
		txtname.setBounds(196, 10, 84, 21);
		add(txtname);
		txtname.setColumns(10);
		
		textsex = new JTextField();
		textsex.setBounds(385, 7, 66, 21);
		add(textsex);
		textsex.setColumns(10);
		
		JLabel label_3 = new JLabel("出生日期：");
		label_3.setBounds(31, 204, 84, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("家庭住址：");
		label_4.setBounds(31, 239, 79, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("身份证号：");
		label_5.setBounds(31, 269, 77, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("入职时间：");
		label_6.setBounds(31, 306, 87, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("详细：");
		label_7.setBounds(31, 341, 54, 15);
		add(label_7);
		
		textnumber = new JTextField();
		textnumber.setBounds(196, 47, 66, 21);
		add(textnumber);
		textnumber.setColumns(10);
		
		textage = new JTextField();
		textage.setBounds(385, 47, 66, 21);
		add(textage);
		textage.setColumns(10);
		
		textedu = new JTextField();
		textedu.setBounds(196, 93, 66, 21);
		add(textedu);
		textedu.setColumns(10);
		
		textbirth = new JTextField();
		textbirth.setBounds(118, 201, 270, 21);
		add(textbirth);
		textbirth.setColumns(10);
		
		texthome = new JTextField();
		texthome.setBounds(118, 236, 379, 21);
		add(texthome);
		texthome.setColumns(10);
		
		textid = new JTextField();
		textid.setBounds(118, 266, 270, 21);
		add(textid);
		textid.setColumns(10);
		
		textwork = new JTextField();
		textwork.setBounds(118, 303, 270, 21);
		add(textwork);
		textwork.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("婚姻：");
		lblNewLabel_3.setBounds(321, 96, 54, 15);
		add(lblNewLabel_3);
		
		JLabel lbli = new JLabel("电话：");
		lbli.setBounds(150, 139, 54, 15);
		add(lbli);
		
		JLabel label_8 = new JLabel("邮箱：");
		label_8.setBounds(321, 139, 54, 15);
		add(label_8);
		
		textmarri = new JTextField();
		textmarri.setBounds(385, 93, 66, 21);
		add(textmarri);
		textmarri.setColumns(10);
		
		texttele = new JTextField();
		texttele.setBounds(196, 136, 97, 21);
		add(texttele);
		texttele.setColumns(10);
		
		textemail = new JTextField();
		textemail.setBounds(385, 136, 112, 21);
		add(textemail);
		textemail.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 352, 379, 75);
		add(scrollPane);
		
		textstate = new JTextArea();
		scrollPane.setViewportView(textstate);
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
		InforDAO inforDAO = new InforDAO();
		Infor infor = inforDAO.getPersonInfor(number);
		setData(infor);	
	}

	private void setData(Infor infor) {
		textage.setText(infor.getAge()+"");
		textbirth.setText(infor.getBirth().toString());
		textedu.setText(infor.getEdu());
		textemail.setText(infor.getEmail());
		texthome.setText(infor.getHome());
		textid.setText(infor.getIdcard());
		textmarri.setText(infor.getMarriage());
		textnumber.setText(infor.getNumber());
		textsex.setText(infor.getSex());
		texttele.setText(infor.getTele());
		txtname.setText(infor.getName());
		textwork.setText(infor.getWork().toString());
		textstate.setText(infor.getState());
		
		
	}
	
	public static InforPanel getInstance(String number){
		
		if(number.equals(InforPanel.number))
			return inforPanel;
		else {
			inforPanel = new InforPanel(number);
			return inforPanel;
		}
			
	}

	@Override
	public void save() {
		// TODO 自动生成的方法存根
		
	}
}
