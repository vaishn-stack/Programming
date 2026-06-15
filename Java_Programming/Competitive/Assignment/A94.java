package Assignment19;

class Logic
{
    void printDigits(int num)
    {
        int iDigit = 0;

        while(num > 0)
        {
            iDigit = num % 10;
            System.out.println(iDigit);
            num = num / 10;
        }
    }
}

public class A94 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.printDigits(9876);
    }
}
