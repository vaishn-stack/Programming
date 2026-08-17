import java.util.*;

public class program775
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

        int iMax = 0;
        char temp = '\0';

        for(char cValue : hobj.keySet())
        {
            System.out.println(cValue  + " occurs " + hobj.get(cValue) + " times");

            if(hobj.get(cValue) > iMax)
            {
                iMax = hobj.get(cValue);
                temp = cValue;
            }
        }

        System.out.println(temp + " occurs maximum time is : " + iMax);



        sobj.close();
    }
}
