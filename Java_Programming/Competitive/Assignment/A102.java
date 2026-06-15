package Assignment21;

class Logic
{
    void countevenOddRange(int n)
    {
        int iEvenCnt = 0;
        int iOddCnt = 0;
        int iCnt = 0;

        for(iCnt = 1; iCnt <= n; iCnt++)
        {
            if(iCnt % 2 == 0)
            {
                iEvenCnt++;
            }
            else
            {
                iOddCnt++;
            }
        }

        System.out.println("Even Numbers Count : " + iEvenCnt);
        System.out.println("Odd Numbers Count  : " + iOddCnt);
    }
    
}
public class A102 
{
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.countevenOddRange(50);
    }
}
