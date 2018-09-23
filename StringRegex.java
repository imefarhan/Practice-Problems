package Personal;

import java.io.*;
import java.lang.*;
import java.util.*;
public class StringRegex
{
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("test cases no: ");
        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0){
        String a = sc.nextLine();
		LinkedHashSet <String> h= new LinkedHashSet<String>();
		
		String ar[]= new String[a.length()];
		
		ar = a.split(" ");
		int i=0;
		
		for(i=0; i<ar.length; i++)
			System.out.print(ar[i]+",");
		
		for(i=0; i<ar.length; i++)
        {
           h.add(ar[i]);
        }
    
		System.out.println();
		Iterator <String> it = h.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+" " );
		}
        System.out.println();
        }
    }
}