package alldatastructure.linked.list;

public class Main {

	public static void main(String[] args) {

		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.add(9, 0);
		linkedList.add(8, 0);

		linkedList.add(7, linkedList.size);
		linkedList.add(6, linkedList.size);

		linkedList.add(5, 2);
		linkedList.add(4, 2);

		System.out.println(linkedList);
		linkedList.traverse();
		System.out.println(linkedList.searchNode(3));
		linkedList.deletionOfNode(0);
		System.out.println(linkedList);

		
		linkedList.deletionOfNode(linkedList.size);
		System.out.println(linkedList);
		
		linkedList.deletionOfNode(2);
		System.out.println(linkedList);
		
	}

}
