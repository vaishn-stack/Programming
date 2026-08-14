// input - india is my country i live in india
// output - bharat is my country i live in bharat
// common question - collection

import java.util.*;

public class program753
{
    public static void main(String a[])
    {
        int i = 0;

        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        char Arr[] = str.toCharArray();

        int Frequency[] = new int[26];

        // for(i = 0; i < Frequency.length; i++)
        // {
        //     Frequency[i] = 0;
        // }

        // a  b  c   d
        // 97 98 99 100
        // 0   1  2  3   
        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] >= 'a' && Arr[i] <= 'z')
            {
                Frequency[(int)Arr[i] - 97]++;
            }
        }

        System.out.println("Frequency of each letter is : ");

        for(i = 0; i < Frequency.length; i++)
        {
            System.out.println((char)(i + 97)+ " : " + Frequency[i]);
        }
        
        sobj.close();
    }
}


