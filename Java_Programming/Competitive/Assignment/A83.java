package Assignment17;

//Write a program to find the maximum of two numbers.

class Logic{
    void findMax(int a, int b)
    {
        if(a > b)
        {
            System.out.println("Maximum number is :"+a);
        }
        else
        {
            System.out.println("Minimum number is:"+b);
        }
    }
}

public class A83 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.findMax(20,15);
    }

}
