#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024

int main()
{
    write(1,"Jay Ganesh...", 13);
    
    return 0;
}