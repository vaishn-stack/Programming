
import java.util.*;

public class program276
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String data = null;
        program281 strobj = new program281();                 // Error
        int iRet = 0;

        System.out.println("Enter the String : ");
        data = sobj.nextLine();

        iRet = strobj.CountCapital(data);

        System.out.println("Number of capital characters : " + iRet);

        iRet = strobj.CountSmall(data);

        System.out.println("Number of Small characters : " + iRet);

        iRet = strobj.CountDigits(data);

        System.out.println("Number of digits are : " + iRet);

        iRet = strobj.CountSpace(data);

        System.out.println("Number of spaces are : " + iRet);

        iRet = strobj.CountSpecial(data);

        System.out.println("Number of special symbols are : " + iRet);

        sobj.close();
    }
}

// string(), StringBuffer(), stringBuilder()