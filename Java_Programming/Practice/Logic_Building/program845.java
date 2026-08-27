import java.util.Scanner;
import java.time.LocalDate;

/* Class Object
{
    public String toString()
    {
    }
}
*/

// class StudyLog extends Object
class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private double Duration;
    private String Description;


    public StudyLog(LocalDate a, String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }

    // Override
    public String toString()
    {
        return Date + " | " + Subject + " | " + Duration + " | " + Description;
    }

    // getter
    public LocalDate getDate()
    {
        return this.Date;
    }

    public String getSubject()
    {
        return this.Subject;
    }

    public double getDuration()
    {
        return this.Duration;
    }

    public String getDescription()
    {
        return this.Description;
    }
}

public class program845
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        LocalDate lobj = LocalDate.now();

        StudyLog sobj1 = new StudyLog(lobj, "C Programming", 3.5, "Pointers in C");

        System.out.println(sobj1.Duration);     // error
        
        System.out.println(sobj1.getDate());
        System.out.println(sobj1.getSubject());
        System.out.println(sobj1.getDuration());
        System.out.println(sobj1.getDescription());

        sobj.close();
    }
}
