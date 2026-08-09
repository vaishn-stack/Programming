

import java.io.*;
import java.util.Scanner;

public class program676
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        String Fname = null;
        File fobj = null;
        FileOutputStream foobj = null;

        System.out.println("Enter the file name : ");
        Fname = sobj.nextLine();
        
        fobj = new File(Fname);

        foobj = new FileOutputStream(fobj);

        String Data = "Marvellous Infosystems";

        byte Arr[] = Data.getBytes();

        if(fobj.exists())
        {
            foobj.write(Arr);   
        }
        else
        {
            System.out.println("There is no duch file");
        }
        
        sobj.close();
        foobj.close();
    }
}

