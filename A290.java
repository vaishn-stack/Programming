package Assignment58;

import java.util.Scanner;

public class A290
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter First String : ");
        String str = sobj.nextLine().toLowerCase();

        int vowels = 0, consonants = 0;
        char ch = '\0';
        int i = 0;

        for(i = 0; i < str.length(); i++)
        {
            ch = str.charAt(i);

            if(ch >= 'a' && ch <= 'z')
            {
                if(ch == 'a' || ch == 'b' || ch == 'i' || ch == 'o' || ch == 'u')
                {
                    vowels++;
                }
                else
                {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels : "+ vowels);
        System.out.println("Consonants : "+ consonants);
        

        sobj.close();
    } 
}
