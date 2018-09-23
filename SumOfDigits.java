package Personal;

public class SumOfDigits {
	
	static LinkedListt sum = new LinkedListt();
	static LinkedListt sum2 =  new LinkedListt();

	public static void main(String[] args) {
		
		/*Reverse Order*/
		/*num1 :: 7->1->6*/
		/*num2 :: 5->9->2*/
		/*sum  :: 2->1->9*/
		
		LinkedListt num1 = new LinkedListt(7);
		num1.next = new LinkedListt(1);
		num1.next.next = new LinkedListt(6);
		
		LinkedListt num2 = new LinkedListt(5);
		num2.next = new LinkedListt(9);
		num2.next.next = new LinkedListt(2);
		
		//LinkedListt sum = new LinkedListt();
		LinkedListt head = sum;
		
		int s=0;
		
		while(num1!=null || num2!=null || s>0)
		{
			int n1=0, n2=0;
			if(num1 != null && num2 != null)
			{
				s+= num1.data + num2.data;
				num1 = num1.next;
				num2 = num2.next;
			}
			else if(num1==null && num2!=null)
			{
				s+= num2.data;
				num2 = num2.next;
			}
			else if(num1!=null && num2==null)
			{
				s+=num1.data;
				num1 = num1.next;
			}
			if(s>0)
			{	
				sum.data = s%10;
				s/=10;
				if(s>0)
				{
					sum.next = new LinkedListt();
					sum = sum.next;
				}
			}
			
		}
		System.out.println("Reverse Sum :");
		LinkedListt temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        
        /*Forward Order*/
		/*num1 :: 6->1->7*/
		/*num2 :: 2->9->5*/
		/*sum  :: 9->1->2*/
        
        num1 = new LinkedListt(6);
		num1.next = new LinkedListt(1);
		num1.next.next = new LinkedListt(7);
		
		num2 = new LinkedListt(2);
		num2.next = new LinkedListt(9);
		num2.next.next = new LinkedListt(5);
		
		sum = new LinkedListt();
		head = sum2;
		
		LinkedListt smaller  = num1.size<num2.size?num1:num2;
		LinkedListt larger  ;//= num1.size>num2.size?num1:num2;
		int lenDifference = num1.size<num2.size ? num2.size-num1.size : num1.size-num2.size;
		
		if(smaller==num1)
			larger = num2;
		else
			larger = num1;
		
//		System.out.println();
//		System.out.println("Larger :");
//		head = larger;
//		temp = head;
//        while(temp!=null){
//            System.out.print(temp.data+" ");
//            temp=temp.next;
//        }
		
		LinkedListt first;
		while(lenDifference-- > 0)
		{
			first = new LinkedListt(0);
			smaller.next = first;
			smaller = first;
		}
		
		carry(smaller,larger);
		
		System.out.println();
		System.out.println("Forward Sum :");
		head = sum;
		temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
		
	}
	
	static int carry(LinkedListt num1, LinkedListt num2)
	{
		LinkedListt temp = new LinkedListt();
		int s = 0;
		if(num1.next==null && num2.next==null)
		{
			s = num1.data + num2.data;
			sum.data = s%10;
			s/=10;
//			sum.data = temp;
//			temp.next = sum;
//			sum = temp;
			
			if(s!=0)
				return s;
		}
		else
		{
			s = num1.data + num2.data + carry(num1.next,num2.next);
			temp.data = s%10;
			s/=10;
			temp.next = sum;
			sum = temp;
			
			if(s!=0)
				return s;
		}
		return 0;
	}

}
