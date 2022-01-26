package alldatastructure.tree.binary.search;

public class BinarySearchTreeMain {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(70);
		bst.insert(50);
		bst.insert(90);
		bst.insert(30);
		bst.insert(60);
		bst.insert(20);
		bst.insert(30);
		bst.insert(40);
		bst.insert(85);
		bst.insert(88);
		bst.insert(100);

		bst.levelOrderTraversal();
		bst.search(bst.root, 20);
		BinaryTreeNode smll=bst.findSmallestNode(bst.root.right);
		System.out.println(smll.value);
		bst.deleteNode(bst.root,100);
		bst.levelOrderTraversal();

	}

}
