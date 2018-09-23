package Personal;
import java.util.*;
public class LinkedListt
{
    public LinkedListt head, next, prev, last;
    public int data;
    public static int size=0;
    
    LinkedListt(int d)
    {
        data = d;
        size++;
    }
    
    LinkedListt()
    {
        data = '\0';
        next = null;
    }

}
