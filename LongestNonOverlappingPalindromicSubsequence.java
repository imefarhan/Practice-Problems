package Personal;

/*

URL : https://www.codechef.com/problems/IISCH05

Sample Input:
aaapaaskmywbcaajjaacb

Sample Output:
50

Reason:
P:- aaaaa (5)
Q:- bcaajjaacb (10)
5*10 = 50

*/

import java.io.*;

class LongestNonOverlappingPalindromicSubsequence {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        
        String s = new String ( keyin.readLine() );
        int len = s.length();
        int [][] chk = new int [ len ] [ len ];
        int i, j;
        
        for ( i = 0 ; i < len ; i++ ){
            chk [i][i] = 1;
        }
        
        for( i = len - 2 ; i >= 0 ; i-- )
        {
            for ( j = i + 1 ; j < len ; j++ )
            {
                if ( s.charAt(i) == s.charAt(j) )
                {
                    chk [i] [j] = 2 + chk [ i+1 ] [ j-1 ] ;
                }
                else
                {
                    chk [i] [j] = Math.max( chk[i][j-1] , chk[i+1][j]);
                }
            }
        }
        int fun, maxi = 0 ;
        for( i = 0 ; i < len - 1 ; i ++){
            fun = chk[0][i] * chk[i+1][len-1];
            if ( fun > maxi ){
                maxi = fun;
            }
        }
        
        for(i =0 ; i < len; i++){
            for(j=0; j<len; j++){
                System.out.print(chk[i][j] + "  ");
            }
            System.out.println("");
        }
        
        System.out.println( maxi );
    }
}