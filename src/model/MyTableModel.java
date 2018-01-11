package model;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	private boolean isEdit = false;
	private ArrayList<Integer> editedIndex = new ArrayList<>();

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
	
	@Override
	public void setValueAt(Object aValue,int row,int column) {
		super.setValueAt(aValue, row, column);
		int i,count=editedIndex.size();
		if(count==0)
			editedIndex.add(row);
		else {
			for(i=0;i<count;i++){
				if(editedIndex.get(i).intValue()>row){
					editedIndex.add(i+1,row);
					break;
				}
			}
			if(i>=count)
				editedIndex.add(row);
		}
		
	}
	public ArrayList<Integer> getEditedIndex() {
		return editedIndex;
	}
	
}
