// Input - my name is amit
// Output - My Name Is Amit

// Input - my NAME is AmIt
// Output - My Name Is Amit

import java.util.*;

public class program740
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        str = str.toLowerCase();

        System.out.println(str);
        

        sobj.close();
    }
}


