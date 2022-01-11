package alldatastructure.queue.array.linear;

import alldatastructure.linked.list.SinglyLinkedList;

public class LinearLLQueue {
	SinglyLinkedList sll;

	void createQueue() {
		sll = new SinglyLinkedList();
	}

	void enQueue(int value) {
		sll.add(value, sll.size);
	}

	int deQueue() {
		if (!isEmpty()) {
			int value = sll.head.value;
			sll.deletionOfNode(0);
			return value;
		} else {
			System.out.println("Queue is empty");
			return -1;
		}
	}

	int peek() {
		if (!isEmpty()) {
			return sll.head.value;
		} else {
			System.out.println("Queue is empty");
			return -1;
		}
	}

	boolean isEmpty() {
		return sll.head == null;
	}
}
