package Personal;

import java.util.Arrays;

/*
 * Reading Material:
 * 					https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 */

public class MaxProfitUsingTwoTransaction {

	public static void main(String[] args) {

		int price[] ={2, 30, 15, 10, 8, 25, 80};
		
		System.out.println("Given Array of Price  is       : "+Arrays.toString(price));
		
		int x = getMaxProfit(price);
		
		System.out.println("Max Profit by two Share market transactions is :"+x);

	}

	private static int getMaxProfit(int[] price) {
		
		int n = price.length;
		int profit[] = new int[n];
		
		int maxPrice = price[n-1];
		
		//Maximum Profit with only two transactions('buy' -> 'sell' -> 'buy' -> 'sell') allowed.
		for(int i = n-2; i>=0; i--)
		{
			if(price[i]>maxPrice)
				maxPrice = price[i];
			
			profit[i] = Math.max(profit[i+1], maxPrice-price[i]);
		}
		
		System.out.println("After first  Iteration Array is: "+Arrays.toString(profit));
		//System.out.println("After 1st Iteration(i.e. one transaction) max Profit is :"+profit[0]);
		
		int minPrice = price[0];
		for(int i=1; i<n; i++)
		{
			if(price[i]<minPrice)
				minPrice = price[i];
			
			profit[i] = Math.max(profit[i-1], profit[i]+(price[i]-minPrice)); //The previous profit plus the new profit.
		}
		
		System.out.println("After Second Iteration Array is: "+Arrays.toString(profit));
		
		return profit[n-1];
	}

}
