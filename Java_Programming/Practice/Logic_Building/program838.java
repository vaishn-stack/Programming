// project - study tracker - project start
// Edutrack - ppa MarvellousResponseEntity

import java.util.ArrayList;
import java.util.Scanner;

class StudyLog
{
    public String Subject;
    public double Duration;

    public StudyLog(String a, double d)
    {
        this.Subject = a;
        this.Duration = d;
    }

}

public class program838
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        StudyLog sobj1 = new StudyLog("C", 2.5);
        StudyLog sobj2 = new StudyLog("Java", 4.5);

        System.out.println(sobj1);
        System.out.println(sobj2);



        sobj.close();
    }
}
