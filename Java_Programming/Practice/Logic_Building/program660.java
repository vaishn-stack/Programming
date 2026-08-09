

import java.io.*;

public class program660
{
    public static void main(String a[]) 
    {
        File fobj = null;               // reference

        boolean bRet = false;

        try
        {
            fobj = new File("Demo.txt");    // reference (pointer)

            bRet = fobj.exists();

            if(bRet == true)
            {
                System.out.println("File already Present.");
            }
            else
            {
                fobj.createNewFile();   

                System.out.println("File gets successfully created.");
            }   
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }

    }
}

