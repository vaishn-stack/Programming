// Recursion

#include<stdio.h>

// infinite iteration function
void Display()
{
    int i = 1;

    while(1)                               // in pyhton - while True:
    {
        printf("Jay Ganesh... %d\n", i);
        i++;
    }
}

// 2 stack frame are created - 1 frame main chi and 2nd frame Display chi
int main()
{
    Display();

    return 0;
}