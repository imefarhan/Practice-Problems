
package Personal;

public class DifferenceBetweenDoubleEqualToAndEqualFunction {
	
	public static void main(String[] args)
	{
//		Object ob;
//		System.out.println(ob);
		
		String str = "Farhan";
		String str2= "Farhan";
		String str3= new String("Farhan");
		String ar[] = {"Farhan","Asad"};
		
		if(str==ar[0])
			System.out.println("== equal true");
		else
			System.out.println("== not equal true");
		
		if(str.equals(ar[0]))
			System.out.println("equals() function true");
		else
			System.out.println("equals() function false");
		
		if(str==str2)
			System.out.println("== equal true");
		else
			System.out.println("== not equal true");
		
		if(str.equals(str2))
			System.out.println("equals() function true");
		else
			System.out.println("equals() function false");
		
		if(str==str3)
			System.out.println("== equal true");
		else
			System.out.println("== not equal true");
		
		if(str.equals(str3))
			System.out.println("equals() function true");
		else
			System.out.println("equals() function false");
		
		
	}

}
