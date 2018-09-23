package Personal;

import java.util.BitSet;

public class TestTest {

//	public static void main(String... args) {
//		
//		String str = "98765";
//		char ch = str.charAt(1);
//		
//		int b = ch;
//		int a = Character.getNumericValue(ch);
//		
//		System.out.println("a :"+a+" b :"+(b-48));
//		
//		int cpc = Character.getNumericValue('g');
//		System.out.println("Character.getNumericValue('g') :"+cpc);
//		
//		
//		String qa[] = new String[11];
//		qa[002] = "frfr";
//		qa[010] = "thth";
//		System.out.println("qa[2] :"+qa[2]+" qa[002] :"+qa[002]+" qa[10] :"+qa[10]+" qa[010] :"+qa[010]);
//		
////        String x = "845f";
////        int ppp = Integer.parseInt(String.valueOf(x));
////        System.out.println("PPP :"+ppp);
//        
//        int xx = 10;
//        int vv = ~xx;
//        System.out.println("xx :"+xx+" ~xx :"+(~xx)+" vv :"+vv);
//		
////		try
////		{
////		str = "abc";
////		a = Integer.parseInt(str);
////		}
////		catch(Exception e)
////		{
////			System.out.println(e);
////		}
////		catch(NumberFormatException e)
////		{
////			System.out.println(e);
////		}
//		
//		for(int i=1; i<=5; i++)
//		{
//			for(int j=1; j<=5; j++)
//			{
//				System.out.println("i :"+i+" j :"+j);
//				if(j==3)
//					break;
//			}
//			System.out.println("i :"+i);
//		}
//		
//	}
	
	static 
	{
		System.out.println("Static Block is Executed Before main()");
	}
	
//	public static void main(String args[])
//	{
//		String s1 = "abc";
//		String s2 = "abc";
//		s1 += "d";
//		s2 += "d";
//		System.out.println(s1 + " " + s2 + " " + (s1.equals(s2)));
//
//		StringBuffer sb1 = new StringBuffer("abc");
//		StringBuffer sb2 = sb1;
//		sb1.append("d");
//		System.out.println(sb1 + " " + sb2 + " " + (sb1 == sb2));
//	}
	
	
	public static void main(String... args) {
		
		BitSet b1 = new BitSet(6);
		b1.set(1);
		b1.set(3);
		b1.set(5);
		BitSet b2 = new BitSet();
//		b1.and(b2);
		b1.flip(3);
		System.out.println("b1 :"+b1);
		
	}

}
