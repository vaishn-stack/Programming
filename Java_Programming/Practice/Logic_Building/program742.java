// Input - my name is amit
// Output - My Name Is Amit

// Input - my NAME is AmIt
// Output - My Name Is Amit

import java.util.*;

public class program742
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

        char Arr[] = str.toCharArray();

        for(int i = 0; i < Arr.length; i++)
        {
            if(Arr[i] == ' ')
            {
               if(Arr[i+1] >= 'a' && Arr[i+1] <= 'z')
               {
                    Arr[i+1] = (char)(Arr[i+1] - 32);
               }
            }
        }

        String output = new String(Arr);

        System.out.println("Updated string is : " + output);

        sobj.close();
    }
}


