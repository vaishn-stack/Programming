package Assignment21;

class Logic
{
    void countFactors(int num)
    {
        int iCnt = 0;
        int iCount = 0;
        
        for(iCnt = 1; iCnt <= num; iCnt++)
        {
            if(num % iCnt == 0)
            {
                iCount++;
            }
        }

        System.out.println("Number of Factors : " + iCount);
    }
}
public class A104 
{
     public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.countFactors(20);
    }
}
