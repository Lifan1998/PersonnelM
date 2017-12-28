package view;

import javax.swing.JPanel;
import javax.swing.JTree;
import java.awt.BorderLayout;

public class TreePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TreePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		add(tree);

	}

}
