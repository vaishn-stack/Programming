package Assignment18;

//Write a program to check Whether a number is prime or not.

class Logic
{
    void CheckPrime(int num)
    {
        int iCnt = 0;
        boolean bFlag = true;
        if(num <= 1)
        {
            System.out.println("Number is not prime:"+num);
            return;
        }

        for(iCnt = 2; iCnt < num; iCnt++)
        {
            if(num  % iCnt == 0)
            {
                bFlag = false;
                break;

            }
        }
            if(bFlag == true)
            {
                System.out.println("Number is prime:"+num);
            }
            else
            {
                System.out.println("Number is not prime:"+num);
            } 
    }
}

public class A86 
{
    
    public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.CheckPrime(11);
    }

}
