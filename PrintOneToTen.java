package Personal;

class A{
	private static int i = 1;
	A()
	{
		System.out.println(i++);
	}
}

public class PrintOneToTen {

	public static void main(String[] args) {
		
		A ob = new A();
		A ob1 = new A();
		
	}

}
