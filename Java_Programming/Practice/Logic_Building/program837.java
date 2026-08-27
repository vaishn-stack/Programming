// project - study tracker
// Edutrack - ppa MarvellousResponseEntity

import java.util.ArrayList;
import java.util.Scanner;

public class program837
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        ArrayList <String> aobj = new ArrayList <String> ();

        aobj.add("Pune");
        aobj.add("Nashik");
        aobj.add("Satara");
        aobj.add("Mumbai");
        aobj.add("Mumbai");

        if(aobj.contains("Satara"))
        {
            System.out.println("Satara is present in ArrayList");
        }


        sobj.close();
    }
}
