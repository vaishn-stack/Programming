

import java.io.*;

public class program670
{
    public static void main(String a[]) 
    {
        FileReader frobj = null;
        char Buffer[] = new char[20];

        try
        {
            frobj = new FileReader("Demo.txt");   

                        // offset length
            frobj.read(Buffer, 3, 10);   
            System.out.println(Buffer);
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        finally
        {
            
        }
    }
}

