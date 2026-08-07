package Assignment51;

import java.io.File;
import java.util.Scanner;

public class A255
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter directory name : ");
        String DirName = sobj.nextLine();

        File dobj = new File(DirName);

        if(dobj.exists() && dobj.isDirectory())
        {
            File Arr[] = dobj.listFiles();

            System.out.println("Files and their sizes are : ");

            for(int i = 0; i < Arr.length; i++)
            {
                if(Arr[i].isFile())
                {
                    System.out.println(
                        Arr[i].getName()
                        + " : "
                        + Arr[i].length()
                        + " bytes"
                    );
                }
            }
        }
        else
        {
            System.out.println("Directory does not exist.");
        }

        sobj.close();
    }
}
