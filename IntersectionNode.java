package Personal;

import java.util.HashSet;

public class IntersectionNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListt l1 = new LinkedListt(1);
		LinkedListt l2 = new LinkedListt(2);
		LinkedListt head1 = l1;
		LinkedListt head2 = l2;
		l1.next = new LinkedListt(3);
		l2.next = new LinkedListt(4);
		l1.next.next = new LinkedListt(5);
		l2.next.next = l1.next.next;
		l1.next.next.next = new LinkedListt(6);
		l2.next.next.next = new LinkedListt(7);
		l1.next.next.next.next = new LinkedListt(8);
		l2.next.next.next.next = new LinkedListt(9);
		
		long time = System.currentTimeMillis();
		
		l1 = head1;
		l2 = head2;
		System.out.print("List 1->>> ");
		while(l1!=null)
		{
			System.out.print(l1.data + " ");
			l1 = l1.next;
		}
		System.out.println();
		System.out.print("List 2->>> ");
		while(l2!=null)
		{
			System.out.print(l2.data + " ");
			l2 = l2.next;
		}
		
		l1 = head1;
		l2 = head2;
		
		int flag = 0;
		while(l1!=null)
		{
			l2=head2;
			while(l2!=null && flag == 0)
			{
				//System.out.println("Matching "+l1.data+" and "+l2.data);
				if(l1 == l2)
				{
					//System.out.println("Intersection Found");
					flag = 1;
					break;
				}
				
				l2 = l2.next;
			}
			if(flag == 1)
				break;
			l1 = l1.next;
		}
		System.out.println("\nFirst Method ->>");
		System.out.println("here at node "+l1.data);
		
		System.out.println("Time taken :: "+(System.currentTimeMillis()-time));
		
/*-----------------------------------------------------------------------------------------------*/
									/*Second Approach*/
									 /*Use a HashMap*/
/*-----------------------------------------------------------------------------------------------*/
		time = System.currentTimeMillis();
		HashSet<LinkedListt> set = new HashSet<LinkedListt>();
		
		l1 = head1;
		
		while(l1!=null)
		{
			//System.out.println("Adding "+l1.data);
			set.add(l1);
			l1 = l1.next;
		}
		flag = 0;
		l2 = head2;
		while(l2!=null)
		{
			//System.out.println("Matching "+l2.data + " ");
			if(set.contains(l2))
			{
				flag = 1;
				break;
			}
			l2 = l2.next;
		}
		
		System.out.println("Second Method ->>");
		if(flag==1)
			System.out.println("Intersection point is "+l2.data);
		else
			System.out.println("No Intersection Found!!");
		
		System.out.println("Time taken :: "+(System.currentTimeMillis()-time));
		
/*----------------------------------------------------------------------------------------------------------------*/
											/*Third Approach*/
/*Chop off the extra nodes and traverse both the lists simultaneously and check if they match at any point*/
/*----------------------------------------------------------------------------------------------------------------*/

		time = System.currentTimeMillis();
		
		int lenDifference = head1.size - head2.size;
		LinkedListt smaller=null, larger=null;
		if(lenDifference > 0)
		{
			smaller = head2;
			larger = head1;
		}
		else if(lenDifference < 0)
		{
			smaller = head1;
			larger = head2;
		}
		else
		{
			smaller = head2;
			larger = head1;
		}
		
		
		while(lenDifference-- > 0)
		{
			larger = larger.next;
		}
		
		flag = 0;
		
		while(larger!=null && smaller!=null)
		{
			//System.out.println("Matching "+larger.data+" and "+smaller.data);
			if(larger==smaller)
			{
				flag =1;
				break;
			}
			larger = larger.next;
			smaller = smaller.next;
		}
		
		System.out.println("Third Method ->>");
		if(flag==1)
			System.out.println("Intersection point is "+smaller.data);
		else
			System.out.println("No Intersection Found!!");
		
		System.out.println("Time taken :: "+(System.currentTimeMillis()-time));
		
	}
}
