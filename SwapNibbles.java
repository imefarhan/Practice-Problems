package Personal;

public class SwapNibbles {

	public static void main(String[] args) {
		
		int n = 70;
		
		int x = swapNibbles(n);
		System.out.println("After Swapping :"+x);
	}

	private static int swapNibbles(int n) {
		
		//11110000 = 240
		//00001111 = 15
		
		int x = 0;
		
		x = (n & 15)<<4 | (n & 240)>>4 ;
		
		return x;
	}

}