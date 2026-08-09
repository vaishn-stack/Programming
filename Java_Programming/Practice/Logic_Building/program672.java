

import java.io.*;
import java.util.Scanner;

public class program672
{
    public static void main(String a[]) 
    {
        Scanner sobj = new Scanner(System.in);

        String Fname = null;
        File fobj = null;
        FileOutputStream foobj = null;

        System.out.println("Enter the file name : ");
        Fname = sobj.nextLine();
        
        fobj = new File(Fname);

        // foobj = new FileOutputStream(fobj);

        String Data = "Marvellous Infosystems";

        if(fobj.exists())
        {
            // foobj.write(Data);   // Error
        }
        else
        {
            System.out.println("There is no duch file");
        }
        
       // foobj.close();
        sobj.close();
      
    }
}

