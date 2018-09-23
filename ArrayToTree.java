package Personal;

public class ArrayToTree {
	
//	static Node1 root = new Node1();
	
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
		
		Node()
		{
			this.data = '\0';
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		
		int ar[] = {1,2,3,4,5,6,7,8,9};
		Node root = convert(ar, 0, ar.length-1);
        print(root);
	}
	
	private static void print(Node root) {
		
		//Inorder traversal method...
		
		if(root==null)
			return;
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}

	public static Node convert(int ar[], int start, int last)
	{
		if(last<start)
			return null;
		
		int mid = (last+start)/2;

		Node temp = new Node(ar[mid]);
		temp.left =	convert(ar, start, mid-1);
		temp.right = convert(ar,mid+1,last);
		return temp;
	}
}
