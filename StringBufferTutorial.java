package Personal;

import java.lang.StringBuffer;

public class StringBufferTutorial {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("String Buffer Tutorial");
		System.out.println("Original String                                  : "+sb.toString());
		
		sb.insert(14,"Insertion ",0,10);
		System.out.println("using sb.insert(14,\"Insertion \",0,10) String->>> : "+sb.toString());
		
		sb = new StringBuffer("String Buffer Tutorial");
		sb.append("xyzAppend",3,9);
		System.out.println("using sb.append(\"xyzAppend\",3,9)          ->>> : "+sb.toString());
		
		sb = new StringBuffer("String Buffer Tutorial");
		int y = sb.indexOf("t");
		System.out.println("using sb.indexOf(\"t\")                     ->>> : "+y);
		
		sb = new StringBuffer("String Buffer Tutorial");
		int x = sb.lastIndexOf("t");
		System.out.println("using sb.lastIndexOf(\"t\")                 ->>> : "+x);
		
		sb = new StringBuffer("String Buffer Tutorial");
		sb.reverse();
		System.out.println("using sb.reverse()                        ->>> : "+sb.toString());
		
		sb = new StringBuffer("String Buffer Tutorial");
		String str = sb.substring(7,14);
		System.out.println("using sb.substring(7,14)                  ->>> : "+str);
		
		sb = new StringBuffer("String Buffer Tutorial");
		sb.setCharAt(10, 'F');
		System.out.println("using sb.setCharAt(10,'F')                ->>> : "+sb.toString());
		
		sb = new StringBuffer("String Buffer Tutorial");
		sb.replace(7, 13, "BUFFER");
		System.out.println("using sb.replace(7, 13, \"BUFFER\")         ->>> : "+sb.toString());
		
	}

}
