package Personal;

public class MaximumNonAdjacentSubsequence {

	public static void main(String[] args) {
		
		//5,  5, 10, 40, 50, 35
		//5, 5, 10, 100, 10, 5
		int ar[] = {5, 5, 10, 100, 10, 5};
		
		int max = maxSum(ar);
		System.out.println("Maximum Non Adjacent Subsequence Sum :"+max);
	}

	private static int maxSum(int[] ar) {
		
		int inc = ar[0];
		int exc = 0;
		int maxUntilPreviousIteration;
		
		for(int i=1; i<ar.length; i++)
		{
			//maximum sum utill now.
			maxUntilPreviousIteration = Math.max(inc, exc); // inc>exc?inc:exc;
			
			//including the current element -> ar[i]
			//Therefore it can only be added to the exc from previous iteration.
			inc = exc + ar[i];
			
			//updating the exc to max(exc & inc-from-previous-iteration)
			exc = maxUntilPreviousIteration;
		}
		
		//return the max of either including the last element or excluding it.
		return Math.max(inc, exc);		//exc>inc?exc:inc;
	}

}
