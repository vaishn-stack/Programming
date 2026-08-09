

import java.io.*;
import java.util.Scanner;

public class program671
{
    public static void main(String a[]) 
    {
        String Fname = null;
        Scanner sobj = new Scanner(System.in);

        File fobj = null;

        System.out.println("Enter the file name : ");
        Fname = sobj.nextLine();
        
        fobj = new File(Fname);

        if(fobj.exists())
        {
            System.out.println("File Name : " + fobj.getName());
            System.out.println("Absolute Path : " + fobj.getAbsolutePath());
            System.out.println("File Size : " + fobj.length());
        }
        else
        {
            System.out.println("There is no duch file");
        }
        
        sobj.close();
    }
}

