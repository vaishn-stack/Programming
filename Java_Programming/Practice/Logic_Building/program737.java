import java.util.*;

public class program737
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        System.out.println("Number of words : " + Tokens.length);

        int iMax = 0;
        String temp = null;

        for(int i = 0; i < Tokens.length; i++)
        {
            if(Tokens[i].length() >= iMax)   // same length che 2 words astil tr >= mule last word milto
            {
                iMax = Tokens[i].length();
                temp = Tokens[i];
            }
        }
        
        System.out.println("Largest word is  : " + temp + " having length : " + iMax);

        sobj.close();
    }
}


// imp for interview questions and tough questions