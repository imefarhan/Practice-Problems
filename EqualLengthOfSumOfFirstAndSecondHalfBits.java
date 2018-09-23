package Personal;

public class EqualLengthOfSumOfFirstAndSecondHalfBits {

	static int i=1;
	public static void main(String[] args) {

		int n = 4;
		
		printAll("",0,0,n);

	}

	private static void printAll(String res, int start, int end, int n) {

		if(res.length()>2*n)
			return;
		
		int diff = Math.abs(start-end);
		
		if((res.length()==2*n) && diff==0)
		{
			System.out.printf("%d )\t%s \tstart: %d end: %d\n",i++, res,start,end);
			return;
		}
		
		String temp = res;
		
		res = "1"+temp+"1";
		//res = "1"+temp;				//Find out why this statement is not being executed.
		printAll(res,start+1,end+1,n);
		
		res = "0"+temp+"0";
		//res = "0"+temp;
		printAll(res,start,end,n);
		
		res = "0"+temp+"1";
		//res = "0"+temp;
		printAll(res,start,end+1,n);
		
		res = "1"+temp+"0";
		//res = "1"+temp;
		printAll(res,start+1,end,n);
		
	}
}