package Personal;

import java.util.HashMap;
import java.util.Map;

/*
 * To insert an object as a key in a hashmap we need to override the equals() and hashcode() method of object class.
 * Because their default implementation always simply checks for reference equality, therefore it would always return false.
 * 
 */

public class ObjectsAsAKeyInAHashMap {
	
	public static void main(String[] args)
	{
		Map<CreditCard, String> m = new HashMap<CreditCard, String>();
	    m.put(new CreditCard(100), "4111111111111111");
	    
	    System.out.println("new CreditCard(599).equals(new CreditCard(599) : "+new CreditCard(599).equals(new CreditCard(599)));
	    
	    System.out.println(m.get(new CreditCard(100)));
	}

}

final class CreditCard {
	  private final int number;
	  
	  public CreditCard(int number) {
	    this.number = number;
	  }

	  public boolean equals(Object o) {
	    if (o == this) {
	      return true;
	    } 
	    if (!(o instanceof CreditCard)) {
	      return false;
	    }
	    CreditCard cc = (CreditCard)o;
	    return cc.number == number; 
	  }

	  public int hashCode() {
	    int result = 17;
	    result = 31 * result + number;
	    return result;
	  }
	}
