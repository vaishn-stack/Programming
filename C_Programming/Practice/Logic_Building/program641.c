#include<stdio.h>
#include<stdlib.h>


int main()
{
    #ifdef _WIN32
        system("dir");
    #else
        system("ls");    // conditional compilation
    #endif

    return 0;
}

// platform independent