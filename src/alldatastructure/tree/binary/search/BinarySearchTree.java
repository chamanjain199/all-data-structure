package alldatastructure.tree.binary.search;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	BinaryTreeNode root;

	BinarySearchTree() {
		root = null;
	}

	public BinaryTreeNode insert(BinaryTreeNode currentNode, int value) {
		if (currentNode == null) {
			currentNode = new BinaryTreeNode();
			currentNode.value = value;
			return currentNode;
		} else if (currentNode.value <= value) {
			currentNode = insert(currentNode.left, value);
			return currentNode;
		} else {
			currentNode = insert(currentNode.right, value);
			return currentNode;

		}

	}

	public void insert(int value) {
		insert(root, value);

	}

	public void preOrderTraversal(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null) {
			return;
		}
		System.out.print(binaryTreeNode.value + " ");
		preOrderTraversal(binaryTreeNode.left);
		preOrderTraversal(binaryTreeNode.right);

	}

	public void inOrderTraversal(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null) {
			return;
		}
		inOrderTraversal(binaryTreeNode.left);
		System.out.print(binaryTreeNode.value + " ");
		inOrderTraversal(binaryTreeNode.right);

	}

	public void postOrderTraversal(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null) {
			return;
		}
		postOrderTraversal(binaryTreeNode.left);
		postOrderTraversal(binaryTreeNode.right);
		System.out.print(binaryTreeNode.value + " ");

	}

	public void levelOrderTraversal(BinaryTreeNode binaryTreeNode) {

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}

	}

	public void search(BinaryTreeNode binaryTreeNode, int value) {

		if (binaryTreeNode == null) {
			System.out.println("value " + value + " not found in tree");
		} else if (binaryTreeNode.value == value) {
			System.out.println("value " + value + " found in tree");
		} else if (value < binaryTreeNode.value) {
			search(binaryTreeNode.left, value);
		} else {
			search(binaryTreeNode.right, value);

		}

	}

}
