package Assignment18;

//Write a program to find the sum of even and odd digits seprately in a number.

class Logic
{
    void sumEvenOddNumbers(int n)
    {
        int iEven = 0;
        int iOdd = 0;
        int iDigit = 0;

    while(n > 0)
    {
        iDigit = n % 10;

        if(iDigit % 2 == 0)
        {
            iEven = iEven + iDigit;
        }

        else
        {
            iOdd = iOdd + iDigit;
        }
         n = n / 10;
    }       
        System.out.println("Sum of Even Digits : " + iEven);
        System.out.println("Sum of Odd Digits : " + iOdd); 
    }
}

public class A89 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj. sumEvenOddNumbers(123456 );
    }

}
