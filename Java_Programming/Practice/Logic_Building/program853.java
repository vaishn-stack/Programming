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

public class program853
{
    public static void main(String a[]) 
    {
       LocalDate lobj = LocalDate.now();

       StudyLog s1 = new StudyLog(lobj, "C Programming", 4.5, "Revision of pointers");
       StudyLog s2 = new StudyLog(lobj, "C++ Programming", 4.5, "Revision of pointers");
       StudyLog s3 = new StudyLog(lobj, "Java Programming", 4.5, "Revision of pointers");
       StudyLog s4 = new StudyLog(lobj, "Python Programming", 4.5, "Revision of pointers");

       ArrayList <StudyLog> Database = new ArrayList<StudyLog>();

        Database.add(s1);
        Database.add(s2);
        Database.add(s3);
        Database.add(s4);

        for(StudyLog s : Database)
        {
            System.out.println(s);
        }

        String FileName = "Marvellous_Study_Log.csv";

        try(FileWriter fwobj = new FileWriter(FileName))
        {
            fwobj.write("Date, Subject, Duration, Description\n");

            for(StudyLog s : Database)
            {
                fwobj.write(s.getDate() + "," + 
                    s.getSubject() + "," + 
                    s.getDuration() + "," + 
                    s.getDescription() + "\n"
                );
            }

            fwobj.close();
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }

        

        Database.clear();
        Database = null;

        System.gc();
        
    }
}

