package Personal;

import java.util.ArrayList;
import java.util.HashSet;

public class AllPairsWithRemainderK {

	public static void main(String[] args) {

		int ar[] = {2, 3, 5, 4, 7};
		int k=2;
		
		allPairs(ar,k);

	}

	private static void allPairs(int[] ar, int k) {

		HashSet<Integer> hs = new HashSet<Integer>();
		int n = ar.length;
		
		for(int i=0; i<n; i++)
			hs.add(ar[i]);
		
		for(int i=0; i<n; i++)
		{
            // (k, numbers greater than k) as
            // [k % (num (> k)) = k ]  i.e. 2%4 = 2
			if(ar[i]>k && hs.contains(k))
			{
				System.out.println( "("+k+", "+ar[i]+")" );
			}
			 // Now Check for current element 'a' how many 'b' exists such that a%b == k
			else if(ar[i]<k)
			{
				ArrayList<Integer> al = getAllFactors(ar[i]-k);

				for(int j=0; j<al.size(); j++)
				{
					int x = al.get(j);
					//if(ar[i]!=x && ar[i]%x==k && hs.contains(x))
					if(ar[i]%x==k && hs.contains(x))
					{
						System.out.println("("+ar[i]+", "+x+")" );
					}
				}

			}
		}
		
	}

	private static ArrayList<Integer> getAllFactors(int x) {
		
		//Rather use a hashSet here.
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i=1; i<=Math.sqrt(x); i++)
		{
			if(x%i==0)
			{
				if(x/i==i)
					al.add(i);
				else 
				{
					al.add(i);
					al.add(x/i);
				}
			}
		}
		return al;
	}

}
