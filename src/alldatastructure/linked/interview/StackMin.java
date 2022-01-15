package alldatastructure.linked.interview;

class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
		super();
		this.value = value;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", next=" + next + "]";
	}

}

public class StackMin {
	Node top;
	Node min;

	public int min() {
		return min.value;
	}

	public void push(int value) {
		if (min == null || min.value > value) {
			min = new Node(value, min);
		} else {
			min = new Node(min.value, min);
		}
		top = new Node(value, top);
	}

	public int pop() {
		int result = top.value;
		min = min.next;

		top = top.next;
		return result;
	}

}
