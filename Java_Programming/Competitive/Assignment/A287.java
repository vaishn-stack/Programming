package Assignment58;

import java.util.Scanner;

public class A287
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str = sobj.nextLine();

        String words[] = str.split(" ");

        int i = 0;
        
        for(String wobj : words)
        {
            for(i = wobj.length() - 1; i >= 0; i--)
            {
                System.out.println(wobj.charAt(i));
            }

            System.out.println(" ");
        }

        

        sobj.close();
    } 
}
