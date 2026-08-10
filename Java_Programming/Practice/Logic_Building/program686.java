

import java.io.*;
import java.util.Scanner;

public class program686
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);
        String FolderName = null;

        System.out.println("Enter folder name : ");
        FolderName = sobj.nextLine();

        File fobj = new File(FolderName);

        if((fobj.exists()) && (fobj.isDirectory()))
        {
            System.out.println("Folder exists");
        }
        else
        {
            System.out.println("There is no such folder");
        }
        sobj.close();
    }
}

