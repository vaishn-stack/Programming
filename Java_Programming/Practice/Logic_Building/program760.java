// common question - collection

import java.util.*;

public class program760
{
    public static boolean CheckAnagram(String str1, String str2)
    {
        int i = 0;

        if(str1.length() != str2.length())
        {
            return false;
        }

        str1 = str1.trim();
        str1 = str1.replaceAll("\\s+", " ");
        str1= str1.toLowerCase();

        char Arr[] = str1.toCharArray();
        

        str2 = str2.trim();
        str2 = str2.replaceAll("\\s+", " ");
        str2= str2.toLowerCase();

        char Brr[] = str2.toCharArray();
        int Frequency[] = new int[26];

        for(i = 0; i < Brr.length; i++)
        {
            if(Arr[i] >= 'a' && Arr[i] <= 'z')
            {
                Frequency[(int)Arr[i] - 97]++;
            }

            if(Brr[i] >= 'a' && Brr[i] <= 'z')
            {
                Frequency[(int)Brr[i] - 97]--;
            }
        }
    
        boolean bFlag = true;

        for(i = 0; i < Frequency.length; i++)
        {
            if(Frequency[i] != 0)
            {
                bFlag = false;
                break;
            }
        }

        return bFlag;
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


