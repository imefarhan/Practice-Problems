import java.util.Arrays;

/* Problem Statement:
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) 
 * such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. 
 * Solve it without division operator and in O(n)
 */
public class ArrayProductSkippingIthElement {

	public static void main(String[] args) {
		
		int ar[] = {1,2,3,4,5};
		int res[] = new int[ar.length];
		
		res = findProduct(ar, ar.length);
		System.out.println(Arrays.toString(res));
	}

	private static int[] findProduct(int[] ar, int n) {
		int prod[] = new int[n];
		
		int x = 1;
		Arrays.fill(prod, 1);
		
		/* 'x' variable contains product of all the elements on left side excluding arr[i]*/
		for(int i=0; i<n; i++)
		{
			prod[i] = x;
			x = ar[i]*x;
		}
		
		x=1;
		for(int i=n-1; i>=0; i--)
		{
			prod[i] = prod[i]*x;
			x = x*ar[i];
		}
		
		return prod;
	}

}
