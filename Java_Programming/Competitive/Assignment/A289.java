package Assignment58;

import java.util.Scanner;

public class A289
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str = sobj.nextLine();

        String result = "";
        char ch = '\0';
        int i = 0;

        for(i = 0; i < str.length(); i++)
        {
            ch = str.charAt(i);

            if(result.indexOf(ch) == -1)
            {
                result = result + ch;
            }
        }

        System.out.println(result);
        

        sobj.close();
    } 
}
