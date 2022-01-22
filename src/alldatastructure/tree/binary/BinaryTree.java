package alldatastructure.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	BinaryTreeNode root;

	BinaryTree() {
		root = null;
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
		queue.add(binaryTreeNode);
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

	public void search(BinaryTreeNode binaryTreeNode, String value) {

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(binaryTreeNode);
		while (!queue.isEmpty()) {
			BinaryTreeNode presentNode = queue.remove();
			if (presentNode.value.equals(value)) {
				System.out.println("The value " + value + " found in the Tree");
				return;
			}
			
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
		System.out.println("The value " + value + " not found in the Tree");


	}
}