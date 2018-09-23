package Personal;

//Java recursive program to print all n-digit
//numbers whose sum of digits equals to given sum
import java.io.*;
import java.util.ArrayList;

class WorkerTimeProblemAskedInEPAM 
{
 // Recursive function to print all n-digit numbers
 // whose sum of digits equals to given sum

 // n, sum --> value of inputs
 // out --> output array
 // index --> index of next digit to be 
 // filled in output array
 static ArrayList<String> findNDigitNumsUtil(int n, int sum, char out[], int index, int dayHour, String pattern, ArrayList<String> ar)
 {
     // Base case
     if (index > n || sum < 0)
         return null;

     // If number becomes N-digit
     if (index == n)
     {
         // if sum of its digits is equal to given sum,
         // print it
         if(sum == 0)
         {
        	 StringBuffer sb = new StringBuffer(pattern);
        	 int x=0;
        	 
        	 for(int i=0; i<pattern.length();i++)
        	 {
        		 if(pattern.charAt(i)=='?')
        		 {
        			 sb.setCharAt(i, out[x]);
        			 x++;
        		 } 
        	 }
             out[index] = ' ';
             //System.out.print(sb.toString());
             ar.add(sb.toString());
             //System.out.print(" ");
         }
         return ar;
     }

     // Traverse through every digit. Note that
     // here we're considering leading 0's as digits
     for (int i = 0; i <= dayHour; i++)
     {
         // append current digit to number
         out[index] = (char)(i + '0');

         // recurse for next digit with reduced sum
         findNDigitNumsUtil(n, sum - i, out, index + 1, dayHour, pattern, ar);
     }
     
     return ar;
 }

 
 static ArrayList<String> findNDigitNums(int n, int sum, int dayHour, String pattern)
 {
	 
	 ArrayList<String> ar = new ArrayList<String>();
     // output array to store N-digit numbers
     char[] out = new char[n + 1];

     // fill 1st position by every digit from 1 to 9 and
     // calls findNDigitNumsUtil() for remaining positions
     for (int i = 0; i <= dayHour; i++)
     {
         out[0] = (char)(i + '0');
         ar = findNDigitNumsUtil(n, sum - i, out, 1, dayHour, pattern, ar);
     }
     
     return ar;
 }
  
 // driver program to test above function
 public static void main (String[] args) 
 {
          //int n = 2, sum = 3;
          //findNDigitNums(n, sum, 8);
          
          
          int dayHour = 4;
          int weekHour = 24;
          String pattern = "???3???";
          
          ArrayList<String> ar = printAllWeeklyPatterns(dayHour,weekHour,pattern);
          for(String ss : ar)
        	  System.out.println(ss);
          
 }

private static ArrayList<String> printAllWeeklyPatterns(int dayHour, int weekHour, String pattern) {
	
	ArrayList<String> ar;
	int k = 0, sum = 0;
	
	for(int i=0; i<pattern.length(); i++)
	{
		char ch = pattern.charAt(i);
		
		if(ch=='?')
		{
			k++;
		}
		else
		{
			sum += (int)ch - 48;
		}
	}
	
	sum = weekHour - sum;
	
	ar = findNDigitNums(k, sum, dayHour, pattern);
	
	return ar;
}
}