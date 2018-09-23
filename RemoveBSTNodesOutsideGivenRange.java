package Personal;

public class RemoveBSTNodesOutsideGivenRange {
	
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
		
		inOrder(root);
		System.out.println();
		
		removeNodes(root,-10,13);
		
		inOrder(root);
		

	}

	private static Node removeNodes(Node node, int i, int j) {
		
		if(node==null)
			return null;
		
		node.left = removeNodes(node.left, i, j);
		node.right= removeNodes(node.right,i,j);
		
		if(node.data<i)
		{
			//Node temp = node.right;
			node.left = null;
			node = node.right;
		}
		
		if(node.data>j)
		{
			node.right = null;
			node = node.left;
		}
		
		return node;
	}

	private static void inOrder(Node node) {
		
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}

}
