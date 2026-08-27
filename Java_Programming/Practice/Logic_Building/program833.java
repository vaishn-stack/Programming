// project - study tracker
// Edutrack - ppa MarvellousResponseEntity

import java.util.ArrayList;
import java.util.Scanner;

public class program833
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        int i = 0;

        ArrayList <Integer> aobj = new ArrayList <Integer> ();

        aobj.add(11);
        aobj.add(21);
        aobj.add(51);
        aobj.add(101);
        aobj.add(51);

        for(i = 0; i < aobj.size(); i++)
        {
            System.out.println(aobj.get(i));
        }


        sobj.close();
    }
}
