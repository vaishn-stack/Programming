package Assignment58;

import java.util.Scanner;

public class A291
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str1 = sobj.nextLine();

        System.out.println("Enter First String : ");
        String str2 = sobj.nextLine();

        if(str1.length() == str2.length() && (str1 + str1).contains(str2))
        {
            System.out.println("It is Rotation");
        }
        else
        {
            System.out.println("It is not Rotation");
        }
       
        

        sobj.close();
    } 
}
