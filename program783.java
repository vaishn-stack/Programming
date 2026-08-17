import java.util.*;

public class program783
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <String, Integer> hobj = new HashMap <String, Integer> ();

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        String Tokens[] = str.split(" ");

        for(String s : Tokens)
        {
            if(hobj.containsKey(s))
            {
                hobj.put(s, hobj.get(s) + 1);
            }
            else
            {
                hobj.put(s, 1);
            }
        }

        int iMax = 0;
        String temp = null;

        for(String sValue : hobj.keySet())
        {
            if(hobj.get(sValue) > iMax)
            {
                iMax = hobj.get(sValue);
                temp = sValue;
            }
        }

        System.out.println(temp + " occurs maximum number of time : " + iMax);

        sobj.close();
    }
}
