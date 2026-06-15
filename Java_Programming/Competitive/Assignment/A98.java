package Assignment20;

class Logic  
{
    void checkPerfect(int num)
    {
        int iCnt = 0;
        int iSum = 0;

        for(iCnt = 1; iCnt < num; iCnt++)
        {
             if(num % iCnt == 0)
            {
                iSum = iSum + iCnt;
            }
        }

        if(iSum == num)
        {
            System.out.println(num + " is a perfect Number");
        }
        else
        {
            System.out.println(num + " is not a perfect Number");
        }
    }
}

public class A98
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.checkPerfect(6);
    }
}
 