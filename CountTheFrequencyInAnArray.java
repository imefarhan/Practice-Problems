package Personal;

import java.util.Arrays;

/*
 * Reading Material:
 * 					https://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time/
 */

public class CountTheFrequencyInAnArray {

	public static void main(String[] args) {
		
		int ar[] = {2, 3, 3, 2, 5};
		
		System.out.println(Arrays.toString(ar));
		
		System.out.println("\nMethod-1 :");
		method1(ar);
		
		for(int i=0; i<ar.length; i++)
		{
			System.out.println(i+1+" : "+Math.abs(ar[i]));
		}
		
		System.out.println("\nMethod-2 :");
		ar = new int[] {2, 3, 3, 2, 5};
		method2(ar);

	}

	

	private static void method1(int[] ar) {

		int n = ar.length;
		int i = 0;
		
		while(i<n)
		{
			if(ar[i]<=0)
			{
				i++;
				continue;
			}
			
			int elementIndex = ar[i]-1;		//[2, 3, 3, 2, 5]

			if(ar[elementIndex]>0)
			{
				ar[i] = ar[elementIndex];
				ar[elementIndex] = -1;
			}
			else
			{
				ar[elementIndex]--;
				ar[i] = 0;
				i++;
			}
		}
		
	}
	
	private static void method2(int[] arr) {
		
		int n = arr.length;
		
		// Subtract 1 from every element so that the elements
        // become in range from 0 to n-1
        for (int j = 0; j < n; j++)
            arr[j] = arr[j] - 1;
 
        // Use every element arr[i] as index and add 'n' to
        // element present at arr[i]%n to keep track of count of
        // occurrences of arr[i]
        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = arr[arr[i] % n] + n;
 
        // To print counts, simply print the number of times n
        // was added at index corresponding to every element i.e. -> (arr[i]/n) times.
        for (int i = 0; i < n; i++)
            System.out.println(i + 1 + "->" + (arr[i] / n));

	}
}
