package alldatastructure.linked.list;

public class Node {
	public int value;
	public Node next;

	@Override
	public String toString() {
		if (next != null)
			return value + "," + next;
		else
			return value+"";
	}

}
