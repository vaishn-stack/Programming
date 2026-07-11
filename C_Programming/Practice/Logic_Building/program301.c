// Bitwise operator
/* 
    unary --> a++,binary-->a+b,ternary-->a+b+c
    Binary operators --> &,|,^,<<,>>
    unary operatord --> ~
    Learn - endian --> little and big endian eg--> egg la saral thevel tr little and ulta thevel tr big endian
    intel madhe big endian cha use hoto

    --------------------------------------------
        op1    op2      &       |       ^
    --------------------------------------------
        0       0       0       0       0
        0       1       0       1       1
        1       0       0       1       1
        1       1       1       1       0
    --------------------------------------------

        BIT
        /  \
    Binary  Digit       --> Bi & t

*/

#include<stdio.h>

int main()
{
    int No = 97;

    printf("Decimal : %d\n",No);
    printf("Octal : %o\n",No);
    printf("HexaDecimal : %x\n",No);

    return 0;
}

