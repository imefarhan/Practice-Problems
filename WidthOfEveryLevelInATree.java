package Personal;

import java.util.HashMap;
import java.util.Map;

import Personal.RemoveBSTNodesOutsideGivenRange.Node;

public class WidthOfEveryLevelInATree {
	
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

		root = new Node(6);
		root.left = new Node(-13);
		root.left.right = new Node(-8);
		root.right = new Node(14);
		root.right.left = new Node(13);
		root.right.right = new Node(15);
		root.right.left.left = new Node(7);
		
		findWidths(root,0,1);
		
		for(Map.Entry m : hm.entrySet())
		{
			System.out.println("Level "+m.getKey()+" : Width = "+m.getValue());
		}

	}
	
	//A hashmap to store the width of each level
	static HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	
//col has no use here, intially thought it would be useful.
//can be used to calculate the height of every vertical branch.	
	
private static void findWidths(Node node,int col,int level) {

	if(node==null)
		return;
	
	if(hm.containsKey(level))
		hm.put(level, Math.abs(hm.get(level)+1));
	else
		hm.put(level, 1);
	
	findWidths(node.left,col-1,level+1);
	
	findWidths(node.right,col+1,level+1);

		
	}

private static void inOrder(Node node) {
		
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}

}
