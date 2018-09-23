package Personal;

import Personal.WidthOfEveryLevelInATree.Node;

public class FindTheKthSmallestElement {
	
	public static Node root;
	
		private static class Node{
			int data;
			Node left;
			Node right;
		
			Node(int data)
			{
				this.data = data;
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
		
		int k = 4;
		
		inOrder(root,k);
	}
	
	static int ii = 1;
	
	//Finding the kth minimum
	//Simple modification to inOrder traversal technique.
	
private static void inOrder(Node node,int k) {
		
		if(node == null)
		{
			ii--;
			return;
		}
		
		inOrder(node.left,k);
		ii++;
		
		//System.out.println("ii :"+ii+" :: data :"+node.data+" ");
		if(ii==k)
		{
			System.out.println(k+"th smallest element is : "+node.data);
		//System.out.println("ii :"+ii+" :: data :"+node.data+" ");
		}
		
		ii++;
		inOrder(node.right,k);
	}

}
