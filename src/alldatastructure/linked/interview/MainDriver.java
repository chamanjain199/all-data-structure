package alldatastructure.linked.interview;

public class MainDriver {

	public static void main(String[] args) {

		StackMin sm=new StackMin();
		sm.push(8);
		sm.push(9);
		sm.push(2);
		sm.push(3);
		sm.push(0);
		sm.push(4);
		sm.push(5);
		sm.push(0);

		System.out.print(sm.min);
		System.out.println(sm.min());
		sm.pop();
		System.out.println(sm.min());
		
		sm.pop();
		System.out.println(sm.min());
		sm.pop();
		System.out.println(sm.min());
		sm.pop();
		System.out.println(sm.min());
		sm.pop();
		System.out.println(sm.min());
		sm.pop();
		System.out.println(sm.min());
		sm.pop();
		System.out.println(sm.min());

	}

}
