import java.time.LocalDate;
import java.io.*;
import java.util.*;

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

public class program856
{
    public static void main(String a[]) 
    {
        int iChoice = 0;

        Scanner sobj = new Scanner(System.in);
        StudyTracker stobj = new StudyTracker();

        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println("------------------------Welcome to Marvellous Study Tracker-----------------------\n");
        System.out.println("----------------------------------------------------------------------------------\n");

        // Shell to interact with end user
        
        do
        {
            System.out.println("----------------------------------------------------------------------------------\n");
            System.out.println("Please selct appropriate option : \n");
            System.out.println("----------------------------------------------------------------------------------\n");

            System.out.println("1 : Insert new Study Log \n");
            System.out.println("2 : View all StudyLog \n");
            System.out.println("3 : Export Study Log to CSV \n");
            System.out.println("4 : Summary of Study Log by Date \n");
            System.out.println("5 : Summary of Study Log by Subject \n");
            System.out.println("6 : Exit the Application \n");

            System.out.println("----------------------------------------------------------------------------------\n");

            iChoice = sobj.nextInt();

            
        } while(iChoice != 6);


        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println("---------------------------Thank for using Study Tracker--------------------------\n");
        System.out.println("----------------------------------------------------------------------------------\n");

       
        
    }
}

