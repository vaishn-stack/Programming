package Assignment18;

//Write a program to check Whether a number is prime or not.

class Logic
{
    void CheckEvenNumbers(int n)
    {
        int iCnt = 0;
        int iEven = 0;

        for(iCnt = 1; iCnt <= n; iCnt++)
        {
            if(iCnt % 2 == 0)
            {
                System.out.println(iCnt);
            }
        }
    }
}

public class A87 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj. CheckEvenNumbers(20);
    }
}
