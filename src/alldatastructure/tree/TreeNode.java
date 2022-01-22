package alldatastructure.tree;

import java.util.ArrayList;

public class TreeNode {

	String value;
	ArrayList<TreeNode> childrens;

	public TreeNode(String value) {
		this.value = value;
		this.childrens = new ArrayList<TreeNode>();
	}

	public void addChild(TreeNode chlid) {
		childrens.add(chlid);
	}

	public String printTree(int level) {
		String res;
		 res = "  ".repeat(level) + value + "\n";
		for (TreeNode treeNode : this.childrens) {
			res += treeNode.printTree(level+1);
		}

		return res;

	}

}
