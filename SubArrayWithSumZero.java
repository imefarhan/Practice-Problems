package Personal;

import java.util.HashMap;

/*
Find the Largest SubArray with equal no of 0s and 1s.
Largest subArray with equal number of 0s and 1s.
*/

public class SubArrayWithSumZero {

	public static void main(String[] args) {

		int arr[] = //{1, 1, 1, 0, 1, 0, 1, 1, 1};
					{1, 0, 1, 1, 1, 0, 0};
		
		/*
		 * Convert all the zeroes to negative-one and then the question becomes Finding a sub array with sum = zero.
		 */
		
        int n = arr.length;
        
        for(int i=0; i<n; i++)
        	if(arr[i]==0)
        		arr[i] = -1;
        
        subArraySumsZero(arr);
        
	}
	
	private static void subArraySumsZero(int[] seed)
	{
	    //int [] 
		//seed = new int[] {1,2,3,4,-9,6,7,-8,1,9};
	    int currSum = 0;
	    int maxDiff = 0, startIndex = -1, endIndex = -1;
	    HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
	    
//In this HashMap maintain the index of first occurrence of a particular sum.
//To find the largest sub array, if we again find that sum we calculate 
//the max-difference between the current index when we again encounter that sum and the first time when we did find that sum(i.e. from the HashMap).
	    for(int i = 0 ; i < seed.length ; i++)
	    {
	        currSum += seed[i];
	        if(currSum == 0)
	        {
	            System.out.println("subset : { 0 - " + i + " }");
	            maxDiff = i;
            	startIndex = 0;
            	endIndex   = i;
	        }
	        else if(sumMap.containsKey(currSum))
	        {
	            System.out.println("subset : { " + (sumMap.get(currSum) + 1) + " - " + i + " }");
	            if(maxDiff < i - sumMap.get(currSum))
	            {
	            	maxDiff = i - sumMap.get(currSum);
	            	startIndex = sumMap.get(currSum);
	            	endIndex   = i;
	            }
	        }
	        else
	            sumMap.put(currSum, i);
	    }
	    
	    System.out.println("Longest SubArray With equal no of 1s and 0s : [" + (startIndex+1) + " - " + (endIndex) + "]");
	    
	    System.out.println("HASH MAP HAS: " + sumMap);
	}

}
