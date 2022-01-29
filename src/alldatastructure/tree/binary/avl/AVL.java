package alldatastructure.tree.binary.avl;
import java.util.LinkedList;
import java.util.Queue;

public class AVL {
	TreeNode root;

	// Constructor
	AVL() {
		root = null;
	}

  // PreOrder Traversal
  public void preOrder(TreeNode node) {
   if (node == null) {
     return;
   }
   System.out.print(node.value + " ");
   preOrder(node.left);
   preOrder(node.right);
 }

 // Inorder Traversal
 public void inOrder(TreeNode node) {
   if (node == null) {
     return;
   }
   inOrder(node.left);
   System.out.print(node.value + " ");
   inOrder(node.right);


 }

 // PostOrder Traversal
 public void postOrder(TreeNode node) {
   if (node == null) {
     return;
   }
   postOrder(node.left);
   postOrder(node.right);
   System.out.print(node.value + " ");
 }

 // Level Order

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

 // Search Method
 TreeNode search(TreeNode node, int value) {
   if (node == null ) {
     System.out.println("Value: "+ value+ " not found in AVL");
     return null;
   } else if (node.value == value) {
     System.out.println("Value: "+ value+ " found in AVL");
     return node;
   } else if (value < node.value) {
     return search(node.left, value);
   } else {
     return search(node.right, value);
   }
 }

//  getHeight
  public int getHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  // rotateRight
  private TreeNode rotateRight(TreeNode disbalancedNode) {
    TreeNode newRoot = disbalancedNode.left;
    disbalancedNode.left = disbalancedNode.left.right;
    newRoot.right = disbalancedNode;
    disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
    newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
    return newRoot;
  }

  // rotateLeft
  private TreeNode rotateLeft(TreeNode disbalancedNode) {
    TreeNode newRoot = disbalancedNode.right;
    disbalancedNode.right = disbalancedNode.right.left;
    newRoot.left = disbalancedNode;
    disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
    newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
    return newRoot;
  }

  // getBalance
  public int getBalance(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return getHeight(node.left) - getHeight(node.right);
  }

  // insertNode Method
  private TreeNode insertNode(TreeNode node, int nodeValue) {
    if (node == null) {
      TreeNode newNode = new TreeNode();
      newNode.value = nodeValue;
      newNode.height = 1;
      return newNode;
    } else if (nodeValue < node.value) {
      node.left = insertNode(node.left, nodeValue);
    } else {
      node.right = insertNode(node.right, nodeValue);
    }

    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    int balance = getBalance(node);

    if (balance > 1 && nodeValue < node.left.value) {
      return rotateRight(node);
    }

    if (balance > 1 && nodeValue > node.left.value) {
      node.left = rotateLeft(node.left);
      return rotateRight(node);
    }

    if (balance < -1 && nodeValue > node.right.value) {
      return rotateLeft(node);
    }

    if (balance < - 1 && nodeValue < node.right.value) {
      node.right = rotateRight(node.right);
      return rotateLeft(node);
    }

    return node;

  }

  public void insert(int value) {
    root = insertNode(root, value);
  }

  // // Minimum node
  public static TreeNode minimumNode(TreeNode root) {
    if (root.left == null) {
      return root;
    } else {
      return minimumNode(root.left);
    }
  }

  // Delete node
 public TreeNode deleteNode(TreeNode node, int value) {
   if (node == null) {
     System.out.println("Value not found in AVL");
     return node;
   }
   if (value < node.value) {
     node.left = deleteNode(node.left, value);
   } else if (value > node.value) {
     node.right = deleteNode(node.right, value);
   } else {
     if (node.left != null && node.right != null) {
       TreeNode temp = node;
       TreeNode minNodeForRight = minimumNode(temp.right);
       node.value = minNodeForRight.value;
       node.right = deleteNode(node.right, minNodeForRight.value);
     } else if (node.left != null) {
       node = node.left;
     } else if (node.right != null) {
       node = node.right;
     } else {
       node = null;
     }
   }
   // Case 2 - rotation required

   // System.out.println("1");
   // System.out.println(previous.value);

   // node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
   int balance = getBalance(node);

   if (balance > 1 && getBalance(node.left) >= 0) {
     return rotateRight(node);
   }
   if (balance > 1 && getBalance(node.left) < 0) {
     node.left = rotateLeft(node.left);
     return rotateRight(node);
   }
   if (balance < -1 && getBalance(node.right) <= 0) {
     return rotateLeft(node);
   }

   if (balance < -1 && getBalance(node.right) > 0) {
     node.right = rotateRight(node.right);
     return rotateLeft(node);
   }

   return node;

 }

 public void delete(int value) {
   root = deleteNode(root, value);
 }

 public void deleteAVL() {
   root = null;
 }


}
