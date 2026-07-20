#include<stdio.h>

void Display()
{
    auto int i = 0;
    i = 1;
 
    if(i <= 4)
    {
        printf("Jay Ganesh...\n");
        i++;

        Display();          // recursion
    }
    
}

int main()
{
    Display();
    
    return 0;
}

// iteration chi concept vaprun recursion madhe lihaycha asel teva pahile code while loop lihaycha mg loop la if-else madhe convert kraycha