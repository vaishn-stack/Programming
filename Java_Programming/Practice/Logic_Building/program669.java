

import java.io.*;

public class program669
{
    public static void main(String a[]) 
    {
        FileReader frobj = null;
        char Buffer[] = new char[10];

        try
        {
            frobj = new FileReader("Demo.txt");   

            frobj.read(Buffer);   
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

