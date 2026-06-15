package Assignment19;

class Logic 
{
    void calculatePower(int base, int exp)
    {
        int iPower = 1;
        int iCnt = 0;

        for(iCnt = 1; iCnt <= exp; iCnt++)
        {
            iPower = iPower * base;
        }
        System.out.println("Power is : " + iPower);
    }
}
public class A95 {
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.calculatePower(2, 5);
    }
}
