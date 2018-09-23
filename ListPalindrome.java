package Personal;

import java.util.Stack;



public class ListPalindrome {
	
	static class Result{
		
		public LinkedListt node;
		public boolean result;
		
		Result(LinkedListt node,boolean result)
		{
			this.node = node;
			this.result = result;
		}
	}

	public static void main(String[] args) {
		
		/*1->2->3->3->3->2->1*/
		
		LinkedListt temp = new LinkedListt(1);
		LinkedListt head = temp;
		temp.next = new LinkedListt(2);
		temp.next.next = new LinkedListt(3);
		temp.next.next.next = new LinkedListt(3);
		temp.next.next.next.next = new LinkedListt(3);
		temp.next.next.next.next.next = new LinkedListt(2);
		temp.next.next.next.next.next.next = new LinkedListt(1);
		
		
		
/*--------------------------------------------------------------------------------------------------------------*/
								/*Reversing Approach*/
								  
		/*Page 163, CtCI*/
/*The key here is not reverse the entire list rather just reverse the first half and compare with the next half */
/*--------------------------------------------------------------------------------------------------------------*/

		long time = System.currentTimeMillis();
		temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
		
        LinkedListt rev = null;
		temp = head;
		LinkedListt temp2;
		
		while(temp!=null)
		{
			temp2 = temp.next;
			temp.next = rev;
			rev =temp;
			temp = temp2;
		}
		System.out.println();
		System.out.print("Reversed LL :");
		temp = rev;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();System.out.println();
        System.out.println();
        if(isPalindrom(head,rev))
        	System.out.println("Palindrom Lists");
        else
        	System.out.println("Not Palindrom Lists");
       
        System.out.println("Time taken :: "+(System.currentTimeMillis()-time));
        System.out.println();System.out.println();
        
/*--------------------------------------------------------------------------------------------------------------*/
        							/*Iterative Approach*/
        							/*Page 163, CtCI*/
/*--------------------------------------------------------------------------------------------------------------*/
        time = System.currentTimeMillis();
        System.out.println("Using Iterative method ::");
        
        LinkedListt fast, slow;
        fast = head;
        slow = head;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        while(fast!=null && fast.next!=null)
        {
        	stack.push(slow.data);
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
/*if the List length is of even length fast would be null, 
 *else if List is of odd length then fast wouldn't be null
 *Therefore if there is an odd length Skipping the middle character, as it doesn't matters in a case of a Palindrom*/
        if(fast!=null)
        {
        	slow = slow.next;
        }
        
        int flag =0;
        
        while(slow!=null)
        {
        	if(slow.data != stack.pop().intValue())
        	{
        		flag = 1;
        		break;
        	}
        	slow = slow.next;
        }
        
        if(flag==1)
        	System.out.println("Not a Palindrom!!");
        else
        	System.out.println("Its a palindrom!!");
        
        System.out.println("Time taken :: "+(System.currentTimeMillis()-time));
        System.out.println();System.out.println();
        
/*--------------------------------------------------------------------------------------------------------------*/
							/*Recursive  Approach*/
        					  /*Page 164, CtCI*/
/*--------------------------------------------------------------------------------------------------------------*/
        time = System.currentTimeMillis();
        System.out.println("Now using recursive approach");
        if(issPalindrome(head))
        	System.out.println("Palindrome list");
        else
        	System.out.println("Not a Palindrome list");
        
        System.out.println("Time taken :: "+(System.currentTimeMillis()-time));
        System.out.println();System.out.println();
        
	}
	
	static boolean issPalindrome(LinkedListt head)
	{
		int length = head.size;
		Result p = issPalindromeRecurse(head, length);
		return p.result;
	}
	
	static Result issPalindromeRecurse(LinkedListt head, int length)
	{
		if(head == null|| length<=0)
			return new Result(head,true);
		else if(length == 1)
			return new Result(head.next,true);
		
		Result res = issPalindromeRecurse(head.next,length-2);
		
		if(!res.result || res.node==null)
			return res;
		
		res.result = (head.data == res.node.data);
		
		res.node = res.node.next;
		
		return res;
	}
	
	static boolean isPalindrom(LinkedListt l1, LinkedListt l2)
	{
		while(l1!=null && l2!=null)
		{
			if(l1.data!=l2.data)
			{
				return false;
			}
			else
			{
				l1 = l1.next;
				l2 = l2.next;
			}
		}
		return true;
	}

}
