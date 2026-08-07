package Assignment50;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class A247
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter file name : ");
        String FileName = sobj.nextLine();

        File fobj = new File(FileName);

        if(fobj.exists() && fobj.isFile())
        {
            try
            {
                FileInputStream fiobj =
                    new FileInputStream(fobj);

                int Data;

                System.out.println("File contents are : ");

                while((Data = fiobj.read()) != -1)
                {
                    System.out.print((char)Data);
                }

                fiobj.close();
            }
            catch(Exception e)
            {
                System.out.println("Exception occurred : " + e);
            }
        }
        else
        {
            System.out.println("File does not exist.");
        }

        sobj.close();
    }
}