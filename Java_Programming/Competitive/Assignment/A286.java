package Assignment58;

import java.util.Scanner;

public class A286
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str = sobj.nextLine();

        int i = 0;
        int j = 0;
        int iCount = 0;

        for(i = 0; i < str.length(); i++)
        {
           if(str.indexOf(str.charAt(i)) == i)
           {
                for(j = 0; j < str.length(); j++)
                {
                    if(str.charAt(i) == str.charAt(j))
                    {
                        iCount++;
                    }
                }
                System.out.println(str.charAt(i) + " -> " + iCount);
           }
        }

        sobj.close();
    } 
}
