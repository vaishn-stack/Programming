// charAt() convert it into character array using tocharArray()
import java.util.*;

class StringX
{
    public int CountCapital(String str)
    {
        int i = 0;
        int iCount = 0;

        char Arr[] = str.toCharArray();

        for(i = 0; i < Arr.length; i++)
        {
            if((Arr[i] >= 'A') && (Arr[i] <= 'Z'))        // &&  short circuit evaluation
            {
                iCount++;
            }
        }

        return iCount;
    }

    public int CountSmall(String str)
    {
        int i = 0;
        int iCount = 0;
        char Arr[] = str.toCharArray();

        for(i = 0; i < Arr.length; i++)
        {
            if((Arr[i] >= 'a') && (Arr[i] <= 'z'))        // &&  short circuit evaluation
            {
                iCount++;
            }
        }

        return iCount;
    }
}

public class program272
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String data = null;
        StringX strobj = new StringX();
        int iRet = 0;

        System.out.println("Enter the String : ");
        data = sobj.nextLine();

        iRet = strobj.CountCapital(data);

        System.out.println("Number of capital characters : " + iRet);

        iRet = strobj.CountSmall(data);

        System.out.println("Number of Small characters : " + iRet);

        sobj.close();
    }
}