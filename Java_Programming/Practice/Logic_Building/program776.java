import java.util.*;

public class program776
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <Character, Integer> hobj = new HashMap <Character, Integer> ();

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        char Arr[] = str.toCharArray();

        int iCount = 0;

        for(char ch : Arr)
        {
            if(hobj.containsKey(ch))
            {
                iCount = hobj.get(ch);
                hobj.put(ch, iCount + 1);
            }
            else
            {
                hobj.put(ch, 1);
            }
        }

        char Brr[] = new char[hobj.size()];

        int i = 0;

        for(char cValue : hobj.keySet())
        {
            Brr[i] = cValue;
            i++; 
        }
        System.out.println(new String(Brr));

        sobj.close();
    }
}
