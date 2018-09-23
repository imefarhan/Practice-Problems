package Personal;

import java.util.HashSet;

public class CircularStartPoint {

	public static void main(String[] args) {
		
		LinkedListt temp = new LinkedListt(1);
		LinkedListt head = temp;
		temp.next = new LinkedListt(2);
		temp.next.next = new LinkedListt(3);
		temp.next.next.next = new LinkedListt(4);
		temp.next.next.next.next = new LinkedListt(5);
		temp.next.next.next.next.next = new LinkedListt(6);
		temp.next.next.next.next.next.next = temp.next.next;
		
//		System.out.println("Circular List :");
//		while(temp!=null){
//			System.out.println("temp.data->"+temp.data);
//			temp = temp.next;
//		}
		
		int flag = 0;
		HashSet<LinkedListt> set = new HashSet<LinkedListt>();
		temp =head;
		while(temp!=null){
		System.out.println("temp.data->"+temp.data);
		if(!set.contains(temp))
		set.add(temp);
		else
		{
			flag =1;
			break;
		}
		temp = temp.next;
		}
		
		if(flag==1)
			System.out.println("The Circular start point is "+temp.data);
		else
			System.out.println("No Circulation available!!");

	}

}
