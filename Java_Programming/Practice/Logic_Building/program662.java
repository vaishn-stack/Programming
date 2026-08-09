

import java.io.*;
import java.util.Scanner;

public class program662
{
    public static void main(String a[]) 
    {
        File fobj = null;               

        boolean bRet = false;

        String Fname = null;

        Scanner sobj = null;

        sobj = new Scanner(System.in);

        System.out.println("Enter the file name : ");
        Fname = sobj.nextLine();

        try
        {
            fobj = new File(Fname);  

            bRet = fobj.exists();

            if(bRet == true)
            {
                fobj.delete();     

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
        sobj.close();
    }
}

