

import java.io.*;

public class program659
{
    public static void main(String a[]) 
    {
        try
        {
            File fobj = new File("Demo.txt");

            boolean bRet = false;

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

