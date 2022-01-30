package alldatastructure.tree.binary.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
	TreeNode root;

	public AVLTree() {
		root = null;
	}

	private int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private int getBalancedHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);

	}

	private TreeNode rotateRight(TreeNode distortedNode) {
		TreeNode newNode = distortedNode.left;
		distortedNode.left = distortedNode.left.right;
		newNode.right = distortedNode;
		distortedNode.height = 1 + Math.max(getHeight(distortedNode.left), getHeight(distortedNode.right));
		newNode.height = 1 + Math.max(getHeight(newNode.left), getHeight(newNode.right));
		return newNode;

	}

	private TreeNode rotateLeft(TreeNode distortedNode) {

		TreeNode newNode = distortedNode.right;
		distortedNode.right = distortedNode.right.left;
		newNode.left = distortedNode;
		distortedNode.height = 1 + Math.max(getHeight(distortedNode.left), getHeight(distortedNode.right));
		newNode.height = 1 + Math.max(getHeight(newNode.left), getHeight(newNode.right));
		return newNode;

	}

	private TreeNode insert(TreeNode node, int value) {

		if (node == null) {
			node = new TreeNode();
			node.value = value;
			node.height = 1;
			return node;
		} else if (value < node.value) {
			node.left = insert(node.left, value);
		} else if (value > node.value) {
			node.right = insert(node.right, value);
		}
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		int balance = getBalancedHeight(node);

		if (balance > 1 && getBalancedHeight(node.left) >= 0) {
			return rotateRight(node);
		} else if (balance > 1 && getBalancedHeight(node.left) < 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		} else if (balance < -1 && getBalancedHeight(node.right) <= 0) {
			return rotateLeft(node);
		} else if (balance < -1 && getBalancedHeight(node.right) > 0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}

		return node;
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	private TreeNode minimunNode(TreeNode node) {
		if (node.left == null) {
			return node;
		} else {
			return minimunNode(node.left);
		}

	}

	public TreeNode deleteNode(TreeNode node, int value) {

		if (node == null) {
			node = new TreeNode();
			node.value = value;
			node.height = 1;
			return node;
		} else if (value < node.value) {
			node.left = deleteNode(node.left, value);
		} else if (value > node.value) {
			node.right = deleteNode(node.right, value);
		} else if (value == node.value) {
			if (node.left != null && node.right != null) {
				TreeNode minimumNode = minimunNode(node.right);
				node.value = minimumNode.value;
				node.right = deleteNode(node.right, minimumNode.value);
			} else if (node.left != null) {
				node = node.left;
			} else if (node.right != null) {
				node = node.right;
			} else {
				node = null;
			}

		}

		int balance = getBalancedHeight(node);
		if (balance > 1 && getBalancedHeight(node.left) >= 0) {
			return rotateRight(node);
		} else if (balance > 1 && getBalancedHeight(node.left) < 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		} else if (balance < -1 && getBalancedHeight(node.right) <= 0) {
			return rotateLeft(node);
		} else if (balance < -1 && getBalancedHeight(node.right) > 0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}

		return node;
	}

	public void levelOrder() {

		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			TreeNode currentNode = queue.remove();
			System.out.print(currentNode.value + " ");
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}

	}

}
