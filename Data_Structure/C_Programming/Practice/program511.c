#include<stdio.h>

void Display()
{ 
    static int i = 1;
 
    if(i <= 4)
    {
        printf("Jay Ganesh... %d \n", i);
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
/*
    Jay Ganesh... 1
    Jay Ganesh... 2
    Jay Ganesh... 3
    Jay Ganesh... 4
*/