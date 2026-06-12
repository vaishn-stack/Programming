package Assignment19;


// Check whether a given year is a leap year or not

class Logic
{
    void checkLeapYear(int year)
    {
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
        {
            System.out.println(year + " is a Leap Year");
        }
        else
        {
            System.out.println(year + " is not a Leap Year");
        }
    }
}

public class A91 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.checkLeapYear(2024);
    }
}
