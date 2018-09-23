package Personal;

import java.util.HashSet;
import java.util.Stack;

public class NonRecursiveInOrder {
	
	private static class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	static void inOrder(Node root)
	{
		if(root==null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(node!=null)
		{
			stack.push(node);
			node = node.left;
		}
		
		while(stack.size()>0)
		{
			node = stack.pop();
			System.out.print(node.data+" ");
			node = node.right;
			
			while(node!=null)
			{
				stack.push(node);
				node = node.left;
			}
		}
	}
	
	static void postOrder(Node root)
	{
		if(root==null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		
		while(node!=null)
		{
			stack.push(node);
			node = node.left;
		}
		HashSet<Node> hs = new HashSet<Node>();
		while(stack.size()>0)
		{
			node = stack.pop();
			System.out.print(node.data+" ");
			//To increase the space efficiency we can remove the element popped from the HashSet here.
			
			if(stack.size()!=0)
				node = stack.peek();
			
			if(!hs.contains(node))
			{
				hs.add(node);
				node = node.right;
			
				while(node!=null)
				{
					stack.push(node);
					node = node.left;
				}
			}

		}
	}
	
	static void preOrder(Node root)
	{
		if(root==null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(stack.size()>0)
		{
			Node node = stack.pop();
			System.out.print(node.data+" ");
			
			if(node.right!=null)
				stack.push(node.right);
			
			stack.push(node.left);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		inOrder(root);
		System.out.println();
		postOrder(root);
	}

}
