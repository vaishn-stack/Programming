// Check 5 and 18 bit on or off

# include<stdio.h>

typedef int BOOL;
typedef unsigned int UINT;

# define TRUE 1
# define FALSE 0

BOOL ChkBit(UINT iNo)
{
    UINT iMask = 0x00020010;

    if((iNo & iMask) == iMask)
    {
        return TRUE;
    }
    else
    {
        return FALSE;
    }

}

int main()
{
    UINT iValue = 0;
    BOOL bRet = FALSE;

    printf("Enter number : ");
    scanf("%u", &iValue);

    bRet = ChkBit(iValue);

    if(bRet == TRUE)
    {
        printf("18th and 5th Bit is ON\n");
    }
    else
    {
        printf("18th and 5th Bit is OFF\n");
    }

    return 0;
}