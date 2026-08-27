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
        Database = new ArrayList<StudyLog>();
    }

    public void InsertLog()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println("------------------------Enter the details of your study---------------------------\n");
        System.out.println("----------------------------------------------------------------------------------\n");

        LocalDate lobj = LocalDate.now();

        System.out.println("We are entering the date as : " + lobj);

        System.out.println("Enter the Subject like C/C++/Java/Pyhon etc.");
        String sub = sobj.nextLine();

        System.out.println("Enter the time period of your Study : ");
        double dur = sobj.nextDouble();

        // Issue Resolved
        sobj.nextLine();

        System.out.println("Please provide the description of your study : ");
        String desc = sobj.nextLine();

        StudyLog studyobj = new StudyLog(lobj, sub, dur, desc);

        Database.add(studyobj);

        System.out.println("Study Log gets inserted Successfully!");

        System.out.println("----------------------------------------------------------------------------------\n");
    }

    public void DisplayLog()
    {
        System.out.println("----------------------------------------------------------------------------------\n");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to display - Database is Empty");
            System.out.println("----------------------------------------------------------------------------------\n");
            return;
        }

        System.out.println("Log Report of Marvellous Study Tracker");
        System.out.println("----------------------------------------------------------------------------------\n");

        for(StudyLog s : Database)
        {
            System.out.println(s);
        }

        System.out.println("----------------------------------------------------------------------------------\n");
    }

    public void ExportToCSV()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the name that you want to create for CSV file : ");
        String FileName = sobj.nextLine();

        System.out.println("----------------------------------------------------------------------------------\n");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to export - Database is Empty");
            System.out.println("----------------------------------------------------------------------------------\n");
            return;
        }

        try(FileWriter fwobj = new FileWriter(FileName))
        {
            fwobj.write("Date, Subject, Duration of Study, Description of study\n");

            for(StudyLog s : Database)
            {
                fwobj.write(s.getDate() + "," + 
                            s.getSubject() + ","+
                            s.getDuration() + "," +
                            s.getDescription() + "\n"
                           );
            }

            System.out.println("Data gets exported to CSV Successfully!");

            System.out.println("----------------------------------------------------------------------------------\n");
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }  
    }

    public void SummaryByDate()
    {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Summary by Date from study tracker");
        System.out.println("----------------------------------------------------------------------------------");

        TreeMap <LocalDate, Double> tobj = new TreeMap <LocalDate, Double>();

        LocalDate lobj = null;
        double d = 0.0;
        double old = 0.0;

        for(StudyLog s : Database)
        {
            lobj = s.getDate();
            d = s.getDuration();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);
                tobj.put(lobj, d + old);
            }
            else
            {
                tobj.put(lobj, d);
            }
        }

        // Display the details as per date
        for(LocalDate l : tobj.keySet())
        {
            System.out.println("Date : " + l + " Total Study Duration : " + tobj.get(l));
        }
        System.out.println("----------------------------------------------------------------------------------");

    }

    public void SummaryBySubject()
    {
        
    }

}

public class program867
{
    public static void main(String a[]) 
    {
        int iChoice = 0;

        Scanner sobj = new Scanner(System.in);
        StudyTracker stobj = new StudyTracker();

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("------------------------Welcome to Marvellous Study Tracker-----------------------");
        System.out.println("----------------------------------------------------------------------------------");

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
        } while(iChoice != 6);

    

        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println("---------------------------Thank for using Study Tracker--------------------------\n");
        System.out.println("----------------------------------------------------------------------------------\n");

        sobj.close();
    }
    // End of main
} // End of class

// maximum subject study add
// add different different dates and timing
// enter date add
// csv to database convert