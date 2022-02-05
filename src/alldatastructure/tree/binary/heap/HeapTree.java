package alldatastructure.tree.binary.heap;

public class HeapTree {

	int heapTree[];
	String type;
	int size = 0;

	public HeapTree(int size, String type) {

		heapTree = new int[size + 1];
		this.type = type;
		size = 1;
	}

	public boolean isFull() {
		return size == heapTree.length-1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(int value) {
		if (!isFull()) {
			heapTree[++size] = value;
			heapifyBottomToTop(size,type);

		} else {
			System.out.println("Tree is Full");
		}
	}

	public void delete(int value) {
		if (!isEmpty()) {
			int lastEl = heapTree[size--];
			heapTree[size] = 0;
			heapTree[1] = lastEl;
			heapifyTopToBottom(size, type);

		} else {
			System.out.println("Tree is empty");
		}
	}

	private void swap(int parent, int index) {
		int temp = heapTree[index];
		heapTree[index] = heapTree[parent];
		heapTree[parent] = temp;
	}

	private void heapifyBottomToTop(int index, String type) {

		int parent = index / 2;
		if (parent < 1) {
			return;
		}

		if (heapTree[index] < heapTree[parent] & type.equals("Min")) {
			swap(parent, index);
		} else if (heapTree[index] > heapTree[parent] & type.equals("Max")) {
			swap(parent, index);
		}
		heapifyBottomToTop(parent, type);

	}

	private void heapifyTopToBottom(int index, String type) {

		int left = index * 2;
		int right = index * 2 + 1;
		int swapedIndex = 1;
		if (left > size) {
			return;
		}
		if (type == "Max") {
			if (heapTree[left] == size && heapTree[left] > heapTree[index]) {

				swapedIndex = left;
				swap(index, left);
			} else if (heapTree[left] > heapTree[index] && heapTree[left] > heapTree[right]) {
				swapedIndex = left;
				swap(index, left);
			} else if (heapTree[right] > heapTree[index] && heapTree[right] > heapTree[left]) {
				swapedIndex = right;
				swap(index, right);

			}
		} else if (type == "Min") {
			if (heapTree[left] == size && heapTree[left] < heapTree[index]) {

				swapedIndex = left;
				swap(index, left);
			} else if (heapTree[left] < heapTree[index] && heapTree[left] < heapTree[right]) {
				swapedIndex = left;
				swap(index, left);
			} else if (heapTree[right] < heapTree[index] && heapTree[right] < heapTree[left]) {
				swapedIndex = right;
				swap(index, right);

			}
		}

		heapifyTopToBottom(swapedIndex, type);

	}

	public void traverse() {
		for (int i = 1; i <=size; i++) {
			System.out.print(heapTree[i] + " ");

		}
		System.out.println();
	}

}
