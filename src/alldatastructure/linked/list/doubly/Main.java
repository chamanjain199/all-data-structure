package alldatastructure.linked.list.doubly;


public class Main {

	public static void main(String[] args) {
		CircularDoublyLinkedList linkedList = new CircularDoublyLinkedList();
		linkedList.add(1, 0);
		linkedList.add(2, 0);
		linkedList.add(3, 0);

		linkedList.traverse();

		linkedList.deletionOfNode(2);
		linkedList.traverse();

		
		
//		linkedList.add(9, 0);
//		linkedList.add(8, 1);
//		linkedList.deletionOfNode(1);
//
//		linkedList.add(6, 2);
//
//		linkedList.add(7, 3);
//
//		linkedList.add(4, 2);
//
//
//		linkedList.traverse();
//		//linkedList.reverseTraverse();
//
//		
//		linkedList.add(7, linkedList.size);
//		linkedList.add(6, linkedList.size);
//
//		linkedList.add(5, 2);
//		linkedList.add(4, 2);
//
//		linkedList.traverse();
//		//linkedList.reverseTraverse();
//
//		System.out.println(linkedList.searchNode(4));
//		linkedList.deletionOfNode(0);
//		linkedList.traverse();
//		//linkedList.reverseTraverse();
//
//
//		linkedList.deletionOfNode(linkedList.size);
//		linkedList.traverse();
//		//linkedList.reverseTraverse();
//
//
//		linkedList.deletionOfNode(2);
//		linkedList.traverse();
//		//linkedList.reverseTraverse();


	}

}
