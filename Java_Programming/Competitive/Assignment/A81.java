package Assignment17;

//1.Write a program to find the sum of digit of a number

class Logic
{
    void SumOfDigits(int sum)
    {
        int iCnt = 0;
        int iDigits = 0;
        int iSum = 0;
        while(sum > 0)
        {
            iDigits = sum % 10;
            iSum = iSum + iDigits;
            sum = sum /10;

        }
        System.out.println("sum of digit is:"+iSum);
    }
    
}

public class A81 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.SumOfDigits(1234);
    }

}
