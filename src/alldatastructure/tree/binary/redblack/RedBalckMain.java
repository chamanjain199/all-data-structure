package alldatastructure.tree.binary.redblack;

public class RedBalckMain {

	public static void main(String[] args) {

		RedBlackTree rbTree = new RedBlackTree();
		rbTree.insert(10);
		rbTree.insert(20);
		rbTree.insert(30);
		rbTree.insert(5);
		rbTree.insert(40);
		rbTree.insert(25);
		rbTree.insert(50);
		rbTree.insert(35);
		rbTree.levelOrder();

	}

}
