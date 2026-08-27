import java.util.*;

class program865
{
    public static void main(String[] args) 
    {
        TreeMap <Integer, String> hobj = new TreeMap<Integer, String>();

        hobj.put(20, "C Programming");
        hobj.put(10, "Java Programming");
        hobj.put(30, "C Programming");

        System.out.println(hobj);

        System.out.println(hobj.firstKey());
        System.out.println(hobj.lastKey());

        System.out.println(hobj.firstEntry());
        System.out.println(hobj.lastEntry());

    }
}