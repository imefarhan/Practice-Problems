package Personal;

public class LastKthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*        /*  3->5->8->5->10->2->1  */
		        LinkedListt head;
		        LinkedListt temp = new LinkedListt(3);
		        head = temp;
		        temp.next = new LinkedListt(5);
		        temp.next.next = new LinkedListt(8);
		        temp.next.next.next = new LinkedListt(5);
		        temp.next.next.next.next = new LinkedListt(10);
		        temp.next.next.next.next.next = new LinkedListt(2);
		        temp.next.next.next.next.next.next = new LinkedListt(1);
		        
		        temp = head;
		        while(temp!=null){
		            System.out.print(temp.data+" ");
		            temp=temp.next;
		        }
		        
		        System.out.println();
		 
//		 Last 3rd element of an Array
		        
		        temp=head;
		        int count = 0;
		        while(temp!=null && count<3){
		            //System.out.print(temp.data+" ");
		            temp=temp.next;
		            count++;
		        }
		        
		        while(temp!=null)
		        {
		            temp=temp.next;
		            head=head.next;
		        }
		        System.out.println("last 3rd :"+head.data);
		
		        
	}

}
