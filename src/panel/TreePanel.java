package panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.tree.DefaultMutableTreeNode;

import dao.DeptDAO;
import dao.InforDAO;
import model.Dept;
import model.Infor;
import tools.Tools;

public class TreePanel extends JPanel {
	private String number;
	private JTree tree;
	private ArrayList<DefaultMutableTreeNode> deptNode,personNode; 
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
			System.out.println(personode.toString());
			
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

}
