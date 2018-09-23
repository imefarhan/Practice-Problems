package Personal;

import java.util.Stack;

//https://www.geeksforgeeks.org/zigzag-tree-traversal/

import Personal.WidthOfEveryLevelInATree.Node;

	public class ZigZagTraversalInATree {
	
		static Node root;
	
		static class Node
		{
			int data;
			Node left;
			Node right;
		
			Node(int val)
			{
				data = val;
				left = null;
				right = null;
			}
		}

		
		
	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);

		zigzagTraversal(root);
		
	}
	
	private static void zigzagTraversal(Node node)
	{
		
		boolean leftToRight = true;
		
		Stack<Node> currentLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		
		currentLevel.push(node);
		
		while(!currentLevel.isEmpty())
		{
			
			Node temp = currentLevel.pop();
			System.out.print(temp.data+" ");
		
		if(leftToRight)
		{
			if(temp.left!=null)
				nextLevel.push(temp.left);
			if(temp.right!=null)
				nextLevel.push(temp.right);
		}
		else
		{
			if(temp.right!=null)
				nextLevel.push(temp.right);
			if(temp.left!=null)
				nextLevel.push(temp.left);
		}
		
		if(currentLevel.isEmpty())
		{
			leftToRight = !leftToRight;
			Stack<Node> tempp = currentLevel;
			currentLevel = nextLevel;
			nextLevel = tempp;
		}
		
		}
		
	}

}
