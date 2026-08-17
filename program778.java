import java.util.*;

public class program778
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <String, Integer> hobj = new HashMap <String, Integer> ();

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        String Tokens[] = str.split(" ");

        for(String s : Tokens)
        {
            System.out.println(s);
        }



        sobj.close();
    }
}
