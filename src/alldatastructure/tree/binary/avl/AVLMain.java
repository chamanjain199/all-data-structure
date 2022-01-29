package alldatastructure.tree.binary.avl;

public class AVLMain {

	public static void main(String[] args) {

		AVLTree avlTree = new AVLTree();

		avlTree.insert(60);
		avlTree.insert(80);
		avlTree.insert(70);
		avlTree.insert(40);
		avlTree.insert(90);
		avlTree.insert(99);
		avlTree.insert(10);
		avlTree.insert(12);

		
		System.out.println("Insertion done");
		
		avlTree.levelOrderTraversal();
		System.out.println("traversal done");

		avlTree.delete(avlTree.root, 60);
		System.out.println("delete done");


	}

}
