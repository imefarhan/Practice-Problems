package Personal;

//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

//Time-Complexity :: O(N*N!)

//O(N!) -> for generating all the possible combinations with swapping.
//O(N)  -> for printing all the strings.

public class PrintAllCombinationsOfAParticularWord {

	public static void main(String[] args) {

		String str = "abc";
		printRec(str,0,str.length());
	}

	private static void printRec(String input, int l, int r) {

		if(l==r)
			System.out.println(input);
		
		
		for(int i=l; i<r; i++)
		{
			input = swap(new StringBuffer(input),l,i);
			printRec(input,l+1,r);
			input = swap(new StringBuffer(input),l,i); //backtracking
		}

	}
	
	static String swap(StringBuffer output, int l, int i)
	{
		char temp = output.charAt(l);
		output.setCharAt(l, output.charAt(i));
		output.setCharAt(i, temp);
		return output.toString();
	}

}
