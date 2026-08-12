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
}
public class program713
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

        sobj.close();
    }
}


// Imp for Interview