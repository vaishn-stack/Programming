package Assignment18;

//Write a program to print all odd numbers up to N.

class Logic
{
    void CheckOddNumbers(int n)
    {
        int iCnt = 0;
        int iEven = 0;

        for(iCnt = 1; iCnt <= n; iCnt++)
        {
            if(iCnt % 2 != 0)
            {
                System.out.println(iCnt);
            }
        }
    }
}


public class A88 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj. CheckOddNumbers(20);
    }

}
