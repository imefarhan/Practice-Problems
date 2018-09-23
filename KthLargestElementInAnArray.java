package Personal;

import java.util.Arrays;

public class KthLargestElementInAnArray {
	
	static int Harr[];
	static int arr_size = 0;

	public static void main(String[] args) {

		int ar[] = {1,23,12,9,30,2,50};
		int i=0, k=3;
		Harr = new int[k];
		for(i=0; i<k; i++)
		{
			insertInHeap(ar[i]);
		}
		
		System.out.println("Heap-Array1 :"+Arrays.toString(Harr));
		
		for(i=k; i<ar.length; i++)
		{
			if(Harr[0]<ar[i])
			{
				Harr[0] = ar[i];
				System.out.println("inside loop Heap-Array :"+Arrays.toString(Harr));
				heapify(0);
			}
		}
		
		System.out.println("Heap-Array :"+Arrays.toString(Harr));
		System.out.println(k+"th max element is :"+Harr[0]);
	}

	private static void insertInHeap(int num) {

		if(arr_size == Harr.length)
		{
			System.out.println("Overflow!!");
			return;
		}
		
		arr_size++;
		int i = arr_size - 1;
		
		Harr[i] = num;
		
		while(i!=0 && Harr[parent(i)]>Harr[i])
		{
			swap(parent(i), i);
			i = parent(i);
		}
	}
	
	private static void heapify(int i)
	{
		int l = left(i);
		int r = right(i);
		int smallest = i;
		
		if(l<Harr.length && Harr[l]<Harr[smallest])
			smallest = l;
		if(r<Harr.length && Harr[r]<Harr[smallest])
			smallest = r;
		if(smallest != i)
		{
			swap(smallest,i);
			heapify(smallest);
		}
	}
	
	private static void swap(int x1, int x2) 
	{
		Harr[x1] = (Harr[x1]+Harr[x2])-(Harr[x2]=Harr[x1]);	
	}

	static int parent(int x)
	{
		return (x-1)/2;
	}
	
	static int left(int x)
	{
		return 2*x+1;
	}
	
	static int right(int x)
	{
		return 2*x+2;
	}

}
