package model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	private boolean isEdit = false;

	public MyTableModel() {
		super();
	}
	
	public void edit() {
		
		isEdit = true;
	}

	public void unedit() {
		isEdit = false;
	}

	public void updata() {
			
	}
	@Override
	public boolean isCellEditable(int row,int colu){
		return isEdit;
		
	}
	
}
