/*Recently you went to a magic show. You were very impressed by one of the tricks, so you decided to try to figure out the secret behind it!

The magician starts by arranging 16 cards in a square grid: 4 rows of cards, with 4 cards in each row. 
Each card has a different number from 1 to 16 written on the side that is showing. 
Next, the magician asks a volunteer to choose a card, and to tell him which row that card is in.

Finally, the magician arranges the 16 cards in a square grid again, possibly in a different order. 
Once again, he asks the volunteer which row her card is in. 
With only the answers to these two questions, the magician then correctly determines which card the volunteer chose. Amazing, right?

You decide to write a program to help you understand the magician's technique. 
The program will be given the two arrangements of the cards, 
and the volunteer's answers to the two questions: the row number of the selected card in the first arrangement, 
and the row number of the selected card in the second arrangement. 
The rows are numbered 1 to 4 from top to bottom.

Your program should determine which card the volunteer chose; or if there is more than one card the volunteer might 
have chosen (the magician did a bad job); 
or if there's no card consistent with the volunteer's answers (the volunteer cheated).

Input Format:

The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line containing an 
integer: the answer to the first question. 
The next 4 lines represent the first arrangement of the cards: each contains 4 integers, separated by a single space. 
The next line contains the answer to the second question, 
and the following four lines contain the second arrangement in the same format.
Constraints

1 = T = 100.
1 = both answers = 4.
Each number from 1 to 16 will appear exactly once in each arrangement.
Output Format

For each test case, output one line containing "x: y", where x is the test case number (starting from 1).

If there is a single card the volunteer could have chosen, y should be the number on the card. If there are multiple cards the volunteer could have chosen, y should be "Bad magician!", without the quotes. If there are no cards consistent with the volunteer's answers, y should be "Volunteer cheated!", without the quotes. The text needs to be exactly right, so consider copying/pasting it from here.

Sample Input 0

3
2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
3
1 2 5 4
3 11 6 15
9 10 7 12
13 14 8 16
2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
3
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Sample Output 0

1: 7
2: Bad magician!
3: Volunteer cheated!
*/

package Personal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class magician {
	/*
	 * We just need to find the common numbers in both the rows
	 * If only one common number than it means that is the number volunteer selected.
	 * If no common numbers, it means volunteer cheated
	 * If more than one common numbers, its a bad magician ??
	 */
	public String getCard(int firstAnswer, ArrayList<ArrayList<Integer>> firstMatrix, int seconAnswer, ArrayList<ArrayList<Integer>> secondMatrix){
		ArrayList<Integer> intersection = getIntersection(firstMatrix.get(firstAnswer-1), secondMatrix.get(seconAnswer-1));
		
		if(intersection.size() == 1){
			return intersection.get(0)+"";
		}
		if(intersection.size() == 0){
			return "Volunteer cheated!";
		}
		return "Bad magician!";
	}
	
	public ArrayList<Integer> getIntersection(ArrayList<Integer> firstRow, ArrayList<Integer> secondRow){
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		Set<Integer> numberSet =new HashSet<Integer>();
		
		for(Integer num: firstRow){
			numberSet.add(num);
		}
		
		for(Integer num: secondRow){
			if(numberSet.contains(num)){
				intersection.add(num);
			}
		}
		
		return intersection;
	}
	
	public static void main(String[] argv) {
		try {
			long startTime = System.currentTimeMillis();
			Reader reader = new FileReader("small.in");
			BufferedReader bufReader = new BufferedReader(reader);
			String x = bufReader.readLine();
			int numOfTestCases = Integer.parseInt(x);
			int count = 0;
	
			File file = new File("small.out");
			FileWriter writer = new FileWriter(file);
			for(count =1; count<= numOfTestCases; count++) {
				String y = bufReader.readLine();
				int firstAnswer = Integer.parseInt(y);
				ArrayList<ArrayList<Integer>> firstMatrix = new ArrayList<ArrayList<Integer>>();
				firstMatrix.add(getIntegerList(bufReader.readLine()));
				firstMatrix.add(getIntegerList(bufReader.readLine()));
				firstMatrix.add(getIntegerList(bufReader.readLine()));
				firstMatrix.add(getIntegerList(bufReader.readLine()));
				
				String z = bufReader.readLine();
				int secondAnswer = Integer.parseInt(z);
				
				ArrayList<ArrayList<Integer>> secondMatrix = new ArrayList<ArrayList<Integer>>();
				secondMatrix.add(getIntegerList(bufReader.readLine()));
				secondMatrix.add(getIntegerList(bufReader.readLine()));
				secondMatrix.add(getIntegerList(bufReader.readLine()));
				secondMatrix.add(getIntegerList(bufReader.readLine()));
				
				
				String output = new magician().getCard(firstAnswer, firstMatrix, secondAnswer, secondMatrix);
				writer.write("Case #" + count + ": " + output+"\n");
				System.out.println("Case #" + count + ": " + output);
			}
			writer.close();
			System.out.println("Total time = " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<Integer> getIntegerList(String s) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		String[] strArr = s.split(" ");
		for (String str : strArr) {
			intList.add(Integer.parseInt(str.trim()));
		}
		return intList;
	}
}