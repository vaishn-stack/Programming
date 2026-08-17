package Assignment57;

import java.util.Scanner;

public class A284
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str = sobj.nextLine().toLowerCase();

        boolean bflag = true;
        char ch = '\0';

        for(ch = 'a'; ch <= 'z'; ch++)
        {
            if(str.indexOf(ch) == -1)
            {
                bflag = false;
                break;
            }
        }

        if(bflag)
        {
            System.out.println("It is a Pangram");
        }
        else
        {
            System.out.println("It is not Pangram");
        }


    }
}
