// Recursion

#include<stdio.h>

// infinite recursion function
void Display()
{
    printf("Jay Ganesh...\n");

    Display();
}

int main()
{
    Display();

    return 0;
}