package alldatastructure.linked.list;

public class SinglyLinkedList {

	public Node head;
	public Node tail;
	public int size;

	public Node add(int value, int index) {

		Node newNode = new Node();
		newNode.value = value;

		if (index == 0 && size == 0) {
			head = newNode;
			tail = newNode;

		} else if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else if (index >= size) {
			tail.next = newNode;
			tail = newNode;
		} else if (index < size) {
			Node temp = head;
			while (index > 1) {
				temp = temp.next;
				index--;
			}
			newNode.next = temp.next;
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
			}
			size--;
		} else {
			Node node = head;
			for (int i = 0; i < location - 2; i++) {
				node = node.next;
			}
			if (location == size) {
				node.next = null;
				tail = node;
				tail.next=head;
			} else {
				Node delNode = node.next;
				Node nextNode = delNode.next;
				node.next = nextNode;
			}
			size--;
		}

	}

	

}
