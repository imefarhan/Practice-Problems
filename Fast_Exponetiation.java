package Personal;

public class Fast_Exponetiation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Calculate m^n where n is very large*/

		int m = 5;
		int n = 20;
		
		System.out.println("Result :"+mypow(m,n));
	}
	
	static long mypow(int m, int n)
	{
		int res = 1;
		
		while(n>0)
		{
			if(n%2==1)
				res = res*m;
			m = m*m;
			n=n>>1;				//Dividing by 2
		}
		
		return res;
	}
}