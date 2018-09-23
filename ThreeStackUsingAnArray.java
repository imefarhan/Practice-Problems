package Personal;

//import java.util.Arrays;
import java.util.Scanner;

public class ThreeStackUsingAnArray {
	
	public static int ar[];
	public static int pos[];
	static int stackSize, noOfStacks;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		noOfStacks = 3;
		stackSize = 4;
		pos = new int[noOfStacks+1];
		
		//Arrays.fill(pos,-1);
		Scanner sc = new Scanner(System.in);
		int flag =1;
		ar = new int[noOfStacks*stackSize];
		while(flag==1){
			System.out.print("Push/1 or POP/2 :");
			int choice = sc.nextInt();
		if(choice==1){	
		System.out.print("Enter the stack-no :");
		int sNo = sc.nextInt();
		System.out.print("Enter the data :");
		int d = sc.nextInt();
		push(sNo,d);
		}
		else if(choice==2)
		{
			System.out.print("Enter the stack-no :");
			int sNo = sc.nextInt();
			System.out.println("Value poped :"+pop(sNo));
		}
		System.out.print("Enter 1 to conttinue else 0:");
		flag = sc.nextInt();
		}
		sc.close();
	}
	
	static void push(int stackNo, int data)
	{
		if(pos[stackNo]>=stackSize)
		{
			for(int i=0; i<ar.length;i++)
				System.out.print(ar[i]+" ");
			System.out.println();
			System.out.println("OverFlow!!");
			return;
		}
		if(pos[stackNo]>=0 && stackNo<=noOfStacks && pos[stackNo]<stackSize)
		{
			ar[(stackSize*(stackNo-1))+pos[stackNo]]=data;
			pos[stackNo] = pos[stackNo]+1;
		}
		for(int i=0; i<ar.length;i++)
			System.out.print(ar[i]+" ");
	}
	
	static int pop(int stackNo)
	{
		if(pos[stackNo]>=0 && stackNo<=noOfStacks)
		{
			System.out.println("Here");
			int res = ar[(stackSize*(stackNo-1))+pos[stackNo]-1];
			ar[(stackSize*(stackNo-1))+pos[stackNo]] = 0;
			if(pos[stackNo]!=0)
				pos[stackNo] = pos[stackNo]-1;
			return res;
		}
		else
		{
			System.out.println("UnderFlow!!");
		}
		
		for(int i=0; i<ar.length;i++)
			System.out.print(ar[i]+" ");
		
		return -1;
	}
}
