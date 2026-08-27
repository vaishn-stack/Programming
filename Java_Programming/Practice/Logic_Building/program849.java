import java.time.LocalDate;
import java.util.ArrayList;

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

    @Override
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

public class program849
{
    public static void main(String a[])
    {
       // Scanner sobj = new Scanner(System.in);

        LocalDate lobj = LocalDate.now();

        ArrayList <StudyLog>  Database = new ArrayList <StudyLog> ();
        
        StudyLog sobj1 = new StudyLog(lobj, "C Programming", 3.5, "Pointers in C");
        StudyLog sobj2 = new StudyLog(lobj, "C++ Programming", 3.5, "Pointers in C++");
        StudyLog sobj3 = new StudyLog(lobj, "Java Programming", 3.5, "Inheritance in Java");

        Database.add(sobj1);
        Database.add(sobj2);
        Database.add(sobj3);

        System.out.println(Database.size());

        for(StudyLog sobj : Database)
        {
            System.out.println(sobj);
        }

        Database.remove(1);

        System.out.println("After removal : ");

        for(StudyLog sobj : Database)
        {
            System.out.println(sobj);
        }
        
    }
}
