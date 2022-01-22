package alldatastructure.tree.binary;

public class BinaryTreeMain {

	public static BinaryTreeNode createBinaryTree() {

		BinaryTreeNode N1 = new BinaryTreeNode();
		N1.value = "N1";
		BinaryTreeNode N2 = new BinaryTreeNode();
		N2.value = "N2";
		BinaryTreeNode N3 = new BinaryTreeNode();
		N3.value = "N3";
		BinaryTreeNode N4 = new BinaryTreeNode();
		N4.value = "N4";
		BinaryTreeNode N5 = new BinaryTreeNode();
		N5.value = "N5";
		BinaryTreeNode N6 = new BinaryTreeNode();
		N6.value = "N6";
		BinaryTreeNode N7 = new BinaryTreeNode();
		N7.value = "N7";
		BinaryTreeNode N8 = new BinaryTreeNode();
		N8.value = "N8";
		BinaryTreeNode N9 = new BinaryTreeNode();
		N9.value = "N9";

		N1.left = N2;
		N1.right = N3;

		N2.left = N4;
		N2.right = N5;

		N3.left = N6;
		N3.right = N7;

		N4.left = N8;
		N4.right = N9;

		return N1;
	}

	

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		BinaryTreeNode rootNode = createBinaryTree();

		System.out.print("Pre-Order Traversal   --> ");
		binaryTree.preOrderTraversal(rootNode);
		System.out.println();

		System.out.print("In-Order Traversal    --> ");
		binaryTree.inOrderTraversal(rootNode);
		System.out.println();

		System.out.print("Post-Order Traversal  --> ");
		binaryTree.postOrderTraversal(rootNode);
		System.out.println();

		System.out.print("Level-Order Traversal --> ");
		binaryTree.levelOrderTraversal(rootNode);
		System.out.println();
		
		System.out.print("Searching in Tree     --> ");
		binaryTree.search(rootNode, "N5");

		System.out.println(); 

	}

}
