// Data Structure --> 3-7-2026
// DS --> Linear and non linear --> linear --> singly and doubly --> singly --> singly linear and singly circular --> doubly linear and doubly circular

#include<stdio.h>

struct node             // structure declaration using self referential structure
{
    int data;
    struct node *next;
};

int main()
{
    struct node obj;                // structure la memory milali

    printf("%lu\n",sizeof(obj));     // 8 or 16 padding astana 8 and padding astana 16 (4 byte memory jast milali)
    // 4(int) + 4(padding) + 8(pointer)

    return 0;
}