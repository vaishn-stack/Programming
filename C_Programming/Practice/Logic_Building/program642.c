#include<stdio.h>
#include<stdlib.h>


int main()
{
    #ifdef _WIN32
        printf("Project is running on Windows platform\n");
    #else
        printf("Project is running on Linux/MacOS platform\n");
    #endif

    return 0;
}

// platform independent