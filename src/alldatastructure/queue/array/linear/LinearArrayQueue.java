package alldatastructure.queue.array.linear;

public class LinearArrayQueue {
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
			queueArray[++top] = value;
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

			int value = queueArray[beginning++];
			if (beginning > top) {
				beginning = top = -1;
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
		return queueArray.length - 1 == top;
	}

	boolean isEmpty() {
		return beginning == -1;
	}

}
