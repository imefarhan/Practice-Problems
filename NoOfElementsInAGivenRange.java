package Personal;
import java.util.*;

public class NoOfElementsInAGivenRange {
	
/*
* If there are multiple queries then an Efficient Approach will be to first sort the array and 
* then using a modified binary search function find two indices, 
* one of first element greater than or equal to lower bound of range and the other of the last element less than or equal to upperbound. 
* Time for running each query will be O(logn) and for sorting the array once will be O(nlogn).
*/

	public static void main(String[] args) {

		int ar[] = {1,3,1,4,9,10,3,9};
		int x=1, y=9;
		
		Arrays.sort(ar);
		
		int count = countInRange(ar,x,y);
		System.out.println("No of Elements in range :"+count);

	}

	private static int countInRange(int[] ar, int x, int y) {
		
		System.out.println(Arrays.toString(ar));
		
		int i=0;
		int j=ar.length-1;
		
		int index1=-1, index2=-1;
		
		//finding the leftmost element of the given range
		while(i<=j)
		{
			//System.out.println("i :"+i+" j :"+j);
			int mid = (i+j)/2;
			if(ar[mid]==x)
			{
				index1 = mid;
				if(mid-1>=0 && ar[mid-1]==x)
					i--;
				else
					break;
			}
			else if(ar[mid]>x)
				j = mid;
			else
				i = mid;
		}
		
		
		//finding the rightmost element of the given range
		i=0;
		j=ar.length-1;
		
		while(i<=j)
		{
			int mid = (i+j)/2;
			if(ar[mid]==y)
			{
				index2 = mid;
				if(mid+1<ar.length && ar[mid+1]==y)
					j++;
				else
					break;
			}
			else if(ar[mid]>y)
				j = mid;
			else
				i = mid;
		}
		
		System.out.println("index1 :"+index1+" index2 :"+index2);
		
		return Math.abs(index1-index2)+1;
	}

}
