package Personal;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

import Personal.DirectiInternship1.InputReader.SpaceCharFilter;

public class MaximumDiameterSum {
	
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
		
		InputReader in = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
		
		int ar[] = {2,4,5,8,-4,3,-6};
		
		//Recursive Technique
		root = insertRecursiveBFS(root,0,ar);
		preOrder(root);
		
		System.out.println();
		
		//Iterative Approach
		root = insertIterativeBFS(root,ar);
		preOrder(root);
		}
	
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
	
	public static void preOrder(Node node)
	{
		if(node == null) return;
		
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	
static	class InputReader {
		 
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int snumChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			int res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
		
		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			long res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
		
		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

}
