package panel;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.tree.DefaultMutableTreeNode;

import dao.DeptDAO;
import dao.InforDAO;
import model.Dept;
import model.Infor;
import tools.MyActionListener;
import tools.Tools;

public class TreePanel extends JPanel {
	private String number;
	private JTree tree;
	private ArrayList<DefaultMutableTreeNode> deptNode,personNode;
	private JPopupMenu popup;
	/**
	 * Create the panel.
	 */
	
	public TreePanel(String number) {
		setSize(209, 311);
		setLayout(new BorderLayout(0, 0));
		
		
		
		init(number);
		
		
		
		
	}
	
	public void init(String number){
		if(number.equals("100000"))
			number = "110000";
		deptNode = new ArrayList<>();
		personNode = new ArrayList<>();
		String deptNo = Tools.getDeptNo(number);
		String deptName = new DeptDAO().getDeptName(deptNo);
		//System.out.println(deptNo+deptName);
		
		initinit(new Dept(deptNo,deptName), new DefaultMutableTreeNode(deptName));
		
		
		tree = new JTree(deptNode.get(0));
		add(tree, BorderLayout.CENTER);
		String name = new InforDAO().getPersonInfor(number).getName();
		for(int i=0;i<personNode.size()&&i<9;i++)
			if(personNode.get(i).getUserObject().equals(name)==false)
				personNode.remove(i);
		java.util.Iterator<DefaultMutableTreeNode> it = personNode.iterator();
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==e.BUTTON3){
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					if(node==null)
						return;
					if(node.isLeaf()){
						//System.out.println(node.toString());
						try {
							popup = new Popup(new InforDAO().getNumber(node.toString()));
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						popup.show(e.getComponent(), e.getX(), e.getY());
						
					}
					
					
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
	}
	
	private void initinit(Dept dept2,DefaultMutableTreeNode node){
		//System.out.println(dept2.getDeptName());
		//DefaultMutableTreeNode denode = new DefaultMutableTreeNode(dept2.getDeptName());
		ArrayList<Infor> list = null;
		deptNode.add(node);
		
		list = new InforDAO().getDeptInfor(dept2.getDeptNo());
		java.util.Iterator<Infor> it = list.iterator();
		while(it.hasNext()){
			DefaultMutableTreeNode personode = new DefaultMutableTreeNode(it.next().getName());
			node.add(personode);
			personNode.add(personode);
			//System.out.println(personode.toString());
			
		}
		ArrayList<Dept> dlist =null;
		dlist = new DeptDAO().getNext(dept2.getDeptNo());
		//System.out.println(dept2.getDeptNo());
		java.util.Iterator<Dept> it1 = dlist.iterator();
		while(it1.hasNext()){
			Dept dept = it1.next();
			DefaultMutableTreeNode denode1 = new DefaultMutableTreeNode(dept.getDeptName());
			node.add(denode1);
			initinit(dept,denode1);
		}
		 
	}
	class Popup extends JPopupMenu{
		String number ;
		private Popup(String number){
			this.number = number;
			
			MyActionListener action = new MyActionListener(number);
			JMenuItem item_1 = new JMenuItem("个人信息");
			item_1.addActionListener(action);
			JMenuItem item_2 = new JMenuItem("个人考勤");
			item_2.addActionListener(action);
			JMenuItem item_3 = new JMenuItem("个人工资");
			item_3.addActionListener(action);
			JMenuItem item_4 = new JMenuItem("下级工资");
			item_4.addActionListener(action);
			JMenuItem item_5 = new JMenuItem("下级考勤");
			item_5.addActionListener(action);
			
			this.add(item_1);
			this.add(item_2);
			this.add(item_3);
			if(Tools.check(number)==2){
				this.add(item_4);
				this.add(item_5);
				
			}
		}
		
	}
	
	

}
