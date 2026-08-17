package Assignment58;

import java.util.Scanner;

public class A288
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str = sobj.nextLine();

        String words[] = str.split(" ");
        String longest = " ";

        for(String wobj : words)
        {
            if(wobj.length() > longest.length())
            {
                longest = wobj;
            }

            System.out.println(longest);
        }

        

        sobj.close();
    } 
}
