package Assignment57;

import java.util.Scanner;

public class A282
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String rev = "";
        int i = 0;

        System.out.println("Enter the String : ");
        String str = sobj.nextLine();

        for(i = str.length() - 1; i >= 0; i--)
        {
            rev = rev + str.charAt(i);
        }

        if(str.equals(rev))
        {
            System.out.println("It is a Palindrome String");
        }
        else
        {
            System.out.println("It is not Palindrome String");
        }



    }
}
