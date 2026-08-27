import java.util.Scanner;
import java.time.LocalDate;

class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public double Duration;
    public String Description;


    public StudyLog(LocalDate a, String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }
}

public class program841
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        LocalDate lobj = LocalDate.now();

        StudyLog sobj1 = new StudyLog(lobj, "C Programming", 3.5, "Pointers in C");
        StudyLog sobj2 = new StudyLog(lobj, "Java Programming", 5.5, "Inheritance in Java");

        System.out.println(sobj1);
        System.out.println(sobj2);

        sobj.close();
    }
}
