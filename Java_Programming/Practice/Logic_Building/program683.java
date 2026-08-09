

import java.io.*;
import java.util.Scanner;

public class program683
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        String Fname = null;
        File fobj = null;
        FileInputStream fiobj = null;

        int iRet = 0;

        System.out.println("Enter the file name : ");
        Fname = sobj.nextLine();
        
        fobj = new File(Fname);

        fiobj = new FileInputStream(fobj);
        
        byte Buffer[] = new byte[50];

        if(fobj.exists())
        {
            String str = null;

            while((iRet = fiobj.read(Buffer)) != -1)
            {
                str = new String(Buffer, 0, iRet);   // IMP

                System.out.print(str);

                str = null;
            }
        }
        else
        {
            System.out.println("There is no duch file");
        }
        
        sobj.close();
        fiobj.close();
    }
}

