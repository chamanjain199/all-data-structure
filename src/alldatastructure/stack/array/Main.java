package alldatastructure.stack.array;

public class Main {

	public static void main(String[] args) {

		//ArrayStack as=new ArrayStack();
		LinkedListStack as=new LinkedListStack();
		//as.createStack(5);
		as.createStack();
		as.push(1);
		as.push(2);
		as.push(3);
		as.push(4);
		as.push(5);
		as.print();
		//as.push(6);

		System.out.println("Peek  "+as.peek());
		System.out.println("Pop  "+as.pop());
		System.out.println("Peek  "+as.peek());
		System.out.println("Pop  "+as.pop());
		System.out.println("Peek  "+as.peek());
		System.out.println("Pop  "+as.pop());
		System.out.println("Peek  "+as.peek());
		System.out.println("Pop  "+as.pop());	
		System.out.println("Peek  "+as.peek());
		System.out.println("Pop  "+as.pop());
		//System.out.println("Peek  "+as.peek());
		//System.out.println("Pop  "+as.pop());

	}

}
