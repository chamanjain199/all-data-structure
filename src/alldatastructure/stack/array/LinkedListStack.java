package alldatastructure.stack.array;

import alldatastructure.linked.list.SinglyLinkedList;

public class LinkedListStack {

	private SinglyLinkedList linkedListStack;

	public void createStack() {
		linkedListStack = new SinglyLinkedList();
	}

	public void push(int element) {

		linkedListStack.add(element, 0);

	}

	public int pop() {
		if (!isEmpty()) {
			int element = linkedListStack.head.value;
			linkedListStack.deletionOfNode(0);
			return element;
		} else {
			throw new RuntimeException("Stack is Empty");
		}
	}

	public int peek() {
		if (!isEmpty()) {

			return linkedListStack.head.value;
		} else {
			throw new RuntimeException("Stack is Empty");
		}
	}

	public boolean isEmpty() {

		return linkedListStack.head == null;
	}

	void print() {

		linkedListStack.traverse();
	}

}
