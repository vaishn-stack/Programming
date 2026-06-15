package Assignment20;

class Logic
{
    void findSmallestDigit(int num)
    {
        int iDigit = 0;
        int iMin = 0;

        while(num > 0)
        {
            iDigit = num % 10;

            if(iDigit < iMin)
            {
                iMin = iDigit;
            }

            num = num / 10;
        }

        System.out.println("Smallest Digit is : " + iMin);
    }
}
public class A100
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.findSmallestDigit(45872);
    }
}
