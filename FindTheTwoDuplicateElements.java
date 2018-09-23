package Personal;

public class FindTheTwoDuplicateElements {

	public static void main(String[] args) {

		 int ar[] = {4, 2, 4, 5, 2, 3, 1};
	        int size = ar.length;
	        printRepeating(ar, size);

	}

	private static void printRepeating(int[] ar, int size) {

		int xor = ar[0];
		
		for(int i=1; i<size; i++)
			xor = xor ^ ar[i];
		
		for(int i=1; i<size-1; i++)
			xor = xor ^ i;
		
		//Finding the rightmost set bit.
		int set_bit = xor & ~(xor-1);
		
		int x=0, y=0;
		
		for(int i=0; i<size; i++)
		{
			if((ar[i] & set_bit) == 0)
				x = x^ar[i];
			else
				y = y^ar[i];
		}
		
		for(int i=1; i<=size-2; i++)
		{
			if((i & set_bit)==0)
				x = x ^ i;
			else
				y = y ^ i;
		}
		
		System.out.println("X :"+x+" Y :"+y);
		
	}

}
