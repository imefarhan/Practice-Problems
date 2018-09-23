package Personal;

import java.util.ArrayList;
import java.util.Stack;

public class StackTopple {
	
	static Stack<Integer> stack;
	static ArrayList<Stack> stacks;
	static int capacity;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack = new Stack<Integer>();
		stacks =  new ArrayList<Stack>();
		capacity = 5;
		
//		pushIn(data);
		
	}
	
	static void pushIn(int data)
	{
		Stack st = getLastStack();
		if(st.size()>capacity)
		{
			stacks.add(new Stack<Integer>());
			st = getLastStack();
		}
		st.push(data);
	}

	private static Stack getLastStack() {
		// TODO Auto-generated method stub
		
		return (stacks.get(stacks.size()-1)) ;
	}

}
