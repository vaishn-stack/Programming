package Assignment17;

//Write a program to print the multiplication table of  a number.

class Logic
{
    void printTable(int num)
    {
        int iCnt = 0;
        int iMult  = 1;
        for(iCnt = 1; iCnt <= 10; iCnt++)
        {
            iMult = iCnt * num;
            System.out.println(iMult);
        }
    }
}

public class A85 
{
    public static void main(String A[])
    {
        Logic obj = new  Logic();
        obj.printTable(5);
    }

}
