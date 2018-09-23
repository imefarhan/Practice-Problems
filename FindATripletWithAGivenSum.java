package Personal;

import java.util.Arrays;

public class FindATripletWithAGivenSum {

	public static void main(String[] args) {

		int ar[] = {12, 3, 4, 1, 6, 9,2};
		int sum = 9;
		
		findTriplet(ar,sum);

	}

	private static void findTriplet(int[] ar, int sum) {

		Arrays.sort(ar);
		
		for(int i=0; i<ar.length; i++)
		{
			int l = i+1, r=ar.length-1;
			while(l<r)
			{
				if(ar[i]+ar[l]+ar[r]==sum)
				{
					System.out.println("Trpilet Found : "+ar[i]+" + "+ar[l]+" + "+ar[r]+" = "+sum);
					break;
				}
				else if(ar[i]+ar[l]+ar[r] < sum)	//if the sum is less than the desired sum we have to move towards the right
				{									//to increase the value of ar[i]+ar[l]+ar[r] because the array is in ascending order.
					l++;
				}
				else
					r--;
			}
		}
		
	}
	
	//Complexity = O(n^2)

}
