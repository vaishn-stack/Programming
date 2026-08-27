import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

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

class StudyTracker
{
    public ArrayList <StudyLog> Database;

    public StudyTracker()
    {
        Database = new ArrayList <StudyLog>();
    }
}

public class program854
{
    public static void main(String a[]) 
    {
       StudyTracker stobj = new StudyTracker();

       
        
    }
}

