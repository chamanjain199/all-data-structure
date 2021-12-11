package alldatastructure.linked.list;

public class SinglyLinkedList {

	public Node head;
	public Node tail;
	public int size;

	public Node add(int value) {

		Node newNode = new Node();
		newNode.value = value;

		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {

			tail.next = newNode;
			tail = newNode;

		}

		size++;

		return head;
	}

}
