package Personal;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "abcdaf", s2 = "zbcdf";
		
		int ar[][] = new int[s1.length()+1][s2.length()+1];
		
		for(int i=1; i<=s1.length(); i++)
		{
			for(int j=1; j<=s2.length(); j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					ar[i][j] = ar[i-1][j-1]+1;
				}
			}
		}
		
		String subSequence = "";
		
		for(int i=0; i<=s1.length(); i++)
		{
			for(int j=0; j<=s2.length(); j++)
			{
				System.out.print(ar[i][j]+" ");
				if(ar[i][j]!=0)
				{
					subSequence += s1.charAt(i-1);
				}
			}
			System.out.println();
		}
		
		System.out.println("The Generated subsequence is : "+subSequence);

	}

}
