package Personal;

import java.util.*;
import java.io.*;
class SweetCandyCodeJam {
public static void main(String[] args) {
  Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int T = in.nextInt();
  
  for (int i = 1; i <= T; ++i) {
    int N = in.nextInt();
    int O = in.nextInt();
    long D = in.nextLong();
    int X1, X2, A,B,C,M,L;
    X1 = in.nextInt();
    X2 = in.nextInt();
    A = in.nextInt();
    B = in.nextInt();
    C = in.nextInt();
    M = in.nextInt();
    L = in.nextInt();
    
    long ar[] = new long[N+1];
    ar[1] = X1+L;
    ar[2] = X2+L;
    long x[] = new long[N+1];
    x[1] = X1;
    x[2] = X2;
    for(int j=3; j<=N; j++)
    {
    	x[j] = ((A*x[j-1])+(B*x[j-2])+C)%M;
    	ar[j] = x[j]+L;
    }
    
    System.out.println(Arrays.toString(ar));
    
    long sum[] = new long[N+1];
    int odd=0, si=0,  max = Integer.MIN_VALUE;
    sum[1] = ar[1];
    //long currSum = ar[1];
    odd = (int) (ar[1] & 1);
    
    for(int j=2; j<=N; j++)
    {
    	if((ar[j] & 1) > 0)
    		odd++;
    	
    	if(odd<=O)		//Including
    	{
    		long temp = sum[j-1] + ar[j];
    		if(temp>sum[j-1] && temp>ar[j] && temp<=D)
    		{
    			//currSum = temp;
    			sum[j] = temp;
    			if(sum[j]>max)
        		{
        			max = (int) sum[j];
        		}
    		}
    		else
    		{
    			sum[j] = ar[j];
    		}
    	}
    	else			//Excluding
    	{
//    		if(sum[j-1]+ar[j]>sum[j-1])
//    			sum[j] = sum[j-1]+ar[j];
//    		else
    			sum[j] = ar[j];
    		odd = (int) (ar[j] & 1);
    	}
    }
    
    System.out.println(Arrays.toString(sum));
    System.out.println("MAX :"+max);
  }
}

}