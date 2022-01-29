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

	private int getBalancedHeight(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}
		return getHeight(treeNode.left) - getHeight(treeNode.right);

	}

	private TreeNode rightRotation(TreeNode distortedNode) {
		TreeNode newNode = distortedNode.left;
		distortedNode.left = distortedNode.left.right;
		newNode.right = distortedNode;
		distortedNode.height = 1 + Math.max(getHeight(distortedNode.left), getHeight(distortedNode.right));
		newNode.height = 1 + Math.max(getHeight(newNode.left), getHeight(newNode.right));
		return newNode;

	}

	private TreeNode leftRotation(TreeNode distortedNode) {
		TreeNode newNode = distortedNode.right;
		distortedNode.right = distortedNode.right.left;
		newNode.left = distortedNode;
		distortedNode.height = 1 + Math.max(getHeight(distortedNode.left), getHeight(distortedNode.right));
		newNode.height = 1 + Math.max(getHeight(newNode.left), getHeight(newNode.right));
		return newNode;

	}

	private TreeNode insert(TreeNode tempNode, int value) {

		if (tempNode == null) {
			tempNode = new TreeNode();
			tempNode.value = value;
			tempNode.height = 1;
			return tempNode;
		} else if (value < tempNode.value) {
			tempNode.left = insert(tempNode.left, value);

		} else {
			tempNode.right = insert(tempNode.right, value);
		}

		tempNode.height = 1 + Math.max(getHeight(tempNode.left), getHeight(tempNode.right));
		int balance = getBalancedHeight(tempNode);
		if (balance > 1 && value < tempNode.left.value) {
			tempNode = rightRotation(tempNode);
		}
		if (balance > 1 && value > tempNode.left.value) {
			tempNode.left=leftRotation(tempNode.left);

			tempNode = rightRotation(tempNode);
		}
		if (balance < -1 && value > tempNode.right.value) {
			tempNode = leftRotation(tempNode);
		}
		if (balance < -1 && value < tempNode.right.value) {
			tempNode.right=rightRotation(tempNode.right);
			tempNode = leftRotation(tempNode);
		}

		return tempNode;
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	private TreeNode findMinimum(TreeNode node) {
		if (node.left == null) {
			return node;
		} else {
			return findMinimum(node.left);
		}

	}

	public TreeNode delete(TreeNode tempNode, int value) {

		if (tempNode == null) {
			System.out.println("Value " + value + " Not found");
			return tempNode;
		} else if (value == tempNode.value) {
			if (tempNode.left != null && tempNode.right != null) {
				TreeNode temp = tempNode;

				TreeNode minimumRightNode = findMinimum(temp.right);
				tempNode.value = minimumRightNode.value;
				tempNode.right = delete(tempNode.right, minimumRightNode.value);

			} else if (tempNode.left != null) {
				tempNode = tempNode.left;
			} else if (tempNode.right != null) {
				tempNode = tempNode.right;
			} else {
				tempNode = null;
			}
		} else if (value < tempNode.value) {
			tempNode.left = delete(tempNode.left, value);

		} else if (value > tempNode.value) {
			tempNode.right = delete(tempNode.right, value);
		}
		int balance = getBalancedHeight(tempNode);

		if (balance > 1 && getBalancedHeight(tempNode.left) >= 0) {
			System.out.println("Right rotate "+tempNode.value+" => "+tempNode.left.value);

			return rightRotation(tempNode);
		}
		if (balance > 1 && getBalancedHeight(tempNode.left) < 0) {
			System.out.println("RL Right rotate "+tempNode.left.value+" => "+tempNode.left.value);
			System.out.println("RL Left rotate "+tempNode.value+" => "+tempNode.value);

			tempNode.left = leftRotation(tempNode.left);

			return rightRotation(tempNode);
		}
		if (balance < -1 && getBalancedHeight(tempNode.right) <= 0) {
			System.out.println("L");
			return leftRotation(tempNode);
		}
		if (balance < -1 && getBalancedHeight(tempNode.right) > 0) {
			System.out.println("RL");
			tempNode.right = rightRotation(tempNode.right);
			return leftRotation(tempNode);
		}

		return tempNode;

	}

	public void levelOrderTraversal() {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode presentNode = queue.remove();
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
}
