package Personal;

public class ChangeNodeDataToChildSum {
	
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
		
		root = new Node(9);
		root.left = new Node(5);
		root.right = new Node(8);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println("Input tree :");
		Inorder(root);
		//addNodes(root);
		replaceNodeDataWithSumOfChilds(root);
		System.out.println("\nAfter Adding the nodes :");
		Inorder(root);
	}
	
	public static int addNodes(Node node)
	{
		if(node==null)
			return 0;
		
		node.data = addNodes(node.left)+ node.data + addNodes(node.right);
		return node.data;
	}
	
	public static void replaceNodeDataWithSumOfChilds(Node node)
	{
		if(node==null)
			return;
		
		node.data = 0;
		if(node.left!=null)
			node.data += node.left.data;
		if(node.right!=null)
			node.data += node.right.data;
		
		replaceNodeDataWithSumOfChilds(node.left);
		replaceNodeDataWithSumOfChilds(node.right);
	}
	
	public static void Inorder(Node node)
	{
		if(node==null)
			return;
		
		Inorder(node.left);
		System.out.print(node.data+" ");
		Inorder(node.right);
	}

}
