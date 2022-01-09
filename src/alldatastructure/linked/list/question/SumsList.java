package alldatastructure.linked.list.question;

import alldatastructure.linked.list.Node;
import alldatastructure.linked.list.SinglyLinkedList;

public class SumsList {

	public static void main(String[] args) {
		SinglyLinkedList ssl1 = new SinglyLinkedList();
		ssl1.add(7, 0);
		ssl1.add(1, 1);
		ssl1.add(6, 2);
		SinglyLinkedList ssl2 = new SinglyLinkedList();
		ssl2.add(5, 0);
		ssl2.add(9, 1);
		ssl2.add(2, 2);
		ssl1.traverse();
		ssl2.traverse();

		Node node1 = ssl1.head;
		Node node2 = ssl2.head;
		SinglyLinkedList ssl3 = new SinglyLinkedList();

		int carry=0;
		for (int i = 0; i < ssl1.size; i++) {
			int sum=carry+node1.value+node2.value;
			carry=sum/10;

			ssl3.add(sum%10, ssl3.size);
			node1=node1.next;
			node2=node2.next;
		}
		ssl3.traverse();
	}
}
