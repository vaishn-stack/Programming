package Assignment51;

import java.io.File;
import java.util.Scanner;

public class A253
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter directory name : ");
        String DirName = sobj.nextLine();

        File dobj = new File(DirName);

        if(dobj.exists())
        {
            System.out.println("Directory already exists.");
        }
        else
        {
            if(dobj.mkdir())
            {
                System.out.println("Directory created successfully.");
            }
            else
            {
                System.out.println("Unable to create directory.");
            }
        }

        sobj.close();
    }
}
