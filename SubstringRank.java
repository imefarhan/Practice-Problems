package Personal;

public class SubstringRank {

	public static void main(String[] args) {

		String str = "zaghsasd";
		System.out.println("Rank is :"+findRank(str));

	}

	private static int findRank(String str) {

		int rank = str.length();
		int l = str.length();
		
		for(int i=1; i<l; i++)
		{
			if(str.charAt(i)<str.charAt(0))
			{
				rank += l-i;
			}
			if(str.charAt(i)==str.charAt(0))
			{
				rank += l-i;
				for(int j=0; j<l-i; j++)
				{
					if(str.charAt(i)==str.charAt(i+j))
					{
						rank--;
					}
				}
			}
		}
		
		return rank;
	}

}
