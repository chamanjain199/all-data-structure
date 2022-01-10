package alldatastructure.queue.array.linear;

public class Main {

	public static void main(String[] args) {

		CircularArrayQueue laq=new CircularArrayQueue();
		laq.createQueue(5);
		laq.enQueue(1);
		laq.enQueue(2);
		laq.enQueue(3);
		laq.enQueue(4);
		laq.enQueue(5);
		
		System.out.println("Peek "+laq.peek());
		System.out.println("deQueue "+laq.deQueue());
		
		laq.enQueue(6);
		
		System.out.println("Peek "+laq.peek());
		System.out.println("deQueue "+laq.deQueue());

		System.out.println("Peek "+laq.peek());
		System.out.println("deQueue "+laq.deQueue());
		
		System.out.println("Peek "+laq.peek());
		System.out.println("deQueue "+laq.deQueue());
		
		System.out.println("Peek "+laq.peek());
		System.out.println("deQueue "+laq.deQueue());
		
		System.out.println("Peek "+laq.peek());
		System.out.println("deQueue "+laq.deQueue());
		
		System.out.println("Peek "+laq.peek());
		System.out.println("deQueue "+laq.deQueue());
		laq.enQueue(8);
		System.out.println("Peek "+laq.peek());
		System.out.println("deQueue "+laq.deQueue());
	}

}
