package Assignment57;

import java.util.Arrays;
import java.util.Scanner;

public class A283
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str1 = sobj.nextLine();

        System.out.println("Enter Second String : ");
        String str2 = sobj.nextLine();

        char a[] = str1.toCharArray();
        char b[] = str2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        if(Arrays.equals(a, b))
        {
            System.out.println("It is a Anagram");
        }
        else
        {
            System.out.println("It is not Anagram");
        }


    }
}
