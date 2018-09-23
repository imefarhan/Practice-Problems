package Personal;

import java.util.*;
public class LLPartition
{
    public static void main(String[] args)
    {

        /*  3->5->8->5->10->2->1  */
        
/*Linked-List Partiton, Problem=2.4, Page 64*/
        
 
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
        int x = 5, count=0;
        temp=head;
        LinkedListt temp2=new LinkedListt();

        while(temp.next!=null && count<=head.size)
        {
            count++;
            temp2 = temp.next;
            //System.out.println("inside while loop-"+count);

                if(temp2.data<x && temp.next!=null)
                {
                    if(temp2.next!=null)
                        temp.next = temp.next.next;
                    else
                        temp.next = null;
                    
                    temp2.next = head;
                    head = temp2;
                }
                else
                    temp = temp.next;
            
        }
        
         temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }               
        
    }
}