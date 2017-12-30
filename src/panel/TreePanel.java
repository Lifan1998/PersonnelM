package panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTree;

public class TreePanel extends JPanel {
	private String number;
	private JTree tree;
	/**
	 * Create the panel.
	 */
	
	public TreePanel(String number) {
		setSize(209, 311);
		setLayout(new BorderLayout(0, 0));
		
		tree = new JTree();
		add(tree, BorderLayout.CENTER);
	}

}
