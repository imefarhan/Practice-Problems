package Personal;

public class Recursion_Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(fib(7));

	}

	private static int fib(int n) {
		// TODO Auto-generated method stub
		
		if(n<=1)
			return n;
		else if(n==3)
		{
			return 1;
		}
		else
		{
			return fib(n-1)+fib(n-2);
		}
	}

}
