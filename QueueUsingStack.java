package Personal;

import java.util.Stack;

public class QueueUsingStack {
	static Stack<Integer> stack;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(lastOutFirst());
		System.out.println(lastOutFirst());

	}

	private static int lastOutFirst() {
		// TODO Auto-generated method stub
		Stack<Integer> temp = new Stack<Integer>();
		
		while(!stack.isEmpty())
			temp.push(stack.pop());
		
		int res = temp.pop();
		
		while(!temp.isEmpty())
			stack.push(temp.pop());
		
		return res;
		
	}

}
