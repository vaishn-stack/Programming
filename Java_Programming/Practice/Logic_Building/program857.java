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

    public void InsertLog()
    {

    }

    public void DisplayLog()
    {
        
    }

    public void ExportToCSV()
    {
        
    }

    public void SummaryByDate()
    {
        
    }

    public void SummaryBySubject()
    {
        
    }

}

public class program857
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

            System.out.println("1 : Insert new Study Log");
            System.out.println("2 : View all StudyLog");
            System.out.println("3 : Export Study Log to CSV");
            System.out.println("4 : Summary of Study Log by Date");
            System.out.println("5 : Summary of Study Log by Subject");
            System.out.println("6 : Exit the Application");

            System.out.println("----------------------------------------------------------------------------------\n");

            iChoice = sobj.nextInt();
            
            
        } while(iChoice != 6);

        switch(iChoice)
        {
            // Insert new Log
            case 1: 
                stobj.InsertLog();
                break;
                
            // View all study Log
            case 2: 
                stobj.DisplayLog();
                break;

            // Export Study Log to CSV
            case 3: 
                stobj.ExportToCSV();
                break;

            // Summary of Study Log by Date
            case 4: 
                stobj.SummaryByDate();
                break;

            // Summary of Study Log by Subject
            case 5: 
                stobj.SummaryBySubject();
                break;

            // Terminate the project
            case 6: 

                break;

            default : 
            System.out.println("Please Enter valid Option");
            
        }


        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println("---------------------------Thank for using Study Tracker--------------------------\n");
        System.out.println("----------------------------------------------------------------------------------\n");
    }
    // End of main
} // End of class

// maximum subject study add
