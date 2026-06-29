// Check 15 bit on or off

# include<stdio.h>

typedef int BOOL;
typedef unsigned int UINT;

# define TRUE 1
# define FALSE 0

BOOL ChkBit(UINT iNo)
{
    UINT iMask = 0x00004000;

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
        printf("15th Bit is ON\n");
    }
    else
    {
        printf("15th Bit is OFF\n");
    }

    return 0;
}