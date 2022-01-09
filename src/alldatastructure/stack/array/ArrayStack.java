package alldatastructure.stack.array;

import java.util.Arrays;

public class ArrayStack {

	private int arrayStack[];
	private int size;
	private int currentElement;

	public void createStack(int size) {
		this.size = size;
		currentElement=-1;
		arrayStack = new int[size];
	}

	public void push(int element) {

		if (!isFull()) {
			arrayStack[++currentElement] = element;
		} else {
			throw new RuntimeException("Stack is Full");

		}
	}

	public int pop() {
		if (!isEmpty()) {
			int element = arrayStack[currentElement];
			arrayStack[currentElement] = 0;
			--currentElement;
			return element;
		} else {
			throw new RuntimeException("Stack is Empty");
		}
	}

	public int peek() {
		if (!isEmpty()) {

			int element = arrayStack[currentElement];
			return element;
		} else {
			throw new RuntimeException("Stack is Empty");
		}
	}

	public boolean isFull() {

		return size - 1 == currentElement;
	}

	public boolean isEmpty() {

		return currentElement == -1;
	}

	void print() {

		System.out.println(Arrays.toString(arrayStack));
	}

}
