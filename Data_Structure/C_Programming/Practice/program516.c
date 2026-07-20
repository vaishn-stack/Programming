#include<stdio.h>

void Display(int iNo)
{
    if(iNo != 0)
    {
        printf("Jay Ganesh... %d \n",iNo);
        iNo--;

        Display(iNo);
    }   
}

int main()
{
    int iValue = 0;

    printf("Enter frequency :\n");
    scanf("%d",&iValue);

    Display(iValue);

    printf("End of main \n");
    
    return 0;
}

// int iNo mule code control krta yeto mhnje stop krta yeto