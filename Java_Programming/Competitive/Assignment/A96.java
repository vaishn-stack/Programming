package Assignment20;

class Logic
{
    void sumEvenNumbers(int n)
    {
        int iCnt = 0;
        int iSum = 0;

        for(iCnt = 1; iCnt <= n; iCnt ++)
        {
            iSum = iSum + (2 * iCnt);
        }
        System.out.println("Sum of first " + n + " even numbers is : " + iSum);
    }
}
public class A96
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.sumEvenNumbers(10);
    }
}
