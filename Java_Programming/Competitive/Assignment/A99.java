package Assignment20;

class Logic
{
    void findLargestDigit(int num)
    {
        int iDigit = 0;
        int iMax = 0;

        while(num > 0)
        {
            iDigit = num % 10;

            if(iDigit > iMax)
            {
                iMax = iDigit;
            }

            num = num / 10;
        }

        System.out.println("Largest Digit is : " + iMax);
    }
}
public class A99 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.findLargestDigit(83429);
    }
}
