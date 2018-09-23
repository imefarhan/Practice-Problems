package Personal;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SapientMaxQueue {

    public static void main(String[] args) {
    	Scanner sc =new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int x = sc.nextInt();
    	int y = sc.nextInt();
    	
    	int ar[] = new int[n];
    	
    	for(int i=0; i<n; i++)
    		ar[i] = sc.nextInt();
    	
    	for(int i=0; i<n; i++)
    	{
    		int a = ar[i];
    		int t=1;
    		while(a>0)
    		{
    			if((t%x==0) && (t%y==0))
    			{
    				a-=2;
    				if(a<=0)
    				{
    					System.out.println("Both");
    				}
    			}
    			else if(t%x==0)
    			{
    				a-=1;
    				if(a<=0)
    				{
    					System.out.println("Monu");
    				}
    			}
    			else if(t%y==0)
    			{
    				a-=1;
    				if(a<=0)
    				{
    					System.out.println("Sonu");
    				}
    			}
    			
    			t++;
    		}
    	}

    }//main
}//class
