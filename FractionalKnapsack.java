package Personal;

public class FractionalKnapsack {

	public static void main(String[] args) {
		
		//MaxProfit = 54.6;
		
		double maxVal = 15;
		
		double profit[] = {10,5,15,7,6,18,3};
		double weight[] = {2 ,3,5 ,7,1,4 ,1};
		
		int l = profit.length;
		
		double ratio[] = new double[l];
		
		for(int i=0; i<l; i++)
		{
			ratio[i] = profit[i]/weight[i];
		}
		
		
		for(int i=0; i<l; i++)
		{
			System.out.print(ratio[i]+" ");
		}
		System.out.println();
		
		//Bubble Sort
		for(int i=0; i<l; i++)
		{
			for(int j=0; j<l-i-1; j++)
			{
				if(ratio[j]<ratio[j+1])
				{
					ratio[j] =  ( ratio[j]+ ratio[j+1])-( ratio[j+1]= ratio[j]);
					profit[j] = (profit[j]+profit[j+1])-(profit[j+1]=profit[j]);
					weight[j] = (weight[j]+weight[j+1])-(weight[j+1]=weight[j]);
				}
			}
		}
		
		for(int i=0; i<l; i++)
		{
			System.out.print(ratio[i]+" ");
		}
		
		System.out.println();
		
		int i=0; 
		double maxProfit = 0;
		while(maxVal>0)
		{
			if(maxVal>weight[i])
			{
			maxVal -= weight[i];
			maxProfit += profit[i];
			System.out.println("Adding profit :"+profit[i]+" and Subtracting weight :"+weight[i]);
			}
			else
			{
				maxProfit += (maxVal/weight[i])*profit[i];
				System.out.println("*Adding profit :"+(maxVal/weight[i])*profit[i]+" and Subtracting weight :"+weight[i]);
				maxVal = 0;
			}
			i++;
		}
		
		System.out.println("\nmaxProfit :"+maxProfit);
	}
}