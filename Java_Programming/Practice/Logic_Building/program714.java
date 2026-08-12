import java.util.Scanner;

class StringX
{
    int CountWords(String str)
    {
        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        return Tokens.length;
    }

    void DisplayWords(String str)
    {
        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        for(int i = 0; i < Tokens.length; i++)
        {
            System.out.println(Tokens[i]);
        }
    }
}
public class program714
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        StringX strobj = new StringX();

        String str = null;

        int iRet = 0;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        iRet = strobj.CountWords(str);

        System.out.println("Number of words are : " +iRet);

        strobj.DisplayWords(str);
        
        sobj.close();
    }
}


// Imp for Interview