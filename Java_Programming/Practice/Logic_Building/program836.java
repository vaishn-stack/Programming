// project - study tracker
// Edutrack - ppa MarvellousResponseEntity

import java.util.ArrayList;
import java.util.Scanner;

public class program836
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

        aobj.remove(4);

        for(String str : aobj)
        {
            System.out.println(str);
        }

        aobj.clear();
        System.out.println(aobj);

        sobj.close();
    }
}
