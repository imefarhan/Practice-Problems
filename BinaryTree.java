package Personal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
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
	
	public void BinaryTree()
	{
		root = null;
	}
	
	public boolean lookup(int data)
	{
		return lookup(root,data);
	}
	
	private boolean lookup(Node root, int data)
	{
		if(root==null)
			return false;
		
		if(root.data==data)
			return true;
		
		else if(root.data<data)
			return lookup(root.left,data);
		
		else
			return lookup(root.right,data);
	}
	
	public void insert(int data)
	{
		root = insert(root, data);
	}
	
	private static Node insert(Node node, int data)
	{
		if(node==null)  //(root==null)
			node = new Node(data);
		else if(data <= node.data)
			node.left = insert(node.left,data);
		else
			node.right = insert(node.right,data);
		
		return node;
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/
	//Insertion in a Complete Binary Tree.
	static Node insertRecursiveBFS(Node node, int i, int ar[])
	{	
		if(i<ar.length)
		{
			Node temp = new Node(ar[i]);
			node = temp;
			node.left = insertRecursiveBFS(node.left,2*i+1,ar);
			node.right = insertRecursiveBFS(node.right,2*i+2,ar);
		}
		return node;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------*/
	static Node insertIterativeBFS(Node node, int ar[])
	{
		int n = ar.length;
		int i = 0;
		Queue<Node> q = new LinkedList<Node>();
		
		node = new Node(ar[i]);
		q.add(node);
		i++;
		while(i<n)
		{	
			Node temp = q.peek();
			
			if(temp.left==null)
			{
				temp.left = new Node(ar[i]);
				i++;
			}
			else if(temp.right==null)
			{
				temp.right = new Node(ar[i]);
				i++;
			}
			else
			{
				q.add(temp.left);
				q.add(temp.right);
				q.remove();
			}
		}
		
		return node;
	}
	
	/*-----------------------------------------------------------------------------------------------------*/
	
	public static void build123a() {
		// /*	Build 123 using three pointer variables. */
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(2);
		Node lChild = new Node(1);
		Node rChild = new Node(3);
		tree.root.left = lChild;
		tree.root.right = rChild;
	}
	
	public static void build123b(){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(2);
		tree.root.left = new Node(1);
		tree.root.right = new Node(3);
	}
	
	public static void build123c()
	{
		BinaryTree tree = new BinaryTree();
		tree.root = insert(tree.root,1);
		tree.root = insert(tree.root,2);
		tree.root = insert(tree.root,3);
	}
	
	/*Max Height Of a Tree*/
	static int height(Node root) {
      	return root==null ? -1 : (1 + Math.max(height(root.left), height(root.right)));
    }
	
	/* Get width of a given level */
    int getWidth(Node node, int level) 
    {
        if (node == null)
            return 0;
  
        if (level == 1)
            return 1;
        
        else if (level > 1)
            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
        return 0;
    }
	
    
	/*Max Size of a Tree*/
	public static int size()
	{
		return size(root);
	}
	private static int size(Node root)
	{
		if(root==null)
			return 0;
		
		return size(root.left) + 1 + size(root.right);
	}
	
	public static int minValue(Node node)
	{
		while(node.left!=null)
			node = node.left;
		
		return node.data;
	}
	
	public static void Inorder(Node node)
	{
		if(node==null)
			return;
		
		Inorder(node.left);
		System.out.print(node.data+" ");
		Inorder(node.right);
	}
	
	public static void preOrder(Node node)
	{
		if(node == null) return;
		
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void postOrder(Node node)
	{
		if(node == null) 
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	/*_Has path with a particular sum and print it_*/
	
	public static boolean hasPath(Node node, int sum)
	{
		if(node==null)
			return sum==0;
		
		return (hasPath(node.left, (sum-node.data) ) || hasPath(node.right, (sum-node.data) ));
	}
	
	/*_Print out all the paths from root to all the leaves_*/
	
	public static void printPath(Node node, ArrayList<Integer> ar)
	{
		if(node==null)
			return;
		
		ar.add(node.data);
		
		if(node.left==null && node.right==null) 
			printArray(ar);
		else
		{
			printPath(node.left,  ar);
			printPath(node.right, ar);
		}
	}
	
	private static void printArray(ArrayList<Integer> ar) {
		
		for(int x : ar)
			System.out.println(x+" ");
		System.out.println();
	}
	
	/*_Convert the tree to its mirror image_*/
	
	public static void mirror(Node node)
	{
		if(node==null)
			return;
		
		if(node!=null)
		{
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			mirror(node.left);
			mirror(node.right);
		}
	}
	
	/*Change a tree by inserting a duplicate node on each node's left*/
	
	public static void duplicate(Node node)
	{
		if(node==null)
			return;
		
		duplicate(node.left);
		duplicate(node.right);
		
		Node temp = node.left;
		node.left = new Node(node.data);
		node.left.left = temp;
		
	}
	
	/*Check if two trees are identical*/
	
	public static boolean identical(Node a, Node b)
	{
		if(a==null && b==null)
			return true;
		
		else if(a!=null && b!=null)
			return (a.data==b.data && identical(a.left,b.left) && identical(a.right,b.right));

		else
			return false;
	}
	
	
	/*No of possible binary trees*/
	//try for dynamic programming approach using memoisation.
	
	public static int countTrees(int n)
	{
		if(n<=1) 
			return 1;
		
		int left, right, sum=0;
		
		for(int root=1; root<=n; root++)
		{
			left =  countTrees(root-1);
			right = countTrees(n-root);
			
			sum+=left*right;
		}
		
		return sum;
	}
	
	/*_Check if the given tree is a Binary Search Tree_*/
	
	/*While calling min = Integer.MIN_VALUE
	 * and			max = Integer.MAX_VALUE
	*/
	
	public static boolean isBST(Node node, int min, int max)
	{
		if(node==null)
			return true;
		
		if(min<node.data && node.data<max)
			return isBST(node.left,min,node.data) && isBST(node.right,node.data,max);
		
		else
			return false;
	}	
}