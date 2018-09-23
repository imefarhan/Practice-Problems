package Personal;

/*
   Let the two odd occurring numbers be x and y. We use bitwise XOR to get x and y. 
   The first step is to do XOR of all elements present in array. 
   XOR of all elements gives us XOR of x and y because of the following properties of XOR operation.
1) XOR of any number n with itself gives us 0, i.e., n ^ n = 0
2) XOR of any number n with 0 gives us n, i.e., n ^ 0 = n
3) XOR is cumulative and associative.

So we have XOR of x and y after the first step. Let the value of XOR be xor2. 
Every set bit in xor2 indicates that the corresponding bits in x and y have values different from each other. 
For example, if x = 6 (0110) and y is 15 (1111), then xor2 will be (1001), 
the two set bits in xor2 indicate that the corresponding bits in x and y are different. 
In the second step, we pick a set bit of xor2 and divide array elements in two groups. Both x and y will go to different groups. 
In the following code, the rightmost set bit of xor2 is picked as it is easy to get rightmost set bit of a number.
set_bit = (xor2 & ~(xor2-1))
If we do XOR of all those elements of array which have the corresponding bit set (or 1), then we get the first odd number. 
And if we do XOR of all those elements which have the corresponding bit 0, then we get the other odd occurring number. 
This step works because of the same properties of XOR. 
All the occurrences of a number will go in same set. 
XOR of all occurrences of a number which occur even number number of times will result in 0 in its set. 
And the xor of a set will be one of the odd occurring elements.
 */

public class FindTwoNosWithOddFrquencyInAnUnSortedArray {

	public static void main(String[] args) {

		int ar[] = {12, 23, 34, 12, 12, 23, 12, 45};
		
		findNumbers(ar);

	}

	private static void findNumbers(int[] ar) {

		int xor = 0;
		
		for(int i=0; i<ar.length; i++)
			xor = xor ^ ar[i];
		
		int set_bit = (xor & ~(xor-1));
		
		int x=0, y=0;
		
		for(int i=0; i<ar.length; i++)
		{
			if((ar[i] & set_bit) == 0)
				x = x ^ ar[i];
			else
				y = y ^ ar[i];	
		}
		
		System.out.println("X :"+x+" Y :"+y);
		
	}

}
