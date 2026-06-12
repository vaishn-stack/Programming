package Assignment17;

//Write a program to check whether a number is a palindrome or not.

class Logic
{
    void CheckPalindrome(int num)
    {
        int iCnt = 0;
        int iDigit = 0;
        int iTemp = num;
        int iRev = 0;

        while(num > 0)
        {
            iDigit = num % 10;
            iRev  = (iRev * 10) + iDigit;
            num = num / 10;
        }

            if(iRev == iTemp )
            {
                System.out.println("number is Palindrome:"+iTemp);

            }
            else
            {
                System.out.println("number is not Palindrome:"+iTemp);
            }

        
    }
}


public class A82
{
     public static void main(String A[])
    {
        Logic obj = new Logic();
        obj.CheckPalindrome(121);
    }

    
}
