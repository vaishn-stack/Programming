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

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        for(int i = 0; i < Tokens.length; i++)
        {
            System.out.println(Tokens[i] + " : " + Tokens[i].length());


            if(Tokens.length > iMax)
            {
                iMax = Tokens[i].length();
            }

            System.out.println("Largest Word is : "+ iMax);     
        }
        
    }
}
public class program716
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        StringX strobj = new StringX();

        String str = null;

        //int iRet = 0;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        // iRet = strobj.CountWords(str);

        // System.out.println("Number of words are : " +iRet);

        // strobj.DisplayWords(str);

        strobj.LargestWord(str);
        
        sobj.close();
    }
}


// Imp for Interview