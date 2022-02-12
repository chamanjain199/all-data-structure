package alldatastructure.tree.binary.search;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class BinarySearchTree {
	BinaryTreeNode root;

	BinarySearchTree() {
		root = null;
	}

	private BinaryTreeNode insert(BinaryTreeNode currentNode, int value) {
		if (currentNode == null) {
			BinaryTreeNode newNode = new BinaryTreeNode();
			newNode.value = value;
			return newNode;
		} else if (value <= currentNode.value) {
			currentNode.left = insert(currentNode.left, value);
			return currentNode;
		} else {
			currentNode.right = insert(currentNode.right, value);
			return currentNode;
  
		}

	}

	public void insert(int value) {
		root = insert(root, value);

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

	public void levelOrderTraversal() {

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
		System.out.println();

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

	public static BinaryTreeNode findSmallestNode(BinaryTreeNode binaryTreeNode) {

		if (binaryTreeNode.left == null) {
			return binaryTreeNode;
		} else {
			return findSmallestNode(binaryTreeNode.left);
		}

	}

	public BinaryTreeNode deleteNode(BinaryTreeNode root, int value) {

		if (root == null) {
			System.out.println("Not found");
			return null;
		} else if (value < root.value) {
			root.left = deleteNode(root.left, value);
		} else if (value > root.value) {
			root.right = deleteNode(root.right, value);
		} else {
			if (root.left != null && root.right != null) {
				BinaryTreeNode temp = root;
				BinaryTreeNode minimumNode = findSmallestNode(temp);
				minimumNode = deleteNode(minimumNode, minimumNode.value);
				temp.value = minimumNode.value;
			} else if (root.left != null) {
				root.left = null;
			} else if (root.right != null) {
				root.right = null;
			} else {
				root = null;
			}
		}
		return root;
	}

}
