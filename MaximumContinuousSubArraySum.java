package Personal;

public class MaximumContinuousSubArraySum {

	public static void main(String[] args) {

		int ar[] =
			{-2,-3,4,-1,-2,1,5,-3}; //Answer is 7 i.e. from index 2 to 6
			//{2,5,6,7,8,3};
			//{-2,-5,-6,8,-7,-8,-3};
			//{-2,-5,-6,-7,-8,-3};
			//{4,1,-6,5,8,2,-10,7,9};
		
		int x = maxSumm(ar);
		
		System.out.print("\nMaximum continuous Sub-Array Sum : "+x);

	}

	private static int maxSumm(int[] ar) {
		
		int maxSum, currSum;
		
		int startIndex = -1, endIndex = -1, tempStartIndex=-1;
		
		maxSum = Integer.MIN_VALUE;
		currSum = 0;
		for(int i=0; i<ar.length; i++)
		{
			if(currSum==0)
			{
				tempStartIndex = i; //Update the a temp starting index whenever we are resetting the sum.
			}
			
			currSum+=ar[i];
			
			if(currSum>maxSum)
			{
				maxSum = currSum;
				startIndex = tempStartIndex; //whenever the sum increases the previous max update it.
				endIndex = i;				 //also update the starting and ending index.
			}
			if(currSum<0)
			{
				currSum = 0;
			}
		}
		
		if(startIndex==-1)
		{
			for(int i=0; i<ar.length; i++)
			{
				if(ar[i]>maxSum)
					maxSum = ar[i];
			}
		}
		
		for(int i=0; i<ar.length; i++)
			System.out.print(ar[i]+" ");
		
		System.out.println("\n\nStart Index :"+startIndex);
		System.out.println("End Index :"+endIndex);
		
		return maxSum;
	}

}
