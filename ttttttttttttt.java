import java.util.HashMap;
import java.util.Map;

public class ttttttttttttt {

	public static void main(String[] args) {
		
		System.out.println("\nAnswer :"+lotteryCoupons(11));
		
//		System.out.println("con :"+consecutive(200));
	}
	
	public static int lotteryCoupons(int n) {
	    
	    int ar[] = new int[n];
	    int i = 0;
	    for(int x=1; x<=n; x++)
	    {
	        int temp = getSum(x);
	        while(temp>9)
	        	temp = getSum(temp);
	        ar[i] = temp;
	        System.out.print(ar[i]+" ");
	        i++;
	    }
	    System.out.println("here");
	    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	    for(int ii = 0; ii < n; ii++)
	    {
	        if(hm.containsKey(ar[ii]))
	        {
	            hm.put(ar[ii], hm.get(ar[ii])+1);
	        }
	        else
	            hm.put(ar[ii], 1);
	    }
System.out.println(hm.toString());
	int max = -1;
	    for(Map.Entry m : hm.entrySet())
	    {
	        int val = Integer.parseInt(m.getValue().toString());
	        if(val > max)
	            max = val;
	    }
System.out.println("Max :"+max);	    
	int res = 0;
	    for(Map.Entry m : hm.entrySet())
	    {
	        int val = Integer.parseInt(m.getValue().toString());
	        if(val == max)
	            res++;
	    }

	return res;
	}

	    private static int getSum(int x)
	    {
	        int sum = 0;
	        while(x>0)
	        {
	            sum = sum + (x%10);
	            x = x/10;
	        }

	        return sum;    
	    }
	    
//	    public static int consecutive(long num) {
//	        // Write your code here
//
//	            long start = (num/2) + 1;
//	            int count = 0;
//	            for(long i=start; i>0; i--)
//	            {
//	                long j = i;
//	                //j--;
//	                long sum = 0;
//	                while(sum<num && j>0)
//	                {
//	                    sum += j;
//	                    j--;
//	                    
//	                    if(sum==num)
//	                        count++;
//	                }
//	            }
//
//	            return count;
//
//	        }


}
