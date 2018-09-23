package Personal;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileReading {

	public static void main(String[] args) {

		try{
		Scanner sc = new Scanner(new File("C:\\Users\\FARHAN ASAD\\workspace\\PBLJ\\Lecture1\\src\\Personal\\A-small-attempt0.in"));
		
//		while(sc.hasNext())
//		{
//			String str = sc.next();
//			System.out.println(str);
//		}
		
		String Fname = sc.next();
		String Lname = sc.next();
		int uid = sc.nextInt();
		Double cgpa = sc.nextDouble();
		
		sc.close();
		
		System.out.println("Fname :"+Fname);
		System.out.println("Lname :"+Lname);
		System.out.println(("uid   :"+uid));
		System.out.println("cgpa  :"+cgpa);
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
