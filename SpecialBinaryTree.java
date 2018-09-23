package Personal;

import Personal.WidthOfEveryLevelInATree.Node;

//https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/

public class SpecialBinaryTree {
	
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

		int inorder[] = {5, 10, 40, 30, 28};
		
		root = constructSpecialBinaryTree(inorder,0,inorder.length-1);
		
		inOrder(root);

	}

	private static Node constructSpecialBinaryTree(int[] inorder, int i, int j) {

		int x = findMaxIndex(inorder,i,j);
		
		if(x==-1)
			return null;
		else
		{
		Node temp = new Node(inorder[x]);
		temp.left = constructSpecialBinaryTree(inorder, i, x-1);
		temp.right = constructSpecialBinaryTree(inorder, x+1, j);
		
		return temp;
		}
		
	}

	private static int findMaxIndex(int[] inorder, int start, int end) {

		int max = Integer.MIN_VALUE, index = -1;

		for(int i=start; i<=end; i++)
		{
			if(inorder[i]>max)
			{
				max = inorder[i];
				index = i;
			}
		}
		
		return index;
	}
	
private static void inOrder(Node node) {
		
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}

}
