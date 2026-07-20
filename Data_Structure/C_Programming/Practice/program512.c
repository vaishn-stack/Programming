#include<stdio.h>

void Display(int iNo)
{
    auto int i = 0;
    i = 1;
    
    // Iteration using while loop
    while(i <= iNo)
    {
        printf("Jay Ganesh...\n");
        i++;
    }
    
}

int main()
{
    Display(7);
    
    return 0;
}