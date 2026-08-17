import java.util.*;

public class program779
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

        int iCount = 0;

        for(String s : Tokens)
        {
            if(hobj.containsKey(s))
            {
                iCount = hobj.get(s);
                hobj.put(s, iCount + 1);
            }
            else
            {
                hobj.put(s, 1);
            }
        }

        System.out.println(hobj);



        sobj.close();
    }
}
