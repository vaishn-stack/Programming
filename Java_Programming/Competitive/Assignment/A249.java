package Assignment50;

import java.io.File;
import java.util.Scanner;

public class A249
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter file name : ");
        String FileName = sobj.nextLine();

        File fobj = new File(FileName);

        if(fobj.exists())
        {
            System.out.println("File already exists.");
        }
        else
        {
            try
            {
                if(fobj.createNewFile())
                {
                    System.out.println("File created successfully.");
                }
                else
                {
                    System.out.println("Unable to create file.");
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception occurred : " + e);
            }
        }

        sobj.close();
    }
}