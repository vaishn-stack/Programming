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
            System.out.println(Tokens[i] + " : " + Tokens[i].length());
        }
    }

    void LargestWord(String str)
    {
        int iMax = 0;
        String temp = null;

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        for(int i = 0; i < Tokens.length; i++)
        {
            System.out.println(Tokens[i] + " : " + Tokens[i].length());

            if(Tokens.length > iMax)
            {
                iMax = Tokens[i].length();
                temp = Tokens[i];
            }

            System.out.println("Largest Word is : "+ iMax);     
            System.out.println("Largest Word is : "+ temp);     
        }
    }

    int PatternMatching(String str, String word)
    {
        int iCount = 0;

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        for(int i = 0; i < Tokens.length; i++)
        {
           if(word.equals(Tokens[i]))
           {
                iCount++;
           }
        }
        return iCount;
    }
}
public class program718
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        StringX strobj = new StringX();

        String str = null;

        int iRet = 0;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        iRet = strobj.PatternMatching(str,"are");

        System.out.println("Frequency of the word is : " + iRet);
        
        
        sobj.close();
    }
}


// Imp for Interview