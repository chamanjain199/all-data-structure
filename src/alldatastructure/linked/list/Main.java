package alldatastructure.linked.list;

public class Main {

	public static void main(String[] args) {

		CircularSinglyLinkedList linkedList = new CircularSinglyLinkedList();
		linkedList.add(9, 0);
		linkedList.add(8, 1);
		linkedList.add(6, 2);
		linkedList.add(7, 3);
		linkedList.add(1, 2);


		linkedList.traverse();
		linkedList.add(7, linkedList.size);
		linkedList.add(6, linkedList.size);

		linkedList.add(5, 2);
		linkedList.add(4, 2);

		linkedList.traverse();
		System.out.println(linkedList.searchNode(3));
		linkedList.deletionOfNode(0);
		linkedList.traverse();

		linkedList.deletionOfNode(linkedList.size);
		linkedList.traverse();

		linkedList.deletionOfNode(2);
		linkedList.traverse();

	}

}
