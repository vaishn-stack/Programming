package Assignment21;

class Logic
{
    void displayFactors(int num)
    {
        int iCnt = 0;

        for(iCnt = 1; iCnt <= num; iCnt++)
        {
            System.out.println(iCnt + " ");
        }
    }
}

public class A103
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.displayFactors(12);
    }
}
