package Personal;

public class SearchAWordInA2DMatrix {

	public static void main(String[] args) {

		char mat[][] = {  {'a','b','c','d','e','f','a'},//0
						  {'g','h','i','j','k','l','b'},//1
						  {'m','f','a','r','h','a','n'},//2
						  {'s','n','u','v','w','n','d'},//3
						  {'y','z','a','b','a','d','e'},//4
						  {'e','f','g','h','i','j','f'},//5
						  {'k','l','r','n','r','p','g'},//6
						  {'q','a','s','t','u','a','h'},//7
						  {'f','x','y','z','a','b','f'},//8
						};
		
		boolean ar[] = new boolean[10];
		
		String word = "farhan";
		
		System.out.println(mat.getClass().getName());
		
		findWords(mat, word.toLowerCase());
		
	}
	
	static void findWords(char mat[][],String word)
	{
		
		String direction[] = {"Left-UP-Diagonal","Upwards-Vertical","Right-UP-diagonal","Right-Horizontal",
							  "Left-Horizontal","Left-Down-Diagonal","Downwards-Vertical","Bottom-Right-Diagonal"};
		
		boolean flag = false;
		
		for(int i=0; i<mat.length; i++)
		{
			for(int j=0; j<mat[0].length; j++)
			{
				int x = searchMat(mat,i,j,word);
				if(x!=-1)
				{
					System.out.println("Found at ("+i+","+j+") in "+direction[x]+" direction!");
					flag = true;
				}
			}
		}
		if(!flag)
			System.out.println("Word Not Found!!");
	}

	private static int searchMat(char[][] mat, int i, int j, String word) {

		int x[] = {-1,-1,-1,0, 0, 1,1,1};
		int y[] = {-1, 0, 1,1,-1,-1,0,1};
		
		if(word.charAt(0)!=mat[i][j])
			return -1;
		
		for(int k=0; k<8; k++)
		{
			int currRow = i + x[k];
			int currCol = j + y[k];
			int p;
			for(p=1; p<word.length(); p++)
			{
				if(currRow<0 || currRow>=mat.length || currCol<0 || currCol>=mat[0].length)
					break;
				
				if(mat[currRow][currCol]!=word.charAt(p))
					break;
				
				currRow += x[k];
				currCol += y[k];
			}
			if(p==word.length())
				return k;
		}
		
		return -1;
	}

}
