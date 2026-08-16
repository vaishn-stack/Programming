// common question - collection

import java.util.*;

public class program756
{
    public static boolean CheckAnagram(String str1, String str2)
    {
        return true;
    }
    public static void main(String a[])
    {

        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str1 = sobj.nextLine();

        System.out.println("Enter Second String : ");
        String str2 = sobj.nextLine();

        boolean bRet = false;

        bRet = CheckAnagram(str1, str2);

        if(bRet == true)
        {
            System.out.println("Strings are Anagram");
        }
        else
        {
            System.out.println("Strings are not Anagram");
        }
        

        sobj.close();
    }
}


