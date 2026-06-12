package Assignment17;

//Write a program to find the minimum of three numbers.

class Logic
{
    void findMin(int a, int b, int c)
    {
        if((a < b)&&(a < c))
        {
            System.out.println("Minimum Number is:"+a);
        }
        else if((b < a)&&(b < c))
        {
            System.out.println("Minimum Number is:"+b);
        }
        else
        {
            System.out.println("Minimum Number is:"+c);x
        }
    }
}


public class A84
{
    
    public static void main(String A[])
    {
        Logic obj = new  Logic();
        obj.findMin(3,7,2);
    }

}
