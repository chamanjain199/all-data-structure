package alldatastructure.tree.binary.heap;

public class HeapMain {

	public static void main(String[] args) {

		HeapTree heapTree = new HeapTree(6, "Max");
		heapTree.insert(41);
		heapTree.insert(30);
		heapTree.insert(20);
		heapTree.insert(50);
		heapTree.insert(40);
		

		
		heapTree.traverse();

	}

}
