package Assignment19;

class Logic 
{
    void displayGrade(int Marks)
    {
        if(Marks < 0 || Marks > 100)
        {
            System.out.println("Invalid Marks");
        }
        else if(Marks >= 75)
        {
            System.out.println("Grade A");
        }

         else if(Marks >= 60)
        {
            System.out.println("Grade B");
        }

        else if(Marks >= 50)
        {
            System.out.println("Grade C");
        }

        else if(Marks >= 35)
        {
            System.out.println("Grade D");
        }
        
        else
        {
            System.out.println("Fail");
        }
    }
}
public class A92 
{
    public static void main(String[] args)
    {
        Logic obj = new Logic();
        obj.displayGrade(82);
    }
}
