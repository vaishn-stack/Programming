package Assignment18;

//Write a program to check whether a number is positive,negative or zero.

class Logic
{
    void CheckSign(int num)
    {
        if(num > 0)
        {
            System.out.println("Number is Positive:"+num);
        }

        else if(num < 0)
        {
            System.out.println("Number is Negative:"+num);
        }

        else
        {
            System.out.println("Number is Zero:"+num);
        }
    }
}

public class A90 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.CheckSign(-8);
    }

}
