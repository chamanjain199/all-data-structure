package alldatastructure.queue.array.linear;

import java.util.Arrays;

public class CircularArrayQueue {
	int queueArray[];
	int top;
	int beginning;

	void createQueue(int size) {
		queueArray = new int[size];
		top = -1;
		beginning = -1;
	}

	void enQueue(int value) {

		if (isFull()) {
			System.out.println("Queue is full");
		} else {
			top = top + 1;
			if (top == queueArray.length) {
				top = 0;
			}
			queueArray[top] = value;
			if (beginning == -1) {
				beginning = 0;
			}

		}

	}

	int deQueue() {

		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		} else {

			int value = queueArray[beginning];
			if (beginning != top) {
				beginning = beginning + 1;
				if (beginning == queueArray.length) {
					beginning = 0;
				}
			} else {
				beginning = -1;
				top = -1;
			}

			return value;

		}

	}

	int peek() {

		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			return queueArray[beginning];
		}

	}

	boolean isFull() {

		return (top + 1) % (queueArray.length) == beginning;
	}

	boolean isEmpty() {
		return (beginning == -1);
	}

	void print() {
		System.out.println(Arrays.toString(queueArray));
	}
}
