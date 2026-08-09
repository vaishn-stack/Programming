

import java.io.*;

public class program657
{
    public static void main(String a[]) 
    {
        try
        {
            File fobj = new File("Demo.txt");

            System.out.println(fobj.exists());     // return value - true or false
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }

    }
}

