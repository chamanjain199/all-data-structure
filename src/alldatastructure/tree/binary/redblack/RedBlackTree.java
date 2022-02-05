package alldatastructure.tree.binary.redblack;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree {

	TreeNode root;

	public RedBlackTree() {
		root = null;

	}

	void levelOrder() {
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
	}

	public TreeNode insert(TreeNode node, TreeNode parent, int value) {

		if (node.parent != null && node.parent.color == Color.RED) {
			TreeNode nodesGrandParent = node.parent.parent;
			TreeNode nodesParent = node.parent;

			if (nodesGrandParent == null) {
				TreeNode nodeValue = node;
				node = parent;
				parent = nodeValue;

				return node;
			}

			if (nodesParent.value < nodesGrandParent.value) {

				if (nodesGrandParent.right == null || nodesGrandParent.right.color == Color.BLACK) {

					if (node.value < parent.value) {

						TreeNode newNode = nodesGrandParent.left;
						nodesGrandParent.left = nodesGrandParent.left.right;
						newNode.right = nodesGrandParent;
						newNode.color = Color.BLACK;
						newNode.right.color = Color.RED;
						node = newNode;

					} else {
						TreeNode nodeValue = node;
						node = parent;
						parent = nodeValue;

					}
					if (node.value > parent.value) {
						TreeNode newNode = nodesGrandParent.left;
						nodesGrandParent.left = nodesGrandParent.left.right;
						newNode.right = nodesGrandParent;
						newNode.color = Color.BLACK;
						newNode.right.color = Color.RED;
						node = newNode;

					}

				} else {
					nodesGrandParent.right.color = Color.BLACK;
					nodesGrandParent.left.color = Color.BLACK;
					nodesGrandParent.color = nodesGrandParent == root ? Color.BLACK : Color.RED;
				}

			} else {
				if (nodesGrandParent.left == null || nodesGrandParent.right.color == Color.BLACK) {

					if (node.value > parent.value) {
						TreeNode newNode = nodesGrandParent.right;
						nodesGrandParent.right = nodesGrandParent.right.left;
						newNode.left = nodesGrandParent;
						newNode.color = Color.BLACK;
						newNode.left.color = Color.RED;
						node = newNode;
					} else {
						TreeNode nodeValue = node;
						node = parent;
						parent = nodeValue;
					}

					if (node.value < parent.value) {
						TreeNode newNode = nodesGrandParent.right;
						nodesGrandParent.right = nodesGrandParent.right.left;
						newNode.left = nodesGrandParent;
						newNode.color = Color.BLACK;
						newNode.left.color = Color.RED;
						node = newNode;
					}
				} else {

					nodesGrandParent.right.color = Color.BLACK;
					nodesGrandParent.left.color = Color.BLACK;
					nodesGrandParent.color = nodesGrandParent == root ? Color.BLACK : Color.RED;
				}

			}
		}

		return node;
	}

	public void insert(int value) {

		TreeNode newNode = new TreeNode();
		newNode.value = value;
		newNode.color = Color.RED;
		TreeNode tempHoldingNode = root;
		TreeNode tempHoldingNodeParent = root;

		if (tempHoldingNode == null) {
			root = newNode;
			root.color = Color.BLACK;
			return;
		}

		while (tempHoldingNode != null) {
			tempHoldingNodeParent = tempHoldingNode;
			if (value < tempHoldingNode.value) {
				tempHoldingNode = tempHoldingNode.left;
			} else {
				tempHoldingNode = tempHoldingNode.right;
			}
		}

		if (value < tempHoldingNodeParent.value) {
			tempHoldingNodeParent.left = newNode;
		} else {
			tempHoldingNodeParent.right = newNode;
		}
		newNode.parent = tempHoldingNodeParent;

		if (newNode.parent == null || newNode.parent.parent == null) {
			return;
		}
		fixInsert(newNode);

	}

	private void rotateRight(TreeNode node) {
		TreeNode child = node.left;
		TreeNode grandParent = node.parent;
		node.left = child.right;
		child.right = node;
		node.parent = child;
		child.parent = grandParent;

		if (grandParent != null) {

			if (grandParent.left.value == node.value) {
				grandParent.left = child;
			} else {
				grandParent.right = child;
			}

		} else {
			root = child;
		}

	}

	private void rotateLeft(TreeNode node) {
		TreeNode child = node.right;
		TreeNode grandParent = node.parent;

		node.right = child.left;
		child.left = node;
		node.parent = child;

		child.parent = grandParent;

		if (grandParent != null) {

			if (grandParent.left.value == node.value) {
				grandParent.left = child;
			} else {
				grandParent.right = child;
			}

		} else {
			root = child;
		}

	}

	private void fixInsert(TreeNode newNode) {
		TreeNode tempNode = newNode;
		while (tempNode.parent != null && tempNode.parent.color == Color.RED) {

			TreeNode parent = tempNode.parent;
			TreeNode grandParent = parent.parent;
			TreeNode uncle = null;

			if (parent.value < grandParent.value) {
				uncle = grandParent.right;

				if (uncle != null && uncle.color == Color.RED) {
					parent.color = Color.BLACK;
					if (grandParent != root)
						grandParent.color = Color.RED;
					uncle.color = Color.BLACK;

				} else {

					if (tempNode.value < parent.value) {
						tempNode.parent.color = Color.BLACK;
						grandParent.color = Color.RED;

						rotateRight(grandParent);

					} else {
						rotateLeft(parent);
					}

				}

			} else {

				uncle = grandParent.left;
				if (uncle != null && uncle.color == Color.RED) {
					parent.color = Color.BLACK;
					if (grandParent != root)
						grandParent.color = Color.RED;
					uncle.color = Color.BLACK;

				} else {
					if (tempNode.value > parent.value) {
						tempNode.parent.color = Color.BLACK;
						grandParent.color = Color.RED;
						rotateLeft(grandParent);

					} else {
						rotateRight(parent);
					}
				}
			}
			if (tempNode.parent.color != Color.RED) {
				tempNode = tempNode.parent;
			}

		}

	}

}
