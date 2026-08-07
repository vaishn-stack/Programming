package Assignment51;

import java.io.File;
import java.util.Scanner;

public class A252
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter file name : ");
        String FileName = sobj.nextLine();

        File fobj = new File(FileName);

        if(fobj.exists())
        {
            if(fobj.isFile())
            {
                System.out.println("It is a regular file.");
            }
            else
            {
                System.out.println("It is not a regular file.");
            }
        }
        else
        {
            System.out.println("File does not exist.");
        }

        sobj.close();
    }
}