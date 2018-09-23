package Personal;

public class AllPossibleEquationFromAGivenStringOfNumbers {

	public static void main(String[] args) {

		String str = "123";
		int target = 7;
		
		printAll(str,"",0,0,0,target);

	}

	private static void printAll(String str, String res, int index, int currVal, int lastVal, int target) {

		if(index==str.length())
		{
			//Currently printing all the possible expressions. Update the condition to print those values with target sum.
			System.out.println(res+" = "+currVal);
			return;
		}
		
		for(int i=index; i<str.length(); i++)
		{
			//Checking if the number starts with zero.
			if(i!=index && str.charAt(index)=='0')
				return;
			
			int start = Integer.parseInt(str.substring(index,i+1));
			
			if(index==0)
				printAll(str,res+start,i+1,currVal+start,start,target);
			else
			{
				printAll(str,res+"+"+start,i+1,currVal+start,start,target);
				
				printAll(str,res+"-"+start,i+1,currVal-start,start,target);
				
				//We require the "last" variable for the case of multiplication. 
				//If we simply multiply it to the "currVal" the desired value of the expression would change 
				//because multiplication has a precedence over other operators within an equation.
				printAll(str,res+"*"+start,i+1,currVal-lastVal+lastVal*start,lastVal*start,target);
			}
		}
	}
}
