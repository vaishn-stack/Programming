package Assignment21;

class Logic
{
    void productOfDigits(int num)
    {
        int iDigit = 0;
        int iProduct = 1;

        while(num > 0)
        {
            iDigit = num % 10;
            iProduct = iProduct * iDigit;
            num = num / 10;
        }

        System.out.println("Product of Digits is : " + iProduct);
    }
}
public class A101 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.productOfDigits(234);
    }
}
