package Personal;

import java.util.*;

public class RhezoAndPrime {
	
	    public static void main(String args[] ) throws Exception {
	        Scanner s=new Scanner(System.in);
	        int n=s.nextInt();
	        int a[]=new int[n+1];
	        for(int i=1;i<=n;i++)
	        a[i]=s.nextInt();
	        int dp[][]=new int[n+1][n+1];
	        for(int i=1;i<=n;i++)
	        {
	            dp[i][i]=a[i];
	            for(int j=i+1;j<=n;j++)
	            {
	                dp[i][j]=a[j]+dp[i][j-1];
	            }
	        }
	        int prime[]=new int[n+1];
	        ArrayList<Integer>Prime=new ArrayList<>();
	        for(int i=2;i<=n;i++)
	        {
	            if(prime[i]==0)
	            {
	                Prime.add(i);
	                for(int j=2*i;j<=n;j+=i)
	                prime[j]=-1;
	            }
	        }
	        int dp1[]=new int[n+1];
	        for(int i=n-1;i>0;i--)
	        {
	            int max=0;
	            for(int j=0;j<Prime.size()&&(Prime.get(j)+i-1)<=n;j++)
	            {
	                int temp=0;
	                if(i+Prime.get(j)-1<=n)
	                temp=dp[i][i+Prime.get(j)-1];
	                if(i+Prime.get(j)+1<=n)
	                temp+=dp1[i+Prime.get(j)+1];
	                if(temp>max)
	                max=temp;
	            }
	            dp1[i]=Math.max(max,dp1[i+1]);
	        }
	        System.out.println(dp1[1]);
	    }

}
