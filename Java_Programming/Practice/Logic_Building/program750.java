// input - india is my country i live in india
// output - bharat is my country i live in bharat
// common question

import java.util.*;

public class program750
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        int iCount = 0;

        for(int i = 0; i < Tokens.length; i++)
        {
            if(Tokens[i].equals("india"))
            {
                iCount++;
            }
        }
        
        System.out.println("Frequency of word is : " + iCount);
        
        sobj.close();
    }
}


