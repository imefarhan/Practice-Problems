package Personal;

public class RecursionSum {

	public static void main(String[] args) {
		int x = 12345;
		System.out.println(recSum(x));
	}
	
	static int recSum(int x)
	{
		if(x<10)
			return x;
		else
		{
			int d = x;
			recSum(x/10);
			int last = x%10;
			return d;
		}
	}

}