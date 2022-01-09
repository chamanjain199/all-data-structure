package alldatastructure.linked.list.doubly;

public class DoublyLinkedList {

	public Node head;
	public Node tail;
	public int size;

	public Node add(int value, int index) {

		Node newNode = new Node();
		newNode.value = value;

		if (head == null || (index == 0 && size == 0)) {
			head = newNode;
			tail = newNode;

		} else if (index == 0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;

		} else if (index >= size) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		} else if (index < size) {
			Node temp = head;
			while (index > 1) {
				temp = temp.next;
				index--;
			}

			newNode.next = temp.next;
			temp.next.prev = newNode;
			newNode.prev = temp;
			temp.next = newNode;
		}

		size++;

		return head;
	}

	public void traverse() {
		Node node = head;
		System.out.print("[");

		for (int i = 0; i < size; i++) {
			System.out.print(node.value);

			node = node.next;
			if (i != size - 1)
				System.out.print(",");
		}

		System.out.print("]");
		System.out.println();

	}

	public void reverseTraverse() {
		Node node = tail;
		System.out.print("[");

		for (int i = 0; i < size; i++) {
			System.out.print(node.value);

			node = node.prev;
			if (i != size - 1)
				System.out.print(",");
		}

		System.out.print("]");
		System.out.println();

	}

	boolean searchNode(int value) {
		Node node = head;

		for (int i = 0; i < size; i++) {
			if (node.value == value) {
				return true;
			}
			node = node.next;

		}
		return false;
	}

	public void deletionOfNode(int location) {

		if (head == null) {
			System.out.println("No Element in SLL");
		}
		if (location == 0) {
			if (size == 1) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				head.prev = null;

			}
			size--;
		} else if (location >= size-1) {

			tail.prev.next = null;
			tail = tail.prev;
			size--;
		} else {
			Node node = head;
			for (int i = 0; i < location - 1; i++) {
				node = node.next;
			}

			node.next = node.next.next;
			if (node.next != null)
				node.next.prev = node;

			size--;
		}

	}

}
