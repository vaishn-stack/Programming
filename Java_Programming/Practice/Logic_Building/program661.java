

import java.io.*;

public class program661
{
    public static void main(String a[]) 
    {
        File fobj = null;               

        boolean bRet = false;

        try
        {
            fobj = new File("Demo.txt");   // access new creating file

            bRet = fobj.exists();

            if(bRet == true)
            {
                fobj.delete();     // file delete krto

                System.out.println("File gets deleted.");
            }
            else
            {
                System.out.println("There is no such file.");
            }   
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }

    }
}

